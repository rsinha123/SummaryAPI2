package com.example.summaryapi;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Text;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView originalText;
    Button summarizer;
    TextView newText;
    private final OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newText = findViewById(R.id.newtext);
        originalText = findViewById(R.id.ogtext);

              summarizer= (Button) findViewById(R.id.sum);


        summarizer.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    final Request request = new Request.Builder()
                            .url("https://api.meaningcloud.com/summarization-1.0?key=fc48e71a78c18cd070b2fd5937ada431&url=https://www.espn.com/nfl/story/_/id/28871296/2020-nfl-free-agency-trade-grades-bill-barnwell-tracks-every-big-signing-move&sentences=5")
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }


                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            try (ResponseBody responseBody = response.body()) {
                                if (!response.isSuccessful())
                                    throw new IOException("Unexpected code " );


                                newText.setText(responseBody.string());

                            }





                        }})
                    ;}




            });
        }}









