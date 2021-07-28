package simplifying.method.calls;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AccountingService {
    private final List<Bill> bills;

    public ArrayList<Bill> findBillsInvoicedBetween(LocalDate from, LocalDate to) {
        return findBills(Bill::getInvoicedDate, from, to);
    }

    public ArrayList<Bill> findBillsDueBetween(LocalDate from, LocalDate to) {
        return findBills(Bill::getDueDate, from, to);
    }

    public ArrayList<Bill> findBillsPaidBetween(LocalDate from, LocalDate to) {
        return findBills(Bill::getPaymentDate, from, to);
    }

    private ArrayList<Bill> findBills(Function<Bill, LocalDate> dateSelector, LocalDate from, LocalDate to) {
        return bills.stream()
                .filter(bill -> isInRange(dateSelector.apply(bill), from, to))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isInRange(LocalDate dateToCheck, LocalDate from, LocalDate to) {
        return dateToCheck != null &&
                (dateToCheck.isAfter(from) || dateToCheck.isEqual(from)) && (dateToCheck.isBefore(to) || dateToCheck.isEqual(to));
    }
}
