package com.krystianfh.songr;

import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public String feeling;
    boolean causesUsToLaugh;
    String personHavingIt;
    int level;
    String reason;

    public Emotion(String feeling, boolean causesUsToLaugh, String personHavingIt, int level, String reason){
        this.feeling = feeling;
        this.causesUsToLaugh = causesUsToLaugh;
        this.personHavingIt = personHavingIt;
        this.level = level;
        this.reason = reason;
    }

    public Emotion(){}

    public boolean isCausesUsToLaugh(){
        return causesUsToLaugh;
    }

    public String getPersonHavingIt(){
        return personHavingIt;
    }

    public int getLevel() {
        return level;
    }

    public String getReason() {
        return reason;
    }

    public String getFeeling() {
        return feeling;
    }
}
