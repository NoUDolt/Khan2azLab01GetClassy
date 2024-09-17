import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {

    @Test
    void getNonZeroLenString() {
        Scanner scanner = new Scanner("Hello\n");
        SafeInputObj input = new SafeInputObj(scanner);

        String result = input.getNonZeroLenString("Enter a string:");
        assertEquals("Hello", result, "Non-zero length string test failed.");
    }

    @Test
    void getRangedInt() {
        Scanner scanner = new Scanner("15\n");
        SafeInputObj input = new SafeInputObj(scanner);

        int result = input.getRangedInt("Enter a number between 10 and 20:", 10, 20);
        assertEquals(15, result, "Ranged int test failed.");
    }

    @Test
    void getInt() {
        Scanner scanner = new Scanner("100\n");
        SafeInputObj input = new SafeInputObj(scanner);

        int result = input.getInt("Enter an integer:");
        assertEquals(100, result, "Integer test failed.");
    }

    @Test
    void getRangedDouble() {
        Scanner scanner = new Scanner("50.75\n");
        SafeInputObj input = new SafeInputObj(scanner);

        double result = input.getRangedDouble("Enter a number between 10.0 and 100.0:", 10, 100);
        assertEquals(50.75, result, 0.001, "Ranged double test failed.");
    }

    @Test
    void getDouble() {
        Scanner scanner = new Scanner("250.50\n");
        SafeInputObj input = new SafeInputObj(scanner);

        double result = input.getDouble("Enter a double:");
        assertEquals(250.50, result, 0.001, "Double test failed.");
    }

    @Test
    void getYNConfirm() {
        Scanner scanner = new Scanner("Y\n");
        SafeInputObj input = new SafeInputObj(scanner);

        boolean result = input.getYNConfirm("Continue?");
        assertTrue(result, "YN confirmation test failed.");
    }

    @Test
    void getRegExString() {
        Scanner scanner = new Scanner("abc123\n");
        SafeInputObj input = new SafeInputObj(scanner);

        String result = input.getRegExString("Enter a string matching the pattern:", "[a-z]{3}\\d{3}");
        assertEquals("abc123", result, "RegEx string test failed.");
    }
}