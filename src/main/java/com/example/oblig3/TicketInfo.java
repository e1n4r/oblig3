package com.example.oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")

public class TicketInfo {
    @Id
    @GeneratedValue
    private Integer id;
    @Setter
    @Getter
    private String film;
    @Setter
    @Getter
    private int numberOfTickets;
    @Setter
    @Getter
    private String firstName;
    @Setter
    @Getter
    private String lastName;
    @Setter
    @Getter
    private String tlf;
    @Setter
    @Getter
    private String email;



}
