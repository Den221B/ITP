public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new CountryFilter());

        // Фильтрация по счастью
        dataManager.loadData("C:\\Users\\Den220\\IdeaProjects\\labs\\Country.csv");
        dataManager.processData("filterByHappinessIndex", 7.3);
        dataManager.saveNormalizedData("C:\\Users\\Den220\\IdeaProjects\\labs\\C1.csv");

        // Фильтрация по ВВП
        dataManager.loadData("C:\\Users\\Den220\\IdeaProjects\\labs\\Country.csv");
        dataManager.processData("filterByGdpPerCapita", 1.4);
        dataManager.saveNormalizedData("C:\\Users\\Den220\\IdeaProjects\\labs\\C2.csv");

        // Без фильтрации
        dataManager.loadData("C:\\Users\\Den220\\IdeaProjects\\labs\\Country.csv");
        dataManager.saveNormalizedData("C:\\Users\\Den220\\IdeaProjects\\labs\\C3.csv");

        dataManager.loadData("C:\\Users\\Den220\\IdeaProjects\\labs\\C3.csv");
        dataManager.processData("filterByGdpPerCapita", 0.5);
        dataManager.saveNormalizedData("C:\\Users\\Den220\\IdeaProjects\\labs\\C4.csv");

        dataManager.shutdown();
    }
}


