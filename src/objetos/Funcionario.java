package objetos;

import java.util.Scanner;

public class Funcionario {

	private String nome;
	private String dataNascimento;
	private String CPF;
	private String empresaCNPJ;

	public Funcionario(String nome, String dataNascimento, String CPF, String empresaCNPJ) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.CPF = CPF;
		this.empresaCNPJ = empresaCNPJ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmpresaCNPJ() {
		return empresaCNPJ;
	}

	public void setEmpresaCNPJ(String empresaCNPJ) {
		this.empresaCNPJ = empresaCNPJ;
	}

	public static String pegaNomeFunc() {
		// Método responsável por pegar o nome da empresa
		Scanner input = new Scanner(System.in);
		String nome;
		System.out.print("Digite o nome do funcionario: ");
		nome = input.nextLine();
		
		return nome;
	}

	public static boolean isCPF(String CPF) {
		// Método responsávelpor verificar se o CPF digitado está certo
		if (CPF.length() != 11)
			return (false);
		for (int i = 0; i < 11; i++) {
			if (Character.isDigit(CPF.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static String pegaCPF() {
		// Método responsável por obter e tratar o CPF
		Scanner input = new Scanner(System.in);
		String saida;
		do {
			System.out.println("Digite o CPF do funcionario");
			saida = input.nextLine();

			if (isCPF(saida) == false) {
				System.out.println("CPF inválido!");
			}
		} while (isCPF(saida) == false);
		
		return saida;
	}

	public static String imprimeCPF(String String) {
		return (String.substring(0, 3) + "." + String.substring(3, 6) + "." + String.substring(6, 9) + "-"
				+ String.substring(9, 11));
	}

	private static String formatData(String dataNasc) {
		// Método responsável por organizar a data de nascimento
		dataNasc = dataNasc.substring(0, 2) + "/" + dataNasc.substring(2, 4) + "/" + dataNasc.substring(4, 8);
		return dataNasc;
	}

	public static String pegaNascimentoFunc() {
		Scanner input = new Scanner(System.in);
		// Método responsável por pegar a data de nascimento do funcionario
		String dataNasc;
		System.out.print(
				"Digite a data de nascimento do funcionario:(DD/MM/AAAA Prenencha todos os campos nesse formato, só adicione os numeros!) ");
		dataNasc = input.nextLine();
		
		return formatData(dataNasc);
	}

	public static String listarFunc(Funcionario[] func) {
		String saida = "\nEmpresas:\n";
		for (int i = 0; i < func.length; i++) {
			if (func[i] != null) {
				saida += "Nome: " + func[i].getNome() + "\nEndereço: " + func[i].getDataNascimento() + "\nCPF: "
						+ imprimeCPF((String) (func[i].getCPF())) + "\n\n";
			}
		}
		return saida;
	}
}
