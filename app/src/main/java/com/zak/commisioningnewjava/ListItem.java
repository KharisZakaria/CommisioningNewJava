package com.zak.commisioningnewjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItem {

    Connection connect;
    String ConnectionResult= "";
    Boolean isSuccess=false;

    public List<Map<String,String>>getlist(){
        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();
        try{
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.conclass();
            if (connect !=null)
            {
            String qu = "select * From TBL_T_COMMISIONING";
                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(qu);
                while (resultSet.next())
                {
                    Map<String,String> dtname = new HashMap<String, String>();
                    dtname.put("tv_id", resultSet.getString("id"));
                    dtname.put("tv_cn", resultSet.getString("cn_unit"));
                    dtname.put("tv_egi", resultSet.getString("egi"));
                    dtname.put("tv_dateexpired", resultSet.getString("date_expired"));
                    data.add(dtname);
                }
                ConnectionResult = "Success";
                isSuccess =true;
                connect.close();
            }else {
                ConnectionResult = "Failed";
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }
}
