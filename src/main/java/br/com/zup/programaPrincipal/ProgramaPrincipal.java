package br.com.zup.programaPrincipal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.zup.carroDAO.CarroDao;
import br.com.zup.carroPOJO.Carro;
import br.com.zup.connectionFactory.ConnectionFactory;

public class ProgramaPrincipal {

	public static void apresentacao() {

		System.out.println("\n******************************");
		System.out.println("--------Estacionamento--------");
		System.out.println("******************************\n");

	}

	public static void menu() {

		System.out.println("\n\n<1> Registrar entrada de veículo");
		System.out.println("<2> Registrar saída de veículo");
		System.out.println("<3> Buscar veículo");
		System.out.println("<4> Listar veículos pela placa");
		System.out.println("<5> Listar veículos pelo fabricante");
		System.out.println("<0> SAIR");

	}

	public static void registraEntradaVeiculo(Scanner teclado, Carro carro, CarroDao carros) {

		teclado.nextLine();
		System.out.print("Digite a placa do veículo: ");
		String placa = teclado.nextLine().toUpperCase();

		System.out.print("Digite a cor do veículo: ");
		String cor = teclado.nextLine();

		System.out.print("Digite o fabricante do veículo: ");
		String fabricante = teclado.nextLine();

		System.out.print("Digite o modelo do veículo: ");
		String modelo = teclado.nextLine();

		Carro carroEntra = new Carro(placa, cor, fabricante, modelo);

		carros.registrarEntradaVeiculo(carroEntra);
	}

	public static void registrarSaidaVeiculo(Scanner teclado, CarroDao carros) {
		teclado.nextLine();
		System.out.print("Digite a placa do veículo que deseja retirar: ");
		String placa = teclado.nextLine().toUpperCase();

		carros.registrarSaidaVeiculo(placa);
	}

	public static void buscaVeiculo(Scanner teclado, Carro carro, CarroDao carros) {

		teclado.nextLine();
		System.out.print("Digite a placa do veículo de que deseja buscar: ");
		String placa = teclado.nextLine().toUpperCase();
		Carro carroEstacionado = carros.buscaCarroEstacionado(placa);

		System.out.println("\nPlaca = " + carroEstacionado.getPlaca());
		System.out.println("Cor = " + carroEstacionado.getCor());
		System.out.println("Fabricante = " + carroEstacionado.getFabricante());
		System.out.println("Modelo = " + carroEstacionado.getModelo());

	}

	public static void listarVeiculosPorPlaca(Scanner teclado, Carro carro, CarroDao carros) {

		List<Carro> veiculos = carros.carrosEstacionados();
		System.out.println("Veículos estacionados: \n");

		for (Carro listaVeiculos : veiculos) {
			System.out.println(listaVeiculos);
		}

	}

	public static void listarVeiculosPorFabricante(Scanner teclado, Carro carro, CarroDao carros) {

		System.out.print("\nDigite o fabricante que deseja buscar:");
		String fabricanteVeiculo = teclado.next();

		List<Carro> carroFabricante = carros.listaCarroFabricante(fabricanteVeiculo);

		System.out.println("\nLista de carros por fabricante: \n\n");
		for (Carro carrosPorFabricante : carroFabricante) {
			System.out.println(carrosPorFabricante);
		}

	}

	public static void main(String[] args) throws SQLException {

		Scanner teclado = new Scanner(System.in);
		Connection conn = new ConnectionFactory().getConnection();
		Carro carro = new Carro();
		CarroDao carros = new CarroDao();
		String opcao = "";

		apresentacao();

		do {
			menu();
			System.out.println("Escolha uma das opções acima");
			opcao = teclado.next();

			switch (opcao) {

			case "1":

				registraEntradaVeiculo(teclado, carro, carros);
				break;

			case "2":

				registrarSaidaVeiculo(teclado, carros);
				break;

			case "3":

				buscaVeiculo(teclado, carro, carros);

				break;

			case "4":

				listarVeiculosPorPlaca(teclado, carro, carros);

				break;

			case "5":

				listarVeiculosPorFabricante(teclado, carro, carros);

				break;

			case "0":

				System.out.println("Obrigada por utilizar nosso estacionamento. Volte sempre!");
				break;

			default:
				System.out.print(opcao + "  Não é uma opção válida. Tente novamente!\n\n");

			}

		} while (!opcao.equals("0"));

	}

}
