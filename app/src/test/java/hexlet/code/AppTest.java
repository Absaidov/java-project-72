package hexlet.code;

import io.ebeaninternal.server.util.Str;
import org.junit.jupiter.api.Test;

import static hexlet.code.App.helloString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.App;

public class AppTest {

    @Test
    public void testStringMain() {
        assertEquals(helloStringTest(), helloString());
    }
    public static String helloStringTest() {
        return "Here Im";
    }
}
