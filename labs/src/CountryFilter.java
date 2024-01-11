import java.util.List;

public class CountryFilter {

    @DataProcessor
    public static List<Country> filterByHappinessIndex(List<Country> countries, double minHappinessIndex) {
        return countries.stream()
                .filter(country -> country.getHappinessIndex() > minHappinessIndex)
                .toList();
    }

    @DataProcessor
    public static List<Country> filterByGdpPerCapita(List<Country> countries, double minGdpPerCapita) {
        return countries.stream()
                .filter(country -> country.getGdpPerCapita() > minGdpPerCapita)
                .toList();
    }

    @DataProcessor
    public static List<Country> filterBySocialSupport(List<Country> countries, double minSocialSupport) {
        return countries.stream()
                .filter(country -> country.getSocialSupport() > minSocialSupport)
                .toList();
    }
    @DataProcessor
    public static List<Country> filterByHealthIndex(List<Country> countries, double minHealthIndex) {
        return countries.stream()
                .filter(country -> country.getHealthIndex() > minHealthIndex)
                .toList();
    }
    @DataProcessor
    public static List<Country> filterByCorruptionPerception(List<Country> countries, double minCorruptionPerception) {
        return countries.stream()
                .filter(country -> country.getCorruptionPerception() > minCorruptionPerception)
                .toList();
    }

    @DataProcessor
    public static List<Country> filterByFreedomIndex(List<Country> countries, double minFreedomIndex) {
        return countries.stream()
                .filter(country -> country.getFreedomIndex() > minFreedomIndex)
                .toList();
    }

    @DataProcessor
    public static List<Country> filterByGenerosityIndex(List<Country> countries, double minGenerosityIndex) {
        return countries.stream()
                .filter(country -> country.getGenerosityIndex() > minGenerosityIndex)
                .toList();
    }
}

