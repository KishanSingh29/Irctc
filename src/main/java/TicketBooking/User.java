package TicketBooking;

import java.util.List;

public class User {
    private String name;

    private String password;

    private String hashPassword;

    private List<Ticket> TicketsBooked;

    private String UserId;

    public User(String name, String password, String hashPassword, List<Ticket> ticketsBooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        TicketsBooked = ticketsBooked;
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return UserId;
    }

    public  void PrintTicket(){
        for (int i = 0; i <TicketsBooked.size(); i++) {
            System.out.println(TicketsBooked.get(i).getTicketInfo());
        }
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getTicketsBooked() {
        return TicketsBooked;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        TicketsBooked = ticketsBooked;
    }
}
