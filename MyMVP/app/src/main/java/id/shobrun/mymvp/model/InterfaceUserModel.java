package id.shobrun.mymvp.model;
import java.util.ArrayList;
import id.shobrun.mymvp.data.User;
/*
    Created By : Galih Anggi Satriawan
 */
public interface InterfaceUserModel {
    ArrayList<User> getAll();
    User getUser(int position);
    int getUser(String username);
    int isValidUser(String username,String password);
    int getCount();
}
