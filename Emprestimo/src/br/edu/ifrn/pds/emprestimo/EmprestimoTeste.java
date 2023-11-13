package br.edu.ifrn.pds.emprestimo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

public class EmprestimoTeste {

	Emprestimo e = new Emprestimo();
	
	@Test
	public void deveriaCalcularValorDasParcelasDe3600A2PorCento() {		
		assertEquals(372, e.parcela(3600, 0.02));
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaTaxaDeJurosNula() {
		try {
			e.parcela(3600, 0);
			fail("N�o lan�ou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("A taxa de juros n�o pode ser nula.", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaTaxaDeJurosNegativa() {
		try {
			e.parcela(3600, -0.05);
			fail("N�o lan�ou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("A taxa de juros n�o pode ser negativa.", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaValorDeEmprestimoInvalido() {
		try {
			e.parcela(2700, 0.05);
			fail("N�o lan�ou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("N�o existe empr�stimos para esse valor.", e.getMessage());
		}
	}
	
}
