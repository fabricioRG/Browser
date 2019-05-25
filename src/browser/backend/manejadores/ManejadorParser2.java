package browser.backend.manejadores;

import browser.backend.analizadores.Lexer1;
import browser.backend.analizadores.Lexer2;
import browser.backend.analizadores.parser1;
import browser.backend.analizadores.parser3;
import browser.backend.objects.Elemento;
import browser.backend.objects.*;
import java.io.StringReader;
import java.util.Hashtable;

/**
 *
 * @author fabricio
 */
public class ManejadorParser2 {

    private Hashtable<String, Variable> variables = null;
    private Variable var = null;
    private String salida = "";
    private browser.frontend.objects.Elemento elemen = null;
    public static String INICIO_HTML = "<html><body>";
    public static String FIN_HTML = "</body></html>";

    public ManejadorParser2() {
        variables = new Hashtable<>();
    }

    public Elemento getElemento(Elemento elemento1, Elemento elemento2) {
        if (elemento1.getSiguienteElemento() == null) {
            elemento1.setSiguienteElemento(elemento2);
            elemento2.setElementoAnterior(elemento1);
        } else {
            Elemento element = elemento1;
            Elemento aux = null;
            while (element != null) {
                aux = element;
                element = element.getSiguienteElemento();
            }
            aux.setSiguienteElemento(elemento2);
            elemento2.setElementoAnterior(aux);
        }
        return elemento1;
    }

    public Elemento setVariables(String variable, int tipo) {
        Variable var = null;
        switch (tipo) {
            case 1:
                var = new Variable("", variable);
                break;
            case 2:
                var = new Variable(0, variable);
                break;
            case 3:
                var = new Variable(true, variable);
                break;
        }
        setVariable(variable, var);
        return new Elemento(var);
    }

    public Elemento setOperacion(String operacion) {
        return new Elemento(new Operacion(1, operacion));
    }

    public Operacion setCondicion(String operacion) {
        return new Operacion(2, operacion);
    }

    public Bloque setBloque(Elemento elemento) {
        return new Bloque(elemento);
    }

    public Elemento setCondicional(Operacion operacion, Bloque bloque1, Bloque bloque2) {
        return new Elemento(new Condicional(operacion, bloque1, bloque2));
    }

    public Elemento setCicloFor(String var, String num1, String num2, Bloque bloque) {
        Variable var1 = variables.get(var);
        return new Elemento(new CicloFor(var1, Integer.parseInt(num1), Integer.parseInt(num2), bloque));
    }

    public Elemento setCicloWhile(Operacion operacion, Bloque bloque) {
        return new Elemento(new CicloWhile(operacion, bloque));
    }

    public Token setToken(String texto, String variable) {
        if (texto != null) {
            return new Token(texto.substring(1, texto.length() - 1));
        } else {
            return new Token(variables.get(variable));
        }
    }

    public Token addToken(Token token1, Token token2) {
        if (token1.getSiguienteToken() == null) {
            token1.setSiguienteToken(token2);
            token2.setTokenAnterior(token1);
        } else {
            Token token = token1;
            Token aux = null;
            while (token != null) {
                aux = token;
                token = token.getSiguienteToken();
            }
            aux.setSiguienteToken(token2);
            token2.setTokenAnterior(aux);
        }
        return token1;
    }

    public Elemento setPrint(Token tokens) {
        return new Elemento(new Print(tokens));
    }

    public Elemento setOperacionRelacional(String operacion) {
        return new Elemento(new Operacion(2, operacion));
    }

    public Elemento setOperacionLogica(String operacion) {
        return new Elemento(new Operacion(3, operacion));
    }

    public Elemento setOperacionConcatenacion(String operacion) {
        return new Elemento(new Operacion(4, operacion));
    }

    public Elemento setAsignacion(String var, Operacion operacion) {
        Variable variable = variables.get(var);
        return new Elemento(new Asignacion(variable, operacion));
    }

    public Variable getVariable(String var) {
        return variables.get(var);
    }

    public Variable setVariable(String key, Variable var) {
        return variables.put(key, var);
    }

    public Hashtable<String, Variable> getVariables() {
        return variables;
    }

    public void setVariables(Hashtable<String, Variable> variables) {
        this.variables = variables;
    }

    public browser.frontend.objects.Elemento getElemen() {
        return elemen;
    }

    public void setElemen(browser.frontend.objects.Elemento elemen) {
        this.elemen = elemen;
    }

