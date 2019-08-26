package jide.delano.internationalsuperstarsoccerdeluxe.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Competition implements Parcelable{

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
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
    }

    public Competition() {
    }

    protected Competition(Parcel in) {
        this.url = in.readString();
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Competition> CREATOR = new Parcelable.Creator<Competition>() {
        @Override
        public Competition createFromParcel(Parcel source) {
            return new Competition(source);
        }

        @Override
        public Competition[] newArray(int size) {
            return new Competition[size];
        }
    };
}