package models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Vlad on 22.06.16.
 */
@Entity
@Table(name = "PAYMENTS", schema = "PAYMENT")
public class PaymentsEntity {
    private Integer paymentId;
    private Integer chargeId;
    private BigDecimal paymentAmount;
    private ChargesEntity chargesByChargeId;

    @Id
    @Column(name = "PAYMENT_ID")
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "CHARGE_ID")
    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    @Basic
    @Column(name = "PAYMENT_AMOUNT")
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentsEntity that = (PaymentsEntity) o;

        if (chargeId != null ? !chargeId.equals(that.chargeId) : that.chargeId != null) return false;
        if (paymentAmount != null ? !paymentAmount.equals(that.paymentAmount) : that.paymentAmount != null)
            return false;
        if (paymentId != null ? !paymentId.equals(that.paymentId) : that.paymentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId != null ? paymentId.hashCode() : 0;
        result = 31 * result + (chargeId != null ? chargeId.hashCode() : 0);
        result = 31 * result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CHARGE_ID", referencedColumnName = "CHARGE_ID", updatable = false, insertable = false)
    public ChargesEntity getChargesByChargeId() {
        return chargesByChargeId;
    }

    public void setChargesByChargeId(ChargesEntity chargesByChargeId) {
        this.chargesByChargeId = chargesByChargeId;
    }
}
