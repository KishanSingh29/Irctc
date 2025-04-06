package TicketBooking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;

    private List<User>  userlist;
    private ObjectMapper objectmapper = new ObjectMapper();



    private static final String USERS_PATH = "TicketBooking/users.json";

    public UserBookingService() throws IOException{
        LoadUsers();

    }

    public List<User> LoadUsers() throws IOException {
        File users = new File(USERS_PATH);

        if (!users.exists()) {
            // If file doesn't exist, create it and initialize empty user list
            users.getParentFile().mkdirs(); // Ensure directory exists
            objectmapper.writeValue(users, new ArrayList<User>());
            userlist = new ArrayList<>();
        } else {
            userlist = objectmapper.readValue(users, new TypeReference<List<User>>() {});
        }

        return userlist;
    }


    public UserBookingService(User user) throws IOException {
        this.user = user;
        LoadUsers();
    }
    public Boolean loginUser(){               //kuch galt hai user 1 dekho constructor me
        Optional<User> foundUser = userlist.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public boolean signUp(User user1){
        try{
            userlist.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
    private void saveUserListToFile() throws IOException {
        File userFile = new File(USERS_PATH);
        objectmapper.writeValue(userFile,userlist);
    }

    public void fetchBooking(){
        user.PrintTicket();
    }
    public Boolean cancelBooking(String TicketId){// toddo with yourSelf
        return Boolean.FALSE;
    }
    public List<Train> getTrains(String source,String Destination){
        try{
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source,Destination);
        } catch (IOException ee){
            return new ArrayList<>();
        }
    }
    public Boolean bookTrainSeat(Train train, int row, int seat) {
        try{
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return true; // Booking successful
                } else {
                    return false; // Seat is already booked
                }
            } else {
                return false; // Invalid row or seat index
            }
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
    public List<List<Integer>> fetchSeats(Train train){
        return train.getSeats();
    }
}
