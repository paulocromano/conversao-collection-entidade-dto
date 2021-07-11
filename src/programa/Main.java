package programa;

import java.util.ArrayList;
import java.util.List;

import util.ConvertToDTOCollection;

public class Main {

	public static void main(String[] args) {
		
		List<Usuario> usuarios = carregarDados();
		
		ConvertToDTOCollection.convertToList(usuarios, UsuarioDTO::new)
			.forEach(usuario -> System.out.println(usuario.getNome()));
	}
	
	public static List<Usuario> carregarDados() {
		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("Ana", 10));
		usuarios.add(new Usuario("Pedro", 5));
		usuarios.add(new Usuario("Jo�o", 45));
		usuarios.add(new Usuario("Vit�ria", 12));
		usuarios.add(new Usuario("Beatriz", 19));
		
		return usuarios;
	}
	
}
