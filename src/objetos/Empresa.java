package objetos;

import java.util.Scanner;

public class Empresa {

	private String nome;
	private String endereco;
	private String CNPJ;

	public Empresa(String nome, String endereco, String CNPJ) {
		this.nome = nome;
		this.endereco = endereco;
		this.CNPJ = CNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public static boolean isCNPJ(String CNPJ) {
		// Método responsávelpor verificar se o CNPJ digitado está certo
		if (CNPJ.length() != 14)
			return (false);
		for (int i = 0; i < 14; i++) {
			if (Character.isDigit(CNPJ.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static String pegaCNPJ() {
		// Método responsável por obter e tratar o CNPJ
		Scanner input = new Scanner(System.in);
		String saida;
		do {
			System.out.println("Digite o CNPJ da empresa");
			saida = input.nextLine();

			if (isCNPJ(saida) == false) {
				System.out.println("CNPJ inválido!");
			}

		} while (isCNPJ(saida) == false);

		return saida;
	}

	public static String imprimeCNPJ(String CNPJ) {
		// Método responsável por incrementar os símbolos do CNPJ o "-" e "."
		return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "."
				+ CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14));
	}

	public static String pegaEnderecoEmp() {
		Scanner input = new Scanner(System.in);
		// Método responsável por peguar o nome da empresa

		String endereco;
		System.out.print("Digite o endereço da empresa: ");
		endereco = input.nextLine();

		return endereco;
	}

	public static String pegaNomeEmp() {
		// Método responsável por pegar o nome da empresa
		Scanner input = new Scanner(System.in);
		String nome;
		System.out.print("Digite o nome da empresa: ");
		nome = input.nextLine();

		return nome;
	}

	public static String listarEmp(Empresa emp[]) {
		String saida = "\nEmpresas:\n";
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				saida += "Nome: " + emp[i].getNome() + "\nEndereço: " + emp[i].getEndereco() + "\nCNPJ: "
						+ imprimeCNPJ(emp[i].getCNPJ()) + "\n\n";
			}
		}
		return saida;
	}

	public String procurarEmpresa(Empresa[] emp) {
		Scanner input = new Scanner(System.in);
		String nome = input.nextLine().toUpperCase();
		int pesq = 0;
		for (int i = 0; i < emp.length; i++) {
			if (nome.equalsIgnoreCase(this.getNome())) {
				pesq = i;
			}
		}
		String saida = "Nome: " + emp[pesq].getNome() + "\nEndereço: " + emp[pesq].getEndereco() + "\nCNPJ: "
				+ emp[pesq].getCNPJ();

		return saida;
	}

	public void excluiEmpresa(Empresa[] emp) {
		int pesq = 0;
		for (int i = 0; i < emp.length; i++) {
			if (nome.equalsIgnoreCase(this.getNome())) {
				emp[i] = null;
				pesq = i;
				i = emp.length - 1;
			}
		}
		for (int i = pesq; i < emp.length - 1; i++) {
			emp[i] = emp[i + 1];
		}
	}
}
