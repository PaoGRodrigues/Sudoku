package Round2;

public class Grilla {

	int tam;
	Nodo inicio;
	
	public Grilla(){
		
		//this.tam = tam;
		
		//INICIO es el nodo de las coordenadas (1,1)
		this.inicio = null;
		
		this.crearSudoku(4,4);
	}
	
	public Nodo getInicio(){
		
		return this.inicio;
	}
	
	//Crea la grilla
	public void crearSudoku(int filas, int columnas){
		
		this.inicio = new Nodo();
		
		Nodo actual = this.inicio;
		
		//se crea el primer nodo de cada fila.
		for(int u = 0; u<filas-1; u++){
			
			Nodo nuevo = new Nodo();
			agregarFila(actual, nuevo);
			actual = nuevo;
		}
		
		actual = this.inicio;
		Nodo primerNodo = this.inicio;
		//se crean los nodos para formar las columnas y se agregan a cada fila.
		for(int j = 0; j<filas; j++){
			
			for(int i = 0; i< columnas-1; i++){
				
				Nodo nuevo = new Nodo();
				agregarNodo(primerNodo, nuevo);
				primerNodo = nuevo;
			}
			
			actual = actual.getAbajo();
			primerNodo = actual;
		}
		
		this.conectarArribaAbajo();
	}
	
	/*******************************************************************************************************************/
	//Size
	public int lengthFila(){
		
		int i = 1;
		Nodo unNodo = this.inicio;
		
		while(unNodo.getDerecha()!=null){
			
			unNodo = unNodo.getDerecha();
			i++;
		}
		
		return i;
	}
	
	//Size Columna
	public int lengthColumna(){
			
		int i = 1;			
		Nodo unNodo = this.inicio;
			
		while(unNodo.getAbajo()!=null){
				
			unNodo = unNodo.getAbajo();				
			i++;
		
		}
			
		return i;
	}
	
	/*******************************************************************************************************************/
	//Agregar todos los nodos de la fila
	public void agregarNodo(Nodo fila, Nodo agrega){
		
		Nodo pivote = fila;
		
		while(pivote.getDerecha()!=null){
			
			pivote = pivote.getDerecha();
		}
		
		agrega.setIzquierda(pivote);
		pivote.setDerecha(agrega);
	}
	
	//Agregar Fila Nueva
	public void agregarFila(Nodo filaActual, Nodo nuevaFila){
		
		Nodo pivote = filaActual;
		
		while(pivote.getAbajo()!=null){
			
			pivote = pivote.getAbajo();
		}
		
		nuevaFila.setArriba(pivote);
		pivote.setAbajo(nuevaFila);
	}

	/*******************************************************************************************************************/
	//Conecta los nodos de cada fila.
	public void conectarArribaAbajo(){
		
		//la primer columna ya esta anidada con su par de abajo/arriba. Arranca por la segunda columna
		Nodo inicio = this.inicio.getDerecha();
		Nodo fila = this.inicio;
		
		while(inicio!=null){
			
			
			while(fila.getAbajo()!=null){
				
				inicio.setAbajo(fila.getAbajo().getDerecha());
				inicio.getAbajo().setArriba(inicio);
				
				inicio = inicio.getAbajo();
				fila = fila.getAbajo();
			
			}
				
			while(inicio.getArriba()!=null){
					
				inicio = inicio.getArriba();
				fila = fila.getArriba();				
			}

			inicio = inicio.getDerecha();
			fila = fila.getDerecha();
		}		
	}
	
	/*******************************************************************************************************************/
	//Ingresar dato: fila y columna se cuentan a partir del 0. Usado para la interfaz.
	public void ingresarDato(int fila, int columna, int dato){
		
		Nodo pivote = this.inicio;
		
		while(fila!=0){
			
			pivote = pivote.getAbajo();
			fila--;
		}
		
		while(columna!=0){
			
			pivote = pivote.getDerecha();
			columna--;
		}
		
		pivote.setValor(dato);
	}

	//Ingresa dato. Usado por solucionador para ingresar dato en el nodo sin necesitar fila/columna
	public void ingresarDato(int dato, Nodo unNodo){
		
		//unNodo tiene que ser el nodo del principio de una fila.
		Nodo pivote = unNodo;
		while(pivote!=null && pivote.getValor()!=0){
				
			pivote = pivote.getDerecha();
		}
		
		pivote.setValor(dato);
	}
	
