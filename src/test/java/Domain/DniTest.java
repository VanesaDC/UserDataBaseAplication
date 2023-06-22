package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DniTest {

    @Test
    void should_throw_a_exception_when_dni_is_nor_valid() {
        String dni = "7869848K";
        String message = assertThrows(DataException.class, ()->Dni.createDni(dni)).getMessage();
        assertEquals("El DNI que escribió no es válido.", message);
    }
}