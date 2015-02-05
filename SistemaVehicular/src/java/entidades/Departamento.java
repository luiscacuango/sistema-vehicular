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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdDpto", query = "SELECT d FROM Departamento d WHERE d.idDpto = :idDpto"),
    @NamedQuery(name = "Departamento.findByNombDpto", query = "SELECT d FROM Departamento d WHERE d.nombDpto = :nombDpto"),
    @NamedQuery(name = "Departamento.findBySiglDpto", query = "SELECT d FROM Departamento d WHERE d.siglDpto = :siglDpto"),
    @NamedQuery(name = "Departamento.findByEstaDpto", query = "SELECT d FROM Departamento d WHERE d.estaDpto = :estaDpto")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DPTO")
    private Integer idDpto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMB_DPTO")
    private String nombDpto;
    @Size(max = 10)
    @Column(name = "SIGL_DPTO")
    private String siglDpto;
    @Size(max = 1)
    @Column(name = "ESTA_DPTO")
    private String estaDpto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDpto")
    private List<Empleado> empleadoList;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public Departamento() {
    }

    public Departamento(Integer idDpto) {
        this.idDpto = idDpto;
    }

    public Departamento(Integer idDpto, String nombDpto) {
        this.idDpto = idDpto;
        this.nombDpto = nombDpto;
    }

    public Integer getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Integer idDpto) {
        this.idDpto = idDpto;
    }

    public String getNombDpto() {
        return nombDpto;
    }

    public void setNombDpto(String nombDpto) {
        this.nombDpto = nombDpto;
    }

    public String getSiglDpto() {
        return siglDpto;
    }

    public void setSiglDpto(String siglDpto) {
        this.siglDpto = siglDpto;
    }

    public String getEstaDpto() {
        return estaDpto;
    }

    public void setEstaDpto(String estaDpto) {
        this.estaDpto = estaDpto;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDpto != null ? idDpto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDpto == null && other.idDpto != null) || (this.idDpto != null && !this.idDpto.equals(other.idDpto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Departamento[ idDpto=" + idDpto + " ]";
    }
    
}
