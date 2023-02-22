package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		// Testa classe Conta

		Conta c1 = new Conta(1, 123, 1, "Guilherme", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		System.out.println();

		// Testa classe Conta Corrente

		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "Vinicius Amorim", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		System.out.println();

		// Testa classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Susy Tateshita", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		System.out.println();

		Scanner scan = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "|****************************************************|");
			System.out.println("|                                                    |");
			System.out.println("|                BANCO DO JAVEIRO                    |");
			System.out.println("|                                                    |");
			System.out.println("|****************************************************|");
			System.out.println("|                                                    |");
			System.out.println("|            1 - Criar Conta                         |");
			System.out.println("|            2 - Listar todas as Contas              |");
			System.out.println("|            3 - Buscar Conta por Numero             |");
			System.out.println("|            4 - Atualizar Dados da Conta            |");
			System.out.println("|            5 - Apagar Conta                        |");
			System.out.println("|            6 - Sacar                               |");
			System.out.println("|            7 - Depositar                           |");
			System.out.println("|            8 - Transferir valores entre Contas     |");
			System.out.println("|            9 - Sair                                |");
			System.out.println("|                                                    |");
			System.out.println("******************************************************");
			System.out.print("Entre com a opção desejada: ");
			System.out.println("                          " + Cores.TEXT_RESET);
			opcao = scan.nextInt();
			scan.nextLine();

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n");
				break;
			case 8:
				System.out.println("Transferência entre Contas\n");
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Banco Javeiro - O seu Futuro começa aqui!\n");
				System.exit(0);
				break;
			default:
				System.err.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				break;
			}
		}
	}
}