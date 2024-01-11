import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomAgeException extends Exception {
    private static Logger logger;

    static {
        try {
            logger = Logger.getLogger("CustomAgeException");
            FileHandler fileHandler = new FileHandler("src/exceptions.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CustomAgeException(String message) {
        super(message);
        logger.log(Level.SEVERE, "CustomAgeException: " + message);
    }

    public static void checkAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Возраст вне допустимого диапазона");
        }
    }

    public static void main(String[] args) {
        try {
            int age = 666;
            checkAge(age);
        } catch (CustomAgeException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
