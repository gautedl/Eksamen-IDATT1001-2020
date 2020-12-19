import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Iterator;

/**
 * En klasse som administrerer registreringene
 * @version 14.12.2020
 * @Author 10020
 */

public class CovidRegister {
    private String navn;
    //Bruker en ArrayList slik at man enklere kan legge til og ta vekk fra registeret
    private ArrayList<CovidLocationStats> covidLocationStats;

    /**
     * Konstruktør for å opprette en liste med registreringer
     * @param navn
     */
    public CovidRegister(String navn) {
        this.navn = navn;
        covidLocationStats = new ArrayList<CovidLocationStats>();
    }

    /**
     * Legger til en ny registrering
     * @param nyCovidLocationStats
     * @return
     */
    public boolean covidRegistrering(CovidLocationStats nyCovidLocationStats){
        // Sjekker først om det allerede er gjort en registrering som tilsvarer den nye.
        // Finnes registreringen fra før vil ikke den nye bli lagt til.
        if (!covidLocationStats.contains(nyCovidLocationStats)){
            // Legger til ny registrering i listen.
            covidLocationStats.add(nyCovidLocationStats);
            return true;
        } else{
            return false;
        }
    }

    /**
     * Søker etter registrering på spesifikk dato
     * @param datoInn
     * @return
     */

    public CovidLocationStats searchSpecificDate(LocalDate datoInn){
        // Oppretter en ny liste med info om den gitte datoen
        ArrayList<CovidLocationStats> list = new ArrayList<>();
        for (CovidLocationStats c : this.covidLocationStats){
            //Går gjennom listen og sjekker om to datoer er like
            if (datoInn.isEqual(c.getDate()));{
                // Returnerer det første instanset der de to datoene er like.
                return c;
            }
        }
        // Returnerer den nye listen.
        return null;
    }

    /**
     * Henter registreringer etter en gitt dato
     * @param datoInn
     * @return
     */
    public ArrayList<CovidLocationStats> searchAfterSpecificDate(LocalDate datoInn){
        // Oppretter en ny liste der registreringer gjort etter den gitte datoen blir lagt inn.
        ArrayList<CovidLocationStats> list = new ArrayList<>();
        //Går gjennom listen og sjekker om to datoer er like
        for (CovidLocationStats c : this.covidLocationStats){
            if (c.getDate().isAfter(datoInn)){
                // Legger til de datoene som samsvarer i en ny liste.
                list.add(c);
            }
        }
        // Returnerer den nye listen.
        return list;
    }

    /**
     * Returnerer antall døde i et gitt land
     * @param country
     * @return
     */

    //Henter inn et land som tekstreng
    public int numberOfDeathsCountry(String country){
        int sum = 0;
        for (CovidLocationStats c : this.covidLocationStats){
            //Går gjennom listen og sjekker om inputen er lik et land som er registrert
            if (country.equalsIgnoreCase(c.getCountry())){
                //Summerer antall døde i det gitte landet
                sum += c.getDeaths();
            }
        }
        //Returnerer antall døde i det gitte landet
        return sum;
    }

    /**
     *
     * @return Returnerer antall smittedede registrert
     */
    public int numberOfInfected(){
        int sum = 0;
        //Går gjennom listen og summerer antall smittede
        for (CovidLocationStats c : this.covidLocationStats){
            sum += c.getInfected();
        }
        //returnerer antall smittede
        return sum;
    }

    /**
     * Iterator som kan brukes til å gå gjennom listen
     * @return
     */
    public Iterator iteratorCovid(){
        Iterator<CovidLocationStats> it = covidLocationStats.iterator();
        return it;
    }

    /**
     * Metode som returnerer informarsjon om registreringer
     * @return
     */


    @Override
    public String toString() {
        return  navn +"\n"+ covidLocationStats +"\n";
    }
}
