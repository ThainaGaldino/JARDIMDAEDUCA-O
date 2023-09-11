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

public class VideoDao {


    public static final String TAG = "CRUD Video";
    private static ArrayList<VideoSql> mVideoList;

    public static <mContext> int insertUser(String nome, String link) {

        // 0 não fez o insert                 1 fez o insert com sucesso
        int vResponse = 0;
        String mSql;
        try {
            mSql = "INSERT INTO Video (nome, link) VALUES (?, ?)";

            Context mContext = null;
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, nome);
            mPreparedStatement.setString(2, link);


            vResponse = mPreparedStatement.executeUpdate(); // 1 para sucesso


        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }


        return vResponse;
    }

    public static int updateVideo(Video mVideo, Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql = "UPDATE Video SET nome=?, link=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mVideo.getnome());
            mPreparedStatement.setString(2, mVideo.getlink());


            mPreparedStatement.setString(7, mVideo.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static int deleteVideo(Video mVideo, Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql = "DELETE FROM Video WHERE id=?";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mVideo.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static int deleteAllVideo(Context mContext) {

        int vResponse = 0;
        String mSql;
        try {
            mSql = "DELETE FROM Video";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); // 1 sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        {
        }


        return vResponse;
    }

    public static List<VideoSql> listAllVideo(Context mContext) {
        List<VideoSql> mVideoList = null;
        String mSql;
        try {
            mSql = "SELECT id, nome, link FROM Video ORDER BY nome ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mVideoList = new ArrayList<VideoSql>();
            while (mResultSet.next()) {
                mVideoList.add(new VideoSql(
                        mResultSet.getString(1),
                        mResultSet.getString(2)
                ));
            }

        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        }
        return mVideoList;
    }

    public static VideoSql listOneVideo(Context mContext, String videoEscolhido) {
        VideoSql mVideo = null;
        String mSql;
        try {
            mSql = "SELECT nome_video, link_video FROM Video where nome_video like '%" + videoEscolhido + "%' ORDER BY nome_video ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();

            while (mResultSet.next()) {
               mVideo = new VideoSql(
                        mResultSet.getString(1),
                        mResultSet.getString(2)
                );
            }

        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        }
        return mVideo;
    }

    public static String authenticateUser(VideoSql mVideo, Context mContext) {
        String mResponse = "";
        String mSql = "SELECT id, nome ,link FROM Video WHERE nome lIKE ? AND link LIKE ? ";

        try {
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(3, mVideo.getnome());
            mPreparedStatement.setString(4, mVideo.getmLink());
            ResultSet mResultSet = mPreparedStatement.executeQuery();

        } catch (Exception e) {
            mResponse = "Exception";
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }
        return mResponse;

    }


}

