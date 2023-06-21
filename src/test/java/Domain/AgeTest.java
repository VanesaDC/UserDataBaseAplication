package Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgeTest {

    @Test
    void should_throw_a_exception_when_the_number_less_than_zero() {
        String age = "-1";
        String message = assertThrows(AgeException.class, ()->Age.createAge(age)).getMessage();
        assertEquals("La edad no puede ser menor que cero.", message);
    }
    @Test
    void should_throw_a_exception_when_the_number_greater_than_a_hundred() {
        String age = "102";
        String message = assertThrows(AgeException.class, ()->Age.createAge(age)).getMessage();
        assertEquals("La edad no puede superar los 100 años.", message);
    }
    @Test
    void should_throw_a_exception_when_it_contains_letters() {
        String age = "edad";
        String message = assertThrows(AgeException.class, ()->Age.createAge(age)).getMessage();
        assertEquals("Escriba la edad con números, por favor.", message);
    }


}