package com.example.c4q.midunit5practical.network;

import com.example.c4q.midunit5practical.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 1/24/18.
 */

public interface UserService {

    //https://randomuser.me/api/?nat=us&inc=name,location,cell,email,dob,picture&results=20

    @GET("?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<User> getUser();

}
