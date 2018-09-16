package com.example.nadag.hospital2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nadag.hospital2.dao.PatientDao;
import com.example.nadag.hospital2.util.DatabaseManager;


public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    Button regeisterBtn;
    EditText idEditText;

    DatabaseManager dbManger = new DatabaseManager();
    // int id;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

     //   getSupportActionBar().hide();

        loginBtn = (Button) findViewById(R.id.button1);

        regeisterBtn = (Button) findViewById(R.id.button2);

        idEditText = (EditText) findViewById(R.id.edit1);

        dbManger = new DatabaseManager();

      /*  dao.execute();

        try {

            dao.get().toString();

        }

        catch (InterruptedException e){

            e.printStackTrace();

        }

        catch (ExecutionException e)

        {

            e.printStackTrace();

        }*/

        //  final PatientDao dao1=new PatientDao(dbManger);


        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                String input = idEditText.getText().toString();

                if (input.isEmpty())

                {

                    Toast.makeText(MainActivity.this, " You didn't enter your id card", Toast.LENGTH_SHORT).show();

                } else

                {

                    try {
                        int id = Integer.parseInt(input);
                        new PatientDao(dbManger, MainActivity.this, id).execute();
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "The id should be number", Toast.LENGTH_SHORT).show();

                    }


                }

            }

        });


        regeisterBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent i1 = new Intent(MainActivity.this, data_of_new_patient.class);

                startActivity(i1);

                finish();

            }

        });

    }


    //  final PatientDao dao1=new PatientDao(dbManger);
    public void select(Patient user) {
        if (user == null) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

            dialog.setTitle("Error");

            dialog.setMessage("Your Id card is not valid");

            dialog.setPositiveButton("Try again", null);

            dialog.show();

        } else

        {

            Intent i = new Intent(this, Deppartments.class);

            startActivity(i);
            finish();
        }

    }

}
