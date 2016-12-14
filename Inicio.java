package Round2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class Inicio extends JFrame implements ActionListener{
	
	JPanel panel=(JPanel)this.getContentPane();
	JButton comenzar, cancelar;
	JLabel indicacion;
	JRadioButton chico, grande;
	ButtonGroup grupo;
	Border border=BorderFactory.createLineBorder(Color.black,1);
	Grilla sudoku;
	
	public Inicio(){
		panel.setLayout(null); 
		panel.setBackground(Color.lightGray);
		this.setTitle("Sudoku");
		
		indicacion=new JLabel("Ingrese las dimensiones para el nuevo juego");
		indicacion.setBounds(60, 30, 290, 50);
		panel.add(indicacion);
		
		//Grupo de RadioButtons
		grupo = new ButtonGroup();
		
		chico=new JRadioButton();
		chico.setHorizontalAlignment(JRadioButton.CENTER);
		chico.setBounds(120, 90, 60, 20);
		chico.setText("4x4");
		chico.setVisible(true);
		chico.setSelected(true);
		panel.add(chico);
		grupo.add(chico);
		
		grande=new JRadioButton();
		grande.setHorizontalAlignment(JRadioButton.CENTER);
		grande.setBounds(120, 130, 60, 20);
		grande.setText("9x9");
		grande.setVisible(true);
		panel.add(grande);
		grupo.add(grande);
		
		//Boton para continuar
		comenzar=new JButton("Comenzar");
		comenzar.setLayout(null);
		comenzar.setMnemonic(KeyEvent.VK_C);
		comenzar.setBounds(88, 190, 95, 29);
		panel.add(comenzar);
		comenzar.addActionListener(this);
		
		//Boton para cancelar
		cancelar=new JButton("Cancelar");
		cancelar.setLayout(null);
		cancelar.setMnemonic(KeyEvent.VK_R);
		cancelar.setBounds(195, 190, 95, 29);
		panel.add(cancelar);
		cancelar.addActionListener(this);
		
		//Variables de la pantalla
		this.setLocation(440, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setResizable(true);
		setName("Sudoku");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comenzar){
			//Deberia preguntar si lo quiero de 4x4 o 9x9
			new Grilla2(9,9);
		}
		if(e.getSource()==cancelar){
			this.dispose();
		}
	}
}
