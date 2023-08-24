package com.example.loginje;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public static final String TAG = "CRUD Aluno";
    private static ArrayList<User> mUserList;

    public static int insertUser(User mUser , Context mContext) {

        // 0 não fez o insert                 1 fez o insert com sucesso
        int vResponse = 0;
        String mSql;
        try {
            mSql = "INSERT INTO Aluno (email, senha, nome, datanasc, statusUsuario) VALUES (?, ?, ?, ?, 'ATIVO')";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getemail());
            mPreparedStatement.setString(2, mUser.getpassword());
            mPreparedStatement.setString(3, mUser.getnome());
            mPreparedStatement.setString(4, mUser.getdatanasc());

            vResponse = mPreparedStatement.executeUpdate(); // 1 para sucesso


        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }


        return vResponse;
    }

    public static int updateUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql ="UPDATE Aluno SET senha=?, email=? , nome=?, datanasc=?,apikey=? , status='ATIVO' WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getpassword());
            mPreparedStatement.setString(2, mUser.getemail());
            mPreparedStatement.setString(3, mUser.getnome());
            mPreparedStatement.setString(4, mUser.getdatanasc());
            mPreparedStatement.setString(5, mUser.getApikey());
            mPreparedStatement.setString(6, mUser.getstatus());

            mPreparedStatement.setString(7, mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static int deleteUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql ="DELETE FROM Aluno WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static int deleteAllUser(Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql ="DELETE FROM Aluno";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static List<User> listAllUser(Context mContext){
        List<User> mUserList = null;
        String mSql;
        try {
            mSql = "SELECT id, email, senha, statusUsuario FROM Aluno ORDER BY email ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
        ResultSet mResultSet = mPreparedStatement.executeQuery();
        mUserList = new ArrayList<User>();
        while (mResultSet.next()){

            String mNome = null;
            String mDatanasc = null;
            mUserList.add(new User(
                    mNome, mDatanasc, mResultSet.getInt(1),
                    mResultSet.getString(3),
                    mResultSet.getString(2)
            ));
        }

        } catch (SQLException e) {
            Log.e(TAG , e.getMessage());
        }
        return mUserList;
    }


        public static String authenticateUser(User mUser , Context mContext){
        String mResponse = "";
        String mSql = "SELECT id, senha, email, nome , datanasc, statusUsuario FROM Aluno WHERE senha lIKE ? AND email LIKE ? AND nome LIKE ? AND datanas LIKE ? ";

        try {
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mUser.getpassword());
            mPreparedStatement.setString(2, mUser.getemail());
            mPreparedStatement.setString(3, mUser.getnome());
            mPreparedStatement.setString(4, mUser.getdatanasc());
            ResultSet mResultSet = mPreparedStatement.executeQuery();

        } catch (Exception e){
            mResponse ="Exception";
            Log.e(TAG , e.getMessage());
            e.printStackTrace();
        }
            return mResponse;

        }


}

