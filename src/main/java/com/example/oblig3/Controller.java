package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private TicketRepository rep;
    private String[] films = new String[]{"Aquaman","Argylle","Sau"};
    @PostMapping("/register-ticket")
    public void registerTicket(TicketInfo ticket){
        rep.registerTicket(ticket);
    }
    @PostMapping("/get-tickets")
    public List<TicketInfo> getTickets(){
        return rep.getTickets();
    }
    @PostMapping("/get-films")
    public String[]getFilms(){
        return films;
    }
    @PostMapping("/delete-tickets")
    public void deleteTickets(){
        rep.deleteTickets();
    }

}
