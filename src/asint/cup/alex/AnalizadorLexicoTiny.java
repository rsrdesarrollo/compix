package asint.cup.alex;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import asint.cup.sym;
import asint.cup.errors.GestionErroresTiny;

public class AnalizadorLexicoTiny implements Scanner {

	private static enum Estado {
		INICIO, REC_MUL, REC_DIV, REC_PAP, REC_PCI, REC_PYC, REC_ASIGN, REC_ADD,
		REC_SUB, REC_ID, REC_ENT, REC_0, REC_EOF, DIVSEC_AUX, REC_DIVSEC, REC_EQ,
		NEQ_AUX, REC_NEQ, REC_LT, REC_LET, REC_GT, REC_GET
	}
	public static void main(String arg[]) throws IOException {
		Reader input = new InputStreamReader(new FileInputStream("input.txt"));
		AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
		UnidadLexica unidad;
		do {
			unidad = al.sigToken();
			System.out.println(unidad);
		} while (unidad.clase() != sym.EOF);
	}
	private Reader input;
	private StringBuffer lex;
	private int sigCar;
	private int filaInicio;
	private int columnaInicio;
	private int filaActual;
	
	private GestionErroresTiny gestorErrores;

	private int columnaActual;

	private static String NL = System.getProperty("line.separator");

	private Estado estado;

	public AnalizadorLexicoTiny(Reader input) throws IOException {
		this.input = input;
		lex = new StringBuffer();
		sigCar = input.read();
		filaActual = 1;
		columnaActual = 1;
	}

	private void error() {
		gestorErrores.errorLexico(filaActual, lex.toString());
	}

	public void fijaGestionErrores(GestionErroresTiny errores) {
		this.gestorErrores = errores;
	}

	private boolean hayAmpersand() {
		return sigCar == '&';
	}

	private boolean hayCero() {
		return sigCar == '0';
	}

	private boolean hayDigito() {
		return hayDigitoPos() || hayCero();
	}

	private boolean hayDigitoPos() {
		return sigCar >= '1' && sigCar <= '9';
	}

	private boolean hayDiv() {
		return sigCar == '/';
	}

	private boolean hayEOF() {
		return sigCar == -1;
	}

	private boolean hayExclamacion() {
		return sigCar == '!';
	}

	private boolean hayIgual() {
		return sigCar == '=';
	}

	private boolean hayLetra() {
		return sigCar >= 'a' && sigCar <= 'z' || sigCar >= 'A' && sigCar <= 'z';
	}

	private boolean hayMayor() {
		return sigCar == '>';
	}

	private boolean hayMenor() {
		return sigCar == '<';
	}

	private boolean hayMul() {
		return sigCar == '*';
	}

	private boolean hayNL() {
		return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';
	}

	private boolean hayPAp() {
		return sigCar == '(';
	}

	private boolean hayPCierre() {
		return sigCar == ')';
	}

	private boolean hayPuntoYComa() {
		return sigCar == ';';
	}

	private boolean hayResta() {
		return sigCar == '-';
	}

	private boolean haySep() {
		return hayNL() || sigCar == ' ' || sigCar == '\t';
	}

	private boolean haySuma() {
		return sigCar == '+';
	}

	private void saltaFinDeLinea() throws IOException {
		for (int i = 1; i < NL.length(); i++) {
			sigCar = input.read();
			if (sigCar != NL.charAt(i))
				error();
		}
		sigCar = '\n';
	}

	private void sigCar() throws IOException {
		sigCar = input.read();
		if (sigCar == NL.charAt(0))
			saltaFinDeLinea();
		if (sigCar == '\n') {
			filaActual++;
			columnaActual = 0;
		} else {
			columnaActual++;
		}
	}

	public UnidadLexica sigToken() throws IOException {
		estado = Estado.INICIO;
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		lex.delete(0, lex.length());
		while (true) {
			switch (estado) {
			case INICIO:
				if (hayLetra())
					transita(Estado.REC_ID);
				else if (hayDigitoPos())
					transita(Estado.REC_ENT);
				else if (hayCero())
					transita(Estado.REC_0);
				else if (haySuma())
					transita(Estado.REC_ADD);
				else if (hayResta())
					transita(Estado.REC_SUB);
				else if (hayMul())
					transita(Estado.REC_MUL);
				else if (hayDiv())
					transita(Estado.REC_DIV);
				else if (hayMenor())
					transita(Estado.REC_LT);
				else if (hayMayor())
					transita(Estado.REC_GT);
				else if (hayPAp())
					transita(Estado.REC_PAP);
				else if (hayPCierre())
					transita(Estado.REC_PCI);
				else if (hayIgual())
					transita(Estado.REC_ASIGN);
				else if (hayPuntoYComa())
					transita(Estado.REC_PYC);
				else if (hayAmpersand())
					transita(Estado.DIVSEC_AUX);
				else if (hayExclamacion())
					transita(Estado.NEQ_AUX);
				else if (haySep())
					transitaIgnorando(Estado.INICIO);
				else if (hayEOF())
					transita(Estado.REC_EOF);
				else
					error();
				break;
			case REC_ID:
				if (hayLetra() || hayDigito())
					transita(Estado.REC_ID);
				else
					return unidadId();
				break;
			case REC_ENT:
				if (hayDigito())
					transita(Estado.REC_ENT);
				else
					return unidadEnt();
				break;
			case REC_0:
				return unidadEnt();
			case REC_ADD:
				return unidadAdd();
			case REC_SUB:
				return unidadSub();
			case REC_MUL:
				return unidadMul();
			case REC_DIV:
				return unidadDiv();
			case REC_PAP:
				return unidadPAp();
			case REC_PCI:
				return unidadPCi();
			case REC_ASIGN:
				if (hayIgual())
					transita(Estado.REC_EQ);
				else
					return unidadAsignacion();
			case REC_PYC:
				return unidadPuntoYComa();
			case REC_EOF:
				return unidadEof();
			case DIVSEC_AUX:
				if (hayAmpersand())
					transita(Estado.REC_DIVSEC);
				else
					error();
				break;
			case REC_DIVSEC:
				return unidadDivisionSeccion();
			case REC_EQ:
				return unidadEQ();
			case REC_GET:
				return unidadGET();
			case REC_GT:
				if (hayIgual())
					transita(Estado.REC_GET);
				else
					return unidadGT();
				break;
			case REC_LET:
				return unidadLET();
			case REC_LT:
				if (hayIgual())
					transita(Estado.REC_LET);
				else
					return unidadLT();
				break;
			case NEQ_AUX:
				if (hayIgual())
					transita(Estado.REC_NEQ);
				else
					error();
				break;
			case REC_NEQ:
				return unidadNEQ();

			}
		}
	}

	private void transita(Estado sig) throws IOException {
		lex.append((char) sigCar);
		sigCar();
		estado = sig;
	}

	private void transitaIgnorando(Estado sig) throws IOException {
		sigCar();
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		estado = sig;
	}

	private UnidadLexica unidadAdd() {
		return new UnidadLexica(filaInicio,
				sym.ADD, "+");
	}

	private UnidadLexica unidadAsignacion() {
		return new UnidadLexica(filaInicio,
				sym.ASIGNACION, "=");
	}

	private UnidadLexica unidadDiv() {
		return new UnidadLexica(filaInicio,
				sym.DIV, "/");
	}

	private UnidadLexica unidadDivisionSeccion() {
		return new UnidadLexica(filaInicio,
				sym.DIV_SEC, "&&");
	}

	private UnidadLexica unidadEnt() {
		return new UnidadLexica(filaInicio,
				sym.ENT, lex.toString());
	}

	private UnidadLexica unidadEof() {
		return new UnidadLexica(filaInicio,
				sym.EOF, "<EOF>");
	}

	private UnidadLexica unidadEQ() {
		return new UnidadLexica(filaInicio,
				sym.EQ, "==");
	}

	private UnidadLexica unidadGET() {
		return new UnidadLexica(filaInicio,
				sym.GET, ">=");
	}

	private UnidadLexica unidadGT() {
		return new UnidadLexica(filaInicio,
				sym.GT, ">");
	}

	private UnidadLexica unidadId() {
		switch (lex.toString()) {
		case "true":
			return new UnidadLexica(filaInicio,
					sym.TRUE, "true");
		case "false":
			return new UnidadLexica(filaInicio,
					sym.FALSE, "false");
		case "int":
			return new UnidadLexica(filaInicio,
					sym.INT, "int");
		case "bool":
			return new UnidadLexica(filaInicio,
					sym.BOOL, "bool");
		case "and":
			return new UnidadLexica(filaInicio,
					sym.AND, "and");
		case "or":
			return new UnidadLexica(filaInicio,
					sym.OR, "or");
		case "not":
			return new UnidadLexica(filaInicio,
					sym.NOT, "not");
		default:
			return new UnidadLexica(filaInicio,
					sym.IDEN, lex.toString());
		}
	}

	private UnidadLexica unidadLET() {
		return new UnidadLexica(filaInicio,
				sym.LET, "<=");
	}

	private UnidadLexica unidadLT() {
		return new UnidadLexica(filaInicio,
				sym.LT, "<");
	}

	private UnidadLexica unidadMul() {
		return new UnidadLexica(filaInicio,
				sym.MUL, "*");
	}

	private UnidadLexica unidadNEQ() {
		return new UnidadLexica(filaInicio,
				sym.NEQ, "!=");
	}

	private UnidadLexica unidadPAp() {
		return new UnidadLexica(filaInicio,
				sym.PAP, "(");
	}

	private UnidadLexica unidadPCi() {
		return new UnidadLexica(filaInicio,
				sym.PCI, ")");
	}

	private UnidadLexica unidadPuntoYComa() {
		return new UnidadLexica(filaInicio,
				sym.PUNTO_COMA, ";");
	}

	private UnidadLexica unidadSub() {
		return new UnidadLexica(filaInicio,
				sym.SUB, "-");
	}

	@Override
	public Symbol next_token() throws Exception {
		return sigToken();
	}
}