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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.name);
    }

    public Side2() {
    }

    protected Side2(Parcel in) {
        this.url = in.readString();
        this.name = in.readString();
    }

    public static final Creator<Side2> CREATOR = new Creator<Side2>() {
        @Override
        public Side2 createFromParcel(Parcel source) {
            return new Side2(source);
        }

        @Override
        public Side2[] newArray(int size) {
            return new Side2[size];
        }
    };
}
