package br.edu.ifrn.pds.emprestimo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.fail;
import org.junit.Test;

public class EmprestimoTeste {

	Emprestimo e = new Emprestimo();
	
	@Test
	public void deveriaCalcularValorDasParcelasDe3600A2PorCento() {		
		assertEquals(372, e.parcela(3600, 0.02));
	}
	
	@Test
	public void deveriaLancarIllegalArgumentExceptionParaTaxaDeJurosNula(){
		assertThrows(IllegalArgumentException.class, () -> e.parcela(3600, 0));
	}
	
	@Test
	public void deveriaLancarIllegalArgumentExceptionParaTaxaDeJurosNegativa(){
		assertThrows(IllegalArgumentException.class, () -> e.parcela(3600, -0.05));
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaTaxaDeJurosNula() {
		try {
			e.parcela(3600, 0);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("A taxa de juros não pode ser nula.", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaTaxaDeJurosNegativa() {
		try {
			e.parcela(3600, -0.05);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("A taxa de juros não pode ser negativa.", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaValorDeEmprestimoInvalido() {
		try {
			e.parcela(2700, 0.05);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Não existe empréstimos para esse valor.", e.getMessage());
		}
	}
	
}
