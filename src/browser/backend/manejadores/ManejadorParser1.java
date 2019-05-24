package browser.backend.manejadores;

import browser.backend.analizadores.Lexer1;
import browser.backend.analizadores.Lexer2;
import browser.backend.analizadores.parser1;
import browser.backend.analizadores.parser2;
import browser.frontend.objects.*;
import java.awt.Color;
import java.io.StringReader;

/**
 *
 * @author fabricio
 */
public class ManejadorParser1 {

    public static int INICIO_SUBSTRING = 1;
    public static int DEFAULT_STYLE = 0;
    public static int FIN_SUBSTRING = 7;
    public static int DEFAULT_ALIGN = 1;
    public static int DEFAULT_WIDTH_PIXEL = 10;
    public static int DEFAULT_SIZE = 15;
    public static String TABULADOR = "\t";
    public static Color DEFAULT_TEXT_COLOR = Color.BLACK;
    public static Color DEFAULT_BG_COLOR = Color.WHITE;
    public static String DEFAULT_FONT = "Noto Sans";
    public static String SALTO_LINEA = "\n";
    public static String ESPACIO = " ";
    private ManejadorAreaTexto mat = null;
    private TipoLetra tipoLetraDefault = null;
    private Atributos atributos = null;
    private Color colorLink = DEFAULT_TEXT_COLOR;

    public ManejadorParser1(ManejadorAreaTexto mat) {
        this.mat = mat;
        atributos = new Atributos(DEFAULT_ALIGN, DEFAULT_STYLE, DEFAULT_BG_COLOR,
                DEFAULT_TEXT_COLOR, DEFAULT_TEXT_COLOR, DEFAULT_SIZE, DEFAULT_FONT);
    }

    public Color getColor(String color) {
        return Color.decode("#" + color.substring(INICIO_SUBSTRING, FIN_SUBSTRING));
    }

    public Color decodeColor(String color) {
        return Color.decode(color);
    }

    public String getFace(String face) {
        return face.substring(1, face.length() - 1);
    }

    public Estilo getEstilo(int style, String texto) {
        return new EstiloBuilder().style(style).texto(texto).build();
    }

    public SaltoLinea getSaltoLinea() {
        return new SaltoLinea();
    }

    public TextoNoLinea getTextoNoLinea(String texto) {
        return new TextoNoLinea(texto);
    }

    public LineaHorizontal getLineaHorizontal() {
        return null;
    }

    public Sangria getSangria(String texto) {
        return new Sangria(texto);
    }

    public Body getBody(int option, Elemento elemento, Body body) {
        if (option == 1) {
            return new Body(DEFAULT_BG_COLOR, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_COLOR, elemento);
        } else if (option == 2) {
            Body bod = new Body(DEFAULT_BG_COLOR, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_COLOR, elemento);
            if (body.getBgColor() != null) {
                bod.setBgColor(body.getBgColor());
            }
            if (body.getText() != null) {
                bod.setText(body.getText());
            }
            if (body.getLink() != null) {
                bod.setLink(body.getLink());
            }
            return bod;
        }
        return null;
    }

    public Body addAtributosBody(Color bgColor, Color text, Color link) {
        Body body = new Body(null, null, null, null);
        if (bgColor != null) {
            body.setBgColor(bgColor);
        }
        if (text != null) {
            body.setText(text);
        }
        if (text != null) {
            body.setLink(link);
        }
        return body;
    }

    public Elemento getElemento(Elemento elemento1, Elemento elemento2) {
        if (elemento1.getSiguienteEtiqueta() == null) {
            elemento1.setSiguienteEtiqueta(elemento2);
            elemento2.setEtiquetaAnterior(elemento1);
        } else {
            Elemento element = elemento1;
            Elemento aux = null;
            while (element != null) {
                aux = element;
                element = element.getSiguienteEtiqueta();
            }
            aux.setSiguienteEtiqueta(elemento2);
            elemento2.setEtiquetaAnterior(aux);
        }
        return elemento1;
    }

    public LineaHorizontal getLineaHorizontal(int option, String numero) {
        if (option == 1) {
            int number = Integer.parseInt(numero.substring(1, numero.length() - 1));
            return new LineaHorizontal(0, 0, number, 0);
        } else if (option == 2) {
            int number = Integer.parseInt(numero.substring(1, numero.length() - 2));
            return new LineaHorizontal(0, number, 0, 0);
        } else if (option == 3) {
            int number = Integer.parseInt(numero.substring(1, numero.length() - 1));
            return new LineaHorizontal(0, 0, 0, number);
        } else if (option == 4) {
            return new LineaHorizontal(DEFAULT_ALIGN, DEFAULT_WIDTH_PIXEL, 0, DEFAULT_SIZE);
        } else {
            return null;
        }
    }

