package Round2;


import org.junit.Assert;
import org.junit.Test;

public class GrillaTest {

	Grilla grilla = new Grilla(4,4);
	Grilla grilla2 = new Grilla(9,9);
	Nodo aux = null;
	
	Verificador ver = new Verificador(this.grilla2);
	
	//Creacion
	@Test
	public void creacion() {
		
		this.grilla.crearSudoku(4, 4);
		this.grilla2.crearSudoku(9, 9);
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
		//this.grilla.imprimir();
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
	
	//Prueba con matrices de 2 y 1 celda
	@Test
	public void matricesRaras2(){
			
		this.grilla.crearSudoku(2, 2);
		this.grilla.ingresarDato(1, 0, 2);
		this.grilla.ingresarDato(1, 1, 1);
		this.grilla.completarNumero(1);
		this.grilla.completarNumero(2);
		//this.grilla.imprimir();
	}
	
	@Test
	public void matricesRaras3(){
			
		this.grilla.crearSudoku(2, 2);
		this.grilla.ingresarDato(0, 0, 2);
		this.grilla.ingresarDato(1, 1, 2);
		this.grilla.completarNumero(1);
		this.grilla.completarNumero(2);
		//this.grilla.imprimir();
	}
	
	@Test
	public void matricesRaras4(){
			
		this.grilla.crearSudoku(2, 2);
		this.grilla.ingresarDato(0, 1, 2);
		this.grilla.ingresarDato(1, 0, 2);
		this.grilla.completarNumero(1);
		this.grilla.completarNumero(2);
		//this.grilla.imprimir();
	}
	
	@Test
	public void recursividad2(){
		
		this.ingresarDatosCeldas();
		this.grilla.completarNumero(1);
		this.grilla.completarNumero(2);
		this.grilla.completarNumero(3);
		this.grilla.completarNumero(4);
		//this.grilla.imprimir();
		
	}
	
	//La final
	@Test
	public void solucionadorDefinitivo(){
		
		this.ingresarDatosCeldas();
		Assert.assertEquals(4, this.grilla.lengthFila());
		//this.grilla.resolver();
		//this.grilla.imprimir();
	}
	
	//Con un 9x9
	@Test
	public void solucionar9x9(){
		
		Assert.assertEquals(9, this.grilla2.lengthFila());
		Assert.assertEquals(9, this.grilla2.lengthColumna());
		
		this.grilla2.ingresarDato(0,1,9);
		this.grilla2.ingresarDato(0,2,4);
		this.grilla2.ingresarDato(0,3,7);
		this.grilla2.ingresarDato(0,4,8);
		this.grilla2.ingresarDato(0,6,5);
		this.grilla2.ingresarDato(0,7,3);
		this.grilla2.ingresarDato(0,8,1);
		
		this.grilla2.ingresarDato(1,0,2);
		this.grilla2.ingresarDato(1,4,1);
		this.grilla2.ingresarDato(1,5,3);
		this.grilla2.ingresarDato(1,8,9);
		
		this.grilla2.ingresarDato(2,0,5);
		this.grilla2.ingresarDato(2,1,1);
		this.grilla2.ingresarDato(2,3,4);
		this.grilla2.ingresarDato(2,5,9);
		this.grilla2.ingresarDato(2,6,2);
		this.grilla2.ingresarDato(2,7,8);
		
		this.grilla2.ingresarDato(3,0,4);
		this.grilla2.ingresarDato(3,2,1);
		this.grilla2.ingresarDato(3,3,2);
		this.grilla2.ingresarDato(3,4,5);
		this.grilla2.ingresarDato(3,6,9);
		this.grilla2.ingresarDato(3,7,7);
		this.grilla2.ingresarDato(3,8,3);
		
		this.grilla2.ingresarDato(4,0,9);
		this.grilla2.ingresarDato(4,1,8);
		this.grilla2.ingresarDato(4,3,3);
		this.grilla2.ingresarDato(4,5,6);
		this.grilla2.ingresarDato(4,7,2);
		this.grilla2.ingresarDato(4,8,5);
		
		this.grilla2.ingresarDato(5,1,5);
		this.grilla2.ingresarDato(5,2,2);
		this.grilla2.ingresarDato(5,4,9);
		this.grilla2.ingresarDato(5,5,7);
		this.grilla2.ingresarDato(5,6,4);
		this.grilla2.ingresarDato(5,8,8);
		
		this.grilla2.ingresarDato(6,0,8);
		this.grilla2.ingresarDato(6,1,2);
		this.grilla2.ingresarDato(6,3,9);
		this.grilla2.ingresarDato(6,5,5);
		this.grilla2.ingresarDato(6,7,1);
		this.grilla2.ingresarDato(6,8,4);
		
		this.grilla2.ingresarDato(7,1,4);
		this.grilla2.ingresarDato(7,2,9);
		this.grilla2.ingresarDato(7,4,3);
		this.grilla2.ingresarDato(7,5,1);
		this.grilla2.ingresarDato(7,6,8);
		
		this.grilla2.ingresarDato(8,1,3);
		this.grilla2.ingresarDato(8,2,5);
		this.grilla2.ingresarDato(8,3,8);
		this.grilla2.ingresarDato(8,5,4);
		this.grilla2.ingresarDato(8,6,7);
		this.grilla2.ingresarDato(8,7,9);
		this.grilla2.ingresarDato(8,8,6);
		
		this.grilla2.resolver();
		this.grilla2.imprimir();
	}

	@Test
	public void solucionar9x9num2(){
		
		Assert.assertEquals(9, this.grilla2.lengthFila());
		Assert.assertEquals(9, this.grilla2.lengthColumna());
		
		this.grilla2.ingresarDato(0,1,1);
		this.grilla2.ingresarDato(0,2,3);
		this.grilla2.ingresarDato(0,4,9);
		this.grilla2.ingresarDato(0,5,4);
		this.grilla2.ingresarDato(0,8,8);
		
		this.grilla2.ingresarDato(1,0,9);
		this.grilla2.ingresarDato(1,3,8);
		this.grilla2.ingresarDato(1,5,2);
		this.grilla2.ingresarDato(1,6,7);
		this.grilla2.ingresarDato(1,8,4);
		
		this.grilla2.ingresarDato(2,2,8);
		this.grilla2.ingresarDato(2,4,5);
		this.grilla2.ingresarDato(2,7,2);
		this.grilla2.ingresarDato(2,8,1);
		
		this.grilla2.ingresarDato(3,0,5);
		this.grilla2.ingresarDato(3,1,2);
		this.grilla2.ingresarDato(3,3,1);
		this.grilla2.ingresarDato(3,4,7);
		this.grilla2.ingresarDato(3,6,8);
		this.grilla2.ingresarDato(3,8,3);
		
		this.grilla2.ingresarDato(4,1,8);
		this.grilla2.ingresarDato(4,2,4);
		this.grilla2.ingresarDato(4,5,5);
		this.grilla2.ingresarDato(4,6,1);
		this.grilla2.ingresarDato(4,8,9);
		
		this.grilla2.ingresarDato(5,2,7);
		this.grilla2.ingresarDato(5,3,4);
		this.grilla2.ingresarDato(5,4,8);
		this.grilla2.ingresarDato(5,7,6);
		
		this.grilla2.ingresarDato(6,0,8);
		this.grilla2.ingresarDato(6,1,5);
		this.grilla2.ingresarDato(6,5,7);
		this.grilla2.ingresarDato(6,7,9);
		this.grilla2.ingresarDato(6,8,2);
		
		this.grilla2.ingresarDato(7,4,4);
		this.grilla2.ingresarDato(7,6,5);
		
		this.grilla2.ingresarDato(8,1,7);
		this.grilla2.ingresarDato(8,2,9);
		this.grilla2.ingresarDato(8,3,5);
		this.grilla2.ingresarDato(8,5,8);
		this.grilla2.ingresarDato(8,6,3);
		this.grilla2.ingresarDato(8,8,6);
		
		this.grilla2.resolver();
		this.grilla2.imprimir();
	}
	
	@Test
	public void numerosRepetidos(){
		
		this.grilla2.ingresarDato(0, 0, 1);
		this.grilla2.ingresarDato(0, 1, 1);
		this.grilla2.ingresarDato(0, 7, 1);
		this.grilla2.ingresarDato(3, 0, 1);
		
		this.ver.verificar(this.grilla2);
		this.ver.imprimirCuadricula();
		
	}
}
