package browser.frontend.objects;

/**
 *
 * @author fabricio
 */
public class Elemento {
    
    private int indice; //Indice hacia el tipo de elemento a guardar
    private Centrado centrado; // 1
    private Enlace enlace; // 2
    private Estilo estilo; // 3
    private LineaHorizontal lineaHorizontal; // 4
    private Parrafo parrafo; // 5
    private SaltoLinea saltoLinea; // 6
    private Sangria sangria; // 7
    private TextoNoLinea textoNoLinea; // 8
    private TipoLetra tipoLetra; // 9
    private String texto; // 10
    private Elemento siguienteEtiqueta;
    private Elemento etiquetaAnterior;
    
    Elemento(ElementoBuilder builder){
        this.indice = builder.getIndice();
        this.centrado = builder.getCentrado();
        this.enlace = builder.getEnlace();
        this.estilo = builder.getEstilo();
        this.lineaHorizontal = builder.getLineaHorizontal();
        this.parrafo = builder.getParrafo();
        this.saltoLinea = builder.getSaltoLinea();
        this.sangria = builder.getSangria();
        this.textoNoLinea = builder.getTextoNoLinea();
        this.tipoLetra = builder.getTipoLetra();
        this.texto = builder.getTexto();
        this.siguienteEtiqueta = builder.getSiguienteEtiqueta();
        this.etiquetaAnterior = builder.getEtiquetaAnterior();
    }

    public int getIndice() {
        return indice;
    }

    public Elemento getSiguienteEtiqueta() {
        return siguienteEtiqueta;
    }

    public Elemento getEtiquetaAnterior() {
        return etiquetaAnterior;
    }

    public void setEtiquetaAnterior(Elemento etiquetaAnterior) {
        this.etiquetaAnterior = etiquetaAnterior;
    }

    public void setSiguienteEtiqueta(Elemento siguienteEtiqueta) {
        this.siguienteEtiqueta = siguienteEtiqueta;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Centrado getCentrado() {
        return centrado;
    }

    public void setCentrado(Centrado centrado) {
        this.centrado = centrado;
    }

    public Enlace getEnlace() {
        return enlace;
    }

    public void setEnlace(Enlace enlace) {
        this.enlace = enlace;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public LineaHorizontal getLineaHorizontal() {
        return lineaHorizontal;
    }

    public void setLineaHorizontal(LineaHorizontal lineaHorizontal) {
        this.lineaHorizontal = lineaHorizontal;
    }

    public Parrafo getParrafo() {
        return parrafo;
    }

    public void setParrafo(Parrafo parrafo) {
        this.parrafo = parrafo;
    }

    public SaltoLinea getSaltoLinea() {
        return saltoLinea;
    }

    public void setSaltoLinea(SaltoLinea saltoLinea) {
        this.saltoLinea = saltoLinea;
    }

    public Sangria getSangria() {
        return sangria;
    }

    public void setSangria(Sangria sangria) {
        this.sangria = sangria;
    }

    public TextoNoLinea getTextoNoLinea() {
        return textoNoLinea;
    }

    public void setTextoNoLinea(TextoNoLinea textoNoLinea) {
        this.textoNoLinea = textoNoLinea;
    }

    public TipoLetra getTipoLetra() {
        return tipoLetra;
    }

    public void setTipoLetra(TipoLetra tipoLetra) {
        this.tipoLetra = tipoLetra;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
