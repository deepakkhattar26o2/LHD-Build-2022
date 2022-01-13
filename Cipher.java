import java.util.Scanner;

public class Cipher {
    private static char shiftLower(char c, int shift ){
        return (char)(((int)c -97 + shift)%26 + 97);
    }
    private static char shiftUpper(char c, int shift ){
        return (char)(((int)c -65 + shift)%26 + 65);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int shift = 7;
        System.out.print("Enter A Message: ");
        String message = sc.nextLine();
        String enc="";
        for(int i=0;i<message.length();i++) {
            if(message.charAt(i)>='a' && message.charAt(i)<='z'){
                enc+=shiftLower(message.charAt(i), shift);
            }
            else if(message.charAt(i)>='A' && message.charAt(i)<='Z'){
                enc+=shiftUpper(message.charAt(i), shift);
            }
            else{
                enc+=message.charAt(i);
            }
        }
        System.out.println("Ciphered Message: " + enc);
    }
}
