package browser.frontend.objects;

import java.awt.Color;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class Body {
    
    private Color bgColor;
    private Color text;
    private Color link;
    private Elemento etiquetas;

    public Body(Color bgColor, Color text, Color link, Elemento etiquetas) {
        this.bgColor = bgColor;
        this.text = text;
        this.link = link;
        this.etiquetas = etiquetas;
    }

    public Elemento getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Elemento etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Color getText() {
        return text;
    }

    public void setText(Color text) {
        this.text = text;
    }

    public Color getLink() {
        return link;
    }

    public void setLink(Color link) {
        this.link = link;
    }
    
}
