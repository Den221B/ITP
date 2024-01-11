import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
        System.out.println(isValidPassword("qwerty"));
        System.out.println(isValidPassword("qwerty1"));
        System.out.println(isValidPassword("QWerty1"));
        System.out.println(isValidPassword("Qwerty223"));
    }

    private static boolean isValidPassword(String password) {
        String passwordPattern = "(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}";
        try {
            Pattern pattern = Pattern.compile(passwordPattern);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }
        catch (Exception ex) {
            System.out.println("Возникла ошибка");
        }
        return false;
    }

}
