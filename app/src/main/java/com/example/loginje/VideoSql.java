package com.example.loginje;

public class VideoSql {

    public static final String TAG = "Video";
    private final String mNome;
    private final String mLink;

    //COLUNAS = MEMBROS

    public VideoSql( String mNome,String mLink) {
        this.mNome = mNome;
        this.mLink = mLink;

    }

    public VideoSql(String mNome, int mId,String mLink) {
        this.mNome = mNome;
        this.mLink = mLink;
        this.mId = mId;

    }

    public VideoSql( int mId, String mNome, String mLink) {
        this.mNome = mNome;
        this.mLink = mLink;
        this.mId = mId;
    }





    @Override
    public String toString() {
        return "VideoSql{" +
                "mId=" + mId +
                ", mLink=' " + mLink + '\''+
                ", mNome='" + mNome + '\'' +
                '}';
    }

    private int mId;


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }







    public String getId() {
        return null;
    }

    public String getnome() {
        return null;
    }


}
