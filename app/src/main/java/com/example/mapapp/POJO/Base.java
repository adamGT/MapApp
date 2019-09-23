package com.example.mapapp.POJO;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Base implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Base createFromParcel(Parcel in) {
            return new Base(in);
        }

        public Base[] newArray(int size) {
            return new Base[size];
        }
    };


    public String _id;
    private Date createdAt;
    private Date updatedAt;

    public String get_id() {
        return _id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Base() {

    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Base(Parcel in){
        this._id = in.readString();
        this.createdAt = (Date) in.readSerializable();
        this.updatedAt = (Date) in.readSerializable();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeSerializable(this.createdAt);
        dest.writeSerializable(this.updatedAt);
    }

    public Boolean isNew() {
        return this._id == null;
    }
}
