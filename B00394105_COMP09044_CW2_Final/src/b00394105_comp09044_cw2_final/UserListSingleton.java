package b00394105_comp09044_cw2_final;

public class UserListSingleton {
    private static UserListSingleton instance = null;
    private UserList userList;

    private UserListSingleton() {
        userList = new UserList();
    }

    public static synchronized UserListSingleton getInstance() {
        if (instance == null) {
            instance = new UserListSingleton();
        }
        return instance;
    }

    public UserList getUserList() {
        return userList;
    }
}
