import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "abd 12 4 6443 1.2";
        Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            try {
                System.out.println(matcher.group(0));
            } catch (Exception ex) {
                System.out.println("Возникла ошибка");
            }
        }
    }
}
