package programa;

public class UsuarioDTO {

	private String nome;
	private Integer pontos;
	
	
	public UsuarioDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.pontos = usuario.getPontos();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
}
