package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contaController = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contaController.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contaController.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contaController.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contaController.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contaController.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contaController.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contaController.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contaController.cadastrar(cp2);

		contaController.listarTodas();

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

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
				System.out.println("Digite o Numero da Agência: ");
				agencia = scan.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				scan.skip("\\R?");
				titular = scan.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = scan.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = scan.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = scan.nextFloat();
					contaController.cadastrar(
							new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = scan.nextInt();
					contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular,
							saldo, aniversario));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n");
				contaController.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n");
				System.out.print("Digite o número da conta: ");
				numero = scan.nextInt();
				contaController.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n");
				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();

				if (contaController.buscarNaCollection(numero) != null) {

					System.out.println("Digite o Numero da Agência: ");
					agencia = scan.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					scan.skip("\\R?");
					titular = scan.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = scan.nextFloat();

					tipo = contaController.retornaTipo(numero);

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = scan.nextFloat();
						contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = scan.nextInt();
						contaController
								.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}

				} else
					System.out.println("\nConta não encontrada!");

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n");

				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();

				contaController.deletar(numero);

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