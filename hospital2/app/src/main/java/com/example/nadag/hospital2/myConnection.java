package com.example.nadag.hospital2;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection extends AsyncTask{
    @Override
    protected Object doInBackground(Object[] objects) {
        final String connectionURL ="jdbc:mysql://172.28.130.76:3306/hna";
        final String userName="root";
        final String userPassword="123456789";

        Connection con = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");

            con=DriverManager.getConnection(connectionURL,userName,userPassword);
            Log.d("hna","yeah we did it ");

        }
        catch (SQLException e)
        {
            Log.d("hna","failed to connect ");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            Log.d("hna","cannot found the class ");
            e.printStackTrace();
        }

        return null;
    }
}