package id.shobrun.mymvp.model;
import java.util.ArrayList;
import id.shobrun.mymvp.data.User;
import id.shobrun.mymvp.data.UserData;

/*
    Created By : Galih Anggi Satriawan
 */
public class UserModel implements InterfaceUserModel {
    private ArrayList<User> users;

    public UserModel() {
        this.users = getAll();
    }

    @Override
    public ArrayList<User> getAll() {
        users = new ArrayList<>();
        for(int i =0 ;i<UserData.users.length;i++){
            User nUser = new User();
            nUser.setUsername(UserData.users[i][0]);
            nUser.setPassword(UserData.users[i][1]);
            users.add(nUser);
        }

        return users;
    }

    @Override
    public User getUser(int position) {
        return users.get(position);
    }
    @Override
    public int getUser(String username) {

        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(username))
                return i;
        }
        return -1;
    }

    public int isValidUser(String username, String password){
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            if(user.getUsername().equals(username)&&(user.getPassword().equals(password)))
                return i;
        }
        return -1;
    }

    @Override
    public int getCount() {
        return users.size();
    }
}
