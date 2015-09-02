package br.org.heranca;

public class ControleBonificacoes {

	private double totalDeBonificacoes = 0;

	public void registra(Funcionario funcionario) {
		System.out.println("Adicionando bonifica��o para o funcion�rio: " + funcionario);
		this.totalDeBonificacoes += funcionario.getBonificacao();
	}

	public double getTotalBonificacoes() {
		return this.totalDeBonificacoes;
	}

}
