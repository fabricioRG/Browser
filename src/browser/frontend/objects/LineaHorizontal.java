package browser.frontend.objects;

/**
 *
 * @author fabricio
 */
public class LineaHorizontal {

    private int align; //1 = right, 2 = left, 3 = center
    private int widthPixel;
    private int widthPantalla;
    private int size;

    public LineaHorizontal(int align, int widthPixel, int widthPantalla, int size) {
        this.align = align;
        this.widthPixel = widthPixel;
        this.widthPantalla = widthPantalla;
        this.size = size;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public int getWidthPixel() {
        return widthPixel;
    }

    public void setWidthPixel(int widthPixel) {
        this.widthPixel = widthPixel;
    }

    public int getWidthPantalla() {
        return widthPantalla;
    }

    public void setWidthPantalla(int widthPantalla) {
        this.widthPantalla = widthPantalla;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
