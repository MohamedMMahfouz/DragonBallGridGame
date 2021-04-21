package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.attack.UltimateAttack;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;



public class AssignUltimateAttackView extends JFrame{
	
	private JPanel UltimateAttacksPanel;
	private JPanel UltimateAttacks;
	private JLabel UltimateAttacksLabel;
	private ArrayList<JButton> SuperAttacksArray;
	private ArrayList<JButton> UltimateAttacksArray;
	
	private JButton GoBack;
	
	
	public AssignUltimateAttackView()
	{
		setTitle("Assign Attacks");
		setBounds(50,50,800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new GridLayout(1,1));
		setBackground(Color.BLACK);
		//setVisible(true);
	
	
		
		UltimateAttacksPanel = new JPanel(new BorderLayout());
		UltimateAttacksPanel.setBackground(Color.BLACK);
		UltimateAttacks = new JPanel(new GridLayout(1, 2));
		UltimateAttacks.setBackground(Color.BLACK);
		UltimateAttacksLabel = new JLabel("Assign a UltimateAttack");
		UltimateAttacksLabel.setBackground(Color.BLACK);
		UltimateAttacksLabel.setForeground(Color.RED);
	    UltimateAttacksLabel.setFont(new Font(Font.SANS_SERIF, 3, 20));
		
		
		UltimateAttacksPanel.add(UltimateAttacksLabel, BorderLayout.NORTH);
		UltimateAttacksPanel.add(UltimateAttacks, BorderLayout.CENTER);
		
		
		 GoBack = new JButton("Back");
	       GoBack.setName("BackAssignU");
	       GoBack.setBackground(Color.BLACK);
	       GoBack.setOpaque(true);
	       GoBack.setFocusPainted(false);
	       GoBack.setBorder(null);
	       GoBack.setForeground(Color.RED);
	       GoBack.setPreferredSize(new Dimension(5, 20));
	       GoBack.setFont(new Font(Font.SANS_SERIF, 3, 15));
	       UltimateAttacksPanel.add(GoBack, BorderLayout.SOUTH);
	       
	       
		add(UltimateAttacksPanel);
		
		
			
				
	}
	
	
	public void addUltimateAttack( JButton b)
	{
		UltimateAttacks.add(b);
		repaint();
		revalidate();
		
	}
	
	public void displayPlayerUltimateAtt(Game CurrentGame)
	{
		   UltimateAttacksArray = new ArrayList<JButton>();
	       for ( UltimateAttack ultimateattack : CurrentGame.getPlayer().getUltimateAttacks()) {
				JButton UaB = new JButton();
				UaB.setText(ultimateattack.getName());
				UaB.setName("AssignUltimateAttack");
				UaB.setBackground(Color.BLACK);
				UaB.setForeground(Color.RED);
				UaB.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15 ));
				addUltimateAttack(UaB);
				UltimateAttacksArray.add(UaB);
				
				
			}
	       
	}
	public void updateLabel(Game g)
	{
		UltimateAttacksLabel.setText("You Currently Have No Ultimate Attacks!");
	}
	
	
	public JPanel getUltimateAttacksPanel() {
		return UltimateAttacksPanel;
	}


	public JButton getGoBack() {
		return GoBack;
	}


	public JPanel getUltimateAttacks() {
		return UltimateAttacks;
	}


	public JLabel getUltimateAttacksLabel() {
		return UltimateAttacksLabel;
	}


	public ArrayList<JButton> getSuperAttacksArray() {
		return SuperAttacksArray;
	}


	public ArrayList<JButton> getUltimateAttacksArray() {
		return UltimateAttacksArray;
	}


	public static void main(String[] args) {
		new AssignUltimateAttackView();
	}

}



