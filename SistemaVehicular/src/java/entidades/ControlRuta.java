/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
 * @author luigi
 */
@Entity
@Table(name = "control_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlRuta.findAll", query = "SELECT c FROM ControlRuta c"),
    @NamedQuery(name = "ControlRuta.findByIdRuta", query = "SELECT c FROM ControlRuta c WHERE c.idRuta = :idRuta"),
    @NamedQuery(name = "ControlRuta.findByDescriRuta", query = "SELECT c FROM ControlRuta c WHERE c.descriRuta = :descriRuta"),
    @NamedQuery(name = "ControlRuta.findByEstadoRuta", query = "SELECT c FROM ControlRuta c WHERE c.estadoRuta = :estadoRuta")})
public class ControlRuta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RUTA")
    private Integer idRuta;
    @Size(max = 100)
    @Column(name = "DESCRI_RUTA")
    private String descriRuta;
    @Size(max = 1)
    @Column(name = "ESTADO_RUTA")
    private String estadoRuta;
    @JoinColumn(name = "COD_CIUDAD", referencedColumnName = "COD_CIUDAD")
    @ManyToOne
    private Ciudad codCiudad;
    @JoinColumn(name = "ID_ORDEMOVI", referencedColumnName = "ID_ORDEMOVI")
    @ManyToOne
    private OrdenMovilizacion idOrdemovi;

    public ControlRuta() {
    }

    public ControlRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public String getDescriRuta() {
        return descriRuta;
    }

    public void setDescriRuta(String descriRuta) {
        this.descriRuta = descriRuta;
    }

    public String getEstadoRuta() {
        return estadoRuta;
    }

    public void setEstadoRuta(String estadoRuta) {
        this.estadoRuta = estadoRuta;
    }

    public Ciudad getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Ciudad codCiudad) {
        this.codCiudad = codCiudad;
    }

    public OrdenMovilizacion getIdOrdemovi() {
        return idOrdemovi;
    }

    public void setIdOrdemovi(OrdenMovilizacion idOrdemovi) {
        this.idOrdemovi = idOrdemovi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRuta != null ? idRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlRuta)) {
            return false;
        }
        ControlRuta other = (ControlRuta) object;
        if ((this.idRuta == null && other.idRuta != null) || (this.idRuta != null && !this.idRuta.equals(other.idRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ControlRuta[ idRuta=" + idRuta + " ]";
    }
    
}
