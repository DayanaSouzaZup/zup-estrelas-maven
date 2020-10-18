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

	public static void menu(Scanner teclado) {

		System.out.println("<1> Registrar entrada de ve�culo");
		System.out.println("<2> Registrar sa�da de ve�culo");
		System.out.println("<3> Buscar ve�culo");
		System.out.println("<4> Listar ve�culos");
		System.out.println("<0> SAIR");

	}

	public static void registraNovoVeiculo(Scanner teclado, Carro carro, CarroDao carros) {

		System.out.print("Digite a placa do ve�culo: ");
		String placa = teclado.next();

		System.out.print("Digite a cor do ve�culo: ");
		String cor = teclado.next();

		System.out.print("Digite o fabricante do ve�culo: ");
		String fabricante = teclado.next();

		System.out.print("Digite o modelo do ve�culo: ");
		String modelo = teclado.next();

		Carro carroEntra = new Carro(placa, cor, fabricante, modelo);

		carros.registrarEntradaVe�culo(carroEntra);
	}

	public static void registrarSaidaVeiculo(Scanner teclado, Carro carro, CarroDao carros) {

		System.out.print("Digite a placa do ve�culo que deseja retirar: ");
		String placa = teclado.next();

		carros.registrarSaidaVe�culo(placa);
	}

	public static void buscaVeiculo(Scanner teclado, Carro carro, CarroDao carros) {

		System.out.print("Digite a placa do ve�culo de que deseja buscar: ");
		String placa = teclado.next();
		Carro carroEstacionado = carros.buscaCarroPorPlaca(placa);

		System.out.println("Placa = " + carroEstacionado.getPlaca());
		System.out.println("Cor = " + carroEstacionado.getCor());
		System.out.println("Fabricante = " + carroEstacionado.getFabricante());
		System.out.println("Modelo = " + carroEstacionado.getModelo());

	}
	
	public static void listarVeiculos(Scanner teclado,Carro carro, CarroDao carros) {
		
		List<Carro> veiculos = carros.listarVeiculosEstacionados();
		System.out.println("Ve�culos estacionados: \n");
		
		for (Carro listaVeiculos: veiculos) {
			System.out.println(listaVeiculos);
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
			menu(teclado);
			System.out.println("Escolha uma das op��es acima");
			opcao = teclado.next();

			switch (opcao) {

			case "1":

				registraNovoVeiculo(teclado, carro, carros);
				break;

			case "2":

				registrarSaidaVeiculo(teclado, carro, carros);
				break;

			case "3":

				buscaVeiculo(teclado, carro, carros);

				break;

			case "4":
				
				listarVeiculos(teclado, carro, carros);

				break;

			case "0":

				System.out.println("Obrigada por utilizar nosso estacionamento. Volte sempre!");
				break;

			default:
				System.out.print(opcao + "  N�o � uma op��o v�lida. Tente novamente!\n\n");

			}

		} while (!opcao.equals("0"));

	}

}
