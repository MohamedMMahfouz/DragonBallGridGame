package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import dragonball.model.game.Game;

public class MyAttacks extends JFrame {
	
	private JPanel SuperAttacksPanel;
	private JPanel SuperAttacks;
	private JLabel SuperAttackLabel;
	private JPanel UltimateAttacksPanel;
	private JPanel UltimateAttacks;
	private JLabel UltimateAttacksLabel;
	
	private ArrayList<JButton> MySuperAttacksArray;
	private ArrayList<JButton> MyUltimateAttacksArray;
	private JButton BackFromAssign ;
	
	public MyAttacks()
	{
		setTitle("Replace Attack");
		setBounds(50,50,800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new GridLayout(2,1));
		setBackground(Color.BLACK);
		setVisible(true);
		
		SuperAttacksPanel = new JPanel(new BorderLayout());
		SuperAttacksPanel.setBackground(Color.BLACK);
		SuperAttacks = new JPanel(new GridLayout(1,4));
		//superAtt = new JButton[4];
		
		//superAtt[0].setText("Empty");
		//superAtt[0].setName("Replace SuperAttack");
		
		
		
		
		
		SuperAttacks.setBackground(Color.BLACK);
		SuperAttackLabel = new JLabel("REPLACE WHICH SUPERATTACK?");
		SuperAttackLabel.setBackground(Color.BLACK);
		SuperAttackLabel.setForeground(Color.RED);
		SuperAttackLabel.setFont(new Font(Font.SANS_SERIF, 3, 20));
		
		
		SuperAttacksPanel.add(SuperAttacks, BorderLayout.CENTER);
		SuperAttacksPanel.add(SuperAttackLabel, BorderLayout.NORTH);
		add(SuperAttacksPanel);
		
		UltimateAttacksPanel = new JPanel(new BorderLayout());
		UltimateAttacksPanel.setBackground(Color.BLACK);
		
		UltimateAttacks = new JPanel(new GridLayout(1, 2));
		UltimateAttacks.setBackground(Color.BLACK);
		//UltimateAttacks.add(new JButton("empty"));
		
		UltimateAttacksLabel = new JLabel("REPLACE WHICH ULTIMATEATTACK?");
		UltimateAttacksLabel.setBackground(Color.BLACK);
		UltimateAttacksLabel.setForeground(Color.RED);
		UltimateAttacksLabel.setFont(new Font(Font.SANS_SERIF, 3, 20));
		
		UltimateAttacksPanel.add(UltimateAttacks, BorderLayout.CENTER);
		UltimateAttacksPanel.add(UltimateAttacksLabel, BorderLayout.NORTH);
		add(UltimateAttacksPanel);
		
		BackFromAssign = new JButton("BACK");
		BackFromAssign.setName("BackFromAssign");
		BackFromAssign.setBackground(Color.BLACK);
		BackFromAssign.setForeground(Color.RED);
		BackFromAssign.setFont(new Font(Font.SANS_SERIF, 3, 20));
		//UltimateAttacksPanel.add(BackFromAssign , BorderLayout.S);
		
	}
	
	public JButton getBackFromAssign() {
		return BackFromAssign;
	}

	public void displayAttacks(Game CurrentGame)
	{
        MySuperAttacksArray = new ArrayList<JButton>();
		
        int j = 0;
        for (int i = 0; i < 4; i++) {
        	
    			JButton SuperAttackbutton = new JButton();
    			if (j >= CurrentGame.getPlayer().getActiveFighter().getSuperAttacks().size()){
    				SuperAttackbutton.setText("Empty");
    			 
    			}
    			else
    				SuperAttackbutton.setText(CurrentGame.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName());
    			
    			SuperAttackbutton.setBackground(Color.BLACK);
    			SuperAttackbutton.setBorderPainted(false);
    			SuperAttackbutton.setOpaque(true);
    			SuperAttackbutton.setForeground(Color.RED);
    			SuperAttackbutton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15 ));
    			SuperAttackbutton.setName("Replace SuperAttack");
    			SuperAttacks.add(SuperAttackbutton);
    			MySuperAttacksArray.add(SuperAttackbutton);
    			j++;	
    	
		}
		
		
		MyUltimateAttacksArray = new ArrayList<JButton>();
		j = 0;
		for (int i = 0; i < 2; i++) {
        	
			JButton ultimateAttackButton = new JButton();
			
			if ( j>= CurrentGame.getPlayer().getActiveFighter().getUltimateAttacks().size()){
				ultimateAttackButton.setText("Empty");
			
			}
			else
				ultimateAttackButton.setText(CurrentGame.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName());
		
		
			ultimateAttackButton.setBackground(Color.BLACK);
			ultimateAttackButton.setBorderPainted(false);
			ultimateAttackButton.setOpaque(true);
			ultimateAttackButton.setForeground(Color.RED);
			ultimateAttackButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15 ));
		
			ultimateAttackButton.setName("Replace UltimateAttack");
			UltimateAttacks.add(ultimateAttackButton);
			MyUltimateAttacksArray.add(ultimateAttackButton);
			j++;
		}
		
	}
	
	public void addSuperAttack(JButton B)
	{
		SuperAttacks.add(B);
		repaint();
		revalidate();
	}
	
	public void addUltimateAttack( JButton b)
	{
		UltimateAttacks.add(b);
		repaint();
		revalidate();
		
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

	public JPanel getUltimateAttacksPanel() {
		return UltimateAttacksPanel;
	}

	public JPanel getUltimateAttacks() {
		return UltimateAttacks;
	}

	public JLabel getUltimateAttacksLabel() {
		return UltimateAttacksLabel;
	}

	public ArrayList<JButton> getMySuperAttacksArray() {
		return MySuperAttacksArray;
	}

	public ArrayList<JButton> getMyUltimateAttacksArray() {
		return MyUltimateAttacksArray;
	}

	public static void main(String[] args) {
		new MyAttacks();
	}

}