	public void imprimir(){
		
		Nodo fila = this.inicio;
		Nodo pivote = this.inicio;
		
		for(int i = 0; i<this.lengthFila(); i++){
			
			for(int j = 0; j< this.lengthColumna(); j++){
				
				if(pivote!=null){
					
					System.out.println(pivote.getValor());
					pivote = pivote.getDerecha();
				}
			}
			System.out.println("\n");
			
			if(fila!=null){
				
				fila = fila.getAbajo();
				pivote = fila;
			}
		}
	}

	/*******************************************************************************************************************/
	//Eliminar Fila
	public void eliminarFila(Nodo nodo){
		
		Nodo pivote = nodo;
		
		//El pivote esta al principio de la fila.
		//pivote = this.volverAlInicio(pivote); Este metodo pasa al eliminarFilaColumna
		
		if(pivote.getArriba()!=null && pivote.getAbajo()!=null){
			
			while(pivote!=null){
				
				pivote.getArriba().setAbajo(pivote.getAbajo());
				pivote.getAbajo().setArriba(pivote.getArriba());
				
				pivote = pivote.getDerecha();
			}			
		
		}else if(pivote.getArriba()==null && pivote.getAbajo()!=null){
			
			pivote = pivote.getAbajo();
			
			this.inicio = pivote;
			while(pivote!=null){
				
				pivote.setArriba(null);
				pivote = pivote.getDerecha();
			}
		
		}else if(pivote.getAbajo()==null && pivote.getArriba()!=null){
			
			pivote = pivote.getArriba();
			
			while(pivote!=null){
				
				pivote.setAbajo(null);
				pivote = pivote.getDerecha();
			}
		}else if(pivote.getArriba()==null && pivote.getAbajo()==null){
			
			if(pivote.getDerecha()!=null){
				
				this.inicio = pivote.getDerecha();
				pivote.setDerecha(null);
			}else{
								
				this.inicio = null;
			}
		}
	}
	
	//Recuperar Nodos de la Fila
	public void recuperarFila(Nodo nodo){
		
		Nodo pivote = nodo;
		
		while(pivote!=null){
			
			if(pivote.getArriba()==null && pivote.getIzquierda()==null){
				this.inicio = pivote;
				
				//pivote.getDerecha().setIzquierda(this.inicio);
				
			}else if(pivote.getArriba()==null){
				
				pivote.getAbajo().setArriba(pivote);
				
			}else if(pivote.getAbajo()==null){
				
				pivote.getArriba().setAbajo(pivote);
				
			}else{
				
				pivote.getArriba().setAbajo(pivote);
				pivote.getAbajo().setArriba(pivote);				
			}
			
			pivote = pivote.getDerecha();
		}
	}

	//Recorre la misma fila hasta el inicio.
	public Nodo volverAlInicio(Nodo unNodo){
			
		while(unNodo.getIzquierda()!=null){
			
			unNodo = unNodo.getIzquierda();
		}
		
		return unNodo;
	}
		
	/*******************************************************************************************************************/ 
	//Eliminar Columna
	public void eliminarColumna(Nodo nodo){
		
		Nodo pivote = nodo;
		
		//El pivote esta al principio de la columna.
		//pivote = this.volverArriba(pivote);
		
		if(pivote.getIzquierda()!=null && pivote.getDerecha()!=null){
			
			pivote.getAbajo();
			while(pivote!=null){
				
				pivote.getIzquierda().setDerecha(pivote.getDerecha());
				pivote.getDerecha().setIzquierda(pivote.getIzquierda());
				
				pivote = pivote.getAbajo();
			}			
		
		}else if(pivote.getIzquierda()==null && pivote.getDerecha()!=null){
			
			pivote = pivote.getDerecha();
			this.inicio = this.inicio.getDerecha();
			while(pivote!=null){
				
				pivote.setIzquierda(null);
				pivote = pivote.getAbajo();
			}
		
		}else if(pivote.getDerecha()==null && pivote.getArriba()==null){
			
			pivote = pivote.getAbajo().getIzquierda();
			
			while(pivote!=null){
				
				pivote.setDerecha(null);
				pivote = pivote.getAbajo();
			}
		}
	}
	
