package b00394105_comp09044_cw2_final;

import java.util.LinkedList;
import java.util.ListIterator;

public class UserList {
    LinkedList<User> users = new LinkedList<>();
    
    public UserList(){
        
    }
    
    public Integer checkCount(){
        Integer userCount = users.size();
        return userCount;
    }
    
    public void addUser(String username, String password, Integer userID, Integer listID, Boolean admin){
        User newUser = new User(username, password, userID, listID, admin);
        users.add(newUser);
    }
    
    public boolean checkUser(String username){
        boolean userExists = false;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).username.equals(username)){
                userExists = true;
            }
        }
        return userExists;
    }
    
    public boolean checkPassword(String username, String password){
        boolean passwordCorrect = false;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
                passwordCorrect = true;
            }
        }
        return passwordCorrect;
    }
    
    public boolean checkAdmin(String username, Integer userID){
        boolean isAdmin = false;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).username.equals(username) && users.get(i).userID.equals(userID)){
                if(users.get(i).admin.equals(true)){
                    isAdmin = true;
                }
            }
        }
        return isAdmin;
    }
    
    public void deleteUser(String username, Integer userID){
        for(int i = 0; i< users.size(); i++){
            if(users.get(i).username.equals(username) && users.get(i).userID.equals(userID)){
                users.remove(i);
            }
        }
    }
    
    public Integer getListID(String username, String password){
        Integer retrievedListID = 0;
        for(int i = 0; i< users.size(); i++){
            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
                retrievedListID = users.get(i).listID;
            }
        }
        return retrievedListID;
    }
    
    public LinkedList<User> displayUsers(){
        LinkedList<User> usersList = new LinkedList<>();
        if(users != null && users.size() > 0){
            for (int i = 0; i < users.size(); i++){
                usersList.add(users.get(i));
            }
        }
        return usersList;
    }
}
