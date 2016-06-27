package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vlad on 22.06.16.
 */
@Entity
@Table(name = "ADDRESSES", schema = "PAYMENT")
public class AddressesEntity {
    private Integer addressId;
    private Integer residentCnt;
    private Integer registeredCnt;
    private Integer hoaId;
    private String street;
    private Integer house;
    private String building;
    private Integer apartment;
    private Collection<AbonentsEntity> abonentsesByAddressId;
    private HoasEntity hoasByHoaId;
    private Collection<ResidentsEntity> residentsesByAddressId;
    private Collection<UsersEntity> usersesByAddressId;

    @Id
    @Column(name = "ADDRESS_ID")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "RESIDENT_CNT")
    public Integer getResidentCnt() {
        return residentCnt;
    }

    public void setResidentCnt(Integer residentCnt) {
        this.residentCnt = residentCnt;
    }

    @Basic
    @Column(name = "REGISTERED_CNT")
    public Integer getRegisteredCnt() {
        return registeredCnt;
    }

    public void setRegisteredCnt(Integer registeredCnt) {
        this.registeredCnt = registeredCnt;
    }

    @Basic
    @Column(name = "HOA_ID")
    public Integer getHoaId() {
        return hoaId;
    }

    public void setHoaId(Integer hoaId) {
        this.hoaId = hoaId;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "HOUSE")
    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    @Basic
    @Column(name = "BUILDING")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "APARTMENT")
    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressesEntity that = (AddressesEntity) o;

        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (apartment != null ? !apartment.equals(that.apartment) : that.apartment != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (hoaId != null ? !hoaId.equals(that.hoaId) : that.hoaId != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        if (registeredCnt != null ? !registeredCnt.equals(that.registeredCnt) : that.registeredCnt != null)
            return false;
        if (residentCnt != null ? !residentCnt.equals(that.residentCnt) : that.residentCnt != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId != null ? addressId.hashCode() : 0;
        result = 31 * result + (residentCnt != null ? residentCnt.hashCode() : 0);
        result = 31 * result + (registeredCnt != null ? registeredCnt.hashCode() : 0);
        result = 31 * result + (hoaId != null ? hoaId.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<AbonentsEntity> getAbonentsesByAddressId() {
        return abonentsesByAddressId;
    }

    public void setAbonentsesByAddressId(Collection<AbonentsEntity> abonentsesByAddressId) {
        this.abonentsesByAddressId = abonentsesByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "HOA_ID", referencedColumnName = "HOA_ID", nullable = false, insertable = false, updatable = false)
    public HoasEntity getHoasByHoaId() {
        return hoasByHoaId;
    }

    public void setHoasByHoaId(HoasEntity hoasByHoaId) {
        this.hoasByHoaId = hoasByHoaId;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<ResidentsEntity> getResidentsesByAddressId() {
        return residentsesByAddressId;
    }

    public void setResidentsesByAddressId(Collection<ResidentsEntity> residentsesByAddressId) {
        this.residentsesByAddressId = residentsesByAddressId;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<UsersEntity> getUsersesByAddressId() {
        return usersesByAddressId;
    }

    public void setUsersesByAddressId(Collection<UsersEntity> usersesByAddressId) {
        this.usersesByAddressId = usersesByAddressId;
    }
}