	//Recuperar Nodos de la Fila
	public void recuperarColumna(Nodo nodo){
		
		Nodo pivote = nodo;
		
		while(pivote!=null){
			
			if(pivote.getIzquierda()==null && pivote.getArriba()==null){
				this.inicio = pivote;
				
				//pivote.getAbajo().setArriba(this.inicio);
			
			}else if(pivote.getIzquierda()==null){
			
				pivote.getDerecha().setIzquierda(pivote);
			
			}else if(pivote.getDerecha()==null){
				
				pivote.getIzquierda().setDerecha(pivote);
			
			}else{
				
				pivote.getDerecha().setIzquierda(pivote);
				pivote.getIzquierda().setDerecha(pivote);
			}
					
			pivote = pivote.getAbajo();
		}
	}

	//Recorre la misma columna hasta arriba.
	public Nodo volverArriba(Nodo unNodo){
			
		while(unNodo.getArriba()!=null){
			
			unNodo = unNodo.getArriba();
		}
		
		return unNodo;
	}
		
	/*******************************************************************************************************************/

	public boolean filaContieneDato (Nodo inicio, int dato){
		
		int i = 0;
		while(inicio.getDerecha()!=null){
			
			inicio = inicio.getDerecha();
			if(inicio.getValor()==dato){
				
				i = 1;
			}
		}
		
		return (i==1);
	}
	
	public int cantidadNodosVacios(Nodo unNodo){
		
		unNodo = this.volverAlInicio(unNodo);
		
		int i = 0;
		while(unNodo!=null){
			
			if(unNodo.getValor()==0){
				
				i++;
			}
			
			unNodo = unNodo.getDerecha();
		}
		
		return i;
	}
	
	//Teniendo el dato, busca en los nodos hasta encontrar el que tiene el dato.
	public Nodo buscarDato(int dato){
		
		Nodo nodo = this.inicio;
		
		while(nodo!=null && nodo.getValor()!=dato){
			
				
			if(nodo.getDerecha()!=null){
				
				nodo = nodo.getDerecha();
					
			}else{
					
				nodo = this.volverAlInicio(nodo);
				nodo = nodo.getAbajo();
			}				
			
		}
		
		return nodo;
	}
	
	//ELimina Fila y columna teniendo el dato.
	public Nodo eliminarFilaColumna(int dato){
		
		Nodo nodoDato = this.buscarDato(dato);
		if(nodoDato !=null){
			
			Nodo nodoFila = this.volverAlInicio(nodoDato);
			Nodo nodoColumna = this.volverArriba(nodoDato);
			this.eliminarFila(nodoFila);
			this.eliminarColumna(nodoColumna);			
		}
		return nodoDato;
	}
	
	//Recupera Fila y Columna
	public void recuperarFilaColumna(Nodo unNodo){
		
		Nodo nodoFila = this.volverAlInicio(unNodo);
		Nodo nodoColumna = this.volverArriba(unNodo);
		this.recuperarColumna(nodoColumna);
		this.recuperarFila(nodoFila);

	}

	//Recorre filas y columnas y completa con el dato sugerido.
	public void completarNumero(int dato){
		
		Nodo elEliminado = null;
		
		if(this.cantidadNodosVacios(this.inicio)==1 && !this.filaContieneDato(this.inicio, dato)){
			
			this.ingresarDato(dato, this.inicio);
		}
						
			
		if(this.lengthColumna()!=1){
				//---
			elEliminado = this.eliminarFilaColumna(dato);
			if(this.cantidadNodosVacios(this.inicio)==1){
					
				//---
				Nodo pivote = this.inicio;
				while(pivote!=null && pivote.getValor()!=0){
					
					pivote = pivote.getDerecha();
				}
				
				this.ingresarDato(dato, pivote);
					
			}
				
			if(this.inicio.getArriba()!=null || this.inicio.getAbajo()!=null){
					
				this.completarNumero(dato);
			}
				
			if(this.cantidadNodosVacios(this.inicio) ==1 && !this.filaContieneDato(this.inicio, dato)){
					
				this.ingresarDato(dato, this.inicio);
			}
		}
		
		if(this.cantidadNodosVacios(this.inicio)==1 && !this.filaContieneDato(this.inicio, dato)){
			
			this.ingresarDato(dato, this.inicio);
		}
		
		this.recuperarFilaColumna(elEliminado);
	}

	public void resolver(){

		for(int i=1; i<this.lengthFila(); i++){
			
			this.completarNumero(i);
		}
	}
}



