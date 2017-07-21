package dao;


import beans.User;

import java.util.List;

/**
 * Created by Prashant on 09-Jul-17.
 */
public interface UserDao {
    public String addUser(User user);

    /* public List<User> listUsers();*/
    public void searchAdmin();

    public List subscriptionDisplay(User user);

    public void checkAdmin();

    public void addAdmin();

    public void updateUser(User user);

    public void deleteUser(String email);

    public boolean checkLogin(String User, String Password);

    public boolean checkEmailUser(String email, String username);

    public String checkEmail(String email);

    public String changePassword(String email, String pass);

    public String getid(String email);

    public int getUserID(String Username);
    public User  getUserData(String username);
    public long countSubscription(User userid);
    public long countTopic(User userid);
}
