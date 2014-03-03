package tema2.ej14.alex.manual;

public class UnidadLexicaUnivaluada extends UnidadLexica {
   public String lexema() {throw new UnsupportedOperationException();}   
   public UnidadLexicaUnivaluada(int fila, int columna, ClaseLexica clase) {
     super(fila,columna,clase);  
   }
  public String toString() {
    return "[clase:"+clase()+",fila:"+fila()+"]";  
  }   
}
