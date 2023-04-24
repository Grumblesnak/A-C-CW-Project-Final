package b00394105_comp09044_cw2_final;

// Class User is used for the structure of each node in UserList
// String username and password are created by the user
// userID and listID are auto-incremented during creation and help identify a user and their corrosponding playlist
// admin takes in either true or false from a combo-box in the GUI
public class User {
    public String username, password;
    public Integer userID, listID;
    public Boolean admin;
    
    // The structure of the User when created/called in UserList for creating new users
    public User(String username, String password, Integer userID, Integer listID, Boolean admin){
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.listID = listID;
        this.admin = admin;
    }
    
    // Override will ensure that when displaying individual users (in a text area) that this structure is taken
    // Rather than a default unintelligble message
    @Override
    public String toString(){
        return "ID: " + this.userID + ". " + this.username + " --- Admin?: " + this.admin;
    }
}
