package jide.delano.internationalsuperstarsoccerdeluxe.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchResult implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("embed")
    @Expose
    private String embed;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("side1")
    @Expose
    private Side1 side1;
    @SerializedName("side2")
    @Expose
    private Side2 side2;
    @SerializedName("competition")
    @Expose
    private Competition competition;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Side1 getSide1() {
        return side1;
    }

    public void setSide1(Side1 side1) {
        this.side1 = side1;
    }

    public Side2 getSide2() {
        return side2;
    }

    public void setSide2(Side2 side2) {
        this.side2 = side2;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.videos);
        parcel.writeParcelable(this.competition, i);
        parcel.writeParcelable(this.side2, i);
        parcel.writeParcelable(this.side1, i);
        parcel.writeString(this.date);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.url);
        parcel.writeString(this.embed);
        parcel.writeString(this.title);
    }
    protected MatchResult(Parcel in) {
        this.videos = in.createTypedArrayList(Video.CREATOR);
        this.competition = in.readParcelable(Competition.class.getClassLoader());
        this.side2 = in.readParcelable(Side2.class.getClassLoader());
        this.side1 = in.readParcelable(Side1.class.getClassLoader());
        this.date = in.readString();
        this.thumbnail = in.readString();
        this.url = in.readString();
        this.embed = in.readString();
        this.title = in.readString();
    }

    public static final Creator<MatchResult> CREATOR = new Creator<MatchResult>() {
        @Override
        public MatchResult createFromParcel(Parcel source) {
            return new MatchResult(source);
        }

        @Override
        public MatchResult[] newArray(int size) {
            return new MatchResult[size];
        }
    };
}