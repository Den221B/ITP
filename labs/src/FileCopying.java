import java.io.*;

public class FileCopying {
    public static void main(String[] args) {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("src/source.txt");
            writer = new FileWriter("src/destination.txt", false);
            int c;
            while ((c = reader.read()) != -1) {
                writer.write((char) c);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка при чтении/записи файла: " + ex.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}
