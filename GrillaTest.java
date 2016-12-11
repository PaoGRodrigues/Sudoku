package Round2;


import org.junit.Assert;
import org.junit.Test;

public class GrillaTest {

	Grilla grilla = new Grilla();
	Nodo aux = null;
	
	//Creacion
	@Test
	public void creacion() {
		
		this.grilla.crearSudoku(4, 4);
	}

	//Size filas/columnas
	@Test
	public void taman() {
		
		this.creacion();
		
		Assert.assertEquals(4, this.grilla.lengthFila());
		Assert.assertEquals(4, this.grilla.lengthColumna());
	}

	//Size filas/columnas
	@Test
	public void taman2() {
			
		grilla.crearSudoku(9, 9);			
		
		Assert.assertEquals(9, this.grilla.lengthFila());
		Assert.assertEquals(9, this.grilla.lengthColumna());
	}
	
	//Relleno de celdas e impresion
	@Test
	public void ingresarDatosCeldas() {
					
		this.creacion();
		
		this.grilla.ingresarDato(0, 0, 3);
		this.grilla.ingresarDato(0, 2, 4);
		this.grilla.ingresarDato(1, 1, 1);
		this.grilla.ingresarDato(1, 3, 3);
		this.grilla.ingresarDato(2, 0, 2);
		this.grilla.ingresarDato(2, 1, 3);
		this.grilla.ingresarDato(3, 0, 1);
		this.grilla.ingresarDato(3, 3, 2);
		
		//this.grilla.imprimir();
	}
	
	//Eliminacion de celdas e impresion
	@Test
	public void eliminarCeldasIntermedias() {
						
		this.ingresarDatosCeldas();
		
		//this.grilla.imprimir();
		
		this.aux = this.grilla.eliminarFilaColumna(1);
		Assert.assertEquals(3, this.grilla.lengthColumna());
		Assert.assertEquals(3, this.grilla.lengthFila());
		//this.grilla.imprimir();
		System.out.println("....................");
	}
	
	//Eliminacion y recuperacion
	@Test
	public void eliminarCeldasFila1(){
		
		this.ingresarDatosCeldas();
		
		this.aux = this.grilla.eliminarFilaColumna(3);
		this.grilla.recuperarFilaColumna(this.aux);
		//this.grilla.imprimir();
	}
	
	//Eliminacion y recuperacion
	@Test
	public void eliminarCeldasUltimaFila(){
		
		this.creacion();
		
		this.grilla.ingresarDato(0, 0, 3);
		this.grilla.ingresarDato(0, 2, 4);
		this.grilla.ingresarDato(1, 1, 1);
		this.grilla.ingresarDato(1, 3, 3);
		this.grilla.ingresarDato(2, 0, 2);
		this.grilla.ingresarDato(2, 1, 3);
		this.grilla.ingresarDato(3, 0, 1);
		this.grilla.ingresarDato(3, 2, 6); //Comprobamos que elimina la ultima fila/columna
		
		this.aux = this.grilla.eliminarFilaColumna(6);
		this.grilla.recuperarFilaColumna(this.aux);
		//this.grilla.imprimir();
	}
	
	//Insertar numero
	@Test
	public void recursividad(){
		
		this.ingresarDatosCeldas();
		this.grilla.completarNumero(1);
		
		//this.grilla.imprimir();
	}
	
	//Prueba con matrices de 2 y 1 celda
	@Test
	public void matricesRaras(){
		
		this.grilla.crearSudoku(2, 2);
		this.grilla.ingresarDato(0, 0, 2);
		this.grilla.ingresarDato(0, 1, 1);
		this.grilla.completarNumero(1);
		this.grilla.completarNumero(2);
		//this.grilla.imprimir();
	}
	
	
	@Test
	public void recursividad2(){
		
		this.ingresarDatosCeldas();
		this.grilla.completarNumero(1);
		this.grilla.completarNumero(2);
		this.grilla.imprimir();
		this.grilla.completarNumero(3);
		
	}
	
	/**
	//La final
	@Test
	public void solucionadorDefinitivo(){
		
		this.ingresarDatosCeldas();
		this.grilla.resolver();
	}*/
}
