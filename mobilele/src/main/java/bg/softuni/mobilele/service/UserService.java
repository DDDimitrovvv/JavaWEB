package bg.softuni.mobilele.service;

public interface UserService {

    //returns true if the user is authenticated successfully
    boolean authenticate(String username, String password);

    void loginUser(String username);

    void logoutCurrentUser();

}
