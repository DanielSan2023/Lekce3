package com.Engeto.Firma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TimeClocksWorker {

    private List<Person> personList = new ArrayList<>();

    public void add(Person newPerson) {

        personList.add(newPerson);
    }

    public void addAll(List<Person> peopleToAdd) {
        personList.addAll(peopleToAdd);
    }

    public int numberOfPeople() {
        return personList.size();
    }

    public double getTicketsAverage() {
        int totalTickets = 0;
        for (Person person : personList) {
            totalTickets += person.getTickets();
        }
        return totalTickets / personList.size();
    }

    public Person firstPersonOverTicketLimit(int limit) {
        for (Person person : personList) {
            if (person.getTickets() > limit) {
                return person;
            }
        }
        return null;
    }

    public  List<Person> getPeopleWithTopTickets(int count, List<Person> personList) {
        if (count <= 0) {
            return Collections.emptyList(); // Pokud je počet nulový nebo záporný, vrátíme prázdný seznam.
        }

        // Seřadíme seznam osob podle počtu ticketů sestupně.
        List<Person> sortedList = personList.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getTickets(), p1.getTickets()))
                .collect(Collectors.toList());

        // Omezíme seznam na první 'count' osob s největším počtem ticketů.
        return sortedList.stream().limit(count).collect(Collectors.toList());
    }





}
