package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vlad on 22.06.16.
 */
@Entity
@Table(name = "HOAS", schema = "PAYMENT")
public class HoasEntity {
    private Integer hoaId;
    private String hoaName;
    private String hoaAddress;
    private String hoaWebsite;
    private String hoaPhone;
    private Collection<AddressesEntity> addressesesByHoaId;

    @Id
    @Column(name = "HOA_ID")
    public Integer getHoaId() {
        return hoaId;
    }

    public void setHoaId(Integer hoaId) {
        this.hoaId = hoaId;
    }

    @Basic
    @Column(name = "HOA_NAME")
    public String getHoaName() {
        return hoaName;
    }

    public void setHoaName(String hoaName) {
        this.hoaName = hoaName;
    }

    @Basic
    @Column(name = "HOA_ADDRESS")
    public String getHoaAddress() {
        return hoaAddress;
    }

    public void setHoaAddress(String hoaAddress) {
        this.hoaAddress = hoaAddress;
    }

    @Basic
    @Column(name = "HOA_WEBSITE")
    public String getHoaWebsite() {
        return hoaWebsite;
    }

    public void setHoaWebsite(String hoaWebsite) {
        this.hoaWebsite = hoaWebsite;
    }

    @Basic
    @Column(name = "HOA_PHONE")
    public String getHoaPhone() {
        return hoaPhone;
    }

    public void setHoaPhone(String hoaPhone) {
        this.hoaPhone = hoaPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoasEntity that = (HoasEntity) o;

        if (hoaAddress != null ? !hoaAddress.equals(that.hoaAddress) : that.hoaAddress != null) return false;
        if (hoaId != null ? !hoaId.equals(that.hoaId) : that.hoaId != null) return false;
        if (hoaName != null ? !hoaName.equals(that.hoaName) : that.hoaName != null) return false;
        if (hoaPhone != null ? !hoaPhone.equals(that.hoaPhone) : that.hoaPhone != null) return false;
        if (hoaWebsite != null ? !hoaWebsite.equals(that.hoaWebsite) : that.hoaWebsite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hoaId != null ? hoaId.hashCode() : 0;
        result = 31 * result + (hoaName != null ? hoaName.hashCode() : 0);
        result = 31 * result + (hoaAddress != null ? hoaAddress.hashCode() : 0);
        result = 31 * result + (hoaWebsite != null ? hoaWebsite.hashCode() : 0);
        result = 31 * result + (hoaPhone != null ? hoaPhone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "hoasByHoaId")
    public Collection<AddressesEntity> getAddressesesByHoaId() {
        return addressesesByHoaId;
    }

    public void setAddressesesByHoaId(Collection<AddressesEntity> addressesesByHoaId) {
        this.addressesesByHoaId = addressesesByHoaId;
    }
}
