package co.udea.ssmu.api.model;


import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jairl
 */
@Entity
@Table(name = "ARCHIVE_A")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchiveA.findAll", query = "SELECT a FROM ArchiveA a"),
    @NamedQuery(name = "ArchiveA.findByArchiveId", query = "SELECT a FROM ArchiveA a WHERE a.archiveId = :archiveId"),
    @NamedQuery(name = "ArchiveA.findByUrlA", query = "SELECT a FROM ArchiveA a WHERE a.urlA = :urlA")})
public class ArchiveA implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARCHIVE_ID")
    private Long archiveId;
    @Size(max = 255)
    @Column(name = "URL_A")
    private String urlA;
    @JoinColumn(name = "MESSAGE_ID", referencedColumnName = "MESSAGE_ID")
    @ManyToOne
    private PqrsMessage messageId;

    public ArchiveA() {
    }

    public ArchiveA(Long archiveId) {
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

    public PqrsMessage getMessageId() {
        return messageId;
    }

    public void setMessageId(PqrsMessage messageId) {
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
        if (!(object instanceof ArchiveA)) {
            return false;
        }
        ArchiveA other = (ArchiveA) object;
        if ((this.archiveId == null && other.archiveId != null) || (this.archiveId != null && !this.archiveId.equals(other.archiveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ArchiveA[ archiveId=" + archiveId + " ]";
    }
    
}
