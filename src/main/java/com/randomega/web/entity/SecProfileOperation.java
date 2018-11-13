package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "sec_profile_operation")
public class SecProfileOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile_operation")
    private BigInteger id;

    @JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
    @ManyToOne
    private SecProfile secProfile;

    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne
    private SecOperation secOperation;

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

    public SecOperation getSecOperation() {
        return secOperation;
    }

    public void setSecOperation(SecOperation secOperation) {
        this.secOperation = secOperation;
    }

}
