package com.hackduck.sca.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @Column(name="idcar")
    @Type(type="pg-uuid")
    private UUID idcar;

    @Column(name="number")
    private String number;

    @Column(name="model")
    private String model;

    @Column(name="status")
    private Integer status;

    @Column(name="pacsid")
    @Type(type="pg-uuid")
    private UUID pacsid;

    @JsonBackReference
    @ManyToMany(mappedBy = "carList")
    private List<User> userList;

    public UUID getIdcar() {
        return idcar;
    }

    public void setIdcar(UUID idcar) {
        this.idcar = idcar;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
