package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dragonball.model.game.Game;



public class StartNewGameView extends JFrame {


	private JPanel Fighters ;
	private JButton Frieza;
	private JButton Earthling;
	private JButton Sayian;
	private JButton Majin;
	private JButton Namekian;
	private JTextField FighterName;
	
	
	
	public StartNewGameView(){
		
		//Startview =v; add fel constructor wla l2
		setTitle("Adventures of Dragon Ball");
		//exit on pressing X
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		Fighters = new JPanel();
		Fighters.setLayout(new GridLayout(1,5));
		add(Fighters );
		JPanel text = new JPanel();
		JTextArea choose = new JTextArea("Choose your Fighter !!");
		choose.setEditable(false);
		choose.setBackground(Color.BLACK);
		choose.setFont(new Font(Font.SANS_SERIF, 3, 20));
		choose.setForeground(Color.RED);
		text.add(choose);
		text.setBackground(Color.black);
		add(text , BorderLayout.NORTH);
		
		FighterName = new JTextField();
		FighterName.setColumns(20);
		JLabel Pns = new JLabel("Fighter's Name ", JLabel.RIGHT);
		Pns.setLabelFor(FighterName);
		JPanel fieldP = new JPanel(new GridLayout(1,1));
		fieldP.add(Pns);
		fieldP.add(FighterName);
		fieldP.setBackground(Color.BLACK);
		Pns.setFont(new Font(Font.SANS_SERIF, 3, 15));
		Pns.setBackground(Color.BLACK);
		Pns.setForeground(Color.red);
		text.add(fieldP,BorderLayout.EAST);
		
		ImageIcon E = new ImageIcon("eathling.png");
		Earthling= new JButton("Earthling", E);
		Earthling.setName("Earthling");
		Earthling.setFont(new Font(Font.SANS_SERIF, 3, 20));
		Earthling.setForeground(Color.red);
		Earthling.setBackground(Color.BLACK);
		Earthling.setHorizontalTextPosition(JButton.CENTER);
		Earthling.setVerticalTextPosition(JButton.TOP);


		ImageIcon S = new ImageIcon("sayian.png");
		Sayian= new JButton("Sayian", S);
		Sayian.setName("Sayian");
		Sayian.setFont(new Font(Font.SANS_SERIF, 3, 20));
		Sayian.setForeground(Color.red);
		Sayian.setBackground(Color.BLACK);
		Sayian.setHorizontalTextPosition(JButton.CENTER);
		Sayian.setVerticalTextPosition(JButton.TOP);
		
		ImageIcon M = new ImageIcon("majin.png");
		Majin= new JButton("Majin", M);
		Majin.setName("Majin");
		Majin.setFont(new Font(Font.SANS_SERIF, 3, 20));
		Majin.setForeground(Color.red);
		Majin.setBackground(Color.BLACK);
		Majin.setHorizontalTextPosition(JButton.CENTER);
		Majin.setVerticalTextPosition(JButton.TOP);
		
		ImageIcon N = new ImageIcon("namekian.png");
		Namekian= new JButton("Namekian", N);
		Namekian.setName("Namekian");
		Namekian.setFont(new Font(Font.SANS_SERIF, 3, 20));
		Namekian.setForeground(Color.red);
		Namekian.setBackground(Color.BLACK);
		Namekian.setHorizontalTextPosition(JButton.CENTER);
		Namekian.setVerticalTextPosition(JButton.TOP);
		
		ImageIcon F = new ImageIcon("Frieza.png");
		Frieza= new JButton("Frieza", F);
		Frieza.setName("Frieza");
		Frieza.setFont(new Font(Font.SANS_SERIF, 3, 20));
		Frieza.setForeground(Color.red);
		Frieza.setBackground(Color.BLACK);
		Frieza.setHorizontalTextPosition(JButton.CENTER);
		Frieza.setVerticalTextPosition(JButton.TOP);
		
		Frieza.setName("Frieza");
		Sayian.setName("Sayian");
		Namekian.setName("Namekian");
		Majin.setName("Majin");
		Earthling.setName("Earthling");
		
		Fighters.add(Frieza);
		Fighters.add(Earthling);
		Fighters.add(Sayian);
		Fighters.add(Namekian);
		Fighters.add(Majin);
		add(Fighters, BorderLayout.CENTER);
		
		
		this.setVisible(false);
		Sayian.setEnabled(false);
		Majin.setEnabled(false);
		Namekian.setEnabled(false);
		Frieza.setEnabled(false);
		Earthling.setEnabled(false);
		
		
	}
	public JPanel getFighters() {
		return Fighters ;
	}
	
	public JButton getFrieza() {
		return Frieza;
	}
	public JButton getEarthling() {
		return Earthling;
	}
	public JButton getSayian() {
		return Sayian;
	}
	public JButton getMajin() {
		return Majin;
	}
	public JButton getNamekian() {
		return Namekian;
	}
	public void addFighters(JButton x){
		Fighters .add(x);
	}
	public String getFighterName() {
		return FighterName.getText();
	}

	public JTextField getFighterNameField(){
		return FighterName;
	}
	
}
	

