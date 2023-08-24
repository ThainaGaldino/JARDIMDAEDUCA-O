package com.example.loginje;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroDao {


    public static final String TAG = "CRUD Cadastro";
    private static ArrayList<Cadastro> mCadastroList;

    public static int insertCadastro(Cadastro mCadastro , Context mContext) {

        // 0 não fez o insert                 1 fez o insert com sucesso
        int vResponse = 0;
        String mSql;
        try {
            mSql = "INSERT INTO cadastro (nome, email, senha , datanasc) VALUES ( ?, ?, ?, ?)";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mCadastro.getnome());
            mPreparedStatement.setString(2, mCadastro.getemail());
            mPreparedStatement.setString(3, mCadastro.getpassword());
            mPreparedStatement.setString(4, mCadastro.getdata());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
            {
        }


        return vResponse;
    }

    public static int updateCadastro(Cadastro mCadastro , Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql ="UPDATE cadastro SET name=? , email=? , senha=? , datanasc=? WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mCadastro.getnome());
            mPreparedStatement.setString(2, mCadastro.getemail());
            mPreparedStatement.setString(3, mCadastro.getpassword());
            mPreparedStatement.setString(4, mCadastro.getdata());
            mPreparedStatement.setString(5, mCadastro.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
            {
        }


        return vResponse;
    }

    public static int deleteCadastro(Cadastro mCadastro , Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql ="DELETE FROM cadastro WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mCadastro.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
            {
        }


        return vResponse;
    }

    public static int deleteAllCadastro(Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql ="DELETE FROM cadastro";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
            {
        }


        return vResponse;
    }

    public static String authenticateUser(Cadastro mCadastro , Context mContext){
        String mResponse = "";
        String mSql = "SELECT id, name, email , senha, datanasc FROM cadastro WHERE email LIKE ? senha LIKE ? name LIKE ? ";

        try {
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mCadastro.getemail());
            mPreparedStatement.setString(2, mCadastro.getpassword());
            mPreparedStatement.setString(3, mCadastro.getname());
            ResultSet mResultSet = mPreparedStatement.executeQuery();

        } catch (Exception e){
            mResponse ="Exception";
            Log.e(TAG , e.getMessage());
            e.printStackTrace();
        }

       return mResponse;
    }

}






