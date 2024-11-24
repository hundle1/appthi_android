package com.example.qlydatphongks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2  extends AppCompatActivity{
    Button btnBack;
    TextView txtvten;
    TextView txtvmota;
    TextView txtvgiatien;
    ImageView imghinh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnBack = (Button) findViewById(R.id.buttonback);
        txtvten=(TextView) findViewById(R.id.textViewten);
        txtvmota=(TextView) findViewById(R.id.textViewmota) ;
        txtvgiatien=(TextView) findViewById(R.id.textViewgiatien) ;
        imghinh=(ImageView) findViewById(R.id.imageViewhinh);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh1=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(mh1);
            }
        });
        String value1 = "";
        String value2 = "";
        String value3 = "";
        String imageName = "";
        int imageResourceId = 0;

        Intent mh2 = getIntent();
        Bundle bundle = mh2.getExtras();
        if (bundle != null) {
            value1 = bundle.getString("Key_1", "ddd");
            value2 = bundle.getString("Key_2", "ddd");
            value3 = bundle.getString("Key_3", "ddd");
            imageName = bundle.getString("Key_4", "");


            imageResourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        }

        txtvten.setText(value1);
        txtvmota.setText(value2);
        txtvgiatien.setText(value3);
        imghinh.setImageResource(imageResourceId);  // Hiển thị ảnh từ ID đã chuyển đổi

    }
}
