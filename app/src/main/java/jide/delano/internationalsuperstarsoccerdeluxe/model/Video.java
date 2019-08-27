package jide.delano.internationalsuperstarsoccerdeluxe.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("embed")
    @Expose
    private String embed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    //Parcelable
    //https://developer.android.com/reference/android/os/Parcelable.html

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.embed);
        out.writeString(this.title);
    }

    public static final Parcelable.Creator<Video> CREATOR
            = new Parcelable.Creator<Video>() {
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public Video() {
    }

    protected Video(Parcel in) {
        this.embed = in.readString();
        this.title = in.readString();
    }
}
