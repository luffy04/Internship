package com.example.intern;

import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static MyDatabase myAppDatabase;
    @RequiresApi(api = Build.VERSION_CODES.N)

    Button delete;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        delete=(Button)findViewById(R.id.delete);
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);

        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"userdb").allowMainThreadQueries().build();

        List<Country> users=myAppDatabase.myDao().getUsers();

//
//        TableView<Country> table = findViewById(R.id.tableView);
//        table.setHeaderAdapter(new SimpleTableHeaderAdapter(this, String.valueOf(list)));

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAppDatabase.myDao().delete();
                stk.removeViews(1, Math.max(0, stk.getChildCount() - 1));
            }
        });

        final JSONArray[] arr1 = {new JSONArray()};


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while(true) {

                }
            }
        };



        AsyncHttpClient client=new AsyncHttpClient();
        client.get("https://restcountries.eu/rest/v2/region/asia", new JsonHttpResponseHandler(){
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                arr1[0] =response;
                try{

                    for (int i = 0; i < arr1[0].length(); i++) {
                        JSONObject jsonobject = arr1[0].getJSONObject(i);
                        String name = jsonobject.getString("name");
                        String capital = jsonobject.getString("capital");
                        String region=jsonobject.getString("region");
                        String subregion=jsonobject.getString("subregion");
                        String population=jsonobject.getString("population");
                        JSONArray borders=jsonobject.getJSONArray("borders");
                        JSONArray lang=jsonobject.getJSONArray("languages");
                        String flag=jsonobject.getString("flag");
                        TableRow tbrow = new TableRow(MainActivity.this);
                        tbrow.setPadding(5,5,5,5);
                        TextView t1v = new TextView(MainActivity.this);
                        t1v.setGravity(Gravity.CENTER);
                        t1v.setPadding(5,5,5,5);
                        t1v.setText(name);
                        t1v.setTextColor(Color.WHITE);
                        t1v.setGravity(Gravity.CENTER);
                        tbrow.addView(t1v);
                        TextView t2v = new TextView(MainActivity.this);
                        t2v.setGravity(Gravity.CENTER);
                        t2v.setPadding(5,5,5,5);
                        t2v.setText(capital);
                        t2v.setTextColor(Color.WHITE);
                        t2v.setGravity(Gravity.CENTER);
                        tbrow.addView(t2v);
                        ImageView t3v = new ImageView(MainActivity.this);
                        t3v.setPadding(5,5,5,5);
                        Glide.with(MainActivity.this).load(flag).into(t3v);
                        TextView t4v = new TextView(MainActivity.this);
                        t4v.setGravity(Gravity.CENTER);
                        t4v.setPadding(5,5,5,5);
                        t4v.setText(region);
                        t4v.setTextColor(Color.WHITE);
                        t4v.setGravity(Gravity.CENTER);
                        tbrow.addView(t4v);
                        TextView t5v = new TextView(MainActivity.this);
                        t5v.setGravity(Gravity.CENTER);
                        t5v.setPadding(5,5,5,5);
                        t5v.setText(subregion);
                        t5v.setTextColor(Color.WHITE);
                        t5v.setGravity(Gravity.CENTER);
                        tbrow.addView(t5v);
                        TextView t6v = new TextView(MainActivity.this);
                        t6v.setGravity(Gravity.CENTER);
                        t6v.setPadding(5,5,5,5);
                        t6v.setText(population);
                        t6v.setTextColor(Color.WHITE);
                        t6v.setGravity(Gravity.CENTER);
                        tbrow.addView(t6v);
                        TextView t7v = new TextView(MainActivity.this);
                        t7v.setGravity(Gravity.CENTER);
                        t7v.setPadding(5,5,5,5);
                        String borderName="";
                        for(int j=0;j<borders.length();j++){
                            if(j!=borders.length()-1){
                                borderName=borderName+borders.get(j)+',';
                            }else{
                                borderName+=borders.getString(j);
                            }
                        }
                        t7v.setText(borderName);
                        t7v.setTextColor(Color.WHITE);
                        t7v.setGravity(Gravity.CENTER);
                        tbrow.addView(t7v);
                        String languages="";
                        for(int j=0;j<lang.length();j++){
                            JSONObject jsonobject1 = lang.getJSONObject(j);
                            if(j!=lang.length()-1){
                                languages=languages+jsonobject1.getString("name")+",";
                            }else{
                                languages+=jsonobject1.getString("name");
                            }
                        }
                        TextView t8v = new TextView(MainActivity.this);
                        t8v.setGravity(Gravity.CENTER);
                        t8v.setPadding(5,5,5,5);
                        t8v.setText(languages);
                        t8v.setTextColor(Color.WHITE);
                        t8v.setGravity(Gravity.CENTER);
                        tbrow.addView(t8v);
                        stk.addView(tbrow);

                        Country country=new Country();
                        country.setName(name);
                        country.setCapital(capital);
                        country.setRegion(region);
                        country.setSubregion(subregion);
                        country.setPopulation(population);
                        country.setFlag(flag);
                        country.setBorders(borderName);
                        country.setLanguages(languages);
                        myAppDatabase.myDao().addUser(country);
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Request Time Out", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }

            public void onFailure(int statusCode, Header[] headers, Throwable t,JSONObject error) {
                System.out.println(error+" "+statusCode);
            }
        });

    }
}