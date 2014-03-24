package alex.manual;

public class UnidadLexicaMultivaluada extends UnidadLexica {
	private String lexema;

	public UnidadLexicaMultivaluada(int fila, int columna, ClaseLexica clase,
			String lexema) {
		super(fila, columna, clase);
		this.lexema = lexema;
	}

	@Override
	public String lexema() {
		return lexema;
	}

	@Override
	public String toString() {
		return "[clase:" + clase() + ",fila:" + fila() + ",col:" + columna()
				+ ",lexema:" + lexema() + "]";
	}
}
