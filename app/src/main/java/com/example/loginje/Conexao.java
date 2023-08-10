package com.example.loginje;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
     public Connection conectar  () {
          Connection conn = null;

          try {
               StrictMode.ThreadPolicy policy;
               policy = new StrictMode.ThreadPolicy.Builder()
                       .permitAll() .build();
               StrictMode.setThreadPolicy(policy);
               Class.forName("net.sourceforge.jtds.jsbc.Driver").newInstance();
               conn = DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.1.94;" +
                       "databaseName= bd_jardimdaeducacao ; user=sa; password=1234567");





          } catch (Exception e) {
               e.printStackTrace();
          }

          return null

     }
}
