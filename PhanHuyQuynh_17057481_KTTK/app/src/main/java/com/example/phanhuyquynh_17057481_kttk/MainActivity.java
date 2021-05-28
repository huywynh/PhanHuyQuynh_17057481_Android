package com.example.phanhuyquynh_17057481_kttk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView rvUsers;
    private UserAdapter adapter;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiUrl = "https://60b08e501f26610017ffe64f.mockapi.io/api/users";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiUrl, null, response -> {
            if (response != null) {
                
                adapter = new UserAdapter(new ArrayList<>());
                rvUsers = findViewById(R.id.rvUsers);
                rvUsers.setAdapter(adapter);
            }
        }, error -> {
            Log.d(TAG, error.toString());
        });



    }
}