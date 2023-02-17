package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("|****************************************************|");
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
			opcao = scan.nextInt();
			scan.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n");
				break;
			case 2:
				System.out.println("Listar todas as Contas\n");
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n");
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n");
				break;
			case 5:
				System.out.println("Apagar a Conta\n");
				break;
			case 6:
				System.out.println("Saque\n");
				break;
			case 7:
				System.out.println("Depósito\n");
				break;
			case 8:
				System.out.println("Transferência entre Contas\n");
				break;
			case 9:
				System.out.println("Banco Javeiro - O seu Futuro começa aqui!\n");
				System.exit(0);
				break;
			default:
				System.err.println("\nOpção Inválida!\n");
				break;
			}

			scan.close();

		}
	}
}