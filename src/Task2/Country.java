package Task2;

import static Task2.Continent.*;

public enum Country {

    UKRAINE("Ukraine", EUROPE),
    NEDERLAND("Nederland", EUROPE),
    CHINA("China", ASIA),
    NIGER("Niger", AFRICA),
    AUSTRALIA("Australia", OCEANIA),
    CHILE("Chile", SOUTH_AMERICA),
    USA("USA", NORTH_AMERICA);

    private final String countryName;
    private final Continent continent;

    Country(String countryName, Continent continent) {
        this.countryName = countryName;
        this.continent = continent;
    }

    public String getCountryName() {
        return countryName;
    }

    public Continent getContinent() {
        return continent;
    }
}
