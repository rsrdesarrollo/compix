package alex.jlex;

public class ALexOperations {

	private AnalizadorLexicoTiny context;

	public ALexOperations(AnalizadorLexicoTiny context) {
		this.context = context;
	}

	public UnidadLexica unidadEnt() {
		return new UnidadLexicaMultivaluada(context.fila(), ClaseLexica.ENT,
				context.lexema().toString());
	}

	public UnidadLexica unidadAdd() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.ADD);
	}

	public UnidadLexica unidadSub() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.SUB);
	}

	public UnidadLexica unidadMul() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.MUL);
	}

	public UnidadLexica unidadDiv() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.DIV);
	}

	public UnidadLexica unidadPAp() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.PAP);
	}

	public UnidadLexica unidadPCi() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.PCI);
	}

	public UnidadLexica unidadAsignacion() {
		return new UnidadLexicaUnivaluada(context.fila(),
				ClaseLexica.ASIGNACION);
	}

	public UnidadLexica unidadPuntoYComa() {
		return new UnidadLexicaUnivaluada(context.fila(),
				ClaseLexica.PUNTO_COMA);
	}

	public UnidadLexica unidadDivisionSeccion() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.DIV_SEC);
	}

	public UnidadLexica unidadEQ() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.EQ);
	}

	public UnidadLexica unidadNEQ() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.NEQ);
	}

	public UnidadLexica unidadGT() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.GT);
	}

	public UnidadLexica unidadGET() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.GET);
	}

	public UnidadLexica unidadLT() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.LT);
	}

	public UnidadLexica unidadLET() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.LET);
	}

	public UnidadLexica unidadEof() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.EOF);
	}

	public UnidadLexica unidadId() {
		return new UnidadLexicaMultivaluada(context.fila(), ClaseLexica.IDEN,
				context.lexema().toString());
	}

	public UnidadLexica unidadOr() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.OR);
	}

	public UnidadLexica unidadAnd() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.AND);
	}

	public UnidadLexica unidadFalse() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.FALSE);
	}

	public UnidadLexica unidadInt() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.INT);
	}

	public UnidadLexica unidadNot() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.NOT);
	}

	public UnidadLexica unidadTrue() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.TRUE);
	}

	public UnidadLexica unidadBool() {
		return new UnidadLexicaUnivaluada(context.fila(), ClaseLexica.BOOL);
	}
	
	
	public void error() {
		System.err.println("***" + context.fila() + " Caracter inesperado: "
				+ context.lexema());
		
		System.exit(-1);
	}
}
