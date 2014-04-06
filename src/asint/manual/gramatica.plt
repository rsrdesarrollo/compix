grammar grammar_ej14 {
    analysis LALR1;
    nonterminal Sp, S, declaraciones, instrucciones, declaracion, instruccion,
				E, E1, E2, E3, E4, booleano, tipo, OP0, OP1, OP2, OP3;
    terminal    IDEN, ENT, PAP, PCI, ASIGNACION, PUNTO_COMA, 
				ADD, SUB, MUL, DIV, EOF, DIV_SEC, EQ, NEQ, LT, 
				LET, GT, GET, FALSE, TRUE, INT, BOOL, AND, OR, 
				NOT;

	S := declaraciones DIV_SEC instrucciones;
	declaraciones := declaracion | declaracion PUNTO_COMA declaraciones;
	instrucciones := instruccion | instruccion PUNTO_COMA instrucciones;
	declaracion := tipo IDEN;
	instruccion := IDEN ASIGNACION E;
	tipo := INT | BOOL;
	
	E := E1 OP0 E1 | E1;
	E1 := E1 OP1 E2 | E2 | NOT E1;
	E2 := E2 OP2 E3 | E3;
	E3 := OP3 E3 | E4;
	E4 := IDEN | ENT | booleano | PAP E PCI;
	booleano := FALSE | TRUE;
	OP0 := EQ | NEQ | LT | LET | GT | GET;
	OP1 := AND | OR;
	OP2 := ADD | SUB | MUL | DIV;
	OP3 := ADD | SUB;
}