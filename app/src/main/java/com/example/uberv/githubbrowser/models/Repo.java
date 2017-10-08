package com.example.uberv.githubbrowser.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;

/**
 * Using name/owner_login as primary key instead of id since name/owner_login is always available
 * vs id is not.
 */
@Entity(indices = {@Index("id"), @Index("owner_login")},
        primaryKeys = {"name", "owner_login"})
// TODO comments
public class Repo {
    public static final int UNKNOWN_ID = -1;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private final int mId;
    @SerializedName("name")
    @ColumnInfo(name = "name")
    private final String mName;
    @SerializedName("full_name")
    @ColumnInfo(name = "full_name")
    private final String mFullName;
    @SerializedName("description")
    @ColumnInfo(name = "description")
    private final String mDescription;
    @SerializedName("stargazers_count")
    @ColumnInfo(name = "stars")
    private final int mStars;
    @SerializedName("owner")
    @ColumnInfo(name = "owner")
    @Embedded(prefix = "owner_")
    private final Owner mOwner;

    public Repo(int id, String name, String fullName, String description, int stars, Owner owner) {
        mId = id;
        mName = name;
        mFullName = fullName;
        mDescription = description;
        mStars = stars;
        mOwner = owner;
    }

    public static int getUnknownId() {
        return UNKNOWN_ID;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getStars() {
        return mStars;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public static class Owner {
        @SerializedName("login")
        private final String mLogin;
        @SerializedName("url")
        private final String mUrl;

        public Owner(String login, String url) {
            mLogin = login;
            mUrl = url;
        }

        public String getLogin() {
            return mLogin;
        }

        public String getUrl() {
            return mUrl;
        }
    }
}
