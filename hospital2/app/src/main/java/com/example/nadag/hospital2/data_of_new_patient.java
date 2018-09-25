package com.example.nadag.hospital2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nadag.hospital2.util.DatabaseManager;

public class data_of_new_patient extends AppCompatActivity {
    Button bt3;
    EditText firstname,lastname,id,age,phone,email,gender;
    ProgressDialog progressDialog;
    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_of_new_patient);
      //  getSupportActionBar().hide();
        btBack=(Button)findViewById(R.id.back);
        bt3 = (Button) findViewById(R.id.bt3);
        firstname=(EditText)findViewById(R.id.first);
        lastname=(EditText)findViewById(R.id.last);
        id=(EditText)findViewById(R.id.i);
        phone=(EditText)findViewById(R.id.ph);
        email=(EditText)findViewById(R.id.e);
        age=(EditText)findViewById(R.id.ag);
        gender=(EditText)findViewById(R.id.gend);
        DatabaseManager dbManger=new DatabaseManager();
        final PatientOut Out=new PatientOut(dbManger);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(data_of_new_patient.this, MainActivity.class);
                startActivity(i2);
                finish();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1=firstname.getText().toString();
                String input2=lastname.getText().toString();
                String input3=id.getText().toString();
                String input4=age.getText().toString();
                String input5=phone.getText().toString();
                String input6=email.getText().toString();
                String input7=gender.getText().toString();
               if (input1.isEmpty()&&input2.isEmpty()&&input3.isEmpty()&&input4.isEmpty()&&input5.isEmpty()&&input7.isEmpty()) {
                   Toast.makeText(data_of_new_patient.this, "Please enter your data", Toast.LENGTH_SHORT).show();
               }
               else {
                   int id=Integer.parseInt(input3);
                   int age =Integer.parseInt(input4);
                   Integer phone = Integer.parseInt(input5);
                   //insert
                   Out.setAge(age);
                   Out.setEmail(input6);
                   Out.setfFirstname(input1);
                   Out.setLastname(input2);
                   Out.setGender(input7);
                   Out.setid(id);
                   Out.setPhone(phone);
                   Out.execute();
                   dialog();
               }
            }
        });
    }
     public void dialog (){
         AlertDialog.Builder dialog=new AlertDialog.Builder(data_of_new_patient.this);
         dialog.setTitle("Successfully Registered");
         dialog.setMessage("Your data is successfully saved");
         dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 Intent i2 = new Intent(data_of_new_patient.this, MainActivity.class);
                 startActivity(i2);
                 finish();
             }
         });
         dialog.show();
    }

}
