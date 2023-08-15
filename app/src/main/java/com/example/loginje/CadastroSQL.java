package com.example.loginje;

public class CadastroSQL {

    public static final String TAG = "Aluno Table";

    //COLUNAS = MEMBROS

    public CadastroSQL(int mId, String mNome, String mEmail, String mPassword, long mCreateDate, String mNivel, String mApikey) {
        this.mId = mId;
        this.mNome = mNome;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mCreateDate = mCreateDate;
        this.mNivel = mNivel;
        this.mApikey = mApikey;
    }

    public CadastroSQL(String mNome, String mEmail, String mPassword, long mCreateDate, String mNivel, String mApikey) {
        this.mNome = mNome;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mCreateDate = mCreateDate;
        this.mNivel = mNivel;
        this.mApikey = mApikey;
    }

    @Override
    public String toString() {
        return "CadastroSQL{" +
                "mId=" + mId +
                ", mNome='" + mNome + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mCreateDate=" + mCreateDate +
                ", mNivel='" + mNivel + '\'' +
                ", mApikey='" + mApikey + '\'' +
                '}';
    }

    private int mId;
    private String mNome;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmFullName() {
        return mNome;
    }

    public void setmFullName(String mFullName) {
        this.mNome = mNome;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public long getmCreateDate() {
        return mCreateDate;
    }

    public void setmCreateDate(long mCreateDate) {
        this.mCreateDate = mCreateDate;
    }

    public String getmNivel() {
        return mNivel;
    }

    public void setmNivel(String mNivel) {
        this.mNivel = mNivel;
    }

    public String getmApikey() {
        return mApikey;
    }

    public void setmApikey(String mApikey) {
        this.mApikey = mApikey;
    }

    private String mEmail;
    private String mPassword;
    private long mCreateDate;
    private String mNivel;
    private String mApikey;






}
