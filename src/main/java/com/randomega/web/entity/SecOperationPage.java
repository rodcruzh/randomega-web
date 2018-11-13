package com.randomega.web.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "sec_operation_page")
public class SecOperationPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operaton_page")
    private BigInteger id;

    @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")
    @ManyToOne
    private SecOperation secOperation;

    @JoinColumn(name = "id_page", referencedColumnName = "id_page")
    @ManyToOne
    private SecPage secPage;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public SecOperation getSecOperation() {
        return secOperation;
    }

    public void setSecOperation(SecOperation secOperation) {
        this.secOperation = secOperation;
    }

    public SecPage getSecPage() {
        return secPage;
    }

    public void setSecPage(SecPage secPage) {
        this.secPage = secPage;
    }

}
