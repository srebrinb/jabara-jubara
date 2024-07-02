
package bg.srebrinb.jabara.jubara.ciphers;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author srebrin
 */
public class Loki  {

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
    public static String s135(String input,int len,int partLen) {
        String res="";
        if (input.length()>=len){
            String part=input.substring(0, partLen); //Get 1/5 from input
            res=j135(part)+input.substring(partLen);
        }
        else{
            res=j135(input);
        }
        return res;
    }
    public static String s135(String input,int len){
        int partLen=(int)(input.length()*0.2); //Get 1/5 from input
        return s135(input,len,partLen);
    }
    public static String s135(String input){
        int partLen=(int)(input.length()*0.2); //Get 1/5 from input
        return s135(input,50,partLen);
    }
    public static String op(String input){
        return    "l42v1."+ s135(new String((Base64.encodeBase64(input.getBytes()))));
    }
    public static String hopString(String input){
        String result =input;
        int dotIndex = input.indexOf('.');
        if (dotIndex != -1) { // Проверка дали има точка в стринга
             result = input.substring(dotIndex + 1);
            
        } 
        return  new String(Base64.decodeBase64(s135(result)));
    }
    
}
