package com.example.uberv.githubbrowser.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(
        primaryKeys = {"repo_name","repo_owner","login"},
        foreignKeys = @ForeignKey(entity = Repo.class,
        parentColumns = {"name","owner_login"})
)
public class Contributor {
}
