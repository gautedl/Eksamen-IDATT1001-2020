import java.time.LocalDate;
import java.util.Objects;

public class CovidLocationStats {
    /**
     * En klasse som representerer en registrering
     * @Version 14.12 2020
     * @Author 10020
     */

    //Relevante datatyper jeg trenger til dette programmet.
    private LocalDate date;
    private String country;
    private int infected;
    private int deaths;

    /**
     * Konstruktør
     * @param date Dato i registrering
     * @param country Land i registrering
     * @param infected Antall smittede på den gitte datoen
     * @param deaths Antall døde på den gitte datoen
     */

    public CovidLocationStats(LocalDate date, String country, int infected, int deaths) {
        // Sjekker at antall smittede og/eller døde er positive tall.
        if (infected < 0 && deaths < 0 || infected < 0 || deaths < 0){
            throw new IllegalArgumentException("Antall smittede og/eller døde kan ikke være et negativt tall.");
        }
        this.date = date;
        this.country = country;
        this.infected = infected;
        this.deaths = deaths;
    }
    //Henter de get-metodene jeg trenger for å bruke programmet.

    /**
     *
     * @return returnerer dato
     */

    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @return Returnerer land
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @return Returnerer antall smittede
     */
    public int getInfected() {
        return infected;
    }

    /**
     * Returnerer antall døde
     * @return
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * Metode som sammenligner to registreringer
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CovidLocationStats that = (CovidLocationStats) o;
        return infected == that.infected &&
                deaths == that.deaths &&
                Objects.equals(date, that.date) &&
                Objects.equals(country, that.country);
    }

    /**
     * Metode som returnerer informarsjon om registreringer
     * Eksempel på utskrift
     * 2020-01-19 China: Smittede: 136 Døde: 1
     * @return
     */
    @Override
    public String toString() {
        return  date + " " + country + ": Smittede: " + infected + " Døde: " + deaths + "\n";
    }
}
