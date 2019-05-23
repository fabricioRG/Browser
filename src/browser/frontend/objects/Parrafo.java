package browser.frontend.objects;

import java.util.List;

/**
 *
 * @author fabricio
 */
public class Parrafo {
    
    private int alineacion; // 1 = left, 2 = right, 3 = center, 4 = justified
    private Elemento etiquetas;

    public Parrafo(int alineacion, Elemento etiquetas) {
        this.alineacion = alineacion;
        this.etiquetas = etiquetas;
    }

    public int getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(int alineacion) {
        this.alineacion = alineacion;
    }

    public Elemento getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Elemento etiquetas) {
        this.etiquetas = etiquetas;
    }
    
    
    
}
