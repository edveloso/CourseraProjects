import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		Cesta<Fruta> frutas = new Cesta<>();

		frutas.adiciona(new Fruta("Ma��"));
		frutas.adiciona(new Fruta("Banana"));
		frutas.adiciona(new Fruta("Mam�o"));
		frutas.adiciona(new Fruta("P�ra"));
		frutas.adiciona(new Fruta("Uva"));
		frutas.adiciona(new FrutaVermelha("Morango"));
		
		List<FrutaVermelha> vermelhas = new ArrayList<>();
		List<Fruta> frut2 = new ArrayList<>();
		vermelhas.add(new FrutaVermelha("Amora"));
		vermelhas.add(new FrutaVermelha("Cereja"));
		
		frutas.adicionaTodos(vermelhas);
		frutas.adicionaTodos(frut2);
		
		while (frutas.temItens()) {
			System.out.println(frutas.retira());
		}
		
	}
}
