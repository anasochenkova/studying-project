package com.anasochenkova.database;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Anastasia on 25.05.2017.
 */
@Entity(name="bands")
public class Band {
    @Id
    private int bandId;
    private String bandName;

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
