import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.example.Calculadora;

public interface TestCalculadora {
    
    Calculadora calc = new Calculadora();

    // teste
    @Test
   public default void testeSoma(){
    double resultado = calc.soma(3,8);
    assertEquals(11, resultado, 0);
   }

   @Test
   public default void testeSubtrai(){
    double resultado = calc.subtrai(10, 12);
    assertEquals(-2, resultado, 0);
   }

   @Test
   public default void  testeMultiplica(){
    double resultado = calc.multiplica(6, 7);
    assertEquals(42, resultado, 0);
   }

   @Test
   public default void  testeDivide(){
    double resultado = calc.divide(20, 5);
    assertEquals(4, resultado, 0);
   }

   @Test
default
void testDivisaoPorZero() {
    Calculadora calculadora = new Calculadora();
    assertThrows(IllegalArgumentException.class, () -> calculadora.divide(10, 0));
}


   }
  

