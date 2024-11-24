package com.example.qlydatphongks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lstvdsphong;
    phongAdapter phongadapter;
    ArrayList<phong> phongarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstvdsphong = (ListView) findViewById(R.id.listviewphong);
        phongarray = new ArrayList<>();
        ReadJSON("http://192.168.0.103/qlphongks_Android/ketnoiPhong.php");
        phongadapter = new phongAdapter(this, R.layout.dongphong, phongarray);
        lstvdsphong.setAdapter(phongadapter);

        lstvdsphong.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
                int vtri = position;
                phong p = phongarray.get(vtri);
                Intent mh2 = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("Key_1", p.ten);
                bundle.putString("Key_2", p.mota);
                bundle.putString("Key_3", p.giatien);
                bundle.putString("Key_4", p.hinhanh);
                mh2.putExtras(bundle);
                startActivity(mh2);
            }
        });
    }

    private void ReadJSON(String url) {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                phongarray.add(new phong("Tên phòng: " + object.getString("Ten"),
                                        "Mô tả: " + object.getString("Mota"),
                                        object.getInt("Giatien"),
                                        object.getString("Hinhanh")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        phongadapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });


        // Set timeout for Volley request
        int timeout = 30000; // 30 seconds
        RetryPolicy policy = new DefaultRetryPolicy(
                timeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );

// Apply the retry policy to the request
        jsonArrayRequest.setRetryPolicy(policy);

// Add the request to the request queue
        requestQueue.add(jsonArrayRequest);
    }




}
