package com.example.loginje;

public class User {

        public static final String TAG = "Login Table";

        //COLUNAS = MEMBROS

    public User(String mPassword, String mEmail, String mApikey, String mResetPasswordOtp, long mResetPasswordCreateAt) {
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mApikey = mApikey;
        this.mResetPasswordOtp = mResetPasswordOtp;
        this.mResetPasswordCreateAt = mResetPasswordCreateAt;
    }

    public User(int mId, String mPassword, String mEmail, String mApikey, String mResetPasswordOtp, long mResetPasswordCreateAt) {
        this.mId = mId;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
        this.mApikey = mApikey;
        this.mResetPasswordOtp = mResetPasswordOtp;
        this.mResetPasswordCreateAt = mResetPasswordCreateAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mPassword='" + mPassword + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mApikey='" + mApikey + '\'' +
                ", mResetPasswordOtp='" + mResetPasswordOtp + '\'' +
                ", mResetPasswordCreateAt=" + mResetPasswordCreateAt +
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

    public String getmResetPasswordOtp() {
        return mResetPasswordOtp;
    }

    public void setmResetPasswordOtp(String mResetPasswordOtp) {
        this.mResetPasswordOtp = mResetPasswordOtp;
    }

    public long getmResetPasswordCreateAt() {
        return mResetPasswordCreateAt;
    }

    public void setmResetPasswordCreateAt(long mResetPasswordCreateAt) {
        this.mResetPasswordCreateAt = mResetPasswordCreateAt;
    }

    private String mEmail;
    private String mApikey;
    private String mResetPasswordOtp;
    private long mResetPasswordCreateAt;


    public String getpassword() {
        return null;
    }

    public String getemail() {
        return null;
    }


    public String getApikey() {
        return null;
    }

    public String getResetPasswordOtp() {
        return null;
    }

    public long getResetPasswordCreateAt() {
        return 0;
    }

    public String getId() {
        return null;
    }
}
