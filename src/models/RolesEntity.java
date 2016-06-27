package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vlad on 22.06.16.
 */
@Entity
@Table(name = "ROLES", schema = "PAYMENT")
public class RolesEntity {
    private String roleId;
    private String roleName;
    private Collection<UsersEntity> usersesByRoleId;

    @Id
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rolesByRoleId")
    public Collection<UsersEntity> getUsersesByRoleId() {
        return usersesByRoleId;
    }

    public void setUsersesByRoleId(Collection<UsersEntity> usersesByRoleId) {
        this.usersesByRoleId = usersesByRoleId;
    }
}
