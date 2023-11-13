package br.edu.ifrn.pds.emprestimo;

public class Emprestimo {
	
	public Emprestimo() {
		
	}
	
	public double parcela(double valorEmprestado, double taxaJuros) {
		int qtdParcelas = 0;
		double valorParcela = 0;
		double juros = valorEmprestado*taxaJuros;
		
		if (taxaJuros == 0) {
			throw new IllegalArgumentException("A taxa de juros n�o pode ser nula.");
		} else if (taxaJuros < 0) {
			throw new IllegalArgumentException("A taxa de juros n�o pode ser negativa.");
		} else {
			if(3000 <= valorEmprestado && valorEmprestado <= 8000) {
				qtdParcelas = 12;
			} else if (8000 < valorEmprestado && valorEmprestado <= 25000){
				qtdParcelas = 36;
			} else if (25000 < valorEmprestado && valorEmprestado <= 50000){
				qtdParcelas = 60;
			} else if (50000 < valorEmprestado && valorEmprestado <= 150000){
				qtdParcelas = 120;
			} else {
				throw new IllegalArgumentException("N�o existe empr�stimos para esse valor.");
			}
		}
		
		valorParcela = valorEmprestado/qtdParcelas + juros;
		return valorParcela;
		
	}
}
