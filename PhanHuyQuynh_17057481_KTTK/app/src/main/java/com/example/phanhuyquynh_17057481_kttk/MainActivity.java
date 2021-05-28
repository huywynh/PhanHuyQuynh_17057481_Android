package com.example.phanhuyquynh_17057481_kttk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
        StringRequest request = new StringRequest(Request.Method.GET, apiUrl, response -> {
            if (response != null) {
                UserList list = gson.fromJson(response, UserList.class);
                if (list != null) {
                    adapter = new UserAdapter(list.getUsers());
                    rvUsers = findViewById(R.id.rvUsers);
                    rvUsers.setAdapter(adapter);
                }
            }
        }, error -> {
            Log.d(TAG, error.toString());
        });
    }
}