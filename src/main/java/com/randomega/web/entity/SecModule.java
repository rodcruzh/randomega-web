package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "sec_module")
public class SecModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_module")
    private BigInteger id;

    @Column
    private String name;

    @JoinColumn(name = "id_father_module", referencedColumnName = "id_module")
    @ManyToOne
    private SecModule secFatherModule;

    @Column
    private Boolean active;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SecModule getSecFatherModule() {
        return secFatherModule;
    }

    public void setSecFatherModule(SecModule secFatherModule) {
        this.secFatherModule = secFatherModule;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