    public LineaHorizontal getLineaHorizontal(LineaHorizontal linea) {
        LineaHorizontal line = new LineaHorizontal(DEFAULT_ALIGN, DEFAULT_WIDTH_PIXEL, 0, DEFAULT_SIZE);
        if (linea.getAlign() != 0) {
            line.setAlign(linea.getAlign());
        }
        if (linea.getWidthPixel() != 0) {
            line.setWidthPixel(linea.getWidthPixel());
        }
        if (linea.getWidthPantalla() != 0) {
            line.setWidthPantalla(linea.getWidthPantalla());
            line.setWidthPixel(0);
        }
        if (linea.getSize() != 0) {
            line.setSize(linea.getSize());
        }
        return line;
    }

    public LineaHorizontal addAtributosLineHor(LineaHorizontal linea1, LineaHorizontal linea2) {
        if (linea2.getAlign() != 0) {
            linea1.setAlign(linea1.getAlign());
        } else if (linea2.getWidthPixel() != 0) {
            linea1.setWidthPixel(linea2.getWidthPixel());
        } else if (linea2.getWidthPantalla() != 0) {
            linea1.setWidthPantalla(linea2.getWidthPantalla());
        } else if (linea2.getSize() != 0) {
            linea1.setSize(linea2.getSize());
        }
        return linea1;
    }

    public TipoLetra addAtributosTipoLetra(TipoLetra letra1, TipoLetra letra2) {
        if (letra2.getSize() != 0) {
            letra1.setSize(letra2.getSize());
        } else if (letra2.getAlign() != 0) {
            letra1.setAlign(letra2.getAlign());
        } else if (letra2.getFace() != null) {
            letra1.setFace(letra2.getFace());
        } else if (letra2.getColor() != null) {
            letra1.setColor(letra2.getColor());
        }
        return letra1;
    }

    public TipoLetra getTipoLetra(TipoLetra tipoLetra, Elemento elemento) {
        TipoLetra letra = new TipoLetra(DEFAULT_SIZE, DEFAULT_ALIGN, DEFAULT_FONT, DEFAULT_TEXT_COLOR, null);
        if (tipoLetra != null) {
            if (tipoLetra.getSize() != 0) {
                letra.setSize(tipoLetra.getSize());
            }
            if (tipoLetra.getAlign() != 0) {
                letra.setAlign(tipoLetra.getAlign());
            }
            if (tipoLetra.getFace() != null) {
                letra.setFace(tipoLetra.getFace());
            }
            if (tipoLetra.getColor() != null) {
                letra.setColor(tipoLetra.getColor());
            }
            letra.setEtiquetas(elemento);
        } else {
            letra.setEtiquetas(elemento);
        }
        return letra;
    }

    public Centrado getCentrado(Elemento elemento) {
        return new Centrado(elemento);
    }

    public Parrafo getParrafo(int number, Elemento elemento) {
        if (number != 0) {
            return new Parrafo(number, elemento);
        } else {
            return new Parrafo(DEFAULT_ALIGN, elemento);
        }
    }

    public Elemento setEstilo(Estilo estilo) {
        return new ElementoBuilder().estilo(estilo).build();
    }

    public Elemento setSaltoLinea(SaltoLinea saltoLinea) {
        return new ElementoBuilder().saltoLinea(saltoLinea).build();
    }

    public Elemento setTextoNoLinea(TextoNoLinea textoNoLinea) {
        return new ElementoBuilder().textoNoLinea(textoNoLinea).build();
    }

    public Elemento setLineaHorizontal(LineaHorizontal lineaHorizontal) {
        return new ElementoBuilder().lineaHorizontal(lineaHorizontal).build();
    }

    public Elemento setTexto(String texto) {
        return new ElementoBuilder().texto(texto).build();
    }

    public Elemento setSangria(Sangria sangria) {
        return new ElementoBuilder().sangria(sangria).build();
    }

    public Elemento setEnlace(Enlace enlace) {
        return new ElementoBuilder().enlace(enlace).build();
    }

    public Elemento setCentrado(Centrado centrado) {
        return new ElementoBuilder().centrado(centrado).build();
    }

    public Elemento setParrafo(Parrafo parrafo) {
        return new ElementoBuilder().parrafo(parrafo).build();
    }

    public Elemento setTipoLetra(TipoLetra tipoLetra) {
        return new ElementoBuilder().tipoLetra(tipoLetra).build();
    }

