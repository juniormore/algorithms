public class Recursion{
    public static void main(String[] args){
        String str = "Olebile";
        char ch = 'e';

        System.out.printf("%d\n", CountChar(str, ch));

    }

    public static int CountChar(String str, char ch){
        if (str==null || str.length() == 0){
            return 0;
        }
        if (str.charAt(0) == ch){
            return 1 + CountChar(str.substring(1), ch);
        }
        else{
            return CountChar(str.substring(1), ch);
        }
    }

    public static String RemoveVowel(String str){
        if(str == null || str.length() == 0){
            return;
        }
        if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' || str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I' || str.charAt(0) == 'O' || str.charAt(0) == 'U' ){
            return 
        }
    }
}