package sistema;

import java.util.Scanner;

import objetos.Empresa;
import objetos.Funcionario;

public class Trigger {

	public static String mainMenu() {
		String menu;

		menu = "Digite a op��o desejada:\n" + "1-Cadastrar empresa\n" + "2-Cadastrar funcion�rio\n"
				+ "3-Listar empresa\n" + "4-Listar funcion�rio\n" + "5-Editar informa��es da empresa\n"
				+ "6-Editar informa��es do funcion�rio\n" + "7-Excluir empresa\n" + "8-Excluir funcion�rio\n"
				+ "9-Finalizar";
		return menu;
	}

	public static int quantidadeEmp() {
		Scanner input = new Scanner(System.in);
		System.out.println("Quantas empresa dejesa cadastrar?(Para cada empresa podem ser cadastrado 20 funcionatios)");
		int num = input.nextInt();
		//input.close();
		return num;

	}

	public static int desejaContinuar(int menu) {
		Scanner input = new Scanner(System.in);
		char deseja;
		do {
			System.out.println("deseja continuar?\nS-sim\nN- n�o, finalize!");
			deseja = input.nextLine().toUpperCase().charAt(0);
			if (deseja != 'S' && deseja != 'N') {
				System.out.println("Caractere inv�lido!");

			}
		} while (deseja != 'S' && deseja != 'N');
		if (deseja == 'S') {
			return menu;

		} else {

			return 9;
		}
	}

	public static boolean empCNPJEquals(String empFunc, Empresa[] empresa) {
		for (int i = 0; i < empresa.length; i++) {
			if (empresa[i] != null) {
				if (empFunc.equals(empresa[i].getCNPJ())) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean funcCPFEquals(String func, Funcionario[] funcio) {
		for (int i = 0; i < funcio.length; i++) {
			if (funcio[i] != null) {
				if (func.equals(funcio[i].getCPF())) {
					return true;
				}
			}
		}
		return false;
	}

	public static void editEmpresa(Empresa[] empresa) {
		String aux;
		Scanner input = new Scanner(System.in);
		int pesq = 0;
		do {

			System.out.println("Informe o CNPJ da empresa que deseja alterar");
			aux = input.nextLine();
			if (Empresa.isCNPJ(aux)) {
				System.out.println("Comando inv�lido!");
			}
		} while (Empresa.isCNPJ(aux));
		for (int i = 0; i < empresa.length; i++) {
			if (aux.equalsIgnoreCase(empresa[i].getCNPJ())) {
				pesq = i;

			}
			System.out.println("Qual o nome da empresa de CNPJ: " + empresa[pesq].getCNPJ());
			empresa[pesq].setNome(input.nextLine());
			System.out.println("Qual o endere�o da empresa de CNPJ: " + empresa[pesq].getCNPJ());
			empresa[pesq].setEndereco(input.nextLine());

		}

	}

	public static void editFuncionario(Funcionario[] funcionarios) {
		String aux;
		Scanner input = new Scanner(System.in);
		int pesq = 0;
		do {

			System.out.println("Informe o CPF da empresa que deseja alterar");
			aux = input.nextLine();
			if (Empresa.isCNPJ(aux)) {
				System.out.println("Comando inv�lido!");
			}
		} while (Empresa.isCNPJ(aux));
		for (int i = 0; i < funcionarios.length; i++) {
			if (aux.equalsIgnoreCase(funcionarios[i].getCPF())) {
				pesq = i;

			}
			System.out.println("Qual o nome do funcion�rio de CPF: " + funcionarios[pesq].getCPF());
			funcionarios[pesq].setNome(input.nextLine());
			System.out.println("Qual a data de nascimento do funcion�rio de CPF: " + funcionarios[pesq].getCPF());
			funcionarios[pesq].setDataNascimento(input.nextLine());
			System.out.println(
					"Qual o CNPJ da empresa que o funcion�rio de CPF : " + funcionarios[pesq].getCPF() + " Trabalha: ");
			funcionarios[pesq].setEmpresaCNPJ(input.nextLine());

		}

	}
}
