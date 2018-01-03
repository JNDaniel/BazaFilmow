/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Gatunek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gatunek.findAll", query = "SELECT g FROM Gatunek g")
    , @NamedQuery(name = "Gatunek.findByGatunekId", query = "SELECT g FROM Gatunek g WHERE g.gatunekId = :gatunekId")
    , @NamedQuery(name = "Gatunek.findByNazwa", query = "SELECT g FROM Gatunek g WHERE g.nazwa = :nazwa")})
public class Gatunek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gatunek_id")
    private Integer gatunekId;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;

    public Gatunek() {
    }

    public Gatunek(Integer gatunekId) {
        this.gatunekId = gatunekId;
    }

    public Gatunek(Integer gatunekId, String nazwa) {
        this.gatunekId = gatunekId;
        this.nazwa = nazwa;
    }

    public Integer getGatunekId() {
        return gatunekId;
    }

    public void setGatunekId(Integer gatunekId) {
        this.gatunekId = gatunekId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatunekId != null ? gatunekId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gatunek)) {
            return false;
        }
        Gatunek other = (Gatunek) object;
        if ((this.gatunekId == null && other.gatunekId != null) || (this.gatunekId != null && !this.gatunekId.equals(other.gatunekId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gatunek{" + "gatunekId=" + gatunekId + ", nazwa=" + nazwa + '}';
    }

    
    
}
