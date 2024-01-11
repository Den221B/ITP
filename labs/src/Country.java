public class Country {
    private String name;
    private double happinessIndex;
    private double gdpPerCapita;
    private double socialSupport;
    private double healthIndex;
    private double freedomIndex;
    private double corruptionPerception;
    private double generosityIndex;

    public Country() {
        this.name = name;
        this.happinessIndex = happinessIndex;
        this.gdpPerCapita = gdpPerCapita;
        this.socialSupport = socialSupport;
        this.healthIndex = healthIndex;
        this.freedomIndex = freedomIndex;
        this.corruptionPerception = corruptionPerception;
        this.generosityIndex = generosityIndex;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getHappinessIndex() {
        return happinessIndex;
    }

    public double getGdpPerCapita() {
        return gdpPerCapita;
    }

    public double getSocialSupport() {
        return socialSupport;
    }

    public double getHealthIndex() {
        return healthIndex;
    }

    public double getFreedomIndex() {
        return freedomIndex;
    }

    public double getCorruptionPerception() {
        return corruptionPerception;
    }

    public double getGenerosityIndex() {
        return generosityIndex;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setHappinessIndex(double happinessIndex) {
        this.happinessIndex = happinessIndex;
    }

    public void setGdpPerCapita(double gdpPerCapita) {
        this.gdpPerCapita = gdpPerCapita;
    }

    public void setSocialSupport(double socialSupport) {
        this.socialSupport = socialSupport;
    }

    public void setHealthIndex(double healthIndex) {
        this.healthIndex = healthIndex;
    }

    public void setFreedomIndex(double freedomIndex) {
        this.freedomIndex = freedomIndex;
    }

    public void setCorruptionPerception(double corruptionPerception) {
        this.corruptionPerception = corruptionPerception;
    }

    public void setGenerosityIndex(double generosityIndex) {
        this.generosityIndex = generosityIndex;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", happinessIndex=" + happinessIndex +
                ", gdpPerCapita=" + gdpPerCapita +
                ", socialSupport=" + socialSupport +
                ", healthIndex=" + healthIndex +
                ", freedomIndex=" + freedomIndex +
                ", corruptionPerception=" + corruptionPerception +
                ", generosityIndex=" + generosityIndex +
                '}';
    }
}
