package browser.frontend.objects;

import java.awt.Color;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class TipoLetra {
    
    private int size;
    private int align;
    private String face;
    private Color color;
    private Elemento etiquetas;

    public TipoLetra(int size, int align, String face, Color color, Elemento etiquetas) {
        this.size = size;
        this.align = align;
        this.face = face;
        this.color = color;
        this.etiquetas = etiquetas;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Elemento getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Elemento etiquetas) {
        this.etiquetas = etiquetas;
    }
    
}
