/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User1
 */
@Entity
@Table(name = "vietu_paveiksliukai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VietosPaveiksliukas.findAll", query = "SELECT v FROM VietosPaveiksliukas v")
    , @NamedQuery(name = "VietosPaveiksliukas.findById", query = "SELECT v FROM VietosPaveiksliukas v WHERE v.id = :id")
    , @NamedQuery(name = "VietosPaveiksliukas.findByVietosId", query = "SELECT v FROM VietosPaveiksliukas v WHERE v.vietosId = :vietosId")
    , @NamedQuery(name = "VietosPaveiksliukas.findByUserId", query = "SELECT v FROM VietosPaveiksliukas v WHERE v.userId = :userId")
    , @NamedQuery(name = "VietosPaveiksliukas.findByPaveiksliukoUrl", query = "SELECT v FROM VietosPaveiksliukas v WHERE v.paveiksliukoUrl = :paveiksliukoUrl")
    , @NamedQuery(name = "VietosPaveiksliukas.findByPaveiksliukoSeka", query = "SELECT v FROM VietosPaveiksliukas v WHERE v.paveiksliukoSeka = :paveiksliukoSeka")})
public class VietosPaveiksliukas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vietos_id")
    private int vietosId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "paveiksliuko_url")
    private String paveiksliukoUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paveiksliuko_seka")
    private int paveiksliukoSeka;

    public VietosPaveiksliukas() {
    }

    public VietosPaveiksliukas(Integer id) {
        this.id = id;
    }

    public VietosPaveiksliukas(Integer id, int vietosId, int userId, String paveiksliukoUrl, int paveiksliukoSeka) {
        this.id = id;
        this.vietosId = vietosId;
        this.userId = userId;
        this.paveiksliukoUrl = paveiksliukoUrl;
        this.paveiksliukoSeka = paveiksliukoSeka;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVietosId() {
        return vietosId;
    }

    public void setVietosId(int vietosId) {
        this.vietosId = vietosId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPaveiksliukoUrl() {
        return paveiksliukoUrl;
    }

    public void setPaveiksliukoUrl(String paveiksliukoUrl) {
        this.paveiksliukoUrl = paveiksliukoUrl;
    }

    public int getPaveiksliukoSeka() {
        return paveiksliukoSeka;
    }

    public void setPaveiksliukoSeka(int paveiksliukoSeka) {
        this.paveiksliukoSeka = paveiksliukoSeka;
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
        if (!(object instanceof VietosPaveiksliukas)) {
            return false;
        }
        VietosPaveiksliukas other = (VietosPaveiksliukas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.svako.stud.robertasjarockis.baigiamasiswebapp.entities.VietosPaveiksliukas[ id=" + id + " ]";
    }
    
}
