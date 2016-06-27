package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Vlad on 22.06.16.
 */
@Entity
@Table(name = "CHARGES", schema = "PAYMENT")
public class ChargesEntity {
    private Integer chargeId;
    private Integer abonentId;
    private BigDecimal chargeAmount;
    private Timestamp periodBeginDate;
    private Timestamp periodEndDate;
    private BigInteger chargePaid;
    private AbonentsEntity abonentsByAbonentId;
    private Collection<PaymentsEntity> paymentsesByChargeId;

    @Id
    @Column(name = "CHARGE_ID")
    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    @Basic
    @Column(name = "ABONENT_ID")
    public Integer getAbonentId() {
        return abonentId;
    }

    public void setAbonentId(Integer abonentId) {
        this.abonentId = abonentId;
    }

    @Basic
    @Column(name = "CHARGE_AMOUNT")
    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    @Basic
    @Column(name = "PERIOD_BEGIN_DATE")
    public Timestamp getPeriodBeginDate() {
        return periodBeginDate;
    }

    public void setPeriodBeginDate(Timestamp periodBeginDate) {
        this.periodBeginDate = periodBeginDate;
    }

    @Basic
    @Column(name = "PERIOD_END_DATE")
    public Timestamp getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(Timestamp periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    @Basic
    @Column(name = "CHARGE_PAID")
    public BigInteger getChargePaid() {
        return chargePaid;
    }

    public void setChargePaid(BigInteger chargePaid) {
        this.chargePaid = chargePaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargesEntity that = (ChargesEntity) o;

        if (abonentId != null ? !abonentId.equals(that.abonentId) : that.abonentId != null) return false;
        if (chargeAmount != null ? !chargeAmount.equals(that.chargeAmount) : that.chargeAmount != null) return false;
        if (chargeId != null ? !chargeId.equals(that.chargeId) : that.chargeId != null) return false;
        if (chargePaid != null ? !chargePaid.equals(that.chargePaid) : that.chargePaid != null) return false;
        if (periodBeginDate != null ? !periodBeginDate.equals(that.periodBeginDate) : that.periodBeginDate != null)
            return false;
        if (periodEndDate != null ? !periodEndDate.equals(that.periodEndDate) : that.periodEndDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chargeId != null ? chargeId.hashCode() : 0;
        result = 31 * result + (abonentId != null ? abonentId.hashCode() : 0);
        result = 31 * result + (chargeAmount != null ? chargeAmount.hashCode() : 0);
        result = 31 * result + (periodBeginDate != null ? periodBeginDate.hashCode() : 0);
        result = 31 * result + (periodEndDate != null ? periodEndDate.hashCode() : 0);
        result = 31 * result + (chargePaid != null ? chargePaid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ABONENT_ID", referencedColumnName = "ABONENT_ID", nullable = false, insertable = false, updatable = false)
    public AbonentsEntity getAbonentsByAbonentId() {
        return abonentsByAbonentId;
    }

    public void setAbonentsByAbonentId(AbonentsEntity abonentsByAbonentId) {
        this.abonentsByAbonentId = abonentsByAbonentId;
    }

    @OneToMany(mappedBy = "chargesByChargeId")
    public Collection<PaymentsEntity> getPaymentsesByChargeId() {
        return paymentsesByChargeId;
    }

    public void setPaymentsesByChargeId(Collection<PaymentsEntity> paymentsesByChargeId) {
        this.paymentsesByChargeId = paymentsesByChargeId;
    }
}
