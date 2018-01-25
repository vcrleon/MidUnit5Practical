package com.example.c4q.midunit5practical.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c4q.midunit5practical.R;
import com.example.c4q.midunit5practical.controller.UserAdapter;
import com.example.c4q.midunit5practical.model.Results;
import com.example.c4q.midunit5practical.model.User;
import com.example.c4q.midunit5practical.network.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //https://randomuser.me/api/?nat=us&inc=name,location,cell,email,dob,picture&results=20
    private final String BASE_URL = "https://randomuser.me/api/";
    private Retrofit retrofit;
    private UserService userService;
    List<Results> userResultsList;
    RecyclerView userRV;
    UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userResultsList = new ArrayList<>();
        userRV = findViewById(R.id.user_rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        userRV.setLayoutManager(gridLayoutManager);
        connectApi();

    }

    public void connectApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userService = retrofit.create(UserService.class);

        Call<User> userCall = userService.getUser();
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userResultsList.addAll(response.body().getResults());
                userAdapter = new UserAdapter(userResultsList);
                userRV.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }

    public void secondActivityIntent(){


        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//        intent.putExtra("info", );
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                Toast.makeText(this, "Refresh ", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
