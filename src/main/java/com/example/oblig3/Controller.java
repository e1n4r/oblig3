package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    TicketRepository ticketRepository;
    private String[] films = new String[]{"Aquaman","Argylle","Sau"};
    @PostMapping("/get-films")
    public String[]getFilms(){
        return films;
    }
    @PostMapping("/register-ticket")
    public void registerTicket(TicketInfo ticket){
        ticketRepository.save(ticket);
    }
    @PostMapping("/get-tickets")
    public List<TicketInfo> getTickets(){
        return ticketRepository.findAll();
    }
    @PostMapping("/delete-tickets")
    public void deleteTickets(){
        ticketRepository.deleteAll();
    }

}
