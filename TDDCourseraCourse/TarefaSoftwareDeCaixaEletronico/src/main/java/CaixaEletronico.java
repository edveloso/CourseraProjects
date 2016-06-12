
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
	
	public String sacar() {
		return null;
	}
	
	public String depositar() {
		return null;
	}
	
	public String saldo() {
		return null;
	}
	
}
