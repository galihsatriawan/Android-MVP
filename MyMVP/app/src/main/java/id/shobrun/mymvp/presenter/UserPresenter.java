package id.shobrun.mymvp.presenter;
import id.shobrun.mymvp.model.UserModel;
import id.shobrun.mymvp.view.UserView;
/*
    Created By : Galih Anggi Satriawan
 */
public class UserPresenter {
    UserView mUserView;
    UserModel mUserModel;
    public UserPresenter(UserView mUserView) {
        this.mUserView = mUserView;
        this.mUserModel = new UserModel();
    }

    public void checkUser(String username,String password){
        int position = mUserModel.isValidUser(username,password);
        if(position!=-1){
            String data = "Username  "+mUserModel.getUser(position).getUsername()+" valid";
            mUserView.onValidUser(data);
        }else{
            String data = "Username dan password anda tidak valid" +
                    "\n Silahkan inputkan kembali";
            mUserView.onInvalidUser(data);
        }
    }

}
