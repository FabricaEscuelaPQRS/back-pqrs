/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udea.ssmu.api.model.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jairl
 */
@Entity
@Table(name = "PQRS")
public class PqrsE implements Serializable {

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

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "ADMIN_ID")
    private Long adminId;

    @Column(name = "COMPLAIN_TO")
    private Long complainTo;

    public PqrsE() {
    }

    public PqrsE(Long pqrsId) {
        this.pqrsId = pqrsId;
    }

    public PqrsE(Long pqrsId, String pqrsType) {
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getComplainTo() {
        return complainTo;
    }

    public void setComplainTo(Long complainTo) {
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
        if (!(object instanceof PqrsE)) {
            return false;
        }
        PqrsE other = (PqrsE) object;
        if ((this.pqrsId == null && other.pqrsId != null) || (this.pqrsId != null && !this.pqrsId.equals(other.pqrsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.udea.ssmu.api.model.entity.PqrsE[ pqrsId=" + pqrsId + " ]";
    }
    
}
