/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udea.ssmu.api.model.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jairl
 */
@Entity
@Table(name = "ARCHIVE_A")
public class ArchiveE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARCHIVE_ID")
    private Long archiveId;
    @Size(max = 255)
    @Column(name = "URL_A")
    private String urlA;

    @Column(name = "MESSAGE_ID")
    private Long messageId;

    public ArchiveE() {
    }

    public ArchiveE(Long archiveId) {
        this.archiveId = archiveId;
    }

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public String getUrlA() {
        return urlA;
    }

    public void setUrlA(String urlA) {
        this.urlA = urlA;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archiveId != null ? archiveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchiveE)) {
            return false;
        }
        ArchiveE other = (ArchiveE) object;
        if ((this.archiveId == null && other.archiveId != null) || (this.archiveId != null && !this.archiveId.equals(other.archiveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.udea.ssmu.api.model.entity.ArchiveE[ archiveId=" + archiveId + " ]";
    }
    
}
