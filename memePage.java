package com.example.day6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class memePage extends AppCompatActivity {
    private String currentImg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_page);
        getMeme();
        Button nextMemeButton = findViewById(R.id.nextMeme);
        Button shareMemeButton = findViewById(R.id.shareMeme);
        nextMemeButton.setOnClickListener(view->{
            nextMeme();
        });
        shareMemeButton.setOnClickListener(view->{
            shareMeme();
        });
    }

    void getMeme(){
        ImageView memeImage = findViewById(R.id.memeImage);
        RequestQueue queue = Volley.newRequestQueue(this);
        String URL = "https://meme-api.herokuapp.com/gimme";
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, URL, null,
                response ->
                {
                    try {
                        currentImg = response.getString("url");
                        String memeURL = response.getString("url");
                        Glide.with(this).load(memeURL).into(memeImage);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error->{
                    Toast.makeText(this, "Something Went Wrong!!", Toast.LENGTH_LONG).show();
                }
                );
        queue.add(req);
    }
    void nextMeme(){
        getMeme();
    }
    void shareMeme(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "");
        Intent chooser = Intent.createChooser(intent, "Hey Take a Look at this " + currentImg);
        try{
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(this, "No Compatible App Found!!", Toast.LENGTH_LONG).show();
        }
    }
}
