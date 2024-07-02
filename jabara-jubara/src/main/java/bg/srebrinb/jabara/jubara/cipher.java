/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bg.srebrinb.jabara.jubara;

/**
 *
 * @author srebrin
 */
public class cipher {

    public static String j135(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'm') {
                c += 13;
            } else if (c >= 'A' && c <= 'M') {
                c += 13;
            } else if (c >= '0' && c <= '4') {
                c += 5;
            } else if (c >= 'n' && c <= 'z') {
                c -= 13;
            } else if (c >= 'N' && c <= 'Z') {
                c -= 13;
            } else if (c >= '5' && c <= '9') {
                c -= 5;
            }
            sb.append(c);
        }
        return sb.toString();
    }
    public static String s135(String input) {
        String res="";
        if (input.length()>10){
            System.out.println("big");
            int partLen=(int)(input.length()*0.2);
            String part=input.substring(0, partLen); //Get 1/5 from input
            res=j135(part)+input.substring(partLen);
        }
        else{
            res=j135(input);
        }
        return res;
    }
}
