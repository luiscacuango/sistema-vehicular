/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
 * @author luigi
 */
@Entity
@Table(name = "tipo_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVehiculo.findAll", query = "SELECT t FROM TipoVehiculo t"),
    @NamedQuery(name = "TipoVehiculo.findByIdTipovehi", query = "SELECT t FROM TipoVehiculo t WHERE t.idTipovehi = :idTipovehi"),
    @NamedQuery(name = "TipoVehiculo.findByDescriTipovehi", query = "SELECT t FROM TipoVehiculo t WHERE t.descriTipovehi = :descriTipovehi")})
public class TipoVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOVEHI")
    private Integer idTipovehi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRI_TIPOVEHI")
    private String descriTipovehi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipovehi")
    private List<Vehiculo> vehiculoList;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Integer idTipovehi) {
        this.idTipovehi = idTipovehi;
    }

    public TipoVehiculo(Integer idTipovehi, String descriTipovehi) {
        this.idTipovehi = idTipovehi;
        this.descriTipovehi = descriTipovehi;
    }

    public Integer getIdTipovehi() {
        return idTipovehi;
    }

    public void setIdTipovehi(Integer idTipovehi) {
        this.idTipovehi = idTipovehi;
    }

    public String getDescriTipovehi() {
        return descriTipovehi;
    }

    public void setDescriTipovehi(String descriTipovehi) {
        this.descriTipovehi = descriTipovehi;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipovehi != null ? idTipovehi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVehiculo)) {
            return false;
        }
        TipoVehiculo other = (TipoVehiculo) object;
        if ((this.idTipovehi == null && other.idTipovehi != null) || (this.idTipovehi != null && !this.idTipovehi.equals(other.idTipovehi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoVehiculo[ idTipovehi=" + idTipovehi + " ]";
    }
    
}
