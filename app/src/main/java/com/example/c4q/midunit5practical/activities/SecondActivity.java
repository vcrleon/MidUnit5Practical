package com.example.c4q.midunit5practical.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.midunit5practical.R;
import com.example.c4q.midunit5practical.model.Results;
import com.example.c4q.midunit5practical.model.User;
import com.example.c4q.midunit5practical.network.UserService;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    UserService userService;

    ImageView picture;
    TextView firstName;
    TextView lastName;
    TextView email;
    TextView street;
    TextView city;
    TextView state;
    TextView zipcode;
    TextView dob;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        settingViews();





    }

    public void settingViews(){
        picture = findViewById(R.id.large_user_image);
        firstName = findViewById(R.id.user_first_name);
        lastName = findViewById(R.id.user_last_name);
        email = findViewById(R.id.user_email);
        street = findViewById(R.id.user_street);
        city = findViewById(R.id.user_city);
        state = findViewById(R.id.user_state);
        zipcode = findViewById(R.id.user_zipcode);
        dob = findViewById(R.id.user_dob);

    }

//    public void makingUserCall() {
//        Call<User> userInfoCall = userService.getUser();
//        userInfoCall.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                firstName.setText(response.body().getResults().get(0).getName().toString());
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                t.printStackTrace();
//
//            }
//        });
//    }



}
