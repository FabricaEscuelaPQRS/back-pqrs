package co.udea.ssmu.api.model;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jairl
 */
@Entity
@Table(name = "PQRS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqrs.findAll", query = "SELECT p FROM Pqrs p"),
    @NamedQuery(name = "Pqrs.findByPqrsId", query = "SELECT p FROM Pqrs p WHERE p.pqrsId = :pqrsId"),
    @NamedQuery(name = "Pqrs.findByPqrsType", query = "SELECT p FROM Pqrs p WHERE p.pqrsType = :pqrsType"),
    @NamedQuery(name = "Pqrs.findByPqrsState", query = "SELECT p FROM Pqrs p WHERE p.pqrsState = :pqrsState"),
    @NamedQuery(name = "Pqrs.findByApproved", query = "SELECT p FROM Pqrs p WHERE p.approved = :approved"),
    @NamedQuery(name = "Pqrs.findByCreatedAt", query = "SELECT p FROM Pqrs p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Pqrs.findByComplaintType", query = "SELECT p FROM Pqrs p WHERE p.complaintType = :complaintType"),
    @NamedQuery(name = "Pqrs.findByGrievanceType", query = "SELECT p FROM Pqrs p WHERE p.grievanceType = :grievanceType")})
public class Pqrs implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PQRS_ID")
    private Long pqrsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PQRS_TYPE")
    private String pqrsType;
    @Size(max = 10)
    @Column(name = "PQRS_STATE")
    private String pqrsState;
    @Size(max = 10)
    @Column(name = "APPROVED")
    private String approved;
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Lob
    @Column(name = "PQRS_DESCRIPTION")
    private String pqrsDescription;
    @Size(max = 50)
    @Column(name = "COMPLAINT_TYPE")
    private String complaintType;
    @Size(max = 50)
    @Column(name = "GRIEVANCE_TYPE")
    private String grievanceType;
    @OneToMany(mappedBy = "pqrsId")
    private Collection<PqrsMessage> pqrsMessageCollection;
    @JoinColumn(name = "CREATED_BY", referencedColumnName = "USER_ID")
    @ManyToOne
    private SsmuUser createdBy;
    @JoinColumn(name = "ADMIN_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private SsmuUser adminId;
    @JoinColumn(name = "COMPLAIN_TO", referencedColumnName = "USER_ID")
    @ManyToOne
    private SsmuUser complainTo;

    public Pqrs() {
    }

    public Pqrs(Long pqrsId) {
        this.pqrsId = pqrsId;
    }

    public Pqrs(Long pqrsId, String pqrsType) {
        this.pqrsId = pqrsId;
        this.pqrsType = pqrsType;
    }

    public Long getPqrsId() {
        return pqrsId;
    }

    public void setPqrsId(Long pqrsId) {
        this.pqrsId = pqrsId;
    }

    public String getPqrsType() {
        return pqrsType;
    }

    public void setPqrsType(String pqrsType) {
        this.pqrsType = pqrsType;
    }

    public String getPqrsState() {
        return pqrsState;
    }

    public void setPqrsState(String pqrsState) {
        this.pqrsState = pqrsState;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPqrsDescription() {
        return pqrsDescription;
    }

    public void setPqrsDescription(String pqrsDescription) {
        this.pqrsDescription = pqrsDescription;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getGrievanceType() {
        return grievanceType;
    }

    public void setGrievanceType(String grievanceType) {
        this.grievanceType = grievanceType;
    }

    @XmlTransient
    public Collection<PqrsMessage> getPqrsMessageCollection() {
        return pqrsMessageCollection;
    }

    public void setPqrsMessageCollection(Collection<PqrsMessage> pqrsMessageCollection) {
        this.pqrsMessageCollection = pqrsMessageCollection;
    }

    public SsmuUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(SsmuUser createdBy) {
        this.createdBy = createdBy;
    }

    public SsmuUser getAdminId() {
        return adminId;
    }

    public void setAdminId(SsmuUser adminId) {
        this.adminId = adminId;
    }

    public SsmuUser getComplainTo() {
        return complainTo;
    }

    public void setComplainTo(SsmuUser complainTo) {
        this.complainTo = complainTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pqrsId != null ? pqrsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqrs)) {
            return false;
        }
        Pqrs other = (Pqrs) object;
        if ((this.pqrsId == null && other.pqrsId != null) || (this.pqrsId != null && !this.pqrsId.equals(other.pqrsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pqrs[ pqrsId=" + pqrsId + " ]";
    }
    
}
