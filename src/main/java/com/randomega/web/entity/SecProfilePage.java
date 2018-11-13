package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "sec_profile_page")
public class SecProfilePage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_page")
    private BigInteger id;

    @JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
    @ManyToOne
    private SecProfile secProfile;

    @JoinColumn(name = "id_page", referencedColumnName = "id_page")
    @ManyToOne
    private SecPage secPage;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public SecProfile getSecProfile() {
        return secProfile;
    }

    public void setSecProfile(SecProfile secProfile) {
        this.secProfile = secProfile;
    }

    public SecPage getSecPage() {
        return secPage;
    }

    public void setSecPage(SecPage secPage) {
        this.secPage = secPage;
    }

}
