package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vlad on 22.06.16.
 */
@NamedQuery(name = "Abonents.findById", query = "SELECT a from AbonentsEntity a WHERE a.id =:id")
@Entity
@Table(name = "ABONENTS", schema = "PAYMENT")
public class AbonentsEntity {
    private Integer abonentId;
    private Integer abonentAccount;
    private Integer addressId;
    private AddressesEntity addressesByAddressId;
    private ServicesEntity servicesByServiceId;
    private Collection<ChargesEntity> chargesesByAbonentId;

    @Id
    @Column(name = "ABONENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abn_gen")
    @GenericGenerator(name="abn_gen", strategy = "sequence", parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "a_gen")})
    public Integer getAbonentId() {
        return abonentId;
    }

    public void setAbonentId(Integer abonentId) {
        this.abonentId = abonentId;
    }

    @Basic
    @Column(name = "ABONENT_ACCOUNT")
    public Integer getAbonentAccount() {
        return abonentAccount;
    }

    public void setAbonentAccount(Integer abonentAccount) {
        this.abonentAccount = abonentAccount;
    }

    @Basic
    @Column(name = "ADDRESS_ID")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbonentsEntity that = (AbonentsEntity) o;

        if (abonentAccount != null ? !abonentAccount.equals(that.abonentAccount) : that.abonentAccount != null)
            return false;
        if (abonentId != null ? !abonentId.equals(that.abonentId) : that.abonentId != null) return false;
        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = abonentId != null ? abonentId.hashCode() : 0;
        result = 31 * result + (abonentAccount != null ? abonentAccount.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID", nullable = false)
    public ServicesEntity getServicesByServiceId() {
        return servicesByServiceId;
    }

    public void setServicesByServiceId(ServicesEntity servicesByServiceId) {
        this.servicesByServiceId = servicesByServiceId;
    }

    @OneToMany(mappedBy = "abonentsByAbonentId")
    public Collection<ChargesEntity> getChargesesByAbonentId() {
        return chargesesByAbonentId;
    }

    public void setChargesesByAbonentId(Collection<ChargesEntity> chargesesByAbonentId) {
        this.chargesesByAbonentId = chargesesByAbonentId;
    }
}
