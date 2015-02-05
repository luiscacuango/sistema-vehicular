/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luigi
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpl", query = "SELECT e FROM Empleado e WHERE e.idEmpl = :idEmpl"),
    @NamedQuery(name = "Empleado.findByCeduEmpl", query = "SELECT e FROM Empleado e WHERE e.ceduEmpl = :ceduEmpl"),
    @NamedQuery(name = "Empleado.findByNombEmpl", query = "SELECT e FROM Empleado e WHERE e.nombEmpl = :nombEmpl"),
    @NamedQuery(name = "Empleado.findByApelEmpl", query = "SELECT e FROM Empleado e WHERE e.apelEmpl = :apelEmpl"),
    @NamedQuery(name = "Empleado.findByTeleEmpl", query = "SELECT e FROM Empleado e WHERE e.teleEmpl = :teleEmpl"),
    @NamedQuery(name = "Empleado.findByDireEmpl", query = "SELECT e FROM Empleado e WHERE e.direEmpl = :direEmpl"),
    @NamedQuery(name = "Empleado.findByGeneEmpl", query = "SELECT e FROM Empleado e WHERE e.geneEmpl = :geneEmpl")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMPL")
    private Integer idEmpl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CEDU_EMPL")
    private String ceduEmpl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMB_EMPL")
    private String nombEmpl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APEL_EMPL")
    private String apelEmpl;
    @Size(max = 10)
    @Column(name = "TELE_EMPL")
    private String teleEmpl;
    @Size(max = 200)
    @Column(name = "DIRE_EMPL")
    private String direEmpl;
    @Size(max = 1)
    @Column(name = "GENE_EMPL")
    private String geneEmpl;
    @JoinColumn(name = "ID_DPTO", referencedColumnName = "ID_DPTO")
    @ManyToOne(optional = false)
    private Departamento idDpto;
    @JoinColumn(name = "ID_TIPOEMPL", referencedColumnName = "ID_TIPOEMPL")
    @ManyToOne(optional = false)
    private TipoEmpleado idTipoempl;
    @OneToMany(mappedBy = "idEmpl")
    private List<OrdenMovilizacion> ordenMovilizacionList;
    @OneToMany(mappedBy = "empIdEmpl")
    private List<OrdenMovilizacion> ordenMovilizacionList1;

    public Empleado() {
    }

    public Empleado(Integer idEmpl) {
        this.idEmpl = idEmpl;
    }

    public Empleado(Integer idEmpl, String ceduEmpl, String nombEmpl, String apelEmpl) {
        this.idEmpl = idEmpl;
        this.ceduEmpl = ceduEmpl;
        this.nombEmpl = nombEmpl;
        this.apelEmpl = apelEmpl;
    }

    public Integer getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(Integer idEmpl) {
        this.idEmpl = idEmpl;
    }

    public String getCeduEmpl() {
        return ceduEmpl;
    }

    public void setCeduEmpl(String ceduEmpl) {
        this.ceduEmpl = ceduEmpl;
    }

    public String getNombEmpl() {
        return nombEmpl;
    }

    public void setNombEmpl(String nombEmpl) {
        this.nombEmpl = nombEmpl;
    }

    public String getApelEmpl() {
        return apelEmpl;
    }

    public void setApelEmpl(String apelEmpl) {
        this.apelEmpl = apelEmpl;
    }

    public String getTeleEmpl() {
        return teleEmpl;
    }

    public void setTeleEmpl(String teleEmpl) {
        this.teleEmpl = teleEmpl;
    }

    public String getDireEmpl() {
        return direEmpl;
    }

    public void setDireEmpl(String direEmpl) {
        this.direEmpl = direEmpl;
    }

    public String getGeneEmpl() {
        return geneEmpl;
    }

    public void setGeneEmpl(String geneEmpl) {
        this.geneEmpl = geneEmpl;
    }

    public Departamento getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Departamento idDpto) {
        this.idDpto = idDpto;
    }

    public TipoEmpleado getIdTipoempl() {
        return idTipoempl;
    }

    public void setIdTipoempl(TipoEmpleado idTipoempl) {
        this.idTipoempl = idTipoempl;
    }

    @XmlTransient
    public List<OrdenMovilizacion> getOrdenMovilizacionList() {
        return ordenMovilizacionList;
    }

    public void setOrdenMovilizacionList(List<OrdenMovilizacion> ordenMovilizacionList) {
        this.ordenMovilizacionList = ordenMovilizacionList;
    }

    @XmlTransient
    public List<OrdenMovilizacion> getOrdenMovilizacionList1() {
        return ordenMovilizacionList1;
    }

    public void setOrdenMovilizacionList1(List<OrdenMovilizacion> ordenMovilizacionList1) {
        this.ordenMovilizacionList1 = ordenMovilizacionList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpl != null ? idEmpl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpl == null && other.idEmpl != null) || (this.idEmpl != null && !this.idEmpl.equals(other.idEmpl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empleado[ idEmpl=" + idEmpl + " ]";
    }
    
}
