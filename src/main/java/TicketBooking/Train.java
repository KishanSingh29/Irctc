package TicketBooking;

import java.security.PrivateKey;
import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;

    private String trainNo;

    private List<List<Integer>> seats;

    private Map<String, String> StationTimes;

    private List<String> Stations;

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public Map<String, String> getStationTimes() {
        return StationTimes;
    }

    public void setStationTimes(Map<String, String> stationTimes) {
        StationTimes = stationTimes;
    }

    public List<String> getStations() {
        return Stations;
    }

    public void setStations(List<String> stations) {
        Stations = stations;
    }
    public String getTicketInfo(){
        return String.format("Train ID: %s Train No: %s", trainId, trainNo);
    }
}
