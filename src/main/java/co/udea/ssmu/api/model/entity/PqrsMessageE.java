/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.udea.ssmu.api.model.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jairl
 */
@Entity
@Table(name = "PQRS_MESSAGE")
public class PqrsMessageE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pqrs_message_id_seq", sequenceName = "pqrs_message_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pqrs_message_id_seq")
    @Column(name = "message_id")
    private Long messageId;

    @Lob
    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "PQRS_ID")
    private Long pqrsId;

    public PqrsMessageE() {
    }

    public PqrsMessageE(Long messageId) {
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

    public Long getPqrsId() {
        return pqrsId;
    }

    public void setPqrsId(Long pqrsId) {
        this.pqrsId = pqrsId;
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
        if (!(object instanceof PqrsMessageE)) {
            return false;
        }
        PqrsMessageE other = (PqrsMessageE) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.udea.ssmu.api.model.entity.PqrsMessageE[ messageId=" + messageId + " ]";
    }
    
}
