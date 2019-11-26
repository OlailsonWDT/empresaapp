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
		System.out.print("Digite a opção desejada:\n" + "1-Cadastrar empresa\n" + "2-Cadastrar funcionário\n"
					+ "3-Listar empresa\n" + "4-Listar funcionário\n" + "5-Editar informações da empresa\n"
					+ "6-Editar informações do funcionário\n" + "7-Excluir empresa\n" + "8-Excluir funcionário\n"
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
							"Não é mais posivel acresentar empresas\npara acresentar mais empresas exclua alguma empresa");
				}
				break;
			case 2:
				boolean test = false;
				String empFuncCNPJ;

				if (contFunc < num * 20) {
					do {
						System.out.println("Qual o CNPJ da empresa de atuação do funcionário?");
						empFuncCNPJ = input.nextLine();
						if (Trigger.empCNPJEquals(empFuncCNPJ, empresa)) {
							test = true;
						} else {
							System.out.println("Empresa não encontrada insira outra empresa.");
						}
					} while (test == false);
					funcionario[contFunc] = new Funcionario(Funcionario.pegaNomeFunc(),
							Funcionario.pegaNascimentoFunc(), Funcionario.pegaCPF(),empFuncCNPJ );
					contFunc++;
				} else {
					System.out.println(
							"Não é mais posivel acresentar funcionários\npara acresentar mais empresas exclua algum funcionário");
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
						System.out.println("CNPJ inválido! insira outro!");
					}

				} while (Trigger.empCNPJEquals(compCNPJ, empresa) == false);
				Trigger.editEmpresa(empresa);
				break;
			case 6:
				String compCPF;
				do {
					System.out.print("Digite o CPF ddo funcionário que deseja editar: ");
					compCPF = input.nextLine();
					if (Trigger.funcCPFEquals(compCPF, funcionario) == false) {
						System.out.println("CPF inválido! insira outro!");
					}

				} while (Trigger.funcCPFEquals(compCPF, funcionario) == false);
				Trigger.editFuncionario(funcionario);
				break;
			case 7:
				String exclCNPJ;
				do {
					System.out.print("Digite o CPF do funcionário que deseja excluir: ");
					exclCNPJ = input.nextLine();
					if (Trigger.empCNPJEquals(exclCNPJ, empresa) == false) {
						System.out.println("CPF inválido! insira outro!");
					}
				} while (Trigger.funcCPFEquals(exclCNPJ, funcionario) == false);

				break;
			case 8:
				String exclCPF;
				do {
					System.out.print("Digite o CPF do funcionário que deseja excluir: ");
					exclCPF = input.nextLine();
					if (Trigger.funcCPFEquals(exclCPF, funcionario) == false) {
						System.out.println("CPF inválido! insira outro!");
					}
				} while (Trigger.funcCPFEquals(exclCPF, funcionario) == false);

				break;
			case 9:
				System.out.println("Programa finalizado!");

				break;

			default:
				System.out.println("Valor inválido!");
			}
		} while (menu != 9);

	}
}
