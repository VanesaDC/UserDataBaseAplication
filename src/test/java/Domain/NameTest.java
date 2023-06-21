package Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class NameTest {
    @Test
    void should_throw_exception_when_name_is_empty(){
        String name= "";
        String message = assertThrows(NameException.class, ()->Name.createName(name)).getMessage();
        assertEquals("El nombre no puede estar vacío.", message);
    }
    @Test
    void should_throw_an_exceptio_when_name_contains_no_only_letters(){
        String name= "Vanes22";
        String message = assertThrows(NameException.class, ()->Name.createName(name)).getMessage();
        assertEquals("El nombre solo puede contener letras.", message);
    }

}