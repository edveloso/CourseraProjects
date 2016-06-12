
public class MockHardware implements Hardware {

	private boolean darPauNaEntregaDeDinheiro = false;
	private boolean darPauNaLeituraDoEnvelope = false;

	public void queroQueDePauNoSaque() {
		darPauNaEntregaDeDinheiro = true;
	}

	public void queroQueDePauNaLeituraDoEnvelope() {
		darPauNaLeituraDoEnvelope = true;
	}
	
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
		if (darPauNaEntregaDeDinheiro)
			throw new EntregarDinheiroException("Problema na entrega do dinheiro!");
	}

	@Override
	public void lerEnvelope() throws Exception {

		if (darPauNaLeituraDoEnvelope)
			throw new ProblemaNaLeituraDoEnvelopeException("Problema ao ler o Envelope!");
	}

}
