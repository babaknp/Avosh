/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avosh.baseproject.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author amirk
 */
@Entity
@Table(name = "redeem_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeemUser.findAll", query = "SELECT r FROM RedeemUser r")
    , @NamedQuery(name = "RedeemUser.findById", query = "SELECT r FROM RedeemUser r WHERE r.id = :id")
    , @NamedQuery(name = "RedeemUser.findByCreateDate", query = "SELECT r FROM RedeemUser r WHERE r.createDate = :createDate")})
public class RedeemUser implements BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinColumn(name = "redeem_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Redeem redeemId;
    @JoinColumn(name = "sec_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SecUser secUserId;
    @OneToMany(mappedBy = "redeemUserId")
    private Collection<Finance> financeCollection;

    public RedeemUser() {
    }

    public RedeemUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Redeem getRedeemId() {
        return redeemId;
    }

    public void setRedeemId(Redeem redeemId) {
        this.redeemId = redeemId;
    }

    public SecUser getSecUserId() {
        return secUserId;
    }

    public void setSecUserId(SecUser secUserId) {
        this.secUserId = secUserId;
    }

    @XmlTransient
    public Collection<Finance> getFinanceCollection() {
        return financeCollection;
    }

    public void setFinanceCollection(Collection<Finance> financeCollection) {
        this.financeCollection = financeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeemUser)) {
            return false;
        }
        RedeemUser other = (RedeemUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.RedeemUser[ id=" + id + " ]";
    }
    
}
