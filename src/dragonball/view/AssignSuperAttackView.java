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

import dragonball.model.attack.SuperAttack;
import dragonball.model.game.Game;

public class AssignSuperAttackView extends JFrame {
	

	private JPanel SuperAttacksPanel;
	private JPanel SuperAttacks;
	private JLabel SuperAttackLabel;
	private ArrayList<JButton> SuperAttacksArray;
	
	private JButton GoBack;
	
	
	
	public AssignSuperAttackView()
	{
		setTitle("Assign Attacks");
		setBounds(50,50,800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new GridLayout(1,1));
		setBackground(Color.BLACK);
		//setVisible(true);
		
		SuperAttacksPanel = new JPanel(new BorderLayout());
		SuperAttacksPanel.setBackground(Color.BLACK);
		SuperAttacks = new JPanel(new GridLayout(5, 0));
		SuperAttacks.setBackground(Color.BLACK);
		SuperAttackLabel = new JLabel("Assign a SuperAttack");
		SuperAttackLabel.setBackground(Color.BLACK);
		SuperAttackLabel.setForeground(Color.RED);
	    SuperAttackLabel.setFont(new Font(Font.SANS_SERIF, 3, 20));
	      
		
		
		SuperAttacksPanel.add(SuperAttacks, BorderLayout.CENTER);
		SuperAttacksPanel.add(SuperAttackLabel, BorderLayout.NORTH);
		
		
		
		   GoBack = new JButton("Back");
	       GoBack.setName("BackAssignS");
	       GoBack.setBackground(Color.BLACK);
	       GoBack.setOpaque(true);
	       GoBack.setFocusPainted(false);
	       GoBack.setBorder(null);
	       GoBack.setForeground(Color.RED);
	       GoBack.setPreferredSize(new Dimension(5, 20));
	       GoBack.setFont(new Font(Font.SANS_SERIF, 3, 15));
	       SuperAttacksPanel.add(GoBack, BorderLayout.SOUTH);
	       
	       add(SuperAttacksPanel);
	}
	
	public void addSuperAttack(JButton B)
	{
		SuperAttacks.add(B);
		repaint();
		revalidate();
	}
	
	public void displayPlayerAttacks(Game CurrentGame)
	{
		  SuperAttacksArray = new ArrayList<JButton>();
			
	       for ( SuperAttack superattack : CurrentGame.getPlayer().getSuperAttacks()) {
			JButton SuperAttackbutton = new JButton();
			SuperAttackbutton.setText(superattack.getName());
			SuperAttackbutton.setName("AssignSuperAttack");
			SuperAttackbutton.setBackground(Color.BLACK);
			SuperAttackbutton.setForeground(Color.RED);
			SuperAttackbutton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15 ));
			addSuperAttack(SuperAttackbutton);
			SuperAttacksArray.add(SuperAttackbutton);
			
		}
	}
	
	public void updateLabel(Game g)
	{
		SuperAttackLabel.setText("You Currently Have No Super Attacks!");
	}
	
	public JPanel getSuperAttacksPanel() {
		return SuperAttacksPanel;
	}

	public JPanel getSuperAttacks() {
		return SuperAttacks;
	}

	public JLabel getSuperAttackLabel() {
		return SuperAttackLabel;
	}

	public JButton getGoBack() {
		return GoBack;
	}

	public ArrayList<JButton> getSuperAttacksArray() {
		return SuperAttacksArray;
	}

	public static void main(String[] args) {
		new AssignSuperAttackView();
	}

}