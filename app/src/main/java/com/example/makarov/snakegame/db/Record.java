package com.example.makarov.snakegame.db;

import java.text.SimpleDateFormat;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 *
 */
public class Record extends RealmObject {

    @PrimaryKey
    private String name;
    private int score;

    @Ignore
    private int sessionId;

    public void setName(String mName) {
        this.name = mName;
    }


    public void setScore(int score) {
        this.score = score;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getScore() {
        return score;
    }

}
