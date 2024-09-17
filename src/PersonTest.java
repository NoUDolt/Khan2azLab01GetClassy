import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void fullName() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        assertEquals("John Doe", p.fullName());
    }

    @Test
    void formalName() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        assertEquals("Mr. John Doe", p.formalName());
    }

    @Test
    void getAge() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        assertEquals("34", p.getAge(2024));
    }

    @Test
    void testGetAge() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        assertEquals("1", p.getAge(1991));
    }

    @Test
    void toCSV() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        assertEquals("123456, John, Doe, Mr., 1990", p.toCSV());
    }

    @Test
    void toJSON() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        String expectedJSON = "123456:John:Doe:Mr.:1990";
        assertEquals(expectedJSON, p.toJSON());
    }

    @Test
    void toXML() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        String expectedXML = "<Person><ID>123456</ID><FirstName>John</FirstName><LastName>Doe</LastName><Title>Mr.</Title><YOB>1990</YOB></Person>";
        assertEquals(expectedXML, p.toXML());
    }

    @Test
    void testToString() {
        Person p = new Person("123456","John", "Doe", "Mr.", 1990);
        String expectedToString = "123456     John     Doe     Mr.     1990";
        assertEquals(expectedToString, p.toString());
    }

    @Test
    void testEquals() {
        Person p1 = new Person("123456","John", "Doe", "Mr.", 1990);
        Person p2 = new Person("123456","Jane", "Smith", "Ms.", 1995);
        assertTrue(p1.equals(p2));
    }
}