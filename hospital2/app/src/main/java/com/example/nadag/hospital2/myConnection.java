package com.example.nadag.hospital2;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection extends AsyncTask{
    @Override
    protected Object doInBackground(Object[] objects) {
        final String connectionURL ="jdbc:mysql://db4free.net:3306/hnahospital";
        final String userName="hnahospitalusr";
        final String userPassword="123456789";

        Connection con = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");

            con=DriverManager.getConnection(connectionURL,userName,userPassword);
            Log.d("hna","yeah we did it ");


        }
        catch (ClassNotFoundException e) {
            Log.d("hna","cannot found the class ");
            Log.d("hna",e.getMessage());
        }

        catch (SQLException e)
        {
            Log.d("hna","failed to connect ");
            Log.d("hna",e.getMessage());

        }
        return null;
    }
}