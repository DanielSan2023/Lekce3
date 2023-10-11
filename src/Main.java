import com.Engeto.Firma.Person;
import com.Engeto.Firma.TimeClocksWorker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Worker worker = new Worker(false, false);
        System.out.println(worker.netWage(10000)); // -> 8500
        TimeClocksWorker worker1 = new TimeClocksWorker();
        List<Person> personList = new ArrayList<>();

        int  numberOfEmployees= 5;
        for(int i = 0; i<numberOfEmployees ; i++){
            personList.add(new Person("Employee"," " +i,true,LocalDate.now()));
        }

        Person charles = new Person("Charles"," DARWIN",true,LocalDate.of(2022,10,7));
        Person anna = new Person("Anna","Kurnikovova", BigDecimal.valueOf(150), false, LocalDate.now());

        personList.add(charles);
        personList.add(anna);
        personList.get(0).setTickets(20);  // vyber zo zoznamu  prveho a daj mu  25 ticket
        personList.get(1).setTickets(12);  // vyber zo zoznamu  prveho a daj mu  28 ticket
        personList.get(2).setTickets(1);
        anna.setTickets(58);
        charles.setTickets(40);

        System.out.println("Anna: "+anna.getId());
        System.out.println("Charles: "+charles.getId());
        System.out.println("Pocet osob v seznamu: "+personList.size());


        printEmployeesNames(personList);

        PrintPeopleWithPosition(personList);

        //Ukol2
        System.out.println("----------------UKOL 2--------------------------------------");
        printNumberGuests(personList);
        getWhoHasFirstTicket(personList);

        getTodayTickets(personList,10,52);
        printLastMonthArrivals(personList);
        getPersonWhoBirstToday(personList);
        System.out.println("----------------UKOL 3--------------------------------------");
        getPersonNameTicketName(personList);


        System.out.println("----------------Pre zdatnych--------------------------------------");
        List<Person> topTicketPeople =worker1.getPeopleWithTopTickets(3,personList);

        System.out.println("Osoby s největším počtem ticketů:");
        for (Person person : topTicketPeople) {
            System.out.println(person.getName() + " " + person.getSurname() + " - " + person.getTickets() + " ticketů");
        }




    }



    private static void getPersonNameTicketName(List<Person> personList) {
        for (Person person : personList) {
            int ticketCount = person.getTickets();
            String formattedCount = " ";
            switch (ticketCount) {
                case 0:  formattedCount += "bez ticketů"; break;
                case 1: formattedCount += "první ticket"; break;
                case 12: formattedCount += "první tucet ticketů"; break;
                default: if (ticketCount > 30) {formattedCount += "zkušený zlepšovatel";
                    } else { formattedCount += ticketCount + " ticketů"; }
            }
            System.out.println(person.getName() + " " + person.getSurname() + " ("+formattedCount+")");
        }
    }

    private static void getPersonWhoBirstToday(List<Person> personList) {
        boolean found =false;
        String nameDate= "Charles";
        System.out.println("Dnes má meniny: ");
        for(Person person : personList){
            if (person.getName().equals(nameDate)){
                System.out.println(person.getName());
                found =true;
            }
        }
        if (!found) {
            System.out.println("nikto"); // Vytiskne "nikto", pokud nikdo nebyl nalezen.
        }
    }

    private static TimeClocksWorker getWhoHasFirstTicket(List<Person> personList) {
        TimeClocksWorker worker1 = new TimeClocksWorker();
        worker1.addAll(personList);
        System.out.println("pocet osob:"+worker1.numberOfPeople());
        System.out.println("Prumerny pocet ticketu : " +worker1.getTicketsAverage());
        int limit =25;
        System.out.println("Prvni cez limit "+limit + ":" +worker1.firstPersonOverTicketLimit(limit));
        return worker1;
    }


    private static void printLastMonthArrivals(List<Person> personList) {
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);

        System.out.println("Osoby, které přišly naposledy minulý měsíc:");
        boolean found = false;

        for (Person person : personList) {
            LocalDate lastArrivalDate = person.getLastArrival();
            LocalDate currentDate = LocalDate.now();
            if (lastArrivalDate != null && !lastArrivalDate.isAfter(currentDate) && lastArrivalDate.isAfter(lastMonth)) {
                String formattedDate = lastArrivalDate.toString();
                System.out.println(person.getName() + " přišel(a) naposledy " + formattedDate);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Žádný zaměstnanec nepřišel naposledy minulý měsíc.");
        }
    }
    //Finding person Whose have correct numbers of ticket Today
    private static void getTodayTickets(List<Person> personList,int minTicket,int maxTicket) {
        LocalDate currentDate = LocalDate.now();
        List<Person> matchingPersons = new ArrayList<>();

        for (Person person : personList) {
            if (person.getTickets() >= minTicket && person.getTickets() <= maxTicket &&
                    person.getLastArrival().isEqual(currentDate)) {
                matchingPersons.add(person);
            }
        }
        System.out.println("Osoby s lístky v rozmezí od "+minTicket +" do " + maxTicket + ":");

        if (matchingPersons.isEmpty()) {
            System.out.println("Žádná osoba neodpovídá kritériím.");
        } else {
            for (Person person : matchingPersons) {
                System.out.println(person.getName() + "  " + person.getTickets());
            }
        }
    }


    private static void printNumberGuests(List<Person> personList) {
                    int pocetHosti =  0;
            for(Person person : personList){
                if (!person.isEmployee()){  // nie zamestnanec cize jt host.
                    pocetHosti++;
                }}
            System.out.println("Pocet hosti: "+pocetHosti);
        }

    private static void printEmployeesNames(List<Person> personList) {
        System.out.println("Mena osob zamestnancu: ");
        for(Person person : personList){
            if (person.isEmployee()){
                System.out.println(person.getName());
            }

        }
    }

    private static void PrintPeopleWithPosition(List<Person> personList) {
        System.out.println("Mena osob hosti: ");
        int counter = 1;
        for(Person person : personList){
            System.out.print(counter+ ")");
            System.out.print(person.getName()+" "+person.getSurname()+"(");

            String position;
            if (person.isEmployee()){ position= ("zamestnanec");
            }else position = ("host");
            System.out.print(position);

            System.out.println(")");
            counter++;


        }
    }


}
