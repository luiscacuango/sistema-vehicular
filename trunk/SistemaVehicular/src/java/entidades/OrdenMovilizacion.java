/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luigi
 */
@Entity
@Table(name = "orden_movilizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenMovilizacion.findAll", query = "SELECT o FROM OrdenMovilizacion o"),
    @NamedQuery(name = "OrdenMovilizacion.findByIdOrdemovi", query = "SELECT o FROM OrdenMovilizacion o WHERE o.idOrdemovi = :idOrdemovi"),
    @NamedQuery(name = "OrdenMovilizacion.findByFechsoliOrdemovi", query = "SELECT o FROM OrdenMovilizacion o WHERE o.fechsoliOrdemovi = :fechsoliOrdemovi"),
    @NamedQuery(name = "OrdenMovilizacion.findByEstadoSoliOrdemovi", query = "SELECT o FROM OrdenMovilizacion o WHERE o.estadoSoliOrdemovi = :estadoSoliOrdemovi"),
    @NamedQuery(name = "OrdenMovilizacion.findByFeciniOrdemovi", query = "SELECT o FROM OrdenMovilizacion o WHERE o.feciniOrdemovi = :feciniOrdemovi"),
    @NamedQuery(name = "OrdenMovilizacion.findByFecfinOrdemovi", query = "SELECT o FROM OrdenMovilizacion o WHERE o.fecfinOrdemovi = :fecfinOrdemovi"),
    @NamedQuery(name = "OrdenMovilizacion.findByObserOrdemovi", query = "SELECT o FROM OrdenMovilizacion o WHERE o.obserOrdemovi = :obserOrdemovi"),
    @NamedQuery(name = "OrdenMovilizacion.findByEstadoOrdemovi", query = "SELECT o FROM OrdenMovilizacion o WHERE o.estadoOrdemovi = :estadoOrdemovi")})
public class OrdenMovilizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEMOVI")
    private Integer idOrdemovi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHSOLI_ORDEMOVI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechsoliOrdemovi;
    @Size(max = 1)
    @Column(name = "ESTADO_SOLI_ORDEMOVI")
    private String estadoSoliOrdemovi;
    @Column(name = "FECINI_ORDEMOVI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feciniOrdemovi;
    @Column(name = "FECFIN_ORDEMOVI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecfinOrdemovi;
    @Size(max = 100)
    @Column(name = "OBSER_ORDEMOVI")
    private String obserOrdemovi;
    @Size(max = 1)
    @Column(name = "ESTADO_ORDEMOVI")
    private String estadoOrdemovi;
    @OneToMany(mappedBy = "idOrdemovi")
    private List<ControlRuta> controlRutaList;
    @JoinColumn(name = "ID_EMPL", referencedColumnName = "ID_EMPL")
    @ManyToOne
    private Empleado idEmpl;
    @JoinColumn(name = "EMP_ID_EMPL", referencedColumnName = "ID_EMPL")
    @ManyToOne
    private Empleado empIdEmpl;
    @JoinColumn(name = "ID_VEHI", referencedColumnName = "ID_VEHI")
    @ManyToOne
    private Vehiculo idVehi;

    public OrdenMovilizacion() {
    }

    public OrdenMovilizacion(Integer idOrdemovi) {
        this.idOrdemovi = idOrdemovi;
    }

    public OrdenMovilizacion(Integer idOrdemovi, Date fechsoliOrdemovi) {
        this.idOrdemovi = idOrdemovi;
        this.fechsoliOrdemovi = fechsoliOrdemovi;
    }

    public Integer getIdOrdemovi() {
        return idOrdemovi;
    }

    public void setIdOrdemovi(Integer idOrdemovi) {
        this.idOrdemovi = idOrdemovi;
    }

    public Date getFechsoliOrdemovi() {
        return fechsoliOrdemovi;
    }

    public void setFechsoliOrdemovi(Date fechsoliOrdemovi) {
        this.fechsoliOrdemovi = fechsoliOrdemovi;
    }

    public String getEstadoSoliOrdemovi() {
        return estadoSoliOrdemovi;
    }

    public void setEstadoSoliOrdemovi(String estadoSoliOrdemovi) {
        this.estadoSoliOrdemovi = estadoSoliOrdemovi;
    }

    public Date getFeciniOrdemovi() {
        return feciniOrdemovi;
    }

    public void setFeciniOrdemovi(Date feciniOrdemovi) {
        this.feciniOrdemovi = feciniOrdemovi;
    }

    public Date getFecfinOrdemovi() {
        return fecfinOrdemovi;
    }

    public void setFecfinOrdemovi(Date fecfinOrdemovi) {
        this.fecfinOrdemovi = fecfinOrdemovi;
    }

    public String getObserOrdemovi() {
        return obserOrdemovi;
    }

    public void setObserOrdemovi(String obserOrdemovi) {
        this.obserOrdemovi = obserOrdemovi;
    }

    public String getEstadoOrdemovi() {
        return estadoOrdemovi;
    }

    public void setEstadoOrdemovi(String estadoOrdemovi) {
        this.estadoOrdemovi = estadoOrdemovi;
    }

    @XmlTransient
    public List<ControlRuta> getControlRutaList() {
        return controlRutaList;
    }

    public void setControlRutaList(List<ControlRuta> controlRutaList) {
        this.controlRutaList = controlRutaList;
    }

    public Empleado getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(Empleado idEmpl) {
        this.idEmpl = idEmpl;
    }

    public Empleado getEmpIdEmpl() {
        return empIdEmpl;
    }

    public void setEmpIdEmpl(Empleado empIdEmpl) {
        this.empIdEmpl = empIdEmpl;
    }

    public Vehiculo getIdVehi() {
        return idVehi;
    }

    public void setIdVehi(Vehiculo idVehi) {
        this.idVehi = idVehi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemovi != null ? idOrdemovi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenMovilizacion)) {
            return false;
        }
        OrdenMovilizacion other = (OrdenMovilizacion) object;
        if ((this.idOrdemovi == null && other.idOrdemovi != null) || (this.idOrdemovi != null && !this.idOrdemovi.equals(other.idOrdemovi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.OrdenMovilizacion[ idOrdemovi=" + idOrdemovi + " ]";
    }
    
}
