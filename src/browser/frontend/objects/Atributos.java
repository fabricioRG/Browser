package browser.frontend.objects;

import java.awt.Color;

/**
 *
 * @author fabricio
 */
public class Atributos implements Cloneable{

    private int alineacion;
    private int estilo;
    private Color bgColor;
    private Color colorLink;
    private Color textColor;
    private int size;
    private String font;

    public Atributos(int alineacion, int estilo, Color bgColor, Color colorLink, Color textColor, int size, String font) {
        this.alineacion = alineacion;
        this.estilo = estilo;
        this.bgColor = bgColor;
        this.colorLink = colorLink;
        this.textColor = textColor;
        this.size = size;
        this.font = font;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public int getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(int alineacion) {
        this.alineacion = alineacion;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Color getColorLink() {
        return colorLink;
    }

    public void setColorLink(Color colorLink) {
        this.colorLink = colorLink;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
    
    
}
