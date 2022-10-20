package Sistema;

import Classes.Carro;
import Classes.Cliente;
import Classes.Venda;
import DAOS.CarroDAO;
import DAOS.ClienteDAO;
import DAOS.VendaDAO;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
        Main m = new Main();
        m.menuprincipal();
    }
	
	public void menuprincipal() {
		
		System.out.println("\nMENU PRINCIPAL");
		System.out.println("---------------------");
		System.out.println("1) Carro");
        System.out.println("2) Cliente");
        System.out.println("3) Venda");
        System.out.println("4) Sair");
        System.out.print("\nEscolha uma Opção: ");
        int op = getOpcao();

        switch (op) {

            case 1:
                menucarro();
            case 2:
                menucliente();
            case 3:
                menuvenda();
            case 4:
            	System.out.println("\nVolte Sempre!");
            	System.exit(0);
                
            default:
                System.out.println("\nDigite uma opção válida!");
                menuprincipal();
        }
    }
	
	public void menucarro() {
    	System.out.println("\nMENU Carros");
		System.out.println("---------------------");
		System.out.println("\n1) Cadastrar Carro");
        System.out.println("2) Listar Carros a Venda");
        System.out.println("3) Excluir Carro");
        System.out.println("4) Alterar Carro");
        System.out.println("5) Voltar");
        System.out.print("\nEscolha uma Opção: ");
        int op = getOpcao();

        switch (op) {

            case 1:
                add_carro();
            case 2:
                listar_carro();
            case 3:
                excluir_carro();
            case 4:
                alterar_carro();
            case 5:
                menuprincipal();
            default:
                System.out.println("\nDigite uma opção válida!");
                menucarro();
        }
    }
	
	public void menucliente() {
    	System.out.println("\nMENU Clientes");
		System.out.println("---------------------");
		System.out.println("\n1) Cadastrar Cliente");
        System.out.println("2) Listar Todas Clientes");
        System.out.println("3) Excluir Cliente");
        System.out.println("4) Alterar Cliente");
       System.out.println("5) Voltar");
        System.out.print("\nEscolha uma Opção: ");
        int op = getOpcao();

        switch (op) {

            case 1:
                add_cliente();
            case 2:
                listar_cliente();
            case 3:
                excluir_cliente();
            case 4:
                alterar_cliente();
            case 5:
            	menuprincipal();
            default:
                System.out.println("\nDigite uma opção válida!");
                menucliente();
        }
    }
	
	public void menuvenda() {
    	System.out.println("\nMENU Vendas");
		System.out.println("---------------------");
		System.out.println("\n1) Realizar Venda");
        System.out.println("2) Mostrar Vendas");
        System.out.println("3) Listar Carro do Cliente");
        System.out.println("4) Voltar");
        System.out.print("\nEscolha uma Opção: ");
        int op = getOpcao();

        switch (op) {

           case 1:
                realizar_venda();
            case 2:
                mostrar_vendas();
            case 3:
                listar_carro_cliente();
            case 4:
            	menuprincipal();
            default:
                System.out.println("\nDigite uma opção válida!");
                menuvenda();
        }
    }
	
	private void add_carro() {
        System.out.print("\nDigite o número do chassi do carro: ");
        String chassi = getScanner().nextLine();
        System.out.print("Digite o nome do carro: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite a cor do carro: ");
        String cor = getScanner().next();
        System.out.print("Digite o ano do carro: ");
        int ano = getScanner().nextInt();
        System.out.print("Digite a potência do carro: ");
        int potencia = getScanner().nextInt();
        System.out.print("Digite o valor do carro: ");
        float valor = getScanner().nextFloat();

        Carro c = new Carro(chassi, nome, cor, ano, potencia, valor);
        CarroDAO cdao = new CarroDAO();
        cdao.add_carro(c);

        menucarro();
    }
	
	public void listar_carro() {
        CarroDAO cdao = new CarroDAO();
        System.out.println("\t\n--- Todos os Carros a Venda ---\n");
        for (Carro c : cdao.mostrar_carros()) {
            System.out.println("Número do Chassi: " + c.getNumero_chassi());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Potência (CV): " + c.getPotencia_cv());
            System.out.println("Valor do carro: " + c.getValor() + "\n");
        }
        menucarro();
    }
	
	public void excluir_carro() {
        CarroDAO cdao = new CarroDAO();
        System.out.print("\nDigite o número do chassi do carro para excluir: ");
        String numero_chassi = getScanner().nextLine();
        cdao.delete_carro(numero_chassi);
        menucarro();

    }
	
	public void alterar_carro() {
	       CarroDAO cdao = new CarroDAO();
	       System.out.print("\nDigite o número do chassi do carro para alterar: ");
	       String numero_chassi = getScanner().nextLine();

	       Carro c = cdao.achar_carro(numero_chassi);

	       System.out.println("\nAlterando Informações do Carro: \n");
	       System.out.println("Número do Chassi: " + c.getNumero_chassi());
	       System.out.println("Nome: " + c.getNome());
	       System.out.println("Cor: " + c.getCor());
	       System.out.println("Ano: " + c.getAno());
	       System.out.println("Potência (CV): " + c.getPotencia_cv());
	       System.out.println("Valor do carro: " + c.getValor() + "\n");

	       System.out.println("Digite as novas informações: \n");

	       System.out.print("Nome: ");
	       String nome = getScanner().nextLine();
	       System.out.print("Cor: ");
	       String cor = getScanner().next();
	       System.out.print("Ano: ");
	       int ano = getScanner().nextInt();
	       System.out.print("Potência (CV): ");
	       int potencia = getScanner().nextInt();
	       System.out.print("Valor do carro: ");
	       float valor = getScanner().nextFloat();

	       cdao.alterar_carro(c.getNumero_chassi(), nome, cor, ano, potencia, valor);
	       menucarro();
	    }
	
	public void add_cliente() {
		System.out.print("\nDigite o CPF do Cliente: ");
		String cpf = getScanner().nextLine();
        System.out.print("Digite o RG do Cliente: ");
        String rg = getScanner().nextLine();
		System.out.print("Digite o nome do Cliente: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite a idade do Cliente: ");
        String idade = getScanner().nextLine();
        System.out.print("Digite o Email: ");
        String email = getScanner().nextLine();
        System.out.print("Digite o Telefone: ");
        String telefone = getScanner().nextLine();
        
        Cliente p = new Cliente(cpf, rg, nome, idade, email, telefone);
        ClienteDAO pdao = new ClienteDAO();
        pdao.add_cliente(p);

        menucliente();
    }
	
	public void listar_cliente() {
    	ClienteDAO pdao = new ClienteDAO();
    	System.out.println("\t\n--- Todos os Clientes ---\n");

        for (Cliente p : pdao.mostrar_clientes()) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("Rg: " + p.getRg());
            System.out.println("Idade: " + p.getIdade());
            System.out.println("Email: " + p.getEmail());
            System.out.println("Telefone: " + p.getTelefone() + "\n");
        }
        menucliente();
    }

	public void excluir_cliente() {

        ClienteDAO pdao = new ClienteDAO();
        System.out.print("\nDigite o CPF do cliente para remove-lo: ");

        String cpf = getScanner().nextLine();
        pdao.delete_cliente(cpf);
        menucliente();
    }
	
	public void alterar_cliente() {
	       ClienteDAO pdao = new ClienteDAO();
	       System.out.print("\nDigite o CPF do cliente para alterar: ");
	       String cpf = getScanner().nextLine();

	       Cliente p = pdao.achar_cliente(cpf);
	       
	       System.out.println("\nAlterando Informações do Cliente: \n");
	       System.out.println("Rg: " + p.getRg());
	       System.out.println("Nome: " + p.getNome());
	       System.out.println("Idade: " + p.getIdade());
	       System.out.println("Email: " + p.getEmail());       
	       System.out.println("Telefone: " + p.getTelefone() + "\n");
	       
	       System.out.println("Digite as novas informações: \n");
	       
	       System.out.print("Rg: ");
	       String rg = getScanner().nextLine();
	       System.out.print("Nome: ");
	       String nome = getScanner().nextLine();
	       System.out.print("Idade: ");
	       String idade = getScanner().nextLine();
	       System.out.print("Email: ");
	       String email = getScanner().nextLine();   
	       System.out.print("Telefone: ");
	       String telefone = getScanner().nextLine();   
	      	       
	       pdao.alterar_cliente(p.getCpf(), rg, nome, idade, email, telefone);
	       menucliente();
	}
	
	public void realizar_venda() {

        System.out.print("\nDigite o CPF do comprador: ");
        String cpf = getScanner().nextLine();
        System.out.print("Digite o número do chassi do carro: ");
        String chassi = getScanner().nextLine();

        ClienteDAO pdao = new ClienteDAO();
        Cliente p = pdao.achar_cliente(cpf);

        CarroDAO cdao = new CarroDAO();
        Carro c = cdao.achar_carro(chassi);

        Venda v = new Venda(p, c);

        System.out.println("\nResumo da Venda: \n");
        System.out.println("*** Grupo3 Multimarcas ***");
        System.out.println("\nCpf do Comprador: " + p.getCpf() + " - " + p.getNome());
        System.out.println("Chassi do Carro: " + c.getNumero_chassi() + " - " + c.getNome());
        System.out.println("Valor: " + c.getValor());
        System.out.println("Data da venda: " + v.getData_venda());
        System.out.print("Finalizar venda? 1-(Sim) 0-(Não): ");
        int escolha = getScanner().nextInt();

        if (escolha == 1) {
            VendaDAO vdao = new VendaDAO();
            vdao.add_venda(v);
            menuvenda();
        } else {
            System.out.print("\n");
            menuvenda();
        }
    }

    public void mostrar_vendas() {
        VendaDAO vdao = new VendaDAO();
        vdao.mostrar_vendas();
        menuvenda();
    }

    public void listar_carro_cliente() {
        System.out.print("\nDigite o CPF do cliente para listar os carros: ");
        String cpf = getScanner().nextLine();

        ClienteDAO pdao = new ClienteDAO();
        pdao.mostrar_meus_carros(cpf);
        menuvenda();
    }
    
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
	
	public static int getOpcao() {
		 String sOpcao = getScanner().nextLine();
			try {
			int opcao =	Integer.parseInt(sOpcao);
			return opcao;
			} catch (Exception e) {
			return 0;
			}
		}
}
