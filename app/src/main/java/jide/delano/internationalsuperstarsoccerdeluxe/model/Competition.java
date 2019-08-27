package jide.delano.internationalsuperstarsoccerdeluxe.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Competition implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        out.writeInt(this.id);
        out.writeString(this.name);
    }

    public static final Parcelable.Creator<Competition> CREATOR
            = new Parcelable.Creator<Competition>() {
        public Competition createFromParcel(Parcel in) {
            return new Competition(in);
        }

        public Competition[] newArray(int size) {
            return new Competition[size];
        }
    };

    public Competition() {
    }

    protected Competition(Parcel in) {
        this.url = in.readString();
        this.id = in.readInt();
        this.name = in.readString();
    }
}