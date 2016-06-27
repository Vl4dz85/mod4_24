package models;

import javax.persistence.*;

/**
 * Created by Vlad on 22.06.16.
 */
@Entity
@Table(name = "USERS", schema = "PAYMENT")
public class UsersEntity {
    private String userId;
    private String userPassword;
    private Integer addressId;
    private String roleId;
    private AddressesEntity addressesByAddressId;
    private RolesEntity rolesByRoleId;

    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_PASSWORD")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
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
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", insertable = false, updatable = false)
    public RolesEntity getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(RolesEntity rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}
