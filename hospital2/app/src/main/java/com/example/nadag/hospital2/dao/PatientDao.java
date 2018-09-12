package com.example.nadag.hospital2.dao;

import android.os.AsyncTask;
import android.util.Log;

import com.example.nadag.hospital2.myConnection;
import com.example.nadag.hospital2.util.DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PatientDao extends AsyncTask<DatabaseManager,Void,Object[]>{

    final  String selectUserById="SELECT * FROM `test` WHERE id = ?";

    @Override
    protected Object[] doInBackground(DatabaseManager... databaseManagers) {
        List<Object[]> results;
        databaseManagers[0].setQueryString(selectUserById);
        Integer id=1;
        databaseManagers[0].setParameter(0,id);
        try {
            results=databaseManagers[0].executeQuery();
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
        Log.d("hna", "the user with id=1 name is"+object[1]);
    }
}