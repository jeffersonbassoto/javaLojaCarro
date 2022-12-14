package Classes;

public class Carro {
	private String numero_chassi;
    private String nome;
    private String cor;
    private int ano;
    private int potencia_cv;
    private double valor;
    
    public Carro() {
    }
    
    public Carro(String numero_chassi, String nome, String cor, int ano, int potencia_cv, double valor) {
        this.numero_chassi = numero_chassi;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.potencia_cv = potencia_cv;
        this.valor = valor;
    }
    
   	public String getNumero_chassi() {
		return numero_chassi;
	}

	public void setNumero_chassi(String numero_chassi) {
		this.numero_chassi = numero_chassi;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getPotencia_cv() {
		return potencia_cv;
	}
	
	public void setPotencia_cv(int potencia_cv) {
		this.potencia_cv = potencia_cv;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
    
	@Override
    public String toString() {
        return "Carro{" 
        	+ "numero_chassi=" + numero_chassi 
        	+ ", nome=" + nome
        	+ ", cor=" + cor
        	+", ano=" + ano
        	+", potencia_cv=" + potencia_cv
        	+", valor=" + valor + "}";
    }
}
