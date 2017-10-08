package com.example.uberv.githubbrowser.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class User {

    @PrimaryKey
    @SerializedName("login")
    @ColumnInfo(name = "login")
    private final String mLogin;
    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    private final String mAvatarUrl;
    @SerializedName("name")
    @ColumnInfo(name = "name")
    private final String mName;
    @SerializedName("company")
    @ColumnInfo(name = "company")
    private final String mCompany;
    @SerializedName("repos_url")
    @ColumnInfo(name = "repos_url")
    private final String mReposUrl;
    @SerializedName("blog")
    @ColumnInfo(name = "blog")
    private final String mBlog;

    public User(String login, String avatarUrl, String name, String company,
                String reposUrl, String blog) {
        this.mLogin = login;
        this.mAvatarUrl = avatarUrl;
        this.mName = name;
        this.mCompany = company;
        this.mReposUrl = reposUrl;
        this.mBlog = blog;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getName() {
        return mName;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public String getBlog() {
        return mBlog;
    }
}
