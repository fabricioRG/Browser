package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Bloque {

    private Elemento cabezaElementos;

    public Bloque(Elemento cabezaElementos) {
        this.cabezaElementos = cabezaElementos;
    }

    public Elemento getCabezaElementos() {
        return cabezaElementos;
    }

    public void setCabezaElementos(Elemento cabezaElementos) {
        this.cabezaElementos = cabezaElementos;
    }
    
}
