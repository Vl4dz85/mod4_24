package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vlad on 22.06.16.
 */
@NamedQuery(name = "Provider.findById", query = "SELECT p from ProvidersEntity p WHERE p.id =:id")
@Entity
@Table(name = "PROVIDERS", schema = "PAYMENT")
public class ProvidersEntity {
    private Integer providerId;
    private String providerName;
    private String providerAddress;
    private Collection<ServicesEntity> servicesesByProviderId;

    @Id
    @Column(name = "PROVIDER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prov_gen")
    @GenericGenerator(name="prov_gen", strategy = "sequence", parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "pr_gen")})
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "PROVIDER_NAME")
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Basic
    @Column(name = "PROVIDER_ADDRESS")
    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvidersEntity that = (ProvidersEntity) o;

        if (providerAddress != null ? !providerAddress.equals(that.providerAddress) : that.providerAddress != null)
            return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;
        if (providerName != null ? !providerName.equals(that.providerName) : that.providerName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = providerId != null ? providerId.hashCode() : 0;
        result = 31 * result + (providerName != null ? providerName.hashCode() : 0);
        result = 31 * result + (providerAddress != null ? providerAddress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "providersByProviderId")
    public Collection<ServicesEntity> getServicesesByProviderId() {
        return servicesesByProviderId;
    }

    public void setServicesesByProviderId(Collection<ServicesEntity> servicesesByProviderId) {
        this.servicesesByProviderId = servicesesByProviderId;
    }
}
