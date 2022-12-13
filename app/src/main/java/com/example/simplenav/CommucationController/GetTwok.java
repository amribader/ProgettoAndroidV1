package com.example.simplenav.CommucationController;

import androidx.annotation.NonNull;

public class GetTwok {

    private String sid = "qaKOeIk1DhEvBLOruWaR";

    private String picture;

    private @NonNull String uid;
    private @NonNull String text;
    private @NonNull String name;
    private @NonNull String bgcol;
    private @NonNull String fontcol;
    private int fontsize;
    private int fonttype;
    private int halign;
    private int valign;
    private float lat;
    private float lon;
    private int pversion;
    private int tid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public GetTwok(@NonNull String uid, @NonNull String text, @NonNull String name, @NonNull String bgcol, @NonNull String fontcol, int fontsize, int fonttype, int halign, int valign, float lat, float lon, int pversion, int tid) {
        this.uid = uid;
        this.text = text;
        this.name = name;
        this.bgcol = bgcol;
        this.fontcol = fontcol;
        this.fontsize = fontsize;
        this.fonttype = fonttype;
        this.halign = halign;
        this.valign = valign;
        this.lat = lat;
        this.lon = lon;
        this.pversion = pversion;
        this.tid = tid;
    }

    public GetTwok() {
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(@NonNull String text) {
        this.text = text;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getBgcol() {
        return bgcol;
    }

    public void setBgcol(@NonNull String bgcol) {
        this.bgcol = bgcol;
    }

    @NonNull
    public String getFontcol() {
        return fontcol;
    }

    public void setFontcol(@NonNull String fontcol) {
        this.fontcol = fontcol;
    }

    public int getFontsize() {
        return fontsize;
    }

    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }

    public int getFonttype() {
        return fonttype;
    }

    public void setFonttype(int fonttype) {
        this.fonttype = fonttype;
    }

    public int getHalign() {
        return halign;
    }

    public void setHalign(int halign) {
        this.halign = halign;
    }

    public int getValign() {
        return valign;
    }

    public void setValign(int valign) {
        this.valign = valign;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public int getPversion() {
        return pversion;
    }

    public void setPversion(int pversion) {
        this.pversion = pversion;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @NonNull
    @Override
    public String toString() {
        return "getTwok{" +
                "uid='" + uid + '\'' +
                ", text='" + text + '\'' +
                ", name='" + name + '\'' +
                ", bgcol='" + bgcol + '\'' +
                ", fontcol='" + fontcol + '\'' +
                ", fontsize=" + fontsize +
                ", fonttype=" + fonttype +
                ", halign=" + halign +
                ", valign=" + valign +
                ", lat=" + lat +
                ", lon=" + lon +
                ", pversion=" + pversion +
                ", tid=" + tid +
                '}';
    }
}
