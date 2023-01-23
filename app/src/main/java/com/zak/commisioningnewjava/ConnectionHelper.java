package com.zak.commisioningnewjava;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String ip, port, db, un, pass;

    @SuppressLint("NewApi")
    public Connection conclass() {
        ip = "127.0.0.1";
        port = "1433";
        db = "DB_COMMISIONING";
        un = "sa";
        pass = "test1234";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectURL = "jdbc:jdts:sqlserver:\\" + ip + ":" + port + ";" + "databaseName=" + db + ";user=" + un + ";password=" + pass + ";";
//            ConnectURL = "jdbc:jdts:sqlserver://" + ip + ":" + port + ";" + "databaseName=" + db + ";user=" + un + ";password=" + pass + ";";
            connection = DriverManager.getConnection(ConnectURL);
        } catch (Exception exception) {
            Log.e("Error :", exception.getMessage());
        }
        return connection;
    }
}
