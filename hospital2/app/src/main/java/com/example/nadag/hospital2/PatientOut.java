package com.example.nadag.hospital2;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> cf29d1c39ed2e061226d79b7293504dd6874bd65
import android.os.AsyncTask;
import android.util.Log;

import com.example.nadag.hospital2.util.DatabaseManager;

import java.sql.SQLException;
import java.util.List;

<<<<<<< HEAD
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
=======
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
>>>>>>> cf29d1c39ed2e061226d79b7293504dd6874bd65
}
