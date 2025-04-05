package TicketBooking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class UserBookingService {
    private User user;

    private List<User> userlist;
    private ObjectMapper objectmapper = new ObjectMapper();



    private static final String USERS_PATH = "java/TicketBooking/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;

        File users = new File(USERS_PATH);

        userlist = objectmapper.readValue(users, new TypeReference<List<User>>() {});
    }
}
