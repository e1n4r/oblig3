package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;
    public void registerTicket(TicketInfo ticket){
        String sql = "INSERT INTO TicketInfo (film, numberOfTickets, firstName, lastName, tlf, email) VALUES (?,?,?,?,?,?)";
        db.update(sql, ticket.getFilm(), ticket.getNumberOfTickets(), ticket.getFirstName(), ticket.getLastName(), ticket.getTlf(), ticket.getEmail());
    }
    public List<TicketInfo>getTickets(){
        String sql = "SELECT * FROM TicketInfo";
        List<TicketInfo> tickets = db.query(sql,new BeanPropertyRowMapper(TicketInfo.class));
        return tickets;
    }
    public void deleteTickets(){
        String sql = "DELETE FROM TicketInfo";
        db.update(sql);
    }
}
