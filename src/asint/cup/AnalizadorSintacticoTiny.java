
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Mon May 05 21:38:56 CEST 2014
//----------------------------------------------------

package asint.cup;

import java_cup.runtime.*;
import asint.cup.alex.AnalizadorLexicoTiny;
import asint.cup.alex.UnidadLexica;
import asint.cup.errors.GestionErroresTiny;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Mon May 05 21:38:56 CEST 2014
  */
public class AnalizadorSintacticoTiny extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoTiny() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\047\000\002\002\005\000\002\002\004\000\002\003" +
    "\005\000\002\003\003\000\002\004\005\000\002\004\003" +
    "\000\002\005\004\000\002\006\005\000\002\014\003\000" +
    "\002\014\003\000\002\007\003\000\002\007\005\000\002" +
    "\010\005\000\002\010\003\000\002\011\005\000\002\011" +
    "\003\000\002\012\004\000\002\012\003\000\002\013\003" +
    "\000\002\013\003\000\002\013\003\000\002\013\005\000" +
    "\002\015\003\000\002\015\003\000\002\016\003\000\002" +
    "\016\003\000\002\016\003\000\002\016\003\000\002\016" +
    "\003\000\002\016\003\000\002\017\003\000\002\017\003" +
    "\000\002\020\003\000\002\020\003\000\002\020\003\000" +
    "\002\020\003\000\002\021\003\000\002\021\003\000\002" +
    "\021\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\006\030\011\031\010\001\002\000\006\011" +
    "\015\012\014\001\002\000\004\004\013\001\002\000\004" +
    "\002\012\001\002\000\006\011\ufffe\012\ufffe\001\002\000" +
    "\004\004\ufff8\001\002\000\004\004\ufff9\001\002\000\004" +
    "\002\000\001\002\000\006\011\ufffb\012\ufffb\001\002\000" +
    "\004\004\021\001\002\000\006\030\011\031\010\001\002" +
    "\000\006\011\uffff\012\uffff\001\002\000\006\002\001\011" +
    "\067\001\002\000\006\002\ufffc\011\ufffc\001\002\000\004" +
    "\010\022\001\002\000\022\004\026\005\024\006\025\013" +
    "\036\024\030\025\031\032\032\033\027\001\002\000\014" +
    "\004\026\005\024\006\025\032\032\033\027\001\002\000" +
    "\040\002\uffee\007\uffee\011\uffee\014\uffee\015\uffee\016\uffee" +
    "\017\uffee\020\uffee\021\uffee\022\uffee\023\uffee\024\uffee\025" +
    "\uffee\026\uffee\027\uffee\001\002\000\022\004\026\005\024" +
    "\006\025\013\036\024\030\025\031\032\032\033\027\001" +
    "\002\000\040\002\uffef\007\uffef\011\uffef\014\uffef\015\uffef" +
    "\016\uffef\017\uffef\020\uffef\021\uffef\022\uffef\023\uffef\024" +
    "\uffef\025\uffef\026\uffef\027\uffef\001\002\000\040\002\uffea" +
    "\007\uffea\011\uffea\014\uffea\015\uffea\016\uffea\017\uffea\020" +
    "\uffea\021\uffea\022\uffea\023\uffea\024\uffea\025\uffea\026\uffea" +
    "\027\uffea\001\002\000\014\004\uffdd\005\uffdd\006\uffdd\032" +
    "\uffdd\033\uffdd\001\002\000\014\004\uffdc\005\uffdc\006\uffdc" +
    "\032\uffdc\033\uffdc\001\002\000\040\002\uffeb\007\uffeb\011" +
    "\uffeb\014\uffeb\015\uffeb\016\uffeb\017\uffeb\020\uffeb\021\uffeb" +
    "\022\uffeb\023\uffeb\024\uffeb\025\uffeb\026\uffeb\027\uffeb\001" +
    "\002\000\040\002\ufff0\007\ufff0\011\ufff0\014\ufff0\015\ufff0" +
    "\016\ufff0\017\ufff0\020\ufff0\021\ufff0\022\ufff0\023\ufff0\024" +
    "\ufff0\025\ufff0\026\ufff0\027\ufff0\001\002\000\040\002\ufff2" +
    "\007\ufff2\011\ufff2\014\ufff2\015\ufff2\016\ufff2\017\ufff2\020" +
    "\ufff2\021\ufff2\022\ufff2\023\ufff2\024\ufff2\025\ufff2\026\ufff2" +
    "\027\ufff2\001\002\000\040\002\ufff4\007\ufff4\011\ufff4\014" +
    "\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4\021\ufff4\022\ufff4" +
    "\023\ufff4\024\061\025\056\026\060\027\062\001\002\000" +
    "\014\004\uffdb\005\uffdb\006\uffdb\032\uffdb\033\uffdb\001\002" +
    "\000\040\002\uffed\007\uffed\011\uffed\014\uffed\015\uffed\016" +
    "\uffed\017\uffed\020\uffed\021\uffed\022\uffed\023\uffed\024\uffed" +
    "\025\uffed\026\uffed\027\uffed\001\002\000\030\002\ufff7\007" +
    "\ufff7\011\ufff7\014\046\015\045\016\052\017\051\020\047" +
    "\021\050\022\042\023\053\001\002\000\006\002\ufffa\011" +
    "\ufffa\001\002\000\022\004\uffe3\005\uffe3\006\uffe3\013\uffe3" +
    "\024\uffe3\025\uffe3\032\uffe3\033\uffe3\001\002\000\022\004" +
    "\026\005\024\006\025\013\036\024\030\025\031\032\032" +
    "\033\027\001\002\000\022\004\026\005\024\006\025\013" +
    "\036\024\030\025\031\032\032\033\027\001\002\000\022" +
    "\004\uffe8\005\uffe8\006\uffe8\013\uffe8\024\uffe8\025\uffe8\032" +
    "\uffe8\033\uffe8\001\002\000\022\004\uffe9\005\uffe9\006\uffe9" +
    "\013\uffe9\024\uffe9\025\uffe9\032\uffe9\033\uffe9\001\002\000" +
    "\022\004\uffe5\005\uffe5\006\uffe5\013\uffe5\024\uffe5\025\uffe5" +
    "\032\uffe5\033\uffe5\001\002\000\022\004\uffe4\005\uffe4\006" +
    "\uffe4\013\uffe4\024\uffe4\025\uffe4\032\uffe4\033\uffe4\001\002" +
    "\000\022\004\uffe6\005\uffe6\006\uffe6\013\uffe6\024\uffe6\025" +
    "\uffe6\032\uffe6\033\uffe6\001\002\000\022\004\uffe7\005\uffe7" +
    "\006\uffe7\013\uffe7\024\uffe7\025\uffe7\032\uffe7\033\uffe7\001" +
    "\002\000\022\004\uffe2\005\uffe2\006\uffe2\013\uffe2\024\uffe2" +
    "\025\uffe2\032\uffe2\033\uffe2\001\002\000\014\002\ufff6\007" +
    "\ufff6\011\ufff6\022\042\023\053\001\002\000\040\002\ufff5" +
    "\007\ufff5\011\ufff5\014\ufff5\015\ufff5\016\ufff5\017\ufff5\020" +
    "\ufff5\021\ufff5\022\ufff5\023\ufff5\024\061\025\056\026\060" +
    "\027\062\001\002\000\022\004\uffe0\005\uffe0\006\uffe0\013" +
    "\uffe0\024\uffe0\025\uffe0\032\uffe0\033\uffe0\001\002\000\022" +
    "\004\026\005\024\006\025\013\036\024\030\025\031\032" +
    "\032\033\027\001\002\000\022\004\uffdf\005\uffdf\006\uffdf" +
    "\013\uffdf\024\uffdf\025\uffdf\032\uffdf\033\uffdf\001\002\000" +
    "\022\004\uffe1\005\uffe1\006\uffe1\013\uffe1\024\uffe1\025\uffe1" +
    "\032\uffe1\033\uffe1\001\002\000\022\004\uffde\005\uffde\006" +
    "\uffde\013\uffde\024\uffde\025\uffde\032\uffde\033\uffde\001\002" +
    "\000\040\002\ufff3\007\ufff3\011\ufff3\014\ufff3\015\ufff3\016" +
    "\ufff3\017\ufff3\020\ufff3\021\ufff3\022\ufff3\023\ufff3\024\ufff3" +
    "\025\ufff3\026\ufff3\027\ufff3\001\002\000\004\007\065\001" +
    "\002\000\040\002\uffec\007\uffec\011\uffec\014\uffec\015\uffec" +
    "\016\uffec\017\uffec\020\uffec\021\uffec\022\uffec\023\uffec\024" +
    "\uffec\025\uffec\026\uffec\027\uffec\001\002\000\040\002\ufff1" +
    "\007\ufff1\011\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1\020" +
    "\ufff1\021\ufff1\022\ufff1\023\ufff1\024\ufff1\025\ufff1\026\ufff1" +
    "\027\ufff1\001\002\000\004\004\021\001\002\000\006\002" +
    "\ufffd\011\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\012\002\005\003\003\005\006\014\004\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\004\016\006\017" +
    "\001\001\000\006\005\015\014\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\020\007\040\010\037\011\034\012\033\013\032\015" +
    "\036\021\022\001\001\000\006\013\065\015\036\001\001" +
    "\000\002\001\001\000\020\007\063\010\037\011\034\012" +
    "\033\013\032\015\036\021\022\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\020\056\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\016\043\017\042\001\001\000\002\001\001\000\002" +
    "\001\001\000\014\011\054\012\033\013\032\015\036\021" +
    "\022\001\001\000\016\010\053\011\034\012\033\013\032" +
    "\015\036\021\022\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\017\042\001" +
    "\001\000\004\020\056\001\001\000\002\001\001\000\012" +
    "\012\062\013\032\015\036\021\022\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\006\067\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoTiny$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoTiny$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintacticoTiny$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 
   errores = new GestionErroresTiny();
   AnalizadorLexicoTiny alex = (AnalizadorLexicoTiny)getScanner();
   alex.fijaGestionErrores(errores);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }

 
   private GestionErroresTiny errores;
   public void syntax_error(Symbol unidadLexica) {
     errores.errorSintactico((UnidadLexica)unidadLexica);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoTiny$actions {
  private final AnalizadorSintacticoTiny parser;

  /** Constructor */
  CUP$AnalizadorSintacticoTiny$actions(AnalizadorSintacticoTiny parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action_part00000000(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoTiny$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // S ::= declaraciones DIV_SEC instrucciones 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("S",0, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= S EOF 
            {
              Object RESULT =null;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoTiny$stack.elementAt(CUP$AnalizadorSintacticoTiny$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoTiny$parser.done_parsing();
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // declaraciones ::= declaraciones PUNTO_COMA declaracion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("declaraciones",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declaraciones ::= declaracion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("declaraciones",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // instrucciones ::= instrucciones PUNTO_COMA instruccion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("instrucciones",2, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // instrucciones ::= instruccion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("instrucciones",2, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // declaracion ::= tipo IDEN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("declaracion",3, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // instruccion ::= IDEN ASIGNACION E 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("instruccion",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // tipo ::= INT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("tipo",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // tipo ::= BOOL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("tipo",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // E ::= E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E",5, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // E ::= E1 OP0 E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E",5, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // E1 ::= E1 OP1 E2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E1",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // E1 ::= E2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E1",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // E2 ::= E2 OP2 E3 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E2",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // E2 ::= E3 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E2",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // E3 ::= OP3 E4 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E3",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // E3 ::= E4 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E3",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // E4 ::= IDEN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // E4 ::= ENT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // E4 ::= booleano 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // E4 ::= PAP E PCI 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // booleano ::= FALSE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("booleano",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // booleano ::= TRUE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("booleano",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // OP0 ::= EQ 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // OP0 ::= NEQ 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // OP0 ::= LT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // OP0 ::= LET 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // OP0 ::= GT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // OP0 ::= GET 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP0",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // OP1 ::= AND 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP1",13, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // OP1 ::= OR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP1",13, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // OP2 ::= ADD 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP2",14, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // OP2 ::= SUB 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP2",14, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // OP2 ::= MUL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP2",14, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // OP2 ::= DIV 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP2",14, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // OP3 ::= ADD 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP3",15, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // OP3 ::= SUB 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP3",15, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // OP3 ::= NOT 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP3",15, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintacticoTiny$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintacticoTiny$do_action_part00000000(
                               CUP$AnalizadorSintacticoTiny$act_num,
                               CUP$AnalizadorSintacticoTiny$parser,
                               CUP$AnalizadorSintacticoTiny$stack,
                               CUP$AnalizadorSintacticoTiny$top);
    }
}

