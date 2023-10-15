
package co.udea.ssmu.api.model;

import java.io.Serializable;
import java.util.Collection;
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
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jairl
 */
@Entity
@Table(name = "PQRS_MESSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PqrsMessage.findAll", query = "SELECT p FROM PqrsMessage p"),
    @NamedQuery(name = "PqrsMessage.findByMessageId", query = "SELECT p FROM PqrsMessage p WHERE p.messageId = :messageId")})
public class PqrsMessage implements Serializable {


    protected static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESSAGE_ID")
    private Long messageId;
    @Lob
    @Column(name = "MESSAGE")
    private String message;
    @JoinColumn(name = "PQRS_ID", referencedColumnName = "PQRS_ID")
    @ManyToOne
    private Pqrs pqrsId;
    @OneToMany(mappedBy = "messageId")
    private Collection<ArchiveA> archiveACollection;

    public PqrsMessage() {
    }

    public PqrsMessage(Long messageId) {
        this.messageId = messageId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pqrs getPqrsId() {
        return pqrsId;
    }

    public void setPqrsId(Pqrs pqrsId) {
        this.pqrsId = pqrsId;
    }

    @XmlTransient
    public Collection<ArchiveA> getArchiveACollection() {
        return archiveACollection;
    }

    public void setArchiveACollection(Collection<ArchiveA> archiveACollection) {
        this.archiveACollection = archiveACollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PqrsMessage)) {
            return false;
        }
        PqrsMessage other = (PqrsMessage) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PqrsMessage[ messageId=" + messageId + " ]";
    }
    
}
