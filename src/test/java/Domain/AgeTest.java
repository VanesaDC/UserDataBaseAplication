package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {

    @Test
    void should_throw_a_exception_when_the_number_less_than_zero() {
        int age = -1;
        String message = assertThrows(AgeException.class, ()->Age.createAge(age)).getMessage();

        assertEquals("La edad no puede ser menor que cero", message);
    }

}