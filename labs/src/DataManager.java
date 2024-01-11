import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {

    private final List<Object> processors;
    private List<Country> originalCountries;
    private List<Country> countries;
    private final ExecutorService executor;

    public DataManager() {
        processors = new ArrayList<>();
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        originalCountries = Reader.readCountriesFromCsv(source);
        countries = new ArrayList<>(originalCountries);
    }

    public void processData(String filterType, double filterValue) {
        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class) && method.getName().equals(filterType)) {
                    try {
                        countries = (List<Country>) method.invoke(processor, new ArrayList<>(countries), filterValue);
                        // Используем новый ArrayList для фильтрации, чтобы избежать изменений в оригинальных данных
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void saveNormalizedData(String destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write("name;happinessIndex;gdpPerCapita;socialSupport;healthIndex;freedomIndex;corruptionPerception;generosityIndex");
            writer.newLine();

            // Find min and max values for normalization
            double[] minValues = findMinValues(countries);
            double[] maxValues = findMaxValues(countries);

            for (Country country : countries) {
                normalizeCountryData(country, minValues, maxValues);
                writer.write(formatCountryForCsv(country));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private double[] findMinValues(List<Country> countries) {
        double[] minValues = new double[8];
        Arrays.fill(minValues, Double.MAX_VALUE);

        for (Country country : countries) {
            minValues[0] = Math.min(minValues[0], country.getHappinessIndex());
            minValues[1] = Math.min(minValues[1], country.getGdpPerCapita());
            minValues[2] = Math.min(minValues[2], country.getSocialSupport());
            minValues[3] = Math.min(minValues[3], country.getHealthIndex());
            minValues[4] = Math.min(minValues[4], country.getFreedomIndex());
            minValues[5] = Math.min(minValues[5], country.getCorruptionPerception());
            minValues[6] = Math.min(minValues[6], country.getGenerosityIndex());
        }

        return minValues;
    }

    private double[] findMaxValues(List<Country> countries) {
        double[] maxValues = new double[8];
        Arrays.fill(maxValues, Double.MIN_VALUE);

        for (Country country : countries) {
            maxValues[0] = Math.max(maxValues[0], country.getHappinessIndex());
            maxValues[1] = Math.max(maxValues[1], country.getGdpPerCapita());
            maxValues[2] = Math.max(maxValues[2], country.getSocialSupport());
            maxValues[3] = Math.max(maxValues[3], country.getHealthIndex());
            maxValues[4] = Math.max(maxValues[4], country.getFreedomIndex());
            maxValues[5] = Math.max(maxValues[5], country.getCorruptionPerception());
            maxValues[6] = Math.max(maxValues[6], country.getGenerosityIndex());
        }

        return maxValues;
    }

    private void normalizeCountryData(Country country, double[] minValues, double[] maxValues) {
        country.setHappinessIndex(normalize(country.getHappinessIndex(), minValues[0], maxValues[0]));
        country.setGdpPerCapita(normalize(country.getGdpPerCapita(), minValues[1], maxValues[1]));
        country.setSocialSupport(normalize(country.getSocialSupport(), minValues[2], maxValues[2]));
        country.setHealthIndex(normalize(country.getHealthIndex(), minValues[3], maxValues[3]));
        country.setFreedomIndex(normalize(country.getFreedomIndex(), minValues[4], maxValues[4]));
        country.setCorruptionPerception(normalize(country.getCorruptionPerception(), minValues[5], maxValues[5]));
        country.setGenerosityIndex(normalize(country.getGenerosityIndex(), minValues[6], maxValues[6]));
    }

    private double normalize(double value, double minValue, double maxValue) {
        return (value - minValue) / (maxValue - minValue);
    }

    private String formatCountryForCsv(Country country) {
        return String.format("%s;%f;%f;%f;%f;%f;%f;%f",
                country.getName(),
                country.getHappinessIndex(),
                country.getGdpPerCapita(),
                country.getSocialSupport(),
                country.getHealthIndex(),
                country.getFreedomIndex(),
                country.getCorruptionPerception(),
                country.getGenerosityIndex());
    }

    public void shutdown() {
        executor.shutdown();
    }
}
