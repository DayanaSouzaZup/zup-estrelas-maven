package br.com.zup.carroDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.zup.carroPOJO.Carro;
import br.com.zup.connectionFactory.ConnectionFactory;

public class CarroDao {

	EntityManager manager;

	public CarroDao() {

		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("carros");
		this.manager = managerFactory.createEntityManager();

	}

	public void registrarEntradaVeiculo(Carro carros) {

		manager.getTransaction().begin();
		manager.persist(carros);
		manager.getTransaction().commit();
	}

	public void registrarSaidaVeiculo(String placa) {

		Carro carroSai = manager.find(Carro.class, placa);

		manager.getTransaction().begin();
		manager.remove(carroSai);
		manager.getTransaction().commit();
	}

	public Carro buscaCarroEstacionado(String placa) {

		Carro carroEstacionado = manager.find(Carro.class, placa);

		return carroEstacionado;

	}

	public List<Carro> carrosEstacionados() {

		Query query = manager.createQuery("select c from Carro as c");

		List<Carro> listaCarros = query.getResultList();

		return listaCarros;

	}

	public List<Carro> listaCarroFabricante(String fabricante) {

		Query query = manager.createQuery("select c from Carro as c where c.fabricante =: fabricante");

		query.setParameter("fabricante", fabricante);

		List<Carro> listarCarrosFabricante = query.getResultList();

		return listarCarrosFabricante;
	}

	/*
	 * private Connection conn;
	 * 
	 * public CarroDao() { this.conn = new ConnectionFactory().getConnection(); }
	 * 
	 * public void registrarEntradaVe�culo(Carro carros) { String sql =
	 * "insert into descricao_carro" + "(placa, cor, fabricante, modelo)" +
	 * "values (?, ?, ?, ?)";
	 * 
	 * try { PreparedStatement stmt = conn.prepareStatement(sql);
	 * 
	 * stmt.setString(1, carros.getPlaca()); stmt.setString(2, carros.getCor());
	 * stmt.setString(3, carros.getFabricante()); stmt.setString(4,
	 * carros.getModelo());
	 * 
	 * stmt.execute(); stmt.close();
	 * System.out.println("\nVe�culo registrado com sucesso!\n");
	 * 
	 * } catch (SQLException e) {
	 * 
	 * System.out.println(
	 * "\nN�o foi poss�vel registrar o ve�culo. Verifique se o dados foram inseridos corretamente.\n "
	 * ); System.out.println(e.getMessage()); } }
	 * 
	 * 
	 * public void registrarSaidaVe�culo(String placa) {
	 * 
	 * try { String sql = "delete from descricao_carro where placa = ?";
	 * 
	 * PreparedStatement stmt = conn.prepareStatement(sql);
	 * 
	 * stmt.setString(1, placa);
	 * 
	 * stmt.execute(); stmt.close();
	 * 
	 * System.out.println("\nRegistrada a sa�da do ve�culo!");
	 * 
	 * } catch (SQLException e) { System.out.
	 * println("\nN�o foi poss�vel registrar a sa�da do ve�culo. Verifique a placa informada\n"
	 * ); System.out.println(e.getMessage()); }
	 * 
	 * }
	 * 
	 * public Carro buscaCarroPorPlaca(String placa) { Carro carro = new Carro();
	 * 
	 * String sql = "select * from descricao_carro where placa = ?";
	 * 
	 * try { PreparedStatement stmt = conn.prepareStatement(sql);
	 * 
	 * stmt.setString(1, placa);
	 * 
	 * ResultSet rs = stmt.executeQuery();
	 * 
	 * while (rs.next()) {
	 * 
	 * carro.setPlaca(rs.getString("placa")); carro.setCor(rs.getString("cor"));
	 * carro.setFabricante(rs.getString("fabricante"));
	 * carro.setModelo(rs.getString("modelo"));
	 * 
	 * }
	 * 
	 * } catch (SQLException e) {
	 * 
	 * System.out.println("\nPlaca inv�lida ou ocorreu algum erro na busca.\n");
	 * System.out.println(e.getMessage()); }
	 * 
	 * return carro; }
	 * 
	 * public List<Carro> listarVeiculosEstacionados() {
	 * 
	 * List<Carro> listaVeiculos = new ArrayList<Carro>(); String sql =
	 * "select * from descricao_carro";
	 * 
	 * try { PreparedStatement stmt = conn.prepareStatement(sql);
	 * 
	 * ResultSet rs = stmt.executeQuery();
	 * 
	 * while (rs.next()) {
	 * 
	 * Carro carrosEstacionados = new Carro();
	 * 
	 * carrosEstacionados.setPlaca(rs.getString("placa"));
	 * carrosEstacionados.setCor(rs.getString("cor"));
	 * carrosEstacionados.setFabricante(rs.getString("fabricante"));
	 * carrosEstacionados.setModelo(rs.getString("modelo"));
	 * listaVeiculos.add(carrosEstacionados);
	 * 
	 * }
	 * 
	 * } catch (SQLException e) {
	 * 
	 * System.out.
	 * println("\nErro ao listar ve�culos estacionados. Tente novamente!\n");
	 * System.out.println(e.getMessage()); }
	 * 
	 * return listaVeiculos;
	 * 
	 * }
	 */
}
