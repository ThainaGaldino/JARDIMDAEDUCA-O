package com.example.loginje;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public static final String TAG = "CRUD User";
    private static ArrayList<User> mUserList;

    public static int insertUser(User mUser , Context mContext) {

        // 0 não fez o insert                 1 fez o insert com sucesso
        int vResponse = 0;
        String mSql;
        try {
            mSql = "INSERT INTO User (password, email, Apikey, reset_password_otp, reset_password_create_at) VALUES ( ?, ?, ?, ?, ?)";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getpassword());
            mPreparedStatement.setString(2, mUser.getemail());
            mPreparedStatement.setString(3, mUser.getApikey());
            mPreparedStatement.setString(4, mUser.getResetPasswordOtp());
            mPreparedStatement.setLong(5, mUser.getResetPasswordCreateAt());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e){
            Log.e( TAG , e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static int updateUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql ="UPDATE User SET password=?, email=? , apikey=? , reset_password_otp=? , reset_password_create_at=? WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getpassword());
            mPreparedStatement.setString(2, mUser.getemail());
            mPreparedStatement.setString(3, mUser.getApikey());
            mPreparedStatement.setString(4, mUser.getResetPasswordOtp());
            mPreparedStatement.setLong(5, mUser.getResetPasswordCreateAt());
            mPreparedStatement.setString(6, mUser.getId());

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
            mSql ="DELETE FROM User WHERE id=?";

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
            mSql ="DELETE FROM User";

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
            mSql = "SELECT id, password, email, Apikey, reset_password_otp, reset_password_create_at FROM users ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
        ResultSet mResultSet = mPreparedStatement.executeQuery();
        mUserList = new ArrayList<User>();
        while (mResultSet.next()){

            mUserList.add(new User(
                    mResultSet.getString(1),
                    mResultSet.getString(2),
                    mResultSet.getString(3),
                    mResultSet.getString(4),
                    mResultSet.getLong(5)



            ));
        }

        } catch (SQLException e) {
            Log.e(TAG , e.getMessage());
        }
        return mUserList;
    }


        public static String authenticateUser(User mUser , Context mContext){
        String mResponse = "";
        String mSql = "SELECT id, password, email FROM user WHERE password lIKE ? AND email LIKE ? ";

        try {
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mUser.getpassword());
            mPreparedStatement.setString(2, mUser.getmEmail());
            ResultSet mResultSet = mPreparedStatement.executeQuery();

        } catch (Exception e){
            mResponse ="Exception";
            Log.e(TAG , e.getMessage());
            e.printStackTrace();
        }
            return mResponse;

        }


}

