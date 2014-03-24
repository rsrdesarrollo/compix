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
   
   /* Ejemplo
   public void Sp() {
      S();
      empareja(ClaseLexica.EOF);
   }
   
   private void S() {
     switch(anticipo.clase()) {
         case EVALUA:          
              empareja(ClaseLexica.EVALUA);
              E0();
              Ds();
              break;
         default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                                          ClaseLexica.EVALUA);                                            
   }
   */
   
   private void empareja(ClaseLexica claseEsperada) {
      if (anticipo.clase() == claseEsperada)
          sigToken();
      else
    	  errores.errorSintactico(anticipo.fila(),anticipo.clase(),claseEsperada);
   }
   
   private void sigToken() {
      try {
        anticipo = alex.sigToken();
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
}