package Round2;
/**
 * Nodo
 */
public class Nodo {

	int valor;
	Nodo derecha;
	Nodo izquierda;
	Nodo arriba;
	Nodo abajo;
	
	public Nodo (){
		
		this.setValor(0);
		this.setDerecha(null);
		this.setIzquierda(null);
		this.setArriba(null);
		this.setAbajo(null);
	}
	
	//Getters and Setters
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Nodo getDerecha() {
		return derecha;
	}
	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	public Nodo getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}
	public Nodo getArriba() {
		return arriba;
	}
	public void setArriba(Nodo arriba) {
		this.arriba = arriba;
	}
	public Nodo getAbajo() {
		return abajo;
	}
	public void setAbajo(Nodo abajo) {
		this.abajo = abajo;
	}
	
}
