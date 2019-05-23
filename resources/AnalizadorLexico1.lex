package browser.backend.analizadores;

import java_cup.runtime.*;
import static browser.backend.analizadores.sym1.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%public
%class Lexer1
%cup
%cupdebug
%line
%column

%{
    StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]
Letra = [a-zA-Z]
Hexa = [a-fA-F]
Entero = [0-9]
Digito = [1-9][0-9]*
Embebido = "<%"[^*] ~ "%>"
A = "A" | "a"
B = "B" | "b"
C = "C" | "c"
D = "D" | "d"
E = "E" | "e"
F = "F" | "f"
G = "G" | "g"
H = "H" | "h"
I = "I" | "i"
J = "J" | "j"
K = "K" | "k"
L = "L" | "l"
M = "M" | "m"
N = "N" | "n"
O = "O" | "o"
P = "P" | "p"
Q = "Q" | "q"
R = "R" | "r"
S = "S" | "s"
T = "T" | "t"
U = "U" | "u"
V = "V" | "v"
W = "W" | "w"
X = "X" | "x"
Y = "Y" | "y"
Z = "Z" | "z"
Slash = "/"
Abertura = "<"
Cierre = ">"
Comillas = "\""
HtmlAbierto = {Abertura}{H}{T}{M}{L}{Cierre}
HtmlCerrado = {Abertura}{Slash}{H}{T}{M}{L}{Cierre}
HeadAbierto = {Abertura}{H}{E}{A}{D}{Cierre}
HeadCerrado = {Abertura}{Slash}{H}{E}{A}{D}{Cierre}
TitleAbierto = {Abertura}{T}{I}{T}{L}{E}{Cierre}
TitleCerrado = {Abertura}{Slash}{T}{I}{T}{L}{E}{Cierre}
BodyAbierto = {Abertura}{B}{O}{D}{Y}
BodyCerrado = {Abertura}{Slash}{B}{O}{D}{Y}{Cierre}
ParrafoAbierto = {Abertura}{P}
ParrafoCerrado = {Abertura}{Slash}{P}{Cierre}
SaltoLinea = {Abertura}{B}{R}{Cierre}
BGColor = {B}{G}{C}{O}{L}{O}{R}
Text = {T}{E}{X}{T}
Link = {L}{I}{N}{K}
CentradoAbierto = {Abertura}{C}{E}{N}{T}{E}{R}{Cierre}
CentradoCerrado = {Abertura}{Slash}{C}{E}{N}{T}{E}{R}{Cierre}
Align = {A}{L}{I}{G}{N}
Left = {Comillas}{L}{E}{F}{T}{Comillas}
Right = {Comillas}{R}{I}{G}{H}{T}{Comillas}
Justified = {Comillas}{J}{U}{S}{T}{I}{F}{I}{E}{D}{Comillas}
TextoPlano = ({Entero}|{Letra}|"."|"-"|"_"|"("|")"|"["|"]"|"{"|"}"|"/"|"*"|"+"|"$"|"\""|";"|","|":"|"?"|"¿"|"!"|"¡"|"#")+
Center = {Comillas}{C}{E}{N}{T}{E}{R}{Comillas}
NegrillaAbierto = {Abertura}{B}{Cierre}
NegrillaCerrado = {Abertura}{Slash}{B}{Cierre}
SubrayadoAbierto = {Abertura}{U}{Cierre}
SubrayadoCerrado = {Abertura}{Slash}{U}{Cierre}
ItalicaAbierto = {Abertura}{I}{Cierre}
ItalicaCerrado = {Abertura}{Slash}{I}{Cierre}
Tamano = {Comillas}{Digito}{Comillas}
TachadoAbierto = {Abertura}{S}{T}{R}{I}{K}{E}{Cierre}
TachadoCerrado = {Abertura}{Slash}{S}{T}{R}{I}{K}{E}{Cierre}
ParpadeanteAbierto = {Abertura}{B}{L}{I}{N}{K}{Cierre}
ParpadeanteCerrado = {Abertura}{Slash}{B}{L}{I}{N}{K}{Cierre}
SubindiceAbierto = {Abertura}{S}{U}{B}{Cierre}
SubindiceCerrado = {Abertura}{Slash}{S}{U}{B}{Cierre}
SuperindiceAbierto = {Abertura}{S}{U}{P}{Cierre}
SuperindiceCerrado = {Abertura}{Slash}{S}{U}{P}{Cierre}
FontAbierto = {Abertura}{F}{O}{N}{T}
FontCerrado = {Abertura}{Slash}{F}{O}{N}{T}{Cierre}
Size = {S}{I}{Z}{E}
Face = {F}{A}{C}{E}
ListDesAbierto = {Abertura}{U}{L}
ListDesCerrado = {Abertura}{Slash}{U}{L}{Cierre}
Item = {Abertura}{L}{I}{Cierre}
ListOrdAbierto = {Abertura}{O}{L}
ListOrdCerrado = {Abertura}{Slash}{O}{L}{Cierre}
Type = {T}{Y}{P}{E}
Start = {S}{T}{A}{R}{T}
NoBrAbierto = {Abertura}{N}{O}{B}{R}{Cierre}
NoBrCerrado = {Abertura}{Slash}{N}{O}{B}{R}{Cierre}
LineHorAbierto = {Abertura}{H}{R}
Width = {W}{I}{D}{T}{H}
SangriaAbierto = {Abertura}{B}{L}{O}{C}{K}{Q}{U}{O}{T}{E}{Cierre}
SangriaCerrado = {Abertura}{Slash}{B}{L}{O}{C}{K}{Q}{U}{O}{T}{E}{Cierre}
EnlaceAbierto = {Abertura}{A}
EnlaceCerrado = {Abertura}{Slash}{A}{Cierre}
Name = {N}{A}{M}{E}
Href = {H}{R}{E}{F}
Enlace = {Comillas}"#"[^*]~{Comillas}
Circle = {Comillas}{C}{I}{R}{C}{L}{E}{Comillas}
Square = {Comillas}{S}{Q}{U}{A}{R}{E}{Comillas}
Disc = {Comillas}{D}{I}{S}{C}{Comillas}
EnteroUno = {Comillas}"1"{Comillas}
Mayuscula = {Comillas}"A"{Comillas}
Minuscula = {Comillas}"a"{Comillas}
AnchoPantalla = {Comillas}{Digito}"%"{Comillas}
LetraNumero = ({Hexa}|{Entero})
Hexadecimal = {Comillas}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{LetraNumero}{Comillas}
Parametro = {Comillas}[^*]~{Comillas} | {Comillas}{Comillas}
Black = {Comillas}{B}{L}{A}{C}{K}{Comillas}
Olive = {Comillas}{O}{L}{I}{V}{E}{Comillas}
Teal = {Comillas}{T}{E}{A}{L}{Comillas}
Red = {Comillas}{R}{E}{D}{Comillas}
Blue = {Comillas}{B}{L}{U}{E}{Comillas}
Maroon = {Comillas}{M}{A}{R}{O}{O}{N}{Comillas}
Navy = {Comillas}{N}{A}{V}{Y}{Comillas}
Gray = {Comillas}{G}{R}{A}{Y}{Comillas}
Lime = {Comillas}{L}{I}{M}{E}{Comillas}
Fuchsia = {Comillas}{F}{U}{C}{H}{S}{I}{A}{Comillas}
Green = {Comillas}{G}{R}{E}{E}{N}{Comillas}
White = {Comillas}{W}{H}{I}{T}{E}{Comillas}
Purple = {Comillas}{P}{U}{R}{P}{L}{E}{Comillas}
Silver = {Comillas}{S}{I}{L}{V}{E}{R}{Comillas}
Yellow = {Comillas}{Y}{E}{L}{L}{O}{W}{Comillas}
Aqua = {Comillas}{A}{Q}{U}{A}{Comillas}
Color = {C}{O}{L}{O}{R}

