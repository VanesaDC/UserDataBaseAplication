package Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class NameTest {
    @Test
    void should_decline_empty_name(){
        String name= "";
        String message = assertThrows(NameException.class, ()->Name.createName(name)).getMessage();

        assertEquals("El nombre no puede estar vacío.", message);
    }
    @Test
    void should_accepts_name_that_contains_only_letters(){
        String name= "Vanes22";
        String message = assertThrows(NameException.class, ()->Name.createName(name)).getMessage();

        assertEquals("El nombre solo puede contener letras.", message);
    }

}