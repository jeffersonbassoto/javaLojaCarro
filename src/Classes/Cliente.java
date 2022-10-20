package Classes;

public class Cliente {

    private String cpf;
    private String rg;
    private String nome;
    private String idade;
    private String email;
    private String telefone;
    

    public Cliente() {
    }

    public Cliente(String cpf, String rg, String nome, String idade, String email, String telefone) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
	@Override
    public String toString() {
        return "Cliente{"
        	 + "cpf=" + cpf
        	 + ", rg=" + rg
        	 + ", nome=" + nome
        	 + ", idade=" + idade
        	 + ", email=" + email
        	 + ", telefone=" + telefone + "}";
    }
}
