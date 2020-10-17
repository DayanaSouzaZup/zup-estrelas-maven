package br.com.zup.carroDAO;

import java.sql.Connection;

import br.com.zup.connectionFactory.ConnectionFactory;

public class CarroDao {

	private Connection conn;

	public CarroDao() {
		this.conn = new ConnectionFactory().get.Connection();
	}

}