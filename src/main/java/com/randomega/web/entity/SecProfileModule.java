package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "sec_profile_module")
public class SecProfileModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_module")
    private BigInteger id;

    @JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
    @ManyToOne
    private SecProfile secProfile;

    @JoinColumn(name = "id_module", referencedColumnName = "id_module")
    @ManyToOne
    private SecModule secModule;

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

    public SecModule getSecModule() {
        return secModule;
    }

    public void setSecModule(SecModule secModule) {
        this.secModule = secModule;
    }

}
