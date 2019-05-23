package browser.frontend.objects;

/**
 *
 * @author fabricio
 */
public class Enlace {
    
    private String enlace;
    private String referencia;
    private Enlace reference;

    public Enlace(String enlace) {
        this.enlace = enlace;
    }

    public Enlace(String referencia, Enlace reference) {
        this.referencia = referencia;
        this.reference = reference;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Enlace getReference() {
        return reference;
    }

    public void setReference(Enlace reference) {
        this.reference = reference;
    }
    
}
