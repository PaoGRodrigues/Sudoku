package Round2;

public class Verificador {

	int[][] cuadricula = null;
	
	public Verificador(Grilla sudoku){
		
		int i = sudoku.getSize();
		this.cuadricula = new int[i][i-1];
	}
	
	public void verificar(Grilla sudoku){
		
		//Rellena si hay repetidos en las filas.
		int i = 0;
		Nodo pivote = sudoku.getInicio();
		while(pivote!=null){
			
			repetidosFila(pivote, i);
			pivote = pivote.getAbajo();
			i++;
		}
		
		i = 0;
		pivote = sudoku.getInicio();
		while(pivote!=null){
			
			repetidosColumna(pivote, i);
			pivote = pivote.getDerecha();
			i++;
		}
		
	}
	
	public void repetidosFila(Nodo inicioFila, int numFila){
		
		Nodo pivote = inicioFila;
		int j = 0;
		int tam = this.cuadricula.length;
		
		for(int i = 1; i<=tam; i++){
			
			j=0;
			pivote = inicioFila;
			
			if(this.cantidadFilaValor(pivote, i)>1){
				
				while(j<this.cuadricula.length){
					
					if(pivote.getValor()==i){
						
						this.cuadricula[numFila][j] = i;
					}
					j++;
					pivote = pivote.getDerecha();
				}
			}
		}
	}
	
	private int cantidadFilaValor(Nodo inicio, int valor){
		
		Nodo pivote = inicio;
		int i = 0;
		
		while(pivote!=null){
			
			if(pivote.getValor()==valor){
				
				i++;
			}
			
			pivote = pivote.getDerecha();
		}
		
		return i;
	}

	private int cantidadColumnaValor(Nodo inicio, int valor){
		
		Nodo pivote = inicio;
		int i = 0;
		
		while(pivote!=null){
			
			if(pivote.getValor()==valor){
				
				i++;
			}
		
			pivote = pivote.getAbajo();
		}
		
		return i;
	}
	
	public void repetidosColumna(Nodo inicioColumna, int numColumna){
		
		Nodo pivote = inicioColumna;
		int j = 0;
		int tam = this.cuadricula.length;
		
		for(int i = 1; i<=tam; i++){
			
			j = 0;
			pivote = inicioColumna;
			
			if(this.cantidadColumnaValor(pivote, i)>1){
				
				while(j<this.cuadricula.length){
					
					if(pivote.getValor()==i){
						
						this.cuadricula[j][numColumna] = i;
					}
					
					j++;
					pivote = pivote.getAbajo();
				}
			}
		}
	}

	private int cantidadFilaCol(Nodo inicio, int valor){
		
		Nodo pivote = inicio;
		int i = 0;
		int fila = 2;
		int columna = 2;
		
		while(nodoActual!=0){
			
			//BUUUU
			
			nodoActual--;
		}
	}
	
	public void imprimirCuadricula(){
		
		for(int i = 0; i<this.cuadricula.length-1;i++){
			
			for(int j = 0; j< this.cuadricula[i].length-1; j++){
				
				System.out.print(this.cuadricula[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
