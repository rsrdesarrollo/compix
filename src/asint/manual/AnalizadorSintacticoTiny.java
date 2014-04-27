package asint.manual;

import java.io.IOException;
import java.io.Reader;

import manual.errors.GestionErroresTiny;
import alex.manual.AnalizadorLexicoTiny;
import alex.manual.ClaseLexica;
import alex.manual.UnidadLexica;

public class AnalizadorSintacticoTiny {
	private UnidadLexica anticipo;
	private AnalizadorLexicoTiny alex;
	private GestionErroresTiny errores;

	public AnalizadorSintacticoTiny(Reader input) throws IOException {
		errores = new GestionErroresTiny();
		alex = new AnalizadorLexicoTiny(input);
		alex.fijaGestionErrores(errores);
		sigToken();
	}

	private void booleano() {
		switch (anticipo.clase()) {
		case FALSE:
			empareja(ClaseLexica.FALSE);
			break;
		case TRUE:
			empareja(ClaseLexica.TRUE);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.FALSE, ClaseLexica.TRUE);
		}
	}

	private void declaracion() {
		switch (anticipo.clase()) {
		case INT:
		case BOOL:
			tipo();
			empareja(ClaseLexica.IDEN);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.INT, ClaseLexica.BOOL);
		}
	}

	private void declaraciones() {
		switch (anticipo.clase()) {
		case INT:
		case BOOL:
			declaracion();
			declaraciones_s();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.INT, ClaseLexica.BOOL);
		}
	}

	private void declaraciones_s() {
		switch (anticipo.clase()) {
		case DIV_SEC:
			break;
		case PUNTO_COMA:
			empareja(ClaseLexica.PUNTO_COMA);
			declaraciones();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.DIV_SEC, ClaseLexica.PUNTO_COMA);
		}
	}

	private void E() {
		switch (anticipo.clase()) {
		case ENT:
		case IDEN:
		case NOT:
		case PAP:
			E1();
			E_s();
			break;
		case FALSE:
		case TRUE:
			booleano();
			E1();
			E_s();
			break;
		case ADD:
		case SUB:
			OP3();
			E1();
			E_s();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.NOT,
					ClaseLexica.PAP, ClaseLexica.FALSE, ClaseLexica.TRUE,
					ClaseLexica.ADD, ClaseLexica.SUB);
		}
	}

	private void E_s() {
		switch (anticipo.clase()) {
		case EQ:
		case NEQ:
		case LT:
		case LET:
		case GT:
		case GET:
			OP0();
			E1();
			break;
		case PCI:
		case PUNTO_COMA:
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.EQ, ClaseLexica.NEQ, ClaseLexica.LT,
					ClaseLexica.LET, ClaseLexica.GT, ClaseLexica.GET,
					ClaseLexica.PCI, ClaseLexica.PUNTO_COMA, ClaseLexica.EOF);
		}

	}

	private void E1() {
		switch (anticipo.clase()) {
		case ENT:
		case IDEN:
		case PAP:
			E2();
			E1_s();
			break;
		case NOT:
			empareja(ClaseLexica.NOT);
			E1();
			E1_s();
			break;
		case FALSE:
		case TRUE:
			booleano();
			E2();
			E1_s();
			break;
		case ADD:
		case SUB:
			OP3();
			E2();
			E1_s();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.NOT,
					ClaseLexica.PAP, ClaseLexica.FALSE, ClaseLexica.TRUE,
					ClaseLexica.ADD, ClaseLexica.SUB);
		}
	}

	private void E1_s() {
		switch (anticipo.clase()) {
		case EQ:
		case NEQ:
		case LT:
		case LET:
		case GT:
		case GET:
		case PCI:
		case PUNTO_COMA:
		case EOF:
			break;
		case AND:
		case OR:
			OP1();
			E2();
			E1_s();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.EQ, ClaseLexica.NEQ, ClaseLexica.LT,
					ClaseLexica.LET, ClaseLexica.GT, ClaseLexica.GET,
					ClaseLexica.PCI, ClaseLexica.PUNTO_COMA, ClaseLexica.EOF,
					ClaseLexica.AND, ClaseLexica.OR);
		}
	}

	private void E2() {
		switch (anticipo.clase()) {
		case ENT:
		case IDEN:
		case NOT:
		case PAP:
			E3();
			E2_s();
			break;
		case FALSE:
		case TRUE:
			booleano();
			E3();
			E2_s();
			break;
		case ADD:
		case SUB:
			OP3();
			E3();
			E2_s();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.NOT,
					ClaseLexica.PAP, ClaseLexica.FALSE, ClaseLexica.TRUE,
					ClaseLexica.ADD, ClaseLexica.SUB);
		}
	}

	private void E2_s() {
		switch (anticipo.clase()) {
		case EQ:
		case NEQ:
		case LT:
		case LET:
		case GT:
		case GET:
		case PCI:
		case PUNTO_COMA:
		case EOF:
			break;
		case AND:
		case OR:
			break;
		case ADD:
		case SUB:
		case MUL:
		case DIV:
			OP2();
			E3();
			E2_s();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.EQ, ClaseLexica.NEQ, ClaseLexica.LT,
					ClaseLexica.LET, ClaseLexica.GT, ClaseLexica.GET,
					ClaseLexica.PCI, ClaseLexica.PUNTO_COMA, ClaseLexica.EOF,
					ClaseLexica.AND, ClaseLexica.OR);
		}
	}

	private void E3() {
		switch (anticipo.clase()) {
		case ENT:
		case IDEN:
		case NOT:
		case PAP:
			E4();
			break;
		case FALSE:
		case TRUE:
			booleano();
			E4();
			break;
		case ADD:
		case SUB:
			OP3();
			E3();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.NOT,
					ClaseLexica.PAP, ClaseLexica.FALSE, ClaseLexica.TRUE,
					ClaseLexica.ADD, ClaseLexica.SUB);
		}
	}

	private void E4() {
		switch (anticipo.clase()) {
		case ENT:
			empareja(ClaseLexica.ENT);
			break;
		case IDEN:
			empareja(ClaseLexica.IDEN);
			break;
		case PAP:
			empareja(ClaseLexica.PAP);
			E();
			empareja(ClaseLexica.PCI);
			break;
		case FALSE:
		case TRUE:
			booleano();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ENT, ClaseLexica.IDEN, ClaseLexica.PAP,
					ClaseLexica.FALSE, ClaseLexica.TRUE);
		}
	}

	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada)
			sigToken();
		else
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					claseEsperada);
	}

	private void instruccion() {
		switch (anticipo.clase()) {
		case IDEN:
			empareja(ClaseLexica.IDEN);
			empareja(ClaseLexica.ASIGNACION);
			E();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.IDEN);
		}
	}

	private void instrucciones() {
		switch (anticipo.clase()) {
		case IDEN:
			instruccion();
			instrucciones_s();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.IDEN);
		}
	}

	private void instrucciones_s() {
		switch (anticipo.clase()) {
		case PUNTO_COMA:
			empareja(ClaseLexica.PUNTO_COMA);
			instrucciones();
			break;
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PUNTO_COMA, ClaseLexica.EOF);
		}
	}

	private void OP0() {
		switch (anticipo.clase()) {
		case EQ:
			empareja(ClaseLexica.EQ);
			break;
		case NEQ:
			empareja(ClaseLexica.NEQ);
			break;
		case LT:
			empareja(ClaseLexica.LT);
			break;
		case LET:
			empareja(ClaseLexica.LET);
			break;
		case GT:
			empareja(ClaseLexica.GT);
			break;
		case GET:
			empareja(ClaseLexica.GET);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.EQ, ClaseLexica.NEQ, ClaseLexica.LT,
					ClaseLexica.LET, ClaseLexica.GT, ClaseLexica.GET);
		}
	}

	private void OP1() {
		switch (anticipo.clase()) {
		case AND:
			empareja(ClaseLexica.AND);
			break;
		case OR:
			empareja(ClaseLexica.OR);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.AND, ClaseLexica.OR);
		}
	}

	private void OP2() {
		switch (anticipo.clase()) {
		case ADD:
			empareja(ClaseLexica.ADD);
			break;
		case SUB:
			empareja(ClaseLexica.SUB);
			break;
		case MUL:
			empareja(ClaseLexica.MUL);
			break;
		case DIV:
			empareja(ClaseLexica.DIV);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ADD, ClaseLexica.SUB, ClaseLexica.MUL,
					ClaseLexica.DIV);
		}
	}

	private void OP3() {
		switch (anticipo.clase()) {
		case ADD:
			empareja(ClaseLexica.ADD);
			break;
		case SUB:
			empareja(ClaseLexica.SUB);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.ADD, ClaseLexica.SUB);
		}
	}

	private void S() {
		switch (anticipo.clase()) {
		case INT:
		case BOOL:
			declaraciones();
			empareja(ClaseLexica.DIV_SEC);
			instrucciones();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.INT, ClaseLexica.BOOL);
		}
	}

	private void sigToken() {
		try {
			anticipo = alex.sigToken();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}

	public void Sp() {
		S();
		empareja(ClaseLexica.EOF);
	}

	private void tipo() {
		switch (anticipo.clase()) {
		case INT:
			empareja(ClaseLexica.INT);
			break;
		case BOOL:
			empareja(ClaseLexica.BOOL);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.INT, ClaseLexica.BOOL);
		}
	}
}