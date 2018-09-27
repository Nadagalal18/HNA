package com.example.nadag.hospital2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Deppartments extends AppCompatActivity {
    Button Obtical;
    Button Pediatric;
    Button Dental;
    Button Physical_Therapy;
    Button btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deppartments);
       // getSupportActionBar().hide();
        btBack=(Button)findViewById(R.id.back);
        Obtical=(Button) findViewById(R.id.bb3);
        Pediatric= (Button) findViewById(R.id.bb4);
        Dental= (Button) findViewById(R.id.bb2);
        Physical_Therapy=(Button)findViewById(R.id.bb1);
       btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Deppartments.this, MainActivity.class);
                startActivity(i2);
                finish();
            }
        });
        Physical_Therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Deppartments.this, Physical_therapy.class);

                startActivity(i1);

                finish();
            }
        });
        Obtical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Deppartments.this, Optical.class);

                startActivity(i1);

                finish();
            }
        });
        Dental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Deppartments.this, Dental.class);

                startActivity(i1);

                finish();
            }
        });
        Pediatric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Deppartments.this, Pediatric.class);

                startActivity(i1);

                finish();
            }
        });
    }
}
