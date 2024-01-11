public class Palindrome {
    public static String reverseString(String s){
        String r="";
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i>=0; i--){
            r+="" + chars[i];
        }
        return r;
    }
    public static boolean isPalindrome(String s){
        String rs=reverseString(s);
        return s.equals(rs);
    }
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }

    }
}
