package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class NameTest {
    @Test
    void should_decline_empty_name(){
        String name= "";
        a
        assertEquals("El nombre no puede estar vacío.", Name.createName(name));
    }
    @Test
    void should_accepts_name_that_contains_only_letters(){
        String name= "Vanes22";
        assertEquals("El nombre solo puede contener letras", Name.createName(name));
    }

}