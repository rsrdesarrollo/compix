/* AnalizadorSintacticoTiny.java */
/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny.java */
package asint.javacc;

public class AnalizadorSintacticoTiny implements AnalizadorSintacticoTinyConstants {

  final public void Sp() throws ParseException {
    S();
    jj_consume_token(0);
  }

  final public void S() throws ParseException {
    declaraciones();
    jj_consume_token(divsec);
    instrucciones();
  }

  final public void declaraciones() throws ParseException {
    declaracion();
    declaraciones_r();
  }

  final public void declaraciones_r() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 19:{
      jj_consume_token(19);
      declaracion();
      declaraciones_r();
      break;
      }
    default:
      jj_la1[0] = jj_gen;

    }
  }

  final public void instrucciones() throws ParseException {
    instruccion();
    instrucciones_r();
  }

  final public void instrucciones_r() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 19:{
      jj_consume_token(19);
      instruccion();
      instrucciones_r();
      break;
      }
    default:
      jj_la1[1] = jj_gen;

    }
  }

  final public void declaracion() throws ParseException {
    tipo();
    jj_consume_token(identificador);
  }

  final public void instruccion() throws ParseException {
    jj_consume_token(identificador);
    jj_consume_token(20);
    E();
  }

  final public void tipo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case int_t:{
      jj_consume_token(int_t);
      break;
      }
    case bool:{
      jj_consume_token(bool);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E() throws ParseException {
    E1();
    E_r();
  }

  final public void E_r() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case get:
    case let:
    case eq:
    case neq:
    case 23:
    case 24:{
      OP0();
      E1();
      break;
      }
    default:
      jj_la1[3] = jj_gen;

    }
  }

  final public void E1() throws ParseException {
    E2();
    E1_r();
  }

  final public void E1_r() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case and:
    case or:{
      OP1();
      E2();
      E1_r();
      break;
      }
    default:
      jj_la1[4] = jj_gen;

    }
  }

  final public void E2() throws ParseException {
    E3();
    E2_r();
  }

  final public void E2_r() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 25:
    case 26:
    case 27:
    case 28:{
      OP2();
      E3();
      E2_r();
      break;
      }
    default:
      jj_la1[5] = jj_gen;

    }
  }

  final public void E3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case not:
    case 25:
    case 26:{
      OP3();
      E4();
      break;
      }
    case true_t:
    case false_t:
    case identificador:
    case numero:
    case 21:{
      E4();
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case identificador:{
      jj_consume_token(identificador);
      break;
      }
    case numero:{
      jj_consume_token(numero);
      break;
      }
    case true_t:
    case false_t:{
      booleano();
      break;
      }
    case 21:{
      jj_consume_token(21);
      E();
      jj_consume_token(22);
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void booleano() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case true_t:{
      jj_consume_token(true_t);
      break;
      }
    case false_t:{
      jj_consume_token(false_t);
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case eq:{
      jj_consume_token(eq);
      break;
      }
    case neq:{
      jj_consume_token(neq);
      break;
      }
    case 23:{
      jj_consume_token(23);
      break;
      }
    case let:{
      jj_consume_token(let);
      break;
      }
    case 24:{
      jj_consume_token(24);
      break;
      }
    case get:{
      jj_consume_token(get);
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case and:{
      jj_consume_token(and);
      break;
      }
    case or:{
      jj_consume_token(or);
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 25:{
      jj_consume_token(25);
      break;
      }
    case 26:{
      jj_consume_token(26);
      break;
      }
    case 27:{
      jj_consume_token(27);
      break;
      }
    case 28:{
      jj_consume_token(28);
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 25:{
      jj_consume_token(25);
      break;
      }
    case 26:{
      jj_consume_token(26);
      break;
      }
    case not:{
      jj_consume_token(not);
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public AnalizadorSintacticoTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80000,0x80000,0x60,0x183c000,0x600,0x1e000000,0x6203980,0x203180,0x180,0x183c000,0x600,0x1e000000,0x6000800,};
   }

  /** Constructor with InputStream. */
  public AnalizadorSintacticoTiny(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AnalizadorSintacticoTiny(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AnalizadorSintacticoTiny(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AnalizadorSintacticoTiny(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[29];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 29; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

                                       }
