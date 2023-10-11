package com.Engeto.Firma;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Person  {
    private static int nextId = 1;  // triedny atribut....static je spolecna pre vsetkz objekty
    private int id = nextId++;

    private String name;
    private String surname;
    private BigDecimal account;
    private boolean isEmployee;
    private int tickets= 0;
    LocalDate lastArrival;
    private int bodyTemperature = -300;

    public Person(String name, String surname) {

        this(name,surname,BigDecimal.ZERO,true,LocalDate.now());
    }

    public Person(String name, String surname, BigDecimal account, boolean isEmployee,
                  LocalDate lastArrival) {
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.isEmployee = isEmployee;
        this.lastArrival = lastArrival;

    }

    public Person(String name, String surname, LocalDate lastArrival) {
        this.name = name;
        this.surname = surname;
        this.lastArrival = lastArrival;
    }

    public Person(String name, String surname, boolean isEmployee, LocalDate lastArrival) {
        this.name = name;
        this.surname = surname;
        this.isEmployee = isEmployee;
        this.lastArrival = lastArrival;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        if (surname == null){return " ";}
        else return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public LocalDate getLastArrival() {
        return lastArrival;
    }

    public void setLastArrival(LocalDate lastArrival) {
        this.lastArrival = lastArrival;
    }

    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(int bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int getId() {
        return id;

    }

    @Override
    public String toString() {
        if (isEmployee()) {
            return    name + '\'' +
                      surname + '\'' +
                    "(ID: "+id +")" +
                    " tickets=" + tickets +
                    '}';
        } else {return "Navsteva:" +
                  name + '\'' +
                 surname + '\'' +
             tickets
                ;
        }
    }
}