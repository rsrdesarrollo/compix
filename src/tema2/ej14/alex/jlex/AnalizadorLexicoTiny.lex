package tema2.ej14.alex.jlex;

%%
%line
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
separador = [ \t\r\b\n]
int = int
bool = bool
true = true
false = false
and = and
or = or
not = not
identificador = {letra}({letra}|{digito}|_)*
numero = (0|({digitoPositivo}{digito}*))
add = \+
sub = \-
mul = \*
div = /
gt = >
get = >=
lt = <
let = <=
eq = ==
neq = !=
parentesisApertura = \(
parentesisCierre = \)
asignacion = \=
puntocoma  = \;
divsec = &&
%%
{separador}               {}
{int}					  {return ops.unidadInt();}
{bool}					  {return ops.unidadBool();}
{and}					  {return ops.unidadAnd();}
{or}					  {return ops.unidadOr();}
{not}					  {return ops.unidadNot();}
{true}					  {return ops.unidadTrue();}
{false}					  {return ops.unidadFalse();}
{identificador}           {return ops.unidadId();}
{numero}                  {return ops.unidadEnt();}
{add}            		  {return ops.unidadAdd();}
{sub}           		  {return ops.unidadSub();}
{mul}                     {return ops.unidadMul();}
{div}        			  {return ops.unidadDiv();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCi();} 
{asignacion}              {return ops.unidadAsignacion();} 
{puntocoma}               {return ops.unidadPuntoYComa();}
{gt}					  {return ops.unidadGT();}
{get}					  {return ops.unidadGET();}
{lt}					  {return ops.unidadLT();}
{let}					  {return ops.unidadLET();}
{neq}					  {return ops.unidadNEQ();}
{eq}					  {return ops.unidadEQ();}
{divsec}				  {return ops.unidadDivisionSeccion();}
[^]                       {ops.error();}  