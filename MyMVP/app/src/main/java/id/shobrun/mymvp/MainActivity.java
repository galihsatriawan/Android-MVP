package id.shobrun.mymvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import id.shobrun.mymvp.presenter.UserPresenter;
import id.shobrun.mymvp.view.UserView;
/*
    Created By : Galih Anggi Satriawan
 */
public class MainActivity extends AppCompatActivity implements UserView {
    UserPresenter mUserPresenter;
    EditText edtUsername,edtPassword;
    TextView tvNotification;
    Button btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElement();
        initPresenter();
        addListener();
    }
    public void initPresenter(){
        mUserPresenter = new UserPresenter(this);
    }
    public void initElement(){
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        tvNotification = findViewById(R.id.tv_notification);
        btnCheck = findViewById(R.id.btn_check);
    }
    public void addListener(){
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmptyField = false;
                String username ,password;
                username = edtUsername.getText().toString().trim();
                password = edtPassword.getText().toString().trim();
                if(TextUtils.isEmpty(username)){
                    edtUsername.setError("Field ini tidak boleh kosong");
                    isEmptyField = true;
                }
                if(TextUtils.isEmpty(password)){
                    edtPassword.setError("Field ini tidak boleh kosong");
                    isEmptyField = true;
                }
                if(!isEmptyField){
                    // Send data to Presenter
                    mUserPresenter.checkUser(username,password);
                }
            }
        });
    }

    @Override
    public void onValidUser(String data) {
        tvNotification.setText(data);
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInvalidUser(String data) {
        tvNotification.setText(data);
        Toast.makeText(getApplicationContext(),"User is invalid",Toast.LENGTH_SHORT).show();
    }
}
