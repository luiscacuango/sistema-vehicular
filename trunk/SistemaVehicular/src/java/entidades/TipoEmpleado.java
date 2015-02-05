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
@Table(name = "tipo_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmpleado.findAll", query = "SELECT t FROM TipoEmpleado t"),
    @NamedQuery(name = "TipoEmpleado.findByIdTipoempl", query = "SELECT t FROM TipoEmpleado t WHERE t.idTipoempl = :idTipoempl"),
    @NamedQuery(name = "TipoEmpleado.findByDescriTipoempl", query = "SELECT t FROM TipoEmpleado t WHERE t.descriTipoempl = :descriTipoempl")})
public class TipoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOEMPL")
    private Integer idTipoempl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRI_TIPOEMPL")
    private String descriTipoempl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoempl")
    private List<Empleado> empleadoList;

    public TipoEmpleado() {
    }

    public TipoEmpleado(Integer idTipoempl) {
        this.idTipoempl = idTipoempl;
    }

    public TipoEmpleado(Integer idTipoempl, String descriTipoempl) {
        this.idTipoempl = idTipoempl;
        this.descriTipoempl = descriTipoempl;
    }

    public Integer getIdTipoempl() {
        return idTipoempl;
    }

    public void setIdTipoempl(Integer idTipoempl) {
        this.idTipoempl = idTipoempl;
    }

    public String getDescriTipoempl() {
        return descriTipoempl;
    }

    public void setDescriTipoempl(String descriTipoempl) {
        this.descriTipoempl = descriTipoempl;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoempl != null ? idTipoempl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpleado)) {
            return false;
        }
        TipoEmpleado other = (TipoEmpleado) object;
        if ((this.idTipoempl == null && other.idTipoempl != null) || (this.idTipoempl != null && !this.idTipoempl.equals(other.idTipoempl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoEmpleado[ idTipoempl=" + idTipoempl + " ]";
    }
    
}
