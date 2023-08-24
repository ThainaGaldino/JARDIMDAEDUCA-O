package com.example.loginje;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnectionHelper {

    // essa classe ira conter string para fazer a conexao com banco de dados :
    // 1 - SOMEE.COM
    // 2 - banco LOCALHOST , no pc do laboratorio/ casa .
    // nesse cenário o app so vai funcionar no emulador ou celular com cabo
    // 3 - banco MySql

    public static final String TAG = "Connection Database";
    //1- SOMEE.COM

    private static String mStringConnectionUrl;
    private static String mStringServerIpnome = "bd_jardimdaeducacao.mssql.somee.com";
    private static String mStringUserName = "JardimEduc_SQLLogin_1";
    private static String mStringpassword = "a3zurkya7i";
    private static String mStringDatabase = "bd_jardimdaeducacao";
    //2 - LOCALHOST

    //private static  String mStringServerIpnome  = "10.0.2.2";
    // private static  String mStringNomeString  = "sa";
    // private static  String mStringpassword  = "@ITB123456";
    //  private static  String mStringDatabase  = "jardim";
    // private static  String mStringport = "1433";
    //private static  String mStringInstance = "SQLEXPRESS";
    //para o MySql as string são as mesmas do topico 2

    public static Connection getConnection(Context mContext) {

        Connection mConnection = null;

        try{

            StrictMode.ThreadPolicy mPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(mPolicy);

            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            mStringConnectionUrl = "jdbc:jtds:sqlserver://" + mStringServerIpnome +
                    ";databaseName=" + mStringDatabase +
                    ";user=" + mStringUserName +
                    ";password=" + mStringpassword + ";";


            mConnection = DriverManager.getConnection(mStringConnectionUrl);

            Log.i(TAG , "Connection Successful");
        } catch (ClassNotFoundException e){
            String mMessage = "Class Not Found" + e.getMessage();
            Log.e(TAG , mMessage);

        }catch (SQLException e){
            String mMessage = "Database Fail" + e.getMessage();
            Log.e(TAG , mMessage);

        }catch (Exception e){
            String mMessage = "Failure Unlnown" + e.getMessage();
            Log.e(TAG , mMessage);

        }

        return mConnection;


         }

    }
