import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAutoridade {

	private Autoridade autoridade;
	
	@Test
	public void testTratamentoInformal() {
		autoridade = new Autoridade("Jo�o", "Silva", new Informal());
		assertEquals("Jo�o", autoridade.getTratamento());
		
	}
	
	@Test
	public void testTratamentoRespeitosoMasc() {
		autoridade = new Autoridade("Jo�o", "Silva", new Respeitoso("masculino"));
		assertEquals("Sr. Silva", autoridade.getTratamento());
		
	}

	@Test
	public void testTratamentoRespeitosoFem() {
		autoridade = new Autoridade("Maria", "Silva", new Respeitoso("feminino"));
		assertEquals("Sra. Silva", autoridade.getTratamento());
		
	}
	
	@Test
	public void testTratamentoComTitulo() {
		autoridade = new Autoridade("Jo�o", "Silva", new ComTitulo("Excelent�ssimo"));
		assertEquals("Excelent�ssimo Jo�o Silva", autoridade.getTratamento());
		
	}
}
