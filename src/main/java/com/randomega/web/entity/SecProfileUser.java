package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "sec_profile_user")
public class SecProfileUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_user")
    private BigInteger id;

    @JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
    @ManyToOne
    private SecProfile secProfile;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private SecUser secUser;

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

    public SecUser getSecUser() {
        return secUser;
    }

    public void setSecUser(SecUser secUser) {
        this.secUser = secUser;
    }

}
