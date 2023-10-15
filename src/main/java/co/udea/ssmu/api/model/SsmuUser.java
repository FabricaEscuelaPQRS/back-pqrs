
package co.udea.ssmu.api.model;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jairl
 */
@Entity
@Table(name = "SSMU_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsmuUser.findAll", query = "SELECT s FROM SsmuUser s"),
    @NamedQuery(name = "SsmuUser.findByUserId", query = "SELECT s FROM SsmuUser s WHERE s.userId = :userId"),
    @NamedQuery(name = "SsmuUser.findByFirstName", query = "SELECT s FROM SsmuUser s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "SsmuUser.findByLastName", query = "SELECT s FROM SsmuUser s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "SsmuUser.findByEmail", query = "SELECT s FROM SsmuUser s WHERE s.email = :email"),
    @NamedQuery(name = "SsmuUser.findByPhone", query = "SELECT s FROM SsmuUser s WHERE s.phone = :phone"),
    @NamedQuery(name = "SsmuUser.findByStateUser", query = "SELECT s FROM SsmuUser s WHERE s.stateUser = :stateUser"),
    @NamedQuery(name = "SsmuUser.findByUserRole", query = "SELECT s FROM SsmuUser s WHERE s.userRole = :userRole")})
public class SsmuUser implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private Long userId;
    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "STATE_USER")
    private Short stateUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USER_ROLE")
    private String userRole;
    @OneToMany(mappedBy = "createdBy")
    private Collection<Pqrs> pqrsCollection;
    @OneToMany(mappedBy = "adminId")
    private Collection<Pqrs> pqrsCollection1;
    @OneToMany(mappedBy = "complainTo")
    private Collection<Pqrs> pqrsCollection2;

    public SsmuUser() {
    }

    public SsmuUser(Long userId) {
        this.userId = userId;
    }

    public SsmuUser(Long userId, String userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getStateUser() {
        return stateUser;
    }

    public void setStateUser(Short stateUser) {
        this.stateUser = stateUser;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @XmlTransient
    public Collection<Pqrs> getPqrsCollection() {
        return pqrsCollection;
    }

    public void setPqrsCollection(Collection<Pqrs> pqrsCollection) {
        this.pqrsCollection = pqrsCollection;
    }

    @XmlTransient
    public Collection<Pqrs> getPqrsCollection1() {
        return pqrsCollection1;
    }

    public void setPqrsCollection1(Collection<Pqrs> pqrsCollection1) {
        this.pqrsCollection1 = pqrsCollection1;
    }

    @XmlTransient
    public Collection<Pqrs> getPqrsCollection2() {
        return pqrsCollection2;
    }

    public void setPqrsCollection2(Collection<Pqrs> pqrsCollection2) {
        this.pqrsCollection2 = pqrsCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsmuUser)) {
            return false;
        }
        SsmuUser other = (SsmuUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SsmuUser[ userId=" + userId + " ]";
    }
    
}
