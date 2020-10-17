package br.com.zup.programaPrincipal;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.zup.connectionFactory.ConnectionFactory;

public class ProgramaPrincipal {

	public static void main(String[] args) throws SQLException {
		Connection conn = new ConnectionFactory().getConnection();
		System.out.println("Conectado!");
		conn.close();
		}

	}


