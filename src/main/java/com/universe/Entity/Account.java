package com.universe.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by boduill on 01.10.15.
 * Entity for accounts table
 */
@Entity
@Table(name = "ACCOUNTS")

public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
    @TableGenerator(
            name = "idGenerator",
            table = "IDS",
            pkColumnName = "table_name",
            valueColumnName = "id_value",
            allocationSize = 100
    )
    @Column(name = "ACC_ID")
    @Expose
    private long id;

    @Expose
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Expose
    @Column(name = "LAST_NAME")
    private String lastName;

    @Expose
    @Column(name = "EMAIL")
    private String eMail;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthDay;

    @Column(name = "PROFFESSION")
    private String profession;

    @Column(name = "HOBBIES")
    private String hobbies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UN_ID")
    private Universe universe;

    @Column(name = "AVATAR")
    private byte[] avatar;

    /**
     * Can containt only 'wait', 'friends', 'apply' values
     */
    @Transient
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBase64() {
        return "data:image/png;base64," + Base64.encode(avatar);
    }

    public String getJson() throws JsonProcessingException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String result = gson.toJson(this);
//        result = result.replaceAll("(\".?(?=:))", "");
//        result = result.replaceAll(",\"", ",");
//        result = result.replaceAll("[{]\"", "{");
//        result = result.replaceAll("\"", "\'");
//        System.out.println(result);
        System.out.println(result);
        return result;
    }

    @Override
    public String toString() {
        return "{id : " + id + "}";
    }
}
