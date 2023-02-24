package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

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

		@SuppressWarnings("resource")
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
			// scan.nextLine();

			try {
				opcao = scan.nextInt();

			} catch (InputMismatchException ex) {
				System.out.print("Digite valores inteiros: ");
				scan.next();
				opcao = 0;
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n");
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n");
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n");
				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n");
				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Banco Javeiro - O seu Futuro começa aqui!\n");
				System.exit(0);
				keyPress();
				break;
			default:
				System.err.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}