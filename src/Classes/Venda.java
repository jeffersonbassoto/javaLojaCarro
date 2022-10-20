package Classes;

public class Venda {

	private Cliente p;
    private Carro c;
    private String data_venda;

    public Venda(Cliente p, Carro c) {
        this.p = p;
        this.c = c;
        this.data_venda = java.time.LocalDate.now().toString();
    }

    public Cliente getP() {
        return p;
    }

    public void setP(Cliente p) {
        this.p = p;
    }

    public Carro getC() {
        return c;
    }

    public void setC(Carro c) {
        this.c = c;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    @Override
    public String toString() {
        return "Venda{"
        		+ "p=" + p
        		+ ", c=" + c
        		+ ", data_venda=" +	data_venda + "}";
    }
}
