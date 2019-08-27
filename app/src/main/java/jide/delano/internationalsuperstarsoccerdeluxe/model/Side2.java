package jide.delano.internationalsuperstarsoccerdeluxe.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Side2 implements Parcelable {

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

    public static final Parcelable.Creator<Side2> CREATOR
            = new Parcelable.Creator<Side2>() {
        public Side2 createFromParcel(Parcel in) {
            return new Side2(in);
        }

        public Side2[] newArray(int size) {
            return new Side2[size];
        }
    };

    public Side2() {
    }

    protected Side2(Parcel in) {
        this.url = in.readString();
        this.name = in.readString();
    }
}
