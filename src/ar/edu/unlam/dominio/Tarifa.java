package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Tarifa {
	
	private Integer id;
	private LocalDateTime desde;
	private LocalDateTime hasta;
	private Double valor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDesde() {
		return desde;
	}
	public void setDesde(LocalDateTime desde) {
		this.desde = desde;
	}
	public LocalDateTime getHasta() {
		return hasta;
	}
	public void setHasta(LocalDateTime hasta) {
		this.hasta = hasta;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	

}

//        desde    hasta

// 1   1/7/2025  31/7/2025    valor 1000.0
// 2   1/8/2025  2/9/2025       valor 1100.0
// 3   3/9/2025   null





