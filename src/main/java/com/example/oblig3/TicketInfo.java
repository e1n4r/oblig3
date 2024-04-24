package com.example.oblig3;

public class TicketInfo {
    private String film;
    private int numberOfTickets;
    private String firstName;
    private String lastName;
    private String tlf;
    private String email;

    public TicketInfo(String film, int numberOfTickets, String firstName, String lastName, String tlf, String email) {
        this.film = film;
        this.numberOfTickets = numberOfTickets;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tlf = tlf;
        this.email = email;
    }
    public TicketInfo(){

    }


    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
