package br.com.jogo.controlador;

public class InverterString implements Embaralhador {

	public InverterString() {
		super();
	}

	@Override
	public String embaralhar(String palavra) {

		// Inverte a palavra usando o m�todo reverse de StringBuilder
		String paravraInvertida = new StringBuilder(palavra).reverse().toString();

		return paravraInvertida;
	}

	@Override
	public int getDificuldade() {
		return 2;
	}

}
