package programa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import util.ConverterToDTOCollection;

public class Main {

	public static void main(String[] args) {
		
		List<Usuario> usuarios = carregarDados();
		
		ConverterToDTOCollection.convertToList(usuarios, UsuarioDTO::new)
			.forEach(usuario -> System.out.println(usuario.getNome()));
		
		System.out.println("\n\t Usuários ordenados");
		ConverterToDTOCollection.convertToOrdenedList(usuarios, UsuarioDTO::new,
			Comparator.comparing(Usuario::getNome))
			.forEach(usuario -> System.out.println(usuario.getNome()));
	}
	
	public static List<Usuario> carregarDados() {
		List<Usuario> usuarios = new ArrayList<>();

		usuarios.add(new Usuario("Ana", 10));
		usuarios.add(new Usuario("Pedro", 5));
		usuarios.add(new Usuario("João", 45));
		usuarios.add(new Usuario("Vitória", 12));
		usuarios.add(new Usuario("Beatriz", 19));
		
		return usuarios;
	}
}
