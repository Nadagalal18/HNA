package com.example.nadag.hospital2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nadag.hospital2.dao.PatientDao;
import com.example.nadag.hospital2.util.DatabaseManager;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    Button bt2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        bt1=(Button)findViewById(R.id.button1);
        bt2=(Button) findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.edit1);
        DatabaseManager dbManger=new DatabaseManager();
        PatientDao dao=new PatientDao(dbManger);
        dao.execute();

       bt1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String input =editText.getText().toString();
               if (input.isEmpty())
               {
                   Toast.makeText(MainActivity.this, " You didn't enter your id card", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   int id = Integer.parseInt(input);
                   selectorinsert(id);
               }
           }
       });
       bt2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i1=new Intent(MainActivity.this,data_of_new_patient.class);
               startActivity(i1);
               finish();
           }
       });

    }
    public void selectorinsert (int id){
        if (id==5)//hena el select
        {
            Intent i=new Intent(this,Deppartments.class);
            startActivity(i);
            finish();
        }
        else

        { //insert code
            AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("Error");
            dialog.setMessage("Your Id card is not valid");
            dialog.setPositiveButton("Try again",null);
            dialog.show();
        }
    }
}

