import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void toCSV() {
        Product product = new Product("123456", "Laptop", "High-end gaming laptop", 1500.99);
        String expectedCSV = "123456, Laptop, High-end gaming laptop, 1500.99";
        assertEquals(expectedCSV, product.toCSV(), "CSV format test failed.");
    }

    @Test
    void toJSON() {
        Product product = new Product("123456", "Laptop", "High-end gaming laptop", 1500.99);
        String expectedJSON = "123456:Laptop:High-end gaming laptop:1500.99";
        assertEquals(expectedJSON, product.toJSON(), "JSON format test failed.");
    }

    @Test
    void toXML() {
        Product product = new Product("123456", "Laptop", "High-end gaming laptop", 1500.99);
        String expectedXML = "<Product><ID>123456</ID><ProductName>Laptop</ProductName><ProductDescription>High-end gaming laptop</ProductDescription><ProductCost>1500.99</ProductCost></Product>";
        assertEquals(expectedXML, product.toXML(), "XML format test failed.");
    }

    @Test
    void testToString() {
        Product p = new Product("123456","Laptop", "High-end gaming laptop", 1500.99);
        String expectedToString = "123456     Laptop     High-end gaming laptop     1500.99";
        assertEquals(expectedToString, p.toString());
    }
}