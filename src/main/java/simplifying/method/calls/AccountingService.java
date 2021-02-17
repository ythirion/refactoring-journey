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

    public ArrayList<Bill> findBillsInvoicedBetween(Period period) {
        return findBills(Bill::getInvoicedDate, period);
    }

    public ArrayList<Bill> findBillsDueBetween(Period period) {
        return findBills(Bill::getDueDate, period);
    }

    public ArrayList<Bill> findBillsPaidBetween(Period period) {
        return findBills(Bill::getPaymentDate, period);
    }

    private ArrayList<Bill> findBills(Function<Bill, LocalDate> dateSelector, Period period) {
        return bills.stream()
                .filter(bill -> isInRange(dateSelector.apply(bill), period))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isInRange(LocalDate dateToCheck, Period period) {
        return dateToCheck != null &&
                (dateToCheck.isAfter(period.getFrom()) || dateToCheck.isEqual(period.getFrom())) &&
                (dateToCheck.isBefore(period.getTo()) || dateToCheck.isEqual(period.getTo()));
    }
}
