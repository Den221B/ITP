import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<Country> readCountriesFromCsv(String fileName) {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Пропускаем заголовок

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                try {
                    countries.add(parseCountry(values));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Error parsing line: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    private static Country parseCountry(String[] data) {
        Country country = new Country();
        country.setName(data[0]);
        country.setHappinessIndex(parseDoubleOrDefault(data[1]));
        country.setGdpPerCapita(parseDoubleOrDefault(data[2]));
        country.setSocialSupport(parseDoubleOrDefault(data[3]));
        country.setHealthIndex(parseDoubleOrDefault(data[4]));
        country.setFreedomIndex(parseDoubleOrDefault(data[5]));
        country.setCorruptionPerception(parseDoubleOrDefault(data[6]));
        country.setGenerosityIndex(parseDoubleOrDefault(data[7]));

        return country;
    }

    private static double parseDoubleOrDefault(String value) {
        try {
            return Double.parseDouble(value.replace(',', '.'));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
