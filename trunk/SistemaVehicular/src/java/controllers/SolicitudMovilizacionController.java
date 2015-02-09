package controllers;

import entidades.OrdenMovilizacion;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import beans.OrdenMovilizacionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "solictudMovilizacionController")
@SessionScoped
public class SolicitudMovilizacionController implements Serializable {

    @EJB
    private beans.OrdenMovilizacionFacade ejbFacade;
    private List<OrdenMovilizacion> items = null;
    private OrdenMovilizacion selected;

    public SolicitudMovilizacionController() {
    }

    public OrdenMovilizacion getSelected() {
        return selected;
    }

    public void setSelected(OrdenMovilizacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OrdenMovilizacionFacade getFacade() {
        return ejbFacade;
    }

    public OrdenMovilizacion prepareCreate() {
        selected = new OrdenMovilizacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Nombres").getString("SolicitudMovilizacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Nombres").getString("SolicitudMovilizacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Nombres").getString("SolicitudMovilizacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OrdenMovilizacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Nombres").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Nombres").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<OrdenMovilizacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OrdenMovilizacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OrdenMovilizacion.class)
    public static class SolicitaMovilizacionViewDialogControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SolicitudMovilizacionController controller = (SolicitudMovilizacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordenMovilizacionController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OrdenMovilizacion) {
                OrdenMovilizacion o = (OrdenMovilizacion) object;
                return getStringKey(o.getIdOrdemovi());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OrdenMovilizacion.class.getName()});
                return null;
            }
        }

    }

}
