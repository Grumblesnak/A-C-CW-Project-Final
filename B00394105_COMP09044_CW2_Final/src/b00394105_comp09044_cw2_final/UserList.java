package b00394105_comp09044_cw2_final;

import java.util.LinkedList;

// UserList is made as a list of Users, each node containing the structure of the User Class
public class UserList {
    LinkedList<User> users = new LinkedList<>();
    
    // Method is used as a constructer between the GUI and Users, nothing internal needs to happen
    public UserList(){
        
    }
    
    // checkCount returns the amount of users currently in the program, used for setting a userID
    public Integer checkCount(){
        Integer userCount = users.size();
        return userCount;
    }
    
    // addUser will take in values from RegisterUI and put them into the users list as a new node
    public void addUser(String username, String password, Integer userID, Integer listID, Boolean admin){
        // newUser is created as a new User (structure from the User class) then put into the list
        User newUser = new User(username, password, userID, listID, admin);
        users.add(newUser);
    }
    
    // checkUser is used both in the LogInUI and RegisterUI to ensure that a user exists and unique usernames
    public boolean checkUser(String username){
        boolean userExists = false;
        for(int i = 0; i < users.size(); i++){
            // If the current user has the name passed name...
            if(users.get(i).username.equals(username)){
                // then the user exists and returns true
                userExists = true;
            }
        }
        // othersie returns false
        return userExists;
    }
    
    // checkPassword is used in the LogInUI for sign in using an input username and password duo
    public boolean checkPassword(String username, String password){
        boolean passwordCorrect = false;
        for(int i = 0; i < users.size(); i++){
            // if the current user matches the passed name and the password also matches...
            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
                // Then the password is correct and validation is confirmed
                passwordCorrect = true;
            }
        }
        // Othersie the password is incorrect
        return passwordCorrect;
    }
    
    // checkAdmin is used for the display users button in PlaylistUI
    public boolean checkAdmin(String username, Integer userID){
        boolean isAdmin = false;
        for(int i = 0; i < users.size(); i++){
            // If the current user matches the currently signed in user in the playlist...
            if(users.get(i).username.equals(username) && users.get(i).userID.equals(userID)){
                // and that user is an admin...
                if(users.get(i).admin.equals(true)){
                    // then return true that they are an admin
                    isAdmin = true;
                }
            }
        }
        // Otherwise return false, not an admin
        return isAdmin;
    }
    
    // deleteUser is used in PlaylistUI when the matching button is pressed
    public void deleteUser(String username, Integer userID){
        for(int i = 0; i< users.size(); i++){
            // if the current user matches the currently signed in user...
            if(users.get(i).username.equals(username) && users.get(i).userID.equals(userID)){
                // Then delete their account
                users.remove(i);
            }
        }
    }
    
    // getListID is used to differentiate the MusicLists amongst users using the passed username and password
    public Integer getListID(String username, String password){
        Integer retrievedListID = null;
        for(int i = 0; i< users.size(); i++){
            // if the current user has a username and password that matches the now signed in username and password
            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
                // return the corresponding listID of that user (userID and listID will be the same)
                retrievedListID = users.get(i).listID;
            }
        }
        // otherwise return nothing
        // Unlikely this will happen as users automatically have a playlist (listID) made for them during registration to match their userID
        return retrievedListID;
    }
    
    // displayUsers will return the toString override method in User when called
    public LinkedList<User> displayUsers(){
        LinkedList<User> usersList = new LinkedList<>();
        if(users != null && users.size() > 0){
            // If users is not empty (unlikely since you need to have a user to reach the button related to this) then...
            // Get every user for display (following toString structure)
            for (int i = 0; i < users.size(); i++){
                usersList.add(users.get(i));
            }
        }
        return usersList;
    }
}
