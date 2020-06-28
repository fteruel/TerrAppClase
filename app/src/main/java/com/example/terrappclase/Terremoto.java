package com.example.terrappclase;

public class Terremoto {

    private Double mMagnitud;
    private String mLugar;
    private Long mTiempo;

    //TODO terremoto ahora tome URL como entrada


    public Terremoto(Double mMagnitud, String mLugar, Long mTiempo) {
        this.mMagnitud = mMagnitud;
        this.mLugar = mLugar;
        this.mTiempo = mTiempo;
    }

    public Double getmMagnitud() {
        return mMagnitud;
    }

    public String getmLugar() {
        return mLugar;
    }

    public Long getmTiempo() {return mTiempo;}
}
