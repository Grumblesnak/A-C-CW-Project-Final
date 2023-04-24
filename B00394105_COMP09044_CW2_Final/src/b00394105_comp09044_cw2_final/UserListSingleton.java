package b00394105_comp09044_cw2_final;

// UserListSingleton is used to ensure that only one insance of the UserList is active in the program when active
public class UserListSingleton {
    private static UserListSingleton instance = null;
    private UserList userList;

    private UserListSingleton() {
        userList = new UserList();
    }

    // This ensures that the single instance of UserList is synchronised
    // Instance is used for the singleton, so if there is no active instance then one will be create from the existing singleton (UserList)
    public static synchronized UserListSingleton getInstance() {
        if (instance == null) {
            instance = new UserListSingleton();
        }
        return instance;
    }

    // Simply returns the userList when called
    public UserList getUserList() {
        return userList;
    }
}
