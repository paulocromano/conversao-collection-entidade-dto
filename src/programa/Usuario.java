package programa;

public class Usuario {

	private String nome;
	private Integer pontos;
	
	
	public Usuario(String nome, Integer pontos) {
		this.nome = nome;
		this.pontos = pontos;
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
