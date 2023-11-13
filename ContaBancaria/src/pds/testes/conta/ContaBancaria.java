package pds.testes.conta;

import java.util.Objects;

public class ContaBancaria {

	private int id;
	private double saldo;

	public ContaBancaria(int id, double saldo) {
		this.saldo = saldo;
		this.id = id;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double consultarSaldo() {
		return saldo;

	}

	public double depositar(double depositado) {
		if(depositado <= 0) {
			throw new IllegalArgumentException("Valor depositado deve ser positivo");
		}
		
		saldo = this.saldo + depositado;
		return saldo;
	}
	
	public double sacar(double sacado) {
		if(sacado > saldo) {
			throw new IllegalArgumentException("Não possui valor suficiente para sacar");
		}
		
		saldo = this.saldo - sacado;
		return saldo;

	}

	public double transferir(ContaBancaria conta2, double transferido) {
		if(transferido > saldo) {
			throw new IllegalArgumentException("Não possui valor suficiente para transferir");
		}if(transferido <= 0) {
			throw new IllegalArgumentException("Valor inválido para transferir");
		}if(conta2.equals(this)) {
			throw new IllegalArgumentException("Conta inválida para transferir");
		}
		
		saldo = this.saldo - transferido;
		conta2.saldo = conta2.saldo + transferido;
		return saldo;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		return id == other.id;
	}
	
	
}
