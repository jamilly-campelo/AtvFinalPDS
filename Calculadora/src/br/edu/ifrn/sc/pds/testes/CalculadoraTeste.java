package br.edu.ifrn.sc.pds.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.Test;

public class CalculadoraTeste {

	Calculadora c = new Calculadora();
	
	@Test
	public void deveriaSomar3Mais5() {
		double soma = c.somar(3, 5);
		
		assertEquals(8, soma);
	}
	
	@Test
	public void deveriaSubtrair3De5() {
		double subtracao = c.subtrair(5, 3);
		
		assertEquals(2, subtracao);
	}
	
	@Test
	public void deveriaMultiplicar3Por5() {
		double produto = c.multiplicar(3, 5);
		
		assertEquals(15, produto);
	}
	
	@Test
	public void deveriaDividir3Por5() {
		double divisao = c.dividir(3, 5);
		
		assertEquals(0.6, divisao);
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorreta() {
		try {
			c.dividir(5, 0);
			fail("N�o lan�ou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("N�o � poss�vel dividir por zero.", e.getMessage());
		}
	}
	
}
