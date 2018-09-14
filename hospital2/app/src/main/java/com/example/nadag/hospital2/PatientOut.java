package com.example.nadag.hospital2;

import android.os.AsyncTask;
import android.util.Log;

import com.example.nadag.hospital2.util.DatabaseManager;

import java.sql.SQLException;
import java.util.List;

class PatientOut extends AsyncTask<Void,Void,Void> {

    private int id;
    private int age;
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String gender;
    private DatabaseManager dbManger;
    final String insertQuery="";//insertQuery



    public PatientOut(DatabaseManager dbManger)  {
        this.dbManger=dbManger;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setfFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        List<Object[]> results;
        dbManger.setQueryString(insertQuery);
      //TODO complete the dao

        return null;
    }
}
