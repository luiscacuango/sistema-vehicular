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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdVehi", query = "SELECT v FROM Vehiculo v WHERE v.idVehi = :idVehi"),
    @NamedQuery(name = "Vehiculo.findByMotorVehi", query = "SELECT v FROM Vehiculo v WHERE v.motorVehi = :motorVehi"),
    @NamedQuery(name = "Vehiculo.findByMarcaVehi", query = "SELECT v FROM Vehiculo v WHERE v.marcaVehi = :marcaVehi"),
    @NamedQuery(name = "Vehiculo.findByMatriVehi", query = "SELECT v FROM Vehiculo v WHERE v.matriVehi = :matriVehi"),
    @NamedQuery(name = "Vehiculo.findByChasisVehi", query = "SELECT v FROM Vehiculo v WHERE v.chasisVehi = :chasisVehi"),
    @NamedQuery(name = "Vehiculo.findByPlacaVehi", query = "SELECT v FROM Vehiculo v WHERE v.placaVehi = :placaVehi"),
    @NamedQuery(name = "Vehiculo.findByColorVehi", query = "SELECT v FROM Vehiculo v WHERE v.colorVehi = :colorVehi")})
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VEHI")
    private Integer idVehi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MOTOR_VEHI")
    private String motorVehi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MARCA_VEHI")
    private String marcaVehi;
    @Size(max = 30)
    @Column(name = "MATRI_VEHI")
    private String matriVehi;
    @Size(max = 50)
    @Column(name = "CHASIS_VEHI")
    private String chasisVehi;
    @Size(max = 10)
    @Column(name = "PLACA_VEHI")
    private String placaVehi;
    @Size(max = 30)
    @Column(name = "COLOR_VEHI")
    private String colorVehi;
    @OneToMany(mappedBy = "idVehi")
    private List<OrdenMovilizacion> ordenMovilizacionList;
    @JoinColumn(name = "ID_TIPOVEHI", referencedColumnName = "ID_TIPOVEHI")
    @ManyToOne(optional = false)
    private TipoVehiculo idTipovehi;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehi) {
        this.idVehi = idVehi;
    }

    public Vehiculo(Integer idVehi, String motorVehi, String marcaVehi) {
        this.idVehi = idVehi;
        this.motorVehi = motorVehi;
        this.marcaVehi = marcaVehi;
    }

    public Integer getIdVehi() {
        return idVehi;
    }

    public void setIdVehi(Integer idVehi) {
        this.idVehi = idVehi;
    }

    public String getMotorVehi() {
        return motorVehi;
    }

    public void setMotorVehi(String motorVehi) {
        this.motorVehi = motorVehi;
    }

    public String getMarcaVehi() {
        return marcaVehi;
    }

    public void setMarcaVehi(String marcaVehi) {
        this.marcaVehi = marcaVehi;
    }

    public String getMatriVehi() {
        return matriVehi;
    }

    public void setMatriVehi(String matriVehi) {
        this.matriVehi = matriVehi;
    }

    public String getChasisVehi() {
        return chasisVehi;
    }

    public void setChasisVehi(String chasisVehi) {
        this.chasisVehi = chasisVehi;
    }

    public String getPlacaVehi() {
        return placaVehi;
    }

    public void setPlacaVehi(String placaVehi) {
        this.placaVehi = placaVehi;
    }

    public String getColorVehi() {
        return colorVehi;
    }

    public void setColorVehi(String colorVehi) {
        this.colorVehi = colorVehi;
    }

    @XmlTransient
    public List<OrdenMovilizacion> getOrdenMovilizacionList() {
        return ordenMovilizacionList;
    }

    public void setOrdenMovilizacionList(List<OrdenMovilizacion> ordenMovilizacionList) {
        this.ordenMovilizacionList = ordenMovilizacionList;
    }

    public TipoVehiculo getIdTipovehi() {
        return idTipovehi;
    }

    public void setIdTipovehi(TipoVehiculo idTipovehi) {
        this.idTipovehi = idTipovehi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehi != null ? idVehi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehi == null && other.idVehi != null) || (this.idVehi != null && !this.idVehi.equals(other.idVehi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vehiculo[ idVehi=" + idVehi + " ]";
    }
    
}
