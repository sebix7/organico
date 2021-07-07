package ar.edu.unlam.tallerweb1.modelo;

public class VerDetalleViewModel {

private long id;
	
	private String nombre;
	
	private Integer stock;
	
	private Boolean tieneDescuento ;
	
	private Integer cantidadMensajesNoLeidos;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getTieneDescuento() {
		return tieneDescuento;
	}

	public void setTieneDescuento(Boolean tieneDescuento) {
		this.tieneDescuento = tieneDescuento;
	}

	public Integer getCantidadMensajesNoLeidos() {
		return cantidadMensajesNoLeidos;
	}

	public void setCantidadMensajesNoLeidos(Integer cantidadMensajesNoLeidos) {
		this.cantidadMensajesNoLeidos = cantidadMensajesNoLeidos;
	}
	
}
