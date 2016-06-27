package models;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Vlad on 22.06.16.
 */
@Entity
@Table(name = "RESIDENTS", schema = "PAYMENT")
public class ResidentsEntity {
    private Integer residentId;
    private Integer addressId;
    private String residentName;
    private BigInteger mainOwner;
    private AddressesEntity addressesByAddressId;

    @Id
    @Column(name = "RESIDENT_ID")
    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    @Basic
    @Column(name = "ADDRESS_ID")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "RESIDENT_NAME")
    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    @Basic
    @Column(name = "MAIN_OWNER")
    public BigInteger getMainOwner() {
        return mainOwner;
    }

    public void setMainOwner(BigInteger mainOwner) {
        this.mainOwner = mainOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidentsEntity that = (ResidentsEntity) o;

        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (mainOwner != null ? !mainOwner.equals(that.mainOwner) : that.mainOwner != null) return false;
        if (residentId != null ? !residentId.equals(that.residentId) : that.residentId != null) return false;
        if (residentName != null ? !residentName.equals(that.residentName) : that.residentName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = residentId != null ? residentId.hashCode() : 0;
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (residentName != null ? residentName.hashCode() : 0);
        result = 31 * result + (mainOwner != null ? mainOwner.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false, insertable = false, updatable = false)
    public AddressesEntity getAddressesByAddressId() {
        return addressesByAddressId;
    }

    public void setAddressesByAddressId(AddressesEntity addressesByAddressId) {
        this.addressesByAddressId = addressesByAddressId;
    }
}
