/*
* Code for the UB CS Hackathon 2022 */
public class UBCSHackathon{
    public static void main(String[] args){
        /* String[] arr = FizzBuzz(50);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        } */
        String pal = Palindromes("abcd");
        System.out.println(pal);
    }
    public static String[] FizzBuzz(int N){
        String[] answers = new String[N];
        int digit = 0;
        for(int i = 0; i < N; i++){
            digit = i + 1;
            if(digit % 3 == 0){
                answers[i] = "Fizz";
            }
            else if(digit % 5 == 0){
                answers[i] = "Buzz";
            }
            else{
                answers[i] = Integer.toString(digit);
            }
            if(digit % 3 == 0 && digit % 5 == 0){
                answers[i] = "FizzBuzz";
            }
        }
        return answers;
    }

    /* public static String Palindromes(String str){
        String pal = "";
        int pivot = 0;
        if (str.length%2 == 0){
            return;
        }
        else{
            for(int i = 1; i < str.length-2; i++ ){
                if (str.charAt(i-1) == str.charAt(i+1)){
                    pivot = i;
                }
            }
            if(pivot + 2 < str.length){
                for(int i = pivot + 2; i < str.length-1; i++ ){
                pal = str.charAt(i) + str;
            }
            }
            else if (pivot + 1 < str.length ){
                for(int i = pivot; i < str.length-1; i++ ){
                pal = str.charAt(i) + str;
            }
            else{
                
            }
            

        }
    } */
    public static String Palindromes(String str){
        String pal = "";
        if ((str.length() < 1) || (isPalindrome(str))){
            return str;
        }
        else{
            pal = Palindromes(str.substring(1)) + str.charAt(0);
        }
        return pal + str.substring(0);
    }
    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}