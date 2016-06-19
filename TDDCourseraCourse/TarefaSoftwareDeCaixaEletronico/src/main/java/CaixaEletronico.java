
public class CaixaEletronico {

	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	private ContaCorrente contaCorrente;
	
	public CaixaEletronico(ServicoRemoto servicoRemoto, Hardware hardware) {
		super();
		this.servicoRemoto = servicoRemoto;
		this.hardware = hardware;
	}

	public String logar(String nroConta) throws Exception {

		hardware.pegarNumeroDaContaCartao(nroConta);
		contaCorrente = servicoRemoto.recuperarConta(nroConta);
		
		if (contaCorrente == null) {
			return "N�o foi poss�vel autenticar o usu�rio";
		}
		else {
			return "Usu�rio Autenticado";
		}
	}
	
	public String sacar(Integer valorSaque) throws Exception {
		if (contaCorrente == null)
			throw new UsuarioNaoLogadoException("Usu�rio n�o logado!");
		else {
			if (valorSaque <= contaCorrente.getSaldo()){
				hardware.entregarDinheiro();
				contaCorrente.setSaldo(contaCorrente.getSaldo() - valorSaque);
				servicoRemoto.persistirConta(contaCorrente);
				return "Retire seu dinheiro";
			} else {
				return "Saldo insuficiente";
			}
		}
	}
	
	public String depositar(Integer valorDeposito) throws Exception {
		if (contaCorrente == null) {
			throw new UsuarioNaoLogadoException("Usu�rio n�o logado!");
		} else {
			if (valorDeposito < 1)
				throw new DepositoComValorNegativoException("N�o � permitido valor negativo para dep�sito");
			
			hardware.lerEnvelope();
			contaCorrente.setSaldo(contaCorrente.getSaldo() + valorDeposito);
			servicoRemoto.persistirConta(contaCorrente);
			return "Dep�sito recebido com sucesso";
		}
	}
	
	public String saldo() throws UsuarioNaoLogadoException {
		if (contaCorrente == null) {
			throw new UsuarioNaoLogadoException("Usu�rio n�o logado!");
		} else {
			return "O saldo � R$" + contaCorrente.getSaldo() + ",00";
		}
	}
	
}
