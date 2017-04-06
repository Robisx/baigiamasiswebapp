/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User1
 */
@Entity
@Table(name = "kategorija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorija.findAll", query = "SELECT k FROM Kategorija k")
    , @NamedQuery(name = "Kategorija.findById", query = "SELECT k FROM Kategorija k WHERE k.id = :id")
    , @NamedQuery(name = "Kategorija.findByZymeklioSpalva", query = "SELECT k FROM Kategorija k WHERE k.zymeklioSpalva = :zymeklioSpalva")
    , @NamedQuery(name = "Kategorija.findByObjektoTipas", query = "SELECT k FROM Kategorija k WHERE k.objektoTipas = :objektoTipas")})
public class Kategorija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "zymeklio_spalva")
    private String zymeklioSpalva;
    @Basic(optional = false)
    @Column(name = "objekto_tipas")
    private String objektoTipas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorijaid")
    private Collection<Vieta> vietaCollection;

    public Kategorija() {
    }

    public Kategorija(Integer id) {
        this.id = id;
    }

    public Kategorija(Integer id, String zymeklioSpalva, String objektoTipas) {
        this.id = id;
        this.zymeklioSpalva = zymeklioSpalva;
        this.objektoTipas = objektoTipas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZymeklioSpalva() {
        return zymeklioSpalva;
    }

    public void setZymeklioSpalva(String zymeklioSpalva) {
        this.zymeklioSpalva = zymeklioSpalva;
    }

    public String getObjektoTipas() {
        return objektoTipas;
    }

    public void setObjektoTipas(String objektoTipas) {
        this.objektoTipas = objektoTipas;
    }

    @XmlTransient
    public Collection<Vieta> getVietaCollection() {
        return vietaCollection;
    }

    public void setVietaCollection(Collection<Vieta> vietaCollection) {
        this.vietaCollection = vietaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategorija)) {
            return false;
        }
        Kategorija other = (Kategorija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Kategorija[ id=" + id + " ]";
    }
    
}
