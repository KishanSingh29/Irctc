package TicketBooking;

import java.util.Date;

public class Ticket {
    private String TicketId;

    private String UserId;

    private String Source;

    private String Destination;

    private Date DateOfTravel;

    private Train train;

    public Ticket(String ticketId, String userId, String source, String destination, Date dateOfTravel, Train train) {
        TicketId = ticketId;
        UserId = userId;
        Source = source;
        Destination = destination;
        DateOfTravel = dateOfTravel;
        this.train = train;
    }

    public String getTicketInfo(){
        return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s",TicketId,UserId,Source,Destination,DateOfTravel);
    }

    public String getTicketId() {
        return TicketId;
    }

    public void setTicketId(String ticketId) {
        TicketId = ticketId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public Date getDateOfTravel() {
        return DateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        DateOfTravel = dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
