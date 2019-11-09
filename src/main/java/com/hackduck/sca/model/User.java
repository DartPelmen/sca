package com.hackduck.sca.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="iduser")
    @Type(type="pg-uuid")
    private UUID iduser;

    @Column(name="fname")
    private String fname;

    @Column(name="sname")
    private String sname;

    @Column(name="lname")
    private String lname;

    @Column(name="status")
    private Integer status;

    @Column(name="pacsid")
    @Type(type="pg-uuid")
    private UUID pacsid;

    @JsonBackReference
    @Expose
    @ManyToMany
    @JoinTable(
            name = "user_car",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "carid"))
    private List<Car> carList;

    public UUID getIduser() {
        return iduser;
    }

    public void setIduser(UUID iduser) {
        this.iduser = iduser;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UUID getPacsid() {
        return pacsid;
    }

    public void setPacsid(UUID pacsid) {
        this.pacsid = pacsid;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

}

