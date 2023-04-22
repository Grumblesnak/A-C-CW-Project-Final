package b00394105_comp09044_cw2_final;

public class User {
    public String username, password;
    public Integer userID, listID;
    public Boolean admin;
    
    public User(String username, String password, Integer userID, Integer listID, Boolean admin){
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.listID = listID;
        this.admin = admin;
    }
    
    @Override
    public String toString(){
        return "ID: " + this.userID + ". " + this.username + " --- Admin?: " + this.admin;
    }
}
