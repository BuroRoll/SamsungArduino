package com.example.buror.samsungproject.IDE;

import android.os.Parcel;
import android.os.Parcelable;

public class Code implements Parcelable {
    private long id;
    private String name;
    private String code;

    public Code(long id, String name, String code){
        this.id = id;
        this.name = name;
        this.code = code;
    }

    protected Code(Parcel in){
        id = in.readLong();
        name = in.readString();
        code = in.readString();
    }

    public static final Creator<Code> CREATOR = new Creator<Code>() {
        @Override
        public Code createFromParcel(Parcel in) {
            return new Code(in);
        }

        @Override
        public Code[] newArray(int size) {
            return new Code[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {  //штука, без которой объект не передаётся через интиент
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(code);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}