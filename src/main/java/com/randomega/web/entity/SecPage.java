package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "sec_page")
public class SecPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_page")
    private BigInteger id;

    @Column
    private String name;

    @Column(name = "menu_item")
    private Boolean menuItem;

    @JoinColumn(name = "id_father_page", referencedColumnName = "id_page")
    @ManyToOne
    private SecPage secFatherPage;

    @JoinColumn(name = "id_module", referencedColumnName = "id_module")
    @ManyToOne
    private SecModule secModule;

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

    public Boolean getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Boolean menuItem) {
        this.menuItem = menuItem;
    }

    public SecPage getSecFatherPage() {
        return secFatherPage;
    }

    public void setSecFatherPage(SecPage secFatherPage) {
        this.secFatherPage = secFatherPage;
    }

    public SecModule getSecModule() {
        return secModule;
    }

    public void setSecModule(SecModule secModule) {
        this.secModule = secModule;
    }

}
