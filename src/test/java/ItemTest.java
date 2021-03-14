import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item = new Item("+","2","3");
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void print() {
        String output = item.print();
        assertEquals(output,"6*x**2");
    }
}