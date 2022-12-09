package com.example.simplenav;

import androidx.annotation.NonNull;

public class CreateTwok {

    private @NonNull String sid;
    private @NonNull String text;
    private @NonNull String bgcol;
    private @NonNull String fontcol;
    private @NonNull String fontsize;
    private @NonNull String fonttype;
    private @NonNull String halign;
    private @NonNull String valign;
    private @NonNull String lat;
    private @NonNull String lon;

    public CreateTwok(String sid, String text, String bgcol, String fontcol, String fontsize, String fonttype, String halign, String valign, String lat, String lon) {
        this.sid = sid;
        this.text = text;
        this.bgcol = bgcol;
        this.fontcol = fontcol;
        this.fontsize = fontsize;
        this.fonttype = fonttype;
        this.halign = halign;
        this.valign = valign;
        this.lat = lat;
        this.lon = lon;
    }

    public CreateTwok() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBgcol() {
        return bgcol;
    }

    public void setBgcol(String bgcol) {
        this.bgcol = bgcol;
    }

    public String getFontcol() {
        return fontcol;
    }

    public void setFontcol(String fontcol) {
        this.fontcol = fontcol;
    }

    public String getFontsize() {
        return fontsize;
    }

    public void setFontsize(String fontsize) {
        this.fontsize = fontsize;
    }

    public String getFonttype() {
        return fonttype;
    }

    public void setFonttype(String fonttype) {
        this.fonttype = fonttype;
    }

    public String getHalign() {
        return halign;
    }

    public void setHalign(String halign) {
        this.halign = halign;
    }

    public String getValign() {
        return valign;
    }

    public void setValign(String valign) {
        this.valign = valign;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "CreateTwok{" +
                "sid='" + sid + '\'' +
                ", text='" + text + '\'' +
                ", bgcol='" + bgcol + '\'' +
                ", fontcol='" + fontcol + '\'' +
                ", fontsize='" + fontsize + '\'' +
                ", fonttype='" + fonttype + '\'' +
                ", halign='" + halign + '\'' +
                ", valign='" + valign + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }

    public enum Font {
        FONT1,
        FONT2,
        FONT3
    }
    public enum Dimension {
        small,
        medium,
        large
    }
    public enum Horizontal {
        left,
        center,
        right
    }
    public enum Vertical {
        top,
        center,
        bottom
    }



}
