
public class MockHardware implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao(String nroConta) throws Exception {
		
		if (nroConta.equals("0"))
			throw new ErroNaLeituraDoCartaoException("Erro na leitura do cart�o!");

		if (nroConta.equals(""))
			throw new CartaoBloqueadoException("Cart�o bloqueado!");

		if (nroConta.equals("x"))
			throw new CartaoInvalidoException("Cart�o inv�lido!");
		
		return nroConta;
	}

	@Override
	public void entregarDinheiro() throws Exception {

	}

	@Override
	public void lerEnvelope(int valor) throws Exception {

	}

}
