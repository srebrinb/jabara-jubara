/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package bg.srebrinb.jabara.jubara;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author srebrin
 */
public class cipherTest {
    
    public cipherTest() {
    }

 
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of j135 method, of class cipher.
     */
    @org.junit.jupiter.api.Test
    public void testJ135() {
        System.out.println("j135");
        String input = "asdfFFFFEWrfvas35678)(HDdadgasdg23456";
        System.out.println("input = " + input);
        String tmp = cipher.j135(input);
        System.out.println("tmp:"+tmp);
        String result = cipher.j135(tmp);
        assertEquals(input, result);
    }

    @Test
    public void testS135() {
         System.out.println("Small 135");
        String input = "asdfFFFFEWrfvas35678)(HDdadgasdg23456";
        System.out.println("input = " + input);
        String tmp = cipher.s135(input);
        System.out.println("tmp:"+tmp);
        String result = cipher.s135(tmp);
        assertEquals(input, result);
    }
        @Test
    public void testS135Big() {
         System.out.println("Big 135");
        String input = "1234567890abcdefg1234567890";
        System.out.println("len:"+ input.length() +"\tinput = " + input);
        String tmp = cipher.s135(input);
        System.out.println("tmp:"+tmp);
        String result = cipher.s135(tmp);
        assertEquals(input, result);
    }
    
}
