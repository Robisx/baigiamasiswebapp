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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User1
 */
@Entity
@Table(name = "vartotojai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vartotojas.findAll", query = "SELECT v FROM Vartotojas v")
    , @NamedQuery(name = "Vartotojas.findById", query = "SELECT v FROM Vartotojas v WHERE v.id = :id")
    , @NamedQuery(name = "Vartotojas.findByVartotojopav", query = "SELECT v FROM Vartotojas v WHERE v.vartotojopav = :vartotojopav")
    , @NamedQuery(name = "Vartotojas.findBySlaptazodis", query = "SELECT v FROM Vartotojas v WHERE v.slaptazodis = :slaptazodis")
    , @NamedQuery(name = "Vartotojas.findByVardas", query = "SELECT v FROM Vartotojas v WHERE v.vardas = :vardas")
    , @NamedQuery(name = "Vartotojas.findByPavarde", query = "SELECT v FROM Vartotojas v WHERE v.pavarde = :pavarde")
    , @NamedQuery(name = "Vartotojas.findByElPastas", query = "SELECT v FROM Vartotojas v WHERE v.elPastas = :elPastas")
    , @NamedQuery(name = "Vartotojas.findByAmzius", query = "SELECT v FROM Vartotojas v WHERE v.amzius = :amzius")
    , @NamedQuery(name = "Vartotojas.findByTelefonas", query = "SELECT v FROM Vartotojas v WHERE v.telefonas = :telefonas")})
public class Vartotojas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Vartotojo_pav")
    private String vartotojopav;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Slaptazodis")
    private String slaptazodis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Vardas")
    private String vardas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Pavarde")
    private String pavarde;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "el_pastas")
    private String elPastas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amzius")
    private int amzius;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefonas")
    private int telefonas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vartotojoid")
    private Collection<Vieta> vietaCollection;

    public Vartotojas() {
    }

    public Vartotojas(Integer id) {
        this.id = id;
    }

    public Vartotojas(Integer id, String vartotojopav, String slaptazodis, String vardas, String pavarde, String elPastas, int amzius, int telefonas) {
        this.id = id;
        this.vartotojopav = vartotojopav;
        this.slaptazodis = slaptazodis;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.elPastas = elPastas;
        this.amzius = amzius;
        this.telefonas = telefonas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVartotojopav() {
        return vartotojopav;
    }

    public void setVartotojopav(String vartotojopav) {
        this.vartotojopav = vartotojopav;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public int getAmzius() {
        return amzius;
    }

    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }

    public int getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(int telefonas) {
        this.telefonas = telefonas;
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
        if (!(object instanceof Vartotojas)) {
            return false;
        }
        Vartotojas other = (Vartotojas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.Vartotojas[ id=" + id + " ]";
    }
    
}
