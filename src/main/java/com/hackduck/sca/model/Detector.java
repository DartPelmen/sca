package com.hackduck.sca.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="detectors")
public class Detector {
    @Id
    @Column(name="iddetector")
    @Type(type="pg-uuid")
    private UUID iddetector;

    @Column(name="description")
    private String desc;

    @Column(name="street")
    private String street;

    @Column(name="status")
    private Integer status;

    public UUID getIddetector() {
        return iddetector;
    }

    public void setIddetector(UUID iddetector) {
        this.iddetector = iddetector;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
