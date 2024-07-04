/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package bg.srebrinb.jabara.jubara;

import bg.srebrinb.jabara.jubara.ciphers.Loki;

/**
 *
 * @author srebrin
 */
public class JabaraJubara {

    public static void main(String[] args) {
        //TODO hubav primern
        String str="Тест: Г-н Жълтищев бързо фиксира, че English текст: The quick brown fox jumps over 12 lazy dogs! 1234567890."; //Demo input 
        System.out.println(str);
        String eha=Loki.op(str); // Tuk stawa Jabara.Jubara Encrypt
        System.out.println("eha = " + eha);
        String ha=Loki.hopString(eha);
        System.out.println("ha = " + ha); // Koj go kaza
    }
}
