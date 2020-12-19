import java.time.LocalDate;
import java.util.Scanner;

public class CovidClient {
    public static void main(String[] args) {
        // Henter inn to tilfeller av registrering for å teste programmet.
        CovidRegister covidReg = new CovidRegister("Covid register");
        CovidLocationStats cov1 = new CovidLocationStats(LocalDate.of(2020, 1,19), "China", 136, 1);
        CovidLocationStats cov2 = new CovidLocationStats(LocalDate.of(2020, 5, 02), "China", 3872, 66);
        CovidLocationStats cov3 = new CovidLocationStats(LocalDate.of(2020,7,03), "Norge", 3, 0);
        CovidLocationStats cov4 = new CovidLocationStats(LocalDate.of(2020,9,03), "USA", 259, 4);
        CovidLocationStats cov5 = new CovidLocationStats(LocalDate.of(2020,9,03), "Norge", 3, 0);
        covidReg.covidRegistrering(cov1);
        covidReg.covidRegistrering(cov2);
        covidReg.covidRegistrering(cov3);
        covidReg.covidRegistrering(cov4);
        covidReg.covidRegistrering(cov5);

        boolean flag = true;
        // Programmet kjører så lenge flag er true
        while (flag) {
            try {
                Scanner s = new Scanner(System.in);
                switch (visMeny()) {
                    case 1:
                        int year;
                        int month;
                        int day;
                        String country;
                        int infected;
                        int deaths;

                        System.out.println("Skriv inn dato årstall i format YYYY");
                        year = s.nextInt();
                        System.out.println("Skriv inn måned i format M/MM");
                        month = s.nextInt();
                        System.out.println("Skriv in dag i format D/DD");
                        day = s.nextInt();
                        System.out.println("Skriv inn land:");
                        s.nextLine();
                        country = s.nextLine();
                        System.out.println("Skriv inn antall smittede:");
                        infected = s.nextInt();
                        System.out.println("Skriv inn antall døde:");
                        deaths = s.nextInt();

                        LocalDate date = LocalDate.of(year, month, day); // Gjør om År, måned og dag til en instans av LocalDate
                        CovidLocationStats newReg = new CovidLocationStats(date, country, infected, deaths);
                        covidReg.covidRegistrering(newReg);
                        break;
                    case 2:
                        System.out.println(covidReg);
                        break;
                    case 3:
                        System.out.println("Skriv inn dato årstall i format YYYY");
                        year = s.nextInt();
                        System.out.println("Skriv inn måned i format M/MM");
                        month = s.nextInt();
                        System.out.println("Skriv in dag i format D/DD");
                        day = s.nextInt();
                        date = LocalDate.of(year, month, day);// Gjør om År, måned og dag til en instans av LocalDate
                        System.out.println(covidReg.searchSpecificDate(date));
                        break;
                    case 4:
                        System.out.println("Skriv inn dato årstall i format YYYY");
                        year = s.nextInt();
                        System.out.println("Skriv inn måned i format M/MM");
                        month = s.nextInt();
                        System.out.println("Skriv in dag i format D/DD");
                        day = s.nextInt();
                        date = LocalDate.of(year, month, day);// Gjør om År, måned og dag til en instans av LocalDate
                        System.out.println(covidReg.searchAfterSpecificDate(date));
                        break;
                    case 5:
                        System.out.println("Skriv inn land:");
                        country = s.nextLine();
                        System.out.println(covidReg.numberOfDeathsCountry(country));
                        break;
                    case 6:
                        System.out.println(covidReg.numberOfInfected());
                        break;
                    case 7:
                        System.out.println("Avslutter programmet...");
                        flag = false;
                        break;
                }
                // Cacher eventuell feil i programmet.
            } catch (NumberFormatException n) {
                System.out.println("Du skrev inn bokstav når tall var forventet");
            } catch (IllegalArgumentException ill) {
                System.out.println(ill.getMessage());
            } catch (Exception e) {
                System.out.println("Det skjedde en uventet feil.");
            }
        }
    }


    public static int visMeny(){
        System.out.println("1: Registrere Covid-19 tilfeller:\n" +
                "2: Skriv ut liste over alle registreringer:\n" +
                "3: Søke etter registrering basert på dato:\n" +
                "4: Søke etter registreringer etter en gitt dato:\n" +
                "5: Regne ut samlet antall døde for et gitt land:\n" +
                "6: Regne ut samlet antall smittede:\n" +
                "7: Avslutt.");
        Scanner s = new Scanner(System.in);
        return Integer.parseInt(s.nextLine());
    }
}
