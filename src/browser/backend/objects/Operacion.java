package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Operacion {
    
    private int indice;// 1 = aritmetica, 2 = relacional, 3 = logica, 4 = concatenacion;
    private String operacion;

    public Operacion(int indice, String operacion) {
        this.indice = indice;
        this.operacion = operacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
