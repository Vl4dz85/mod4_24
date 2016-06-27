package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vlad on 22.06.16.
 */
@NamedQuery(name = "Services.findById", query = "SELECT s from ServicesEntity s where s.id = :id")
@Entity
@Table(name = "SERVICES", schema = "PAYMENT")
public class ServicesEntity {
    private Integer serviceId;
    private String serviceName;
    private IsMeter isMeter;
    private Collection<AbonentsEntity> abonentsByServiceId;
    private ProvidersEntity providersByProviderId;

    @Id
    @Column(name = "SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serv_gen")
    @GenericGenerator(name="serv_gen", strategy = "sequence", parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "s_gen")})
    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "SERVICE_NAME")
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }



    @Basic
    @Column(name = "IS_METER")
    @Convert(converter = IsMeterConverter.class)
    public IsMeter getIsMeter() {
        return isMeter;
    }

    public void setIsMeter(IsMeter isMeter) {
        this.isMeter = isMeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServicesEntity that = (ServicesEntity) o;

        if (isMeter != null ? !isMeter.equals(that.isMeter) : that.isMeter != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (isMeter != null ? isMeter.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "servicesByServiceId")
    public Collection<AbonentsEntity> getAbonentsByServiceId() {
        return abonentsByServiceId;
    }

    public void setAbonentsByServiceId(Collection<AbonentsEntity> abonentsesByServiceId) {
        this.abonentsByServiceId = abonentsesByServiceId;
    }

    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "PROVIDER_ID", nullable = false)
    public ProvidersEntity getProvidersByProviderId() {
        return providersByProviderId;
    }

    public void setProvidersByProviderId(ProvidersEntity providersByProviderId) {
        this.providersByProviderId = providersByProviderId;
    }
}
