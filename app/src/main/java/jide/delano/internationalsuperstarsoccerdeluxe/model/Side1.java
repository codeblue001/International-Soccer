package jide.delano.internationalsuperstarsoccerdeluxe.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Side1 implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //Parcelable
    //https://developer.android.com/reference/android/os/Parcelable.html

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.url);
        out.writeString(this.name);
    }

    public static final Parcelable.Creator<Side1> CREATOR
            = new Parcelable.Creator<Side1>() {
        public Side1 createFromParcel(Parcel in) {
            return new Side1(in);
        }

        public Side1[] newArray(int size) {
            return new Side1[size];
        }
    };

    public Side1() {
    }

    protected Side1(Parcel in) {
       this.url = in.readString();
        this.name = in.readString();
    }
}