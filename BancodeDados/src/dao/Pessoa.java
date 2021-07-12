package dao;

public class Pessoa {
    
	private String nome;
    private String email;
	private String cpf ;
	private String telefone;
	
     	
	
	public Pessoa(String nome, String email, String cpf, String telefone) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}



	public String getNome() {
		return nome;
	}


	
	public String getEmail() {
		return email;
	}
	

	public String getCpf() {
		return cpf;
	}

	
	public String getTelefone() {
		return telefone;
	}
		
}
