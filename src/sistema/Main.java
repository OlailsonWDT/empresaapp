package sistema;

import java.util.Scanner;

import objetos.Empresa;
import objetos.Funcionario;

public class Main {
	public static void main(String[] args) {
		
		int num = Trigger.quantidadeEmp();
		Scanner input = new Scanner(System.in);
		int menu = 0, contEmp = 0, contFunc = 0;
		Empresa[] empresa = new Empresa[num];
		Funcionario[] funcionario = new Funcionario[num * 20];
		do {
		System.out.print("Digite a op��o desejada:\n" + "1-Cadastrar empresa\n" + "2-Cadastrar funcion�rio\n"
					+ "3-Listar empresa\n" + "4-Listar funcion�rio\n" + "5-Editar informa��es da empresa\n"
					+ "6-Editar informa��es do funcion�rio\n" + "7-Excluir empresa\n" + "8-Excluir funcion�rio\n"
					+ "9-Finalizar\n");
			menu = input.nextInt();
			switch (menu) {
			case 1:
				if (contEmp < num) {
					empresa[contEmp] = new Empresa(Empresa.pegaNomeEmp(), Empresa.pegaEnderecoEmp(),
							Empresa.pegaCNPJ());
					contEmp++;
				} else {
					System.out.println(
							"N�o � mais posivel acresentar empresas\npara acresentar mais empresas exclua alguma empresa");
				}
				break;
			case 2:
				boolean test = false;
				String empFuncCNPJ;

				if (contFunc < num * 20) {
					do {
						System.out.println("Qual o CNPJ da empresa de atua��o do funcion�rio?");
						empFuncCNPJ = input.nextLine();
						if (Trigger.empCNPJEquals(empFuncCNPJ, empresa)) {
							test = true;
						} else {
							System.out.println("Empresa n�o encontrada insira outra empresa.");
						}
					} while (test == false);
					funcionario[contFunc] = new Funcionario(Funcionario.pegaNomeFunc(),
							Funcionario.pegaNascimentoFunc(), Funcionario.pegaCPF(),empFuncCNPJ );
					contFunc++;
				} else {
					System.out.println(
							"N�o � mais posivel acresentar funcion�rios\npara acresentar mais empresas exclua algum funcion�rio");
				}

				break;
			case 3:
				System.out.println(Empresa.listarEmp(empresa));
				break;
			case 4:
				System.out.println(Funcionario.listarFunc(funcionario));
				break;
			case 5:
				String compCNPJ;
				do {
					System.out.print("Digite o CNPJ da empresa que deseja editar: ");
					compCNPJ = input.nextLine();
					if (Trigger.empCNPJEquals(compCNPJ, empresa)==false) {
						System.out.println("CNPJ inv�lido! insira outro!");
					}

				} while (Trigger.empCNPJEquals(compCNPJ, empresa) == false);
				Trigger.editEmpresa(empresa);
				break;
			case 6:
				String compCPF;
				do {
					System.out.print("Digite o CPF ddo funcion�rio que deseja editar: ");
					compCPF = input.nextLine();
					if (Trigger.funcCPFEquals(compCPF, funcionario) == false) {
						System.out.println("CPF inv�lido! insira outro!");
					}

				} while (Trigger.funcCPFEquals(compCPF, funcionario) == false);
				Trigger.editFuncionario(funcionario);
				break;
			case 7:
				String exclCNPJ;
				do {
					System.out.print("Digite o CPF do funcion�rio que deseja excluir: ");
					exclCNPJ = input.nextLine();
					if (Trigger.empCNPJEquals(exclCNPJ, empresa) == false) {
						System.out.println("CPF inv�lido! insira outro!");
					}
				} while (Trigger.funcCPFEquals(exclCNPJ, funcionario) == false);

				break;
			case 8:
				String exclCPF;
				do {
					System.out.print("Digite o CPF do funcion�rio que deseja excluir: ");
					exclCPF = input.nextLine();
					if (Trigger.funcCPFEquals(exclCPF, funcionario) == false) {
						System.out.println("CPF inv�lido! insira outro!");
					}
				} while (Trigger.funcCPFEquals(exclCPF, funcionario) == false);

				break;
			case 9:
				System.out.println("Programa finalizado!");

				break;

			default:
				System.out.println("Valor inv�lido!");
			}
		} while (menu != 9);

	}
}
