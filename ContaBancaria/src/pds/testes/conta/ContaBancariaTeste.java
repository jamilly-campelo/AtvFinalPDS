package pds.testes.conta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContaBancariaTeste {

	@Test
	public void deveConsultarSaldo() {
		ContaBancaria c = new ContaBancaria(1, 500);
		assertEquals(500, c.consultarSaldo());
	}
	
	@Test
	public void deveDepositar100() {
		ContaBancaria c = new ContaBancaria(1, 500);
		System.out.println("Saldo da conta inicalmente:" + c.consultarSaldo());
		try {
			c.depositar(100);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao depositar: " + e.getMessage());
		}
		assertEquals(600, c.consultarSaldo());
		System.out.println("Saldo depois do depósito:" + c.consultarSaldo());
	}
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaValorDepositadoPositivo() {
		ContaBancaria c = new ContaBancaria(1, 500);
		try {
			c.depositar(0);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Valor depositado deve ser positivo", e.getMessage());
		}
	}

	@Test
	public void deveSacar200() {
		ContaBancaria c = new ContaBancaria(1, 500);
		System.out.println("Saldo da conta inicalmente:" + c.consultarSaldo());
		try {
			c.sacar(200);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao sacar: " + e.getMessage());
		}
		assertEquals(300, c.consultarSaldo());
		System.out.println("Saldo depois do saque:" + c.consultarSaldo());
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaSacarValorMaiorQueSaldo() {
		ContaBancaria c = new ContaBancaria(1, 500);
		try {
			c.sacar(600);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Não possui valor suficiente para sacar", e.getMessage());
		}
	}
	
	@Test
	public void deveTransferir400() {
		ContaBancaria c = new ContaBancaria(1, 500);
		ContaBancaria c2 = new ContaBancaria(2, 0);
				
		try {
			c.transferir(c2, 400);
			
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao transferir: " + e.getMessage());
		}
		assertEquals(100, c.consultarSaldo());
		assertEquals(400, c2.consultarSaldo());
		System.out.println("Saldo depois da Transferência:" + c.consultarSaldo());
		System.out.println("Saldo depois da Transferência conta 2:" + c2.consultarSaldo());
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaTransferirValorInsuficiente() {
		ContaBancaria c = new ContaBancaria(1, 500);
		ContaBancaria c2 = new ContaBancaria(2, 0);
		try {
			c.transferir(c2, 600);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Não possui valor suficiente para transferir", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaTransferirValorInvalido() {
		ContaBancaria c = new ContaBancaria(1, 500);
		ContaBancaria c2 = new ContaBancaria(2, 0);
		try {
			c.transferir(c2, 0);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Valor inválido para transferir", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaTransferirContaInvalida() {
		ContaBancaria c = new ContaBancaria(1, 500);
		try {
			c.transferir(c, 10);
			fail("Não lançou a Exception esperada");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Conta inválida para transferir", e.getMessage());
		}
	}
}
