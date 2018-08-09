package com.example.angeli.patientprofiles;

import java.io.Serializable;

public class Patient implements Serializable {
    private String name;
    private String id;

    /**
     * Constructs a patient with given name and id.
     *
     * @param name the patient's number
     * @param id the patient's id
     */

    public Patient (String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Return the name of the patient
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the id of the patient
     *
     * @return the id
     */
    public String getId() {
        return id;
    }
}
