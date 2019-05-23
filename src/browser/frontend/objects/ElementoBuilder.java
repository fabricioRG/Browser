package browser.frontend.objects;

/**
 *
 * @author fabricio
 */
public class ElementoBuilder {
    
    private int indice; //Indice hacia el tipo de elemento a guardar
    private Centrado centrado;
    private Enlace enlace;
    private Estilo estilo;
    private LineaHorizontal lineaHorizontal;
    private Parrafo parrafo;
    private SaltoLinea saltoLinea;
    private Sangria sangria;
    private TextoNoLinea textoNoLinea;
    private TipoLetra tipoLetra;
    private String texto;
    private Elemento siguienteEtiqueta;
    private Elemento etiquetaAnterior;

    public ElementoBuilder() {
    }
    
    public ElementoBuilder centrado(Centrado centrado) {
        this.indice = 1;
        this.centrado = centrado;
        return this;
    }
    
    public ElementoBuilder enlace(Enlace enlace) {
        this.indice = 2;
        this.enlace = enlace;
        return this;
    }
    
    public ElementoBuilder estilo(Estilo estilo) {
        this.indice = 3;
        this.estilo = estilo;
        return this;
    }
    
    public ElementoBuilder lineaHorizontal(LineaHorizontal lineaHorizontal) {
        this.indice = 4;
        this.lineaHorizontal = lineaHorizontal;
        return this;
    }
    
    public ElementoBuilder parrafo(Parrafo parrafo) {
        this.indice = 5;
        this.parrafo = parrafo;
        return this;
    }
    
    public ElementoBuilder saltoLinea(SaltoLinea saltoLinea) {
        this.indice = 6;
        this.saltoLinea = saltoLinea;
        return this;
    }
    
    public ElementoBuilder sangria(Sangria sangria) {
        this.indice = 7;
        this.sangria = sangria;
        return this;
    }
    
    public ElementoBuilder textoNoLinea(TextoNoLinea textoNoLinea) {
        this.indice = 8;
        this.textoNoLinea = textoNoLinea;
        return this;
    }
    
    public ElementoBuilder tipoLetra(TipoLetra tipoLetra) {
        this.indice = 9;
        this.tipoLetra = tipoLetra;
        return this;
    }

    public ElementoBuilder texto(String texto) {
        this.indice = 10;
        this.texto = texto;
        return this;
    }
    
    public ElementoBuilder siguienteEtiqueta(Elemento siguienteEtiqueta) {
        this.siguienteEtiqueta = siguienteEtiqueta;
        return this;
    }
    
    public ElementoBuilder etiquetaAnterior(Elemento etiquetaAnterior) {
        this.etiquetaAnterior = etiquetaAnterior;
        return this;
    }
    
    public Elemento build(){
        return new Elemento(this);
    }

    public Elemento getEtiquetaAnterior() {
        return etiquetaAnterior;
    }
    
    public int getIndice() {
        return indice;
    }

    public Elemento getSiguienteEtiqueta() {
        return siguienteEtiqueta;
    }

    public Centrado getCentrado() {
        return centrado;
    }

    public Enlace getEnlace() {
        return enlace;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public String getTexto() {
        return texto;
    }

    public LineaHorizontal getLineaHorizontal() {
        return lineaHorizontal;
    }

    public Parrafo getParrafo() {
        return parrafo;
    }

    public SaltoLinea getSaltoLinea() {
        return saltoLinea;
    }

    public Sangria getSangria() {
        return sangria;
    }

    public TextoNoLinea getTextoNoLinea() {
        return textoNoLinea;
    }

    public TipoLetra getTipoLetra() {
        return tipoLetra;
    }
    
}
