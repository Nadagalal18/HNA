package com.example.nadag.hospital2.dao;

import android.os.AsyncTask;
import android.util.Log;

import com.example.nadag.hospital2.util.DatabaseManager;

import java.sql.SQLException;
import java.util.List;

public class PatientDao extends AsyncTask<Void,Void,Object[]>{


    DatabaseManager dbManger;

    public PatientDao(DatabaseManager dbManger) {
        this.dbManger = dbManger;
    }

    final  String selectUserById="SELECT * FROM `test` WHERE id = ?";

    @Override
    protected Object[] doInBackground(Void... voids) {
        List<Object[]> results;
        dbManger.setQueryString(selectUserById);
        Integer id=1;
        dbManger.setParameter(0,id);
        try {
            results=dbManger.executeQuery();
            if(results.isEmpty()){
                Log.d("hna", "didn't find this user ");
            } else{
                return results.get(0);
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
        Log.d("hna", "the user with id=1 name is "+object[1]);
    }
}