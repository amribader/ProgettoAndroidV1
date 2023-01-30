package com.example.simplenav.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;
@Entity
public class Twok {
    @PrimaryKey
    private int uid;
    private @NotNull String name;
    private int pversion;
    private @NotNull String picture;

    public Twok(int uid, @NotNull String name, int pversion, @NotNull String picture) {
        this.uid = uid;
        this.name = name;
        this.pversion = pversion;
        this.picture = picture;
    }


    public int getUid() {
        return uid;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public int getPversion() {
        return pversion;
    }

    @NotNull
    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "Twok{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", pversion=" + pversion +
                ", picture='" + picture + '\'' +
                '}';
    }
}