    public void procesarBody(Body body) {
        Elemento element = body.getEtiquetas();
        mat.getAt().getNavegador().setBackground(body.getBgColor());
        atributos.setBgColor(body.getBgColor());
        mat.getAt().getNavegador().setForeground(body.getText());
        atributos.setTextColor(body.getText());
        colorLink = body.getLink();
        procesarElemento(element, "", atributos);
    }

    public void procesarElemento(Elemento elemento, String text, Atributos at) {
        Elemento element = elemento;
        String texto = text;
        while (element != null) {
            switch (element.getIndice()) {
                case 1:
                    if (!texto.isEmpty()) {
                        texto += "\n";
                    } 
//                    else if (element.getEtiquetaAnterior() != null) {
//                        int ind = element.getEtiquetaAnterior().getIndice();
//                        if (ind == 5 || ind == 1) {
//                            texto += "\n";
//                        }
//                    }
                    mat.mostrarTexto(texto, at);
                    texto = "";
                    try {
                        Atributos at2 = (Atributos) at.clone();
                        at2.setAlineacion(3);
                        procesarElemento(element.getCentrado().getEtiquetas(), "", at2);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    if (element.getSiguienteEtiqueta() != null) {
                        int indice = element.getSiguienteEtiqueta().getIndice();
                        if (indice == 5 || indice == 1) {
                            texto = "";
                        }
                    }
                    finProceso(element);
                    break;
                case 2:
                    break;
                case 3:
                    mat.mostrarTexto(texto, at);
                    at.setEstilo(element.getEstilo().getStyle());
                    mat.mostrarTexto(element.getEstilo().getTexto(), at);
                    at.setEstilo(DEFAULT_STYLE);
                    texto = "";
                    break;
                case 4:
                    break;
                case 5:
                    if (!texto.isEmpty()) {
                        texto += "\n";
                    } 
                    mat.mostrarTexto(texto, at);
                    try {
                        Atributos at2 = (Atributos) at.clone();
                        at2.setAlineacion(element.getParrafo().getAlineacion());
                        procesarElemento(element.getParrafo().getEtiquetas(), "", at2);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    texto = SALTO_LINEA;
                    if (element.getSiguienteEtiqueta() != null) {
                        int indice = element.getSiguienteEtiqueta().getIndice();
                        if (indice == 5 || indice == 1) {
                            texto = "";
                        }
                    }
                    finProceso(element);
                    break;
                case 6:
                    texto += SALTO_LINEA;
                    break;
                case 7:
                    if (!texto.isEmpty()) {
                        texto += "\n";
                    }
                    mat.mostrarTexto(texto, at);
                    at.setAlineacion(DEFAULT_ALIGN);
                    mat.mostrarTexto(element.getSangria().getTexto() + SALTO_LINEA, at);
                    texto = "";
                    break;
                case 8:
                    texto += element.getTextoNoLinea().getTexto() + ESPACIO;
                    break;
                case 9:
                    mat.mostrarTexto(texto, at);
                    texto = "";
                    try {
                        Atributos at2 = (Atributos) at.clone();
                        at2.setAlineacion(element.getTipoLetra().getAlign());
                        at2.setSize(element.getTipoLetra().getSize());
                        at2.setTextColor(element.getTipoLetra().getColor());
                        at2.setFont(element.getTipoLetra().getFace());
                        procesarElemento(element.getTipoLetra().getEtiquetas(), "", at2);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    finProceso(element);
                    break;
                case 10:
                    System.out.println(element.getTexto());
                    texto += element.getTexto() + ESPACIO;
                    break;
            }
            element = element.getSiguienteEtiqueta();
        }
        mat.mostrarTexto(texto + SALTO_LINEA, at);
    }

    public void finProceso(Elemento element) {
        switch (element.getIndice()) {
            case 1:
                System.out.println("<<Fin centrado");
                if (element.getEtiquetaAnterior() != null) {
                    System.out.println("Indice anterior: " + element.getEtiquetaAnterior().getIndice());
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.out.println("<<Fin Parrafo");
                if (element.getEtiquetaAnterior() != null) {
                    System.out.println("Indice anterior: " + element.getEtiquetaAnterior().getIndice());
                }
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                System.out.println("<<Fin Tipo Letra");
                if (element.getEtiquetaAnterior() != null) {
                    System.out.println("Indice anterior: " + element.getEtiquetaAnterior().getIndice());
                }
                break;
            case 10:
                break;
        }
    }

    public void runEmbebido(String texto) {
        String entrada = texto.substring(2, texto.length() - 2);
        System.out.println(entrada);
        if (!entrada.trim().isEmpty()) {
            StringReader sr = new StringReader(entrada);
            Lexer2 lexer = new Lexer2(sr);
            parser2 pars = new parser2(lexer, new ManejadorParser2());
            try {
                pars.parse();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
