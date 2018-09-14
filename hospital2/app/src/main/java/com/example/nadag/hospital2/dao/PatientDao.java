package com.example.nadag.hospital2.dao;



import android.os.AsyncTask;

import android.util.Log;



import com.example.nadag.hospital2.MainActivity;

import com.example.nadag.hospital2.Patient;

import com.example.nadag.hospital2.util.DatabaseManager;



import java.sql.SQLException;

import java.util.List;



public class PatientDao extends AsyncTask<Void, Void, Patient> {





    final String selectUserById = "SELECT `ID Card`,`First Name`," +

            " `Last Name`, `Email`, `Age`, `Phone Number`, `Gender` FROM `Data`" +

            " WHERE `ID Card`=? ";

    public int id;

    DatabaseManager dbManger;

    private MainActivity view;





    public PatientDao(DatabaseManager dbManger, MainActivity view, int id) {

        this.dbManger = dbManger;

        this.view = view;

        this.id = id;

    }



    @Override

    protected Patient doInBackground(Void... voids) {

        List<Object[]> results;

        dbManger.setQueryString(selectUserById);

        // Integer id=1;

        dbManger.setParameter(0, id);

        try {

            results = dbManger.executeQuery();

            if (results.isEmpty()) {

                Log.d("hna", "didn't find this user ");





            } else {

                return convertToPatient(results.get(0));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }





        return null;

    }





    @Override

    protected void onPostExecute(Patient user) {

        super.onPostExecute(user);

        //here we will try to update the mainactivity view with the data from this object

        //but for now just log



        view.select(user);//after getting the data this will update the UI



    }



    private Patient convertToPatient(Object[] row){

        Patient user=new Patient();

        user.setIdCard((Integer) row[0]);

        user.setFirstName((String) row[1]);

        user.setLastName((String) row[2]);

        user.setEmail((String) row[3]);

        user.setAge((Integer) row[4]);

        user.setPhoneNumber((Integer) row[5]);

        user.setGender((String) row[6]);



        return user;

    }

}