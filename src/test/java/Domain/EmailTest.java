package Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void should_throw_a_exception_when_email_is_not_correct(){
        String email= "vanesa@gemail";
        String message = assertThrows(DataException.class, ()->Email.createEmail(email)).getMessage();
        assertEquals("Error: El email tiene algún fallo", message);
    }
}