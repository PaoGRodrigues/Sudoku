package Round2;

import javax.swing.JTextField;

/**
 * Nodo
 */
public class Nodo {

	int valor;
	Nodo derecha;
	Nodo izquierda;
	Nodo arriba;
	Nodo abajo;
	
	//interfaz
	JTextField casilla;
	
	public Nodo (){
		
		this.casilla = new JTextField();
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
		this.casilla.setText(Integer.toString(valor));
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
	
	public JTextField getCasilla(){
		return this.casilla;
	}
	
	public void setOnlyValor(int valor){
		
		this.valor = valor;
	}
}
