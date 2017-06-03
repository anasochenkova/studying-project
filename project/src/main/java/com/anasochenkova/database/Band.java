package com.anasochenkova.database;

import javax.persistence.Entity;
import javax.persistence.Id;

/** This class is needed for getting entity <strong>"bands"</strong> from DB
 * Created by Anastasia on 25.05.2017.
 * @author Anasasia
 * @version 1.0
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
