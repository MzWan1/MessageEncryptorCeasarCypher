/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.ejb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MzWandile
 */
@Entity
@Table(catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m")
    , @NamedQuery(name = "Messages.findByMessageId", query = "SELECT m FROM Messages m WHERE m.messageId = :messageId")
    , @NamedQuery(name = "Messages.findByCyphertext", query = "SELECT m FROM Messages m WHERE m.cyphertext = :cyphertext")
    , @NamedQuery(name = "Messages.findByMessageLen", query = "SELECT m FROM Messages m WHERE m.messageLen = :messageLen")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MESSAGE_ID", nullable = false)
    private Integer messageId;
    @Size(max = 500)
    @Column(length = 500)
    private String cyphertext;
    @Column(name = "MESSAGE_LEN")
    private Integer messageLen;
    @JoinColumn(name = "AGENT_ID_FK", referencedColumnName = "AGENT_ID")
    @ManyToOne
    private Users agentIdFk;

    public Messages() {
    }

    public Messages(String cyphertext, Integer messageLen, Users agentIdFk) {
        this.cyphertext = cyphertext;
        this.messageLen = messageLen;
        this.agentIdFk = agentIdFk;
    }
    
    public Messages(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getCyphertext() {
        return cyphertext;
    }

    public void setCyphertext(String cyphertext) {
        this.cyphertext = cyphertext;
    }

    public Integer getMessageLen() {
        return messageLen;
    }

    public void setMessageLen(Integer messageLen) {
        this.messageLen = messageLen;
    }

    public Users getAgentIdFk() {
        return agentIdFk;
    }

    public void setAgentIdFk(Users agentIdFk) {
        this.agentIdFk = agentIdFk;
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
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.ejb.model.Messages[ messageId=" + messageId + " ]";
    }

}