package com.example.loginje;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {


    public static final String TAG = "CRUD Aluno";
    private static ArrayList<User> mUserList;

    public static int insertUser(String nome, String email, String senha, String dataNasc, Context mContext) {

        // 0 não fez o insert                 1 fez o insert com sucesso
        int vResponse = 0;
        String mSql;
        try {
            mSql = "INSERT INTO Aluno (email, senha, nome, datanasc, statusUsuario) VALUES (?, ?, ?, ?, 'Ativo')";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, email);
            mPreparedStatement.setString(2, senha);
            mPreparedStatement.setString(3, nome);

            mPreparedStatement.setDate(4, java.sql.Date.valueOf(dataNasc));
            //mPreparedStatement.setString(5, mUser.getstatus());

            vResponse = mPreparedStatement.executeUpdate(); // 1 para sucesso


        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }


        return vResponse;
    }

    public static int updateUser(User mUser, Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql = "UPDATE Aluno SET senha=?, email=? , nome=?, datanasc=?,apikey=? , status='Ativo' WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getpassword());
            mPreparedStatement.setString(2, mUser.getemail());
            mPreparedStatement.setString(3, mUser.getnome());
            mPreparedStatement.setString(4, mUser.getdatanasc());
            mPreparedStatement.setString(5, mUser.getApikey());
            mPreparedStatement.setString(6, mUser.getstatus());

            mPreparedStatement.setString(7, mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static int deleteUser(User mUser, Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql = "DELETE FROM Aluno WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static int deleteAllUser(Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql = "DELETE FROM Aluno";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static List<User> listAllUser(Context mContext) {
        List<User> mUserList = null;
        String mSql;
        try {
            mSql = "SELECT id, nome, email, senha, statusUsuario FROM Aluno ORDER BY email ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
            while (mResultSet.next()) {
                mUserList.add(new User(mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5)
                ));
            }

        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        }
        return mUserList;
    }


    public static int authenticateUser(User mUser, Context mContext) {
        int mResponse = 0;
        String mSql = "SELECT id, senha, email, nome , datanasc, statusUsuario FROM Aluno WHERE senha lIKE '%?%' AND email LIKE '%?%'";

        try {
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mUser.getpassword().toString());
            mPreparedStatement.setString(2, mUser.getemail().toString());

            boolean sucesso = mPreparedStatement.execute();
            if(sucesso)
                mResponse = 1;
        } catch (Exception e) {

            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }
        return mResponse;

    }


}

