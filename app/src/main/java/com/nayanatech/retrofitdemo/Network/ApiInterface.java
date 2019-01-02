package com.nayanatech.retrofitdemo.Network;

import com.nayanatech.retrofitdemo.Model.UnknownModel;
import com.nayanatech.retrofitdemo.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.nayanatech.retrofitdemo.Network.ApiUrl.UNKNOWN_URL;
import static com.nayanatech.retrofitdemo.Network.ApiUrl.USER_URL;

public interface ApiInterface {
    @GET(UNKNOWN_URL)
    Call<UnknownModel> getUnknownList();
    @POST(USER_URL)
    Call<User> createUser(@Body User user);
}
