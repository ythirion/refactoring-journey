package simplifying.method.calls;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class separateQueryFromModifier {
    private final Client client = new Client(new LinkedHashMap<>() {{
        put("Tenet Deluxe Edition", 45.99);
        put("Inception", 30.50);
        put("The Dark Knight", 30.50);
        put("Interstellar", 23.98);
    }});

    @Test
    public void client_should_return_statement() {
        String statement = client.toStatement();

        assertEquals(130.97, client.getTotalAmount());
        assertEquals("Tenet Deluxe Edition for 45.99€\n" +
                "Inception for 30.5€\n" +
                "The Dark Knight for 30.5€\n" +
                "Interstellar for 23.98€\n" +
                "Total : 130.97€", statement);
    }
}
