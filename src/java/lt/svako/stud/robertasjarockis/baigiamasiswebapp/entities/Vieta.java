/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User1
 */
@Entity
@Table(name = "vietos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vieta.findAll", query = "SELECT v FROM Vieta v")
    , @NamedQuery(name = "Vieta.findById", query = "SELECT v FROM Vieta v WHERE v.id = :id")
    , @NamedQuery(name = "Vieta.findByPavadinimas", query = "SELECT v FROM Vieta v WHERE v.pavadinimas = :pavadinimas")
    , @NamedQuery(name = "Vieta.findByTrumpasaprasymas", query = "SELECT v FROM Vieta v WHERE v.trumpasaprasymas = :trumpasaprasymas")
    , @NamedQuery(name = "Vieta.findByVietosaplankalas", query = "SELECT v FROM Vieta v WHERE v.vietosaplankalas = :vietosaplankalas")
    , @NamedQuery(name = "Vieta.findByKoordinates", query = "SELECT v FROM Vieta v WHERE v.koordinates = :koordinates")
    , @NamedQuery(name = "Vieta.findBySukurimoData", query = "SELECT v FROM Vieta v WHERE v.sukurimoData = :sukurimoData")})
public class Vieta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Pavadinimas")
    private String pavadinimas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Trumpas_aprasymas")
    private String trumpasaprasymas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Vietos_aplankalas")
    private String vietosaplankalas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "koordinates")
    private String koordinates;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sukurimo_data")
    @Temporal(TemporalType.DATE)
    private Date sukurimoData;
    @JoinColumn(name = "Vartotojo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vartotojas vartotojoid;
    @JoinColumn(name = "Kategorija_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kategorija kategorijaid;

    public Vieta() {
    }

    public Vieta(Integer id) {
        this.id = id;
    }

    public Vieta(Integer id, String pavadinimas, String trumpasaprasymas, String vietosaplankalas, String koordinates, Date sukurimoData) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.trumpasaprasymas = trumpasaprasymas;
        this.vietosaplankalas = vietosaplankalas;
        this.koordinates = koordinates;
        this.sukurimoData = sukurimoData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getTrumpasaprasymas() {
        return trumpasaprasymas;
    }

    public void setTrumpasaprasymas(String trumpasaprasymas) {
        this.trumpasaprasymas = trumpasaprasymas;
    }

    public String getVietosaplankalas() {
        return vietosaplankalas;
    }

    public void setVietosaplankalas(String vietosaplankalas) {
        this.vietosaplankalas = vietosaplankalas;
    }

    public String getKoordinates() {
        return koordinates;
    }

    public void setKoordinates(String koordinates) {
        this.koordinates = koordinates;
    }

    public Date getSukurimoData() {
        return sukurimoData;
    }

    public void setSukurimoData(Date sukurimoData) {
        this.sukurimoData = sukurimoData;
    }

    public Vartotojas getVartotojoid() {
        return vartotojoid;
    }

    public void setVartotojoid(Vartotojas vartotojoid) {
        this.vartotojoid = vartotojoid;
    }

    public Kategorija getKategorijaid() {
        return kategorijaid;
    }

    public void setKategorijaid(Kategorija kategorijaid) {
        this.kategorijaid = kategorijaid;
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
        if (!(object instanceof Vieta)) {
            return false;
        }
        Vieta other = (Vieta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vieta[ id=" + id + " ]";
    }
    
}
