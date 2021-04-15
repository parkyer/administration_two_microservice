package com.parkyer.admin2.parking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Parking {
    @Id
    @SequenceGenerator(
        name = "parking_sequence",
        sequenceName =  "parking_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )

    private int id;
    private int id_owner;
    private String id_client;
    private String location;
    private String type;


    public Parking() {
    }

    public Parking(int id_owner, String id_client, String location, String type) {
        this.id_owner = id_owner;
        this.id_client = id_client;
        this.location = location;
        this.type = type;
    }

    public Parking(int id, int id_owner, String id_client, String location, String type) {
        this.id = id;
        this.id_owner = id_owner;
        this.id_client = id_client;
        this.location = location;
        this.type = type;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_owner() {
        return this.id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }


    public String getId_client() {
        return this.id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " id_owner='" + getId_owner() + "'" +
            ", id_client='" + getId_client() + "'" +
            ", location='" + getLocation() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

}
