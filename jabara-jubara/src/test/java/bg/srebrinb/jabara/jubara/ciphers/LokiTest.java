/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package bg.srebrinb.jabara.jubara.ciphers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author srebrin
 */
public class LokiTest {

    public LokiTest() {
    }

    @Test
    public void testJ135() {
    }

    @Test
    public void testS135_3args() {
    }

    @Test
    public void testS135_String_int() {
    }

    @Test
    public void testS135_String() {
    }

    @Test
    public void testOp() {
        String srt = "ttest tedsfasfasdfsdf";
        String result = "l42v1.qUEyp8DtqTIxp7Mup7Mup7Ezp7Ez";
        String o = Loki.op(srt);
        assertEquals(o, result);
    }

    @Test
    public void testOpE2E() {
        String srt = "ttest tedsfasfasdfsdf";
        String o = Loki.op(srt);
        System.out.println("o = " + o);
        String result = Loki.hopString(o);
        System.out.println("result = " + result);
        assertEquals(srt, result);
    }

    @Test
    public void testHop() {
        String srt = "l42v1.qUEyp8DtqTIxp7Mup7Mup7Ezp7Ez";
        String result = "ttest tedsfasfasdfsdf";
        String o = Loki.hopString(srt);
        assertEquals(o, result);
    }
        @Test
    public void testOpE2E_long() {
        String srt = "Тест: Г-н Жълтищев бързо фиксира, че English текст: The quick brown fox jumps over 12 lazy dogs! 1234567890.";
        String o = Loki.op(srt);
        System.out.println("o = " + o);
        String result = Loki.hopString(o);
        System.out.println("result = " + result);
        assertEquals(srt, result);
    }

}
