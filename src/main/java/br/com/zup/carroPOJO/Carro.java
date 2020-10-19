package br.com.zup.carroPOJO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {

	@Id
	private String placa;
	private String cor;
	private String fabricante;
	private String modelo;

	public Carro(String placa, String cor, String fabricante, String modelo) {
		this.placa = placa;
		this.cor = cor;
		this.fabricante = fabricante;
		this.modelo = modelo;
	}

	public Carro() {

	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String toString() {
		return "placa= " + placa + ", " + "cor= " + cor + ", " + "fabricante= " + fabricante + ", " + "modelo= " + modelo
				+ "";
	}

}
