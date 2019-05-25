 package browser.backend.analizadores;

import java_cup.runtime.*;
import static browser.backend.analizadores.sym2.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%public
%class Lexer2
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
Entero = [0-9]
Digito = [0-9][0-9]*
ComillaSimple = "'"
Variable = {Letra}({Letra}|{Entero}|"_")*
Texto = {ComillaSimple}[^*]~{ComillaSimple}

%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {

	"INTEGER" {return symbol(INTEGER, yytext());}
	"BOOLEAN" {return symbol(BOOLEAN, yytext());}
	"STRING" {return symbol(STRING, yytext());}
	"TRUE" {return symbol(TRUE, yytext());}
	"FALSE" {return symbol(FALSE, yytext());}
	"+" {return symbol(MAS, yytext());}
	"-" {return symbol(MENOS, yytext());}
	"*" {return symbol(MULTIPLICACION, yytext());}
	"/" {return symbol(DIVISION, yytext());}
	">" {return symbol(MAYOR_QUE, yytext());}
	"<" {return symbol(MENOR_QUE, yytext());}
	">=" {return symbol(MAYOR_IGUAL, yytext());}
	"<=" {return symbol(MENOR_IGUAL, yytext());}
	"<>" {return symbol(DIFERENTE_QUE, yytext());}
	"=" {return symbol(IGUAL_QUE, yytext());}
	"AND" {return symbol(AND, yytext());}
	"OR" {return symbol(OR, yytext());}
	"IF" {return symbol(IF, yytext());}
	"THEN" {return symbol(THEN, yytext());}
	"ELSE" {return symbol(ELSE, yytext());}
	"WHILE" {return symbol(WHILE, yytext());}
	"FOR" {return symbol(FOR, yytext());}
	"TO" {return symbol(TO, yytext());}
	"PRINT" {return symbol(PRINT, yytext());}
	"(" {return symbol(PAR_AB, yytext());}
	")" {return symbol(PAR_CE, yytext());}
	"[" {return symbol(COR_AB, yytext());}
	"]" {return symbol(COR_CE, yytext());}
	":=" {return symbol(ASIGNACION, yytext());}
	":" {return symbol(DOS_PUNTOS, yytext());}
	";" {return symbol(PUNTO_COMA, yytext());}
	"," {return symbol(COMA, yytext());}
	"END" {return symbol(END, yytext());}
	"BEGIN" {return symbol(BEGIN, yytext());}
	"VAR" {return symbol(VAR, yytext());}
	{Digito} {return symbol(NUMERO, yytext());}
	{Variable} {return symbol(VARIABLE, yytext());}
	{Texto} {return symbol(TEXTO, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
	{LineTerminator} 	{/*Nothing to do*/}

}
[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }
