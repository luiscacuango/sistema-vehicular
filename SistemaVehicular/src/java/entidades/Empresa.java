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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByNombEmpr", query = "SELECT e FROM Empresa e WHERE e.nombEmpr = :nombEmpr"),
    @NamedQuery(name = "Empresa.findBySiglEmpr", query = "SELECT e FROM Empresa e WHERE e.siglEmpr = :siglEmpr"),
    @NamedQuery(name = "Empresa.findByDireEmpr", query = "SELECT e FROM Empresa e WHERE e.direEmpr = :direEmpr"),
    @NamedQuery(name = "Empresa.findByTelfEmpr", query = "SELECT e FROM Empresa e WHERE e.telfEmpr = :telfEmpr"),
    @NamedQuery(name = "Empresa.findByEstEmpr", query = "SELECT e FROM Empresa e WHERE e.estEmpr = :estEmpr")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMB_EMPR")
    private String nombEmpr;
    @Size(max = 10)
    @Column(name = "SIGL_EMPR")
    private String siglEmpr;
    @Size(max = 200)
    @Column(name = "DIRE_EMPR")
    private String direEmpr;
    @Size(max = 10)
    @Column(name = "TELF_EMPR")
    private String telfEmpr;
    @Size(max = 1)
    @Column(name = "EST_EMPR")
    private String estEmpr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Departamento> departamentoList;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String nombEmpr) {
        this.idEmpresa = idEmpresa;
        this.nombEmpr = nombEmpr;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombEmpr() {
        return nombEmpr;
    }

    public void setNombEmpr(String nombEmpr) {
        this.nombEmpr = nombEmpr;
    }

    public String getSiglEmpr() {
        return siglEmpr;
    }

    public void setSiglEmpr(String siglEmpr) {
        this.siglEmpr = siglEmpr;
    }

    public String getDireEmpr() {
        return direEmpr;
    }

    public void setDireEmpr(String direEmpr) {
        this.direEmpr = direEmpr;
    }

    public String getTelfEmpr() {
        return telfEmpr;
    }

    public void setTelfEmpr(String telfEmpr) {
        this.telfEmpr = telfEmpr;
    }

    public String getEstEmpr() {
        return estEmpr;
    }

    public void setEstEmpr(String estEmpr) {
        this.estEmpr = estEmpr;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
