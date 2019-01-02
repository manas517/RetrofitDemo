package com.nayanatech.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nayanatech.retrofitdemo.Model.UnknownModel;
import com.nayanatech.retrofitdemo.Model.User;
import com.nayanatech.retrofitdemo.Network.ApiClient;
import com.nayanatech.retrofitdemo.Network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView unknown,userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        unknown=findViewById(R.id.textView);
        userlist=findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                networkCallForUnknownList();
                networkCallForUserList();

            }
        });
    }

    private void networkCallForUserList() {
        ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<UnknownModel> call=apiInterface.getUnknownList();
        call.enqueue(new Callback<UnknownModel>() {
            @Override
            public void onResponse(Call<UnknownModel> call, Response<UnknownModel> response) {
                UnknownModel unknownModel;
                unknownModel=response.body();
                unknown.setVisibility(View.VISIBLE);
                unknown.setText(unknownModel.getTotalPages().toString());

            }

            @Override
            public void onFailure(Call<UnknownModel> call, Throwable t) {
            call.cancel();
            }
        });
    }

    private void networkCallForUnknownList() {
        ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<User> call=apiInterface.createUser(new User("MANAS JAYA","ANDROID INFOSYS"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user=response.body();
                userlist.setVisibility(View.VISIBLE);
                userlist.setText(user.id+"\n"+user.name+"\n"+user.job+"\n"+user.createdAt);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}
