package com.example.loginje;

public class User {

    public static final String TAG = "Aluno";
    private String mNome;
    private String mDatanasc;

    //COLUNAS = MEMBROS

    public User(String mPassword, String mEmail, String mNome, String mDatanasc, String mApikey, String mResetPasswordOtp, long mResetPasswordCreateAt) {
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mNome = mNome;
        this.mDatanasc = mDatanasc;
        this.mApikey = mApikey;

    }

    public User(String mNome, String mDatanasc, int mId, String mPassword, String mEmail, String mApikey, String mResetPasswordOtp, long mResetPasswordCreateAt) {
        this.mNome = mNome;
        this.mDatanasc = mDatanasc;
        this.mId = mId;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mApikey = mApikey;

    }

    public User( int mId, String mNome, String mEmail, String mPassword, String mDatanasc) {
        this.mNome = mNome;
        this.mDatanasc = mDatanasc;
        this.mId = mId;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
    }

    public User(String mNome, String mEmail, String mPassword, String mDatanasc) {
        this.mNome = mNome;
        this.mDatanasc = mDatanasc;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mPassword='" + mPassword + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mNome='" + mNome + '\'' +
                '}';
    }

    private int mId;
    private String mPassword;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmApikey() {
        return mApikey;
    }

    public void setmApikey(String mApikey) {
        this.mApikey = mApikey;
    }



    private String mEmail;
    private String mApikey;



    public String getpassword() {
        return null;
    }

    public String getemail() {
        return null;
    }


    public String getApikey() {
        return null;
    }



    public String getId() {
        return null;
    }

    public String getnome() {
        return null;
    }

    public String getdatanasc() {
        return null;
    }

    public String getstatus() {
        return null;
    }
}