    public void procesar(Elemento element) {
        procesarElemento(element);
        if (!salida.trim().isEmpty()) {
            salida = INICIO_HTML + salida + FIN_HTML;
            ManejadorParser1 mp1 = new ManejadorParser1(null);
            StringReader sr = new StringReader(salida);
            Lexer1 lexer = new Lexer1(sr);
            parser1 pars = new parser1(lexer, mp1);
            try {
                salida = "";
                pars.parse();
                elemen = mp1.getBody1().getEtiquetas();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateVariable(String key, Variable variable) {
        variable.setKey(key);
        this.variables.replace(key, variable);
    }

    public void procesarOperacion(String operacion) {
        StringReader sr = new StringReader(operacion);
        Lexer2 lexer = new Lexer2(sr);
        parser3 pars = new parser3(lexer, this);
        try {
            pars.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void procesarElemento(Elemento elemento) {
        Elemento element = elemento;
        while (element != null) {
            switch (element.getIndice()) {
                case 1: //Condicional
                    procesarOperacion(element.getCondicional().getCondicion().getOperacion());
                    if (var.isBool()) {
                        procesarElemento(element.getCondicional().getBloque1().getCabezaElementos());
                    } else {
                        procesarElemento(element.getCondicional().getBloque2().getCabezaElementos());
                    }
                    break;
                case 2: //Asignacion
                    procesarOperacion(element.getAsignacion().getOperacion().getOperacion());
                    updateVariable(element.getAsignacion().getVariable().getKey(), var);
                    break;
                case 3: //Print
                    getTokens(element.getPrint().getListaToken());
                    break;
                case 4: //For
                    CicloFor cf = element.getCicloFor();
                    Variable va = cf.getVariable();
                    va.setInteger(cf.getInicio() - 1);
                    for (int i = cf.getInicio(); i <= cf.getFin(); i++) {
                        va.setInteger(va.getInteger() + 1);
                        procesarElemento(cf.getBloque().getCabezaElementos());
                    }
                    break;
                case 5://While
                    while (true) {
                        procesarOperacion(element.getCicloWhile().getCondicion().getOperacion());
                        procesarElemento(element.getCicloWhile().getBloquer().getCabezaElementos());
                        if (!var.isBool()) {
                            break;
                        }
                    }
                    break;
                case 6://Variable
                    break;
                case 7://Operacion
                    break;
            }
            element = element.getSiguienteElemento();
        }
    }

    public void getTokens(Token cabeza) {
        Token tok = cabeza;
        while (tok != null) {
            if (tok.getTexto() != null) {
                salida += tok.getTexto();
            } else if (tok.getVariable() != null) {
                Variable var = variables.get(tok.getVariable().getKey());
                if (var.getIndice() == 1) {
                    salida += var.getString();
                } else if (var.getIndice() == 2) {
                    salida += var.getInteger();
                } else if (var.getIndice() == 3) {
                    salida += var.isBool();
                } else {
                    salida += var.getTexto();
                }
            }
            tok = tok.getSiguienteToken();
        }
    }

    ////////////////////////////////////////////////////////////////////////
    public Variable setNumero(String num) {
        return new Variable(Integer.parseInt(num));
    }

    public Variable setVariable(String text, int option) {
        return new Variable(text, option);
    }

    public Variable setBoolean(int option) {
        if (option == 1) {
            return new Variable(true);
        } else if (option == 2) {
            return new Variable(false);
        }
        return null;
    }

    public Variable getOperacionAritmetica(Variable v1, Variable v2, int option) {
        if (option == 1) {
            if (v1.getIndice() == 2 && v2.getIndice() == 2) {
                v1.setInteger(v1.getInteger() + v2.getInteger());
            } else {
                String text1 = "";
                String text2 = "";
                if (v1.getIndice() == 1) {
                    text1 += v1.getString();
                } else if (v1.getIndice() == 2) {
                    text1 += v1.getInteger();
                } else if (v1.getIndice() == 3) {
                    text1 += v1.isBool();
                } else {
                    text1 += v1.getTexto();
                }
                if (v2.getIndice() == 1) {
                    text2 += v2.getString();
                } else if (v2.getIndice() == 2) {
                    text1 += v2.getInteger();
                } else if (v2.getIndice() == 3) {
                    text1 += v2.isBool();
                } else {
                    text1 += v2.getTexto();
                }
                v1.setString(text1 + text2);
            }
        } else if (option == 2) {
            v1.setInteger(v1.getInteger() - v2.getInteger());
        } else if (option == 3) {
            v1.setInteger(v1.getInteger() * v2.getInteger());
        } else if (option == 4) {
            v1.setInteger(v1.getInteger() / v2.getInteger());
        }
        return v1;
    }

    public Variable getOperacionRelacional(Variable v1, Variable v2, int option) {
        switch (option) {
            case 1:
                v1.setBool(v1.getInteger() < v2.getInteger());
                break;
            case 2:
                v1.setBool(v1.getInteger() > v2.getInteger());
                break;
            case 3:
                v1.setBool(v1.getInteger() >= v2.getInteger());
                break;
            case 4:
                v1.setBool(v1.getInteger() <= v2.getInteger());
                break;
            case 5:
                v1.setBool(v1.getInteger() == v2.getInteger());
                break;
            case 6:
                v1.setBool(v1.getInteger() != v2.getInteger());
                break;
        }
        return v1;
    }

    public Variable getOperacionLogica(Variable v1, Variable v2, int option) {
        if (option == 1) {
            v1.setBool(v1.isBool() || v2.isBool());
        } else {
            v1.setBool(v1.isBool() && v2.isBool());
        }
        return v1;
    }

    public void setVariableValue(Variable var) {
        this.var = var;
    }

}