%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {

	"=" {return symbol(SIGNO_IGUAL, yytext());}
	"&aacute;" {return symbol(A_TILDE, yytext());}
	"&eacute;" {return symbol(E_TILDE, yytext());}
	"&iacute;" {return symbol(I_TILDE, yytext());}
	"&oacute;" {return symbol(O_TILDE, yytext());}
	"&uacute;" {return symbol(U_TILDE, yytext());}
	"&Ntilde;" {return symbol(N_TILDE_MAY, yytext());}
	"&ntilde;" {return symbol(N_TILDE_MIN, yytext());}
	"&lt;" {return symbol(MENOR, yytext());}
	"&gt;" {return symbol(MAYOR, yytext());}
	{Embebido} {return symbol(CODIGO_EMBEBIDO, yytext());}
	{HtmlAbierto} {return symbol(HTML_AB, yytext());}
	{HtmlCerrado} {return symbol(HTML_CE, yytext());}
	{HeadAbierto} {return symbol(HEAD_AB, yytext());}
	{HeadCerrado} {return symbol(HEAD_CE, yytext());}
	{TitleAbierto} {return symbol(TITLE_AB, yytext());}
	{TitleCerrado} {return symbol(TITLE_CE, yytext());}
	{BodyAbierto} {return symbol(BODY_AB, yytext());}
	{BodyCerrado} {return symbol(BODY_CE, yytext());}
	{ParrafoAbierto} {return symbol(PARRAFO_AB, yytext());}
	{ParrafoCerrado} {return symbol(PARRAFO_CE, yytext());}
	{SaltoLinea} {return symbol(SALTO_LINEA, yytext());}
	{BGColor} {return symbol(BG_COLOR, yytext());}
	{Text} {return symbol(TEXT, yytext());}
	{Link} {return symbol(LINK, yytext());}
	{CentradoAbierto} {return symbol(CENTRADO_AB, yytext());}
	{CentradoCerrado} {return symbol(CENTRADO_CE, yytext());}
	{Align} {return symbol(ALIGN, yytext());}
	{Left} {return symbol(LEFT, yytext());}
	{Right} {return symbol(RIGHT, yytext());}
	{Justified} {return symbol(JUSTIFIED, yytext());}
	{Center} {return symbol(CENTER, yytext());}
	{Cierre} {return symbol(CIERRE, yytext());}
	{NegrillaAbierto} {return symbol(NEGRILLA_AB, yytext());}
	{NegrillaCerrado} {return symbol(NEGRILLA_CE, yytext());}
	{SubrayadoAbierto} {return symbol(SUBRAYADO_AB, yytext());}
	{SubrayadoCerrado} {return symbol(SUBRAYADO_CE, yytext());}
	{ItalicaAbierto} {return symbol(ITALICA_AB, yytext());}
	{ItalicaCerrado} {return symbol(ITALICA_CE, yytext());}
	{TachadoAbierto} {return symbol(TACHADO_AB, yytext());}
	{TachadoCerrado} {return symbol(TACHADO_CE, yytext());}
	{ParpadeanteAbierto} {return symbol(PARPADEANTE_AB, yytext());}
	{ParpadeanteCerrado} {return symbol(PARPADEANTE_CE, yytext());}
	{SubindiceAbierto} {return symbol(SUBINDICE_AB, yytext());}
	{SubindiceCerrado} {return symbol(SUBINDICE_CE, yytext());}
	{SuperindiceAbierto} {return symbol(SUPERINDICE_AB, yytext());}
	{SuperindiceCerrado} {return symbol(SUPERINDICE_CE, yytext());}
	{FontAbierto} {return symbol(FONT_AB, yytext());}
	{FontCerrado} {return symbol(FONT_CE, yytext());}
	{Size} {return symbol(SIZE, yytext());}
	{Face} {return symbol(FACE, yytext());}
	{Color} {return symbol(COLOR, yytext());}
	{ListDesAbierto} {return symbol(LIST_DES_AB, yytext());}
	{ListDesCerrado} {return symbol(LIST_DES_CE, yytext());}
	{ListOrdAbierto} {return symbol(LIST_ORD_AB, yytext());}
	{ListOrdCerrado} {return symbol(LIST_ORD_CE, yytext());}
	{Item} {return symbol(ITEM, yytext());}
	{Type} {return symbol(TYPE, yytext());}
	{Start} {return symbol(START, yytext());}
	{NoBrAbierto} {return symbol(NOBR_AB, yytext());}
	{NoBrCerrado} {return symbol(NOBR_CE, yytext());}
	{LineHorAbierto} {return symbol(LINE_HOR_AB, yytext());}
	{Width} {return symbol(WIDTH, yytext());}
	{SangriaAbierto} {return symbol(SANGRIA_AB, yytext());}
	{SangriaCerrado} {return symbol(SANGRIA_CE, yytext());}
	{EnlaceAbierto} {return symbol(ENLACE_AB, yytext());}
	{EnlaceCerrado} {return symbol(ENLACE_CE, yytext());}
	{Name} {return symbol(NAME, yytext());}
	{Href} {return symbol(HREF, yytext());}
	{Enlace} {return symbol(ENLACE, yytext());}
	{Circle} {return symbol(CIRCLE, yytext());}
	{Square} {return symbol(SQUARE, yytext());}
	{Disc} {return symbol(DISC, yytext());}
	{EnteroUno} {return symbol(ENTERO_UNO, yytext());}
	{Black} {return symbol(BLACK, yytext());}
	{Olive} {return symbol(OLIVE, yytext());}
	{Teal} {return symbol(TEAL, yytext());}
	{Red} {return symbol(RED, yytext());}
	{Blue} {return symbol(BLUE, yytext());}
	{Maroon} {return symbol(MAROON, yytext());}
	{Navy} {return symbol(NAVY, yytext());}
	{Gray} {return symbol(GRAY, yytext());}
	{Lime} {return symbol(LIME, yytext());}
	{Fuchsia} {return symbol(FUCHSIA, yytext());}
	{Green} {return symbol(GREEN, yytext());}
	{Purple} {return symbol(PURPLE, yytext());}
	{Silver} {return symbol(SILVER, yytext());}
	{Yellow} {return symbol(YELLOW, yytext());}
	{White} {return symbol(WHITE, yytext());}
	{Aqua} {return symbol(AQUA, yytext());}
	{Hexadecimal} {return symbol(HEXADECIMAL, yytext());}
	{Mayuscula} {return symbol(MAY, yytext());}
	{Minuscula} {return symbol(MIN, yytext());}
	{Tamano} {return symbol(TAMANO, yytext());}
	{AnchoPantalla} {return symbol(ANCHO_PANTALLA, yytext());}
	{Parametro} {return symbol(PARAMETRO, yytext());}
	{TextoPlano} {return symbol(TEXTO_PLANO, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}

}
[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }
