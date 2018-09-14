package com.example.nadag.hospital2;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.nadag.hospital2.util.DatabaseManager;

import java.sql.SQLException;
import java.util.List;

public class PatientOut extends AsyncTask<Void,Void,Object[]> {
    DatabaseManager dbManger;
    public int id,age,phone;
    public String firstname,lastname,email,gender;


    public PatientOut(DatabaseManager dbManger) {
        this.dbManger = dbManger;
    }

    public void setid (int ID){
        id =ID;
    }
    public void setfFirstname(String fname){
        firstname=fname;
    }
    public void setAge (int AGE){
        age =AGE;
    }
    public void setLastname(String lname){
        lastname=lname;
    }
    public void setPhone (int Phone){
        phone =Phone;
    }
    public void setEmail(String Email){
        email=Email;
    }
    public void setGender(String Gender){
        gender=Gender;
    }

    final  String query="INSERT INTO `Data` (`First Name`, `Last Name`, `ID Card`, `Email`, `Age`, `Phone Number`, `Gender`)"+ "VALUES (?, ?, ?, ?, ?,?,?)";

    @Override
    protected Object[] doInBackground(Void... voids) {
        Integer results;
        dbManger.setQueryString(query);
        // Integer id=1;
        dbManger.setParameter(0,firstname);
        dbManger.setParameter(1,lastname);
        dbManger.setParameter(2,id);
        dbManger.setParameter(3,email);
        dbManger.setParameter(4,age);
        dbManger.setParameter(5,phone);
        dbManger.setParameter(6,gender);
        try {
            results=dbManger.executeUpdate();
            if(results==null){
                Log.d("hna", "didn't find this user ");

            } else{
                System.out.println("done");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }



    @Override
    protected void onPostExecute(Object[] object) {
        super.onPostExecute(object);
        //here we will try to update the mainactivity view with the data from this object
        //but for now just log
       // Log.d("hna", "the user with id=1 name is "+object[1]);
    }
}
