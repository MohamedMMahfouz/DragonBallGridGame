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
import javax.swing.JTextArea;


import dragonball.model.game.Game;

public class UpgradeFighterView extends JFrame{
	
	 private JPanel availableFighterAttributes;
	 private JPanel upgradeAttribute;
	 private JPanel thedamnthing;
	 
	 private JButton[] buttons = new JButton[5];
	 private JLabel[] attributesLabels;
	 
	 private JTextArea availableAbilityPoints;
	 private ArrayList<JButton> DoNotBotherToUnderstand;
	 
	 
	 private JButton GoBack;
	 
	 
	 public UpgradeFighterView() {
		
       setTitle("Upgrade Fighter!");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setBounds(50,50,800,800);
       setExtendedState(MAXIMIZED_BOTH);
       setLayout(new BorderLayout());
       //setVisible(true);
       
       availableFighterAttributes = new JPanel(new GridLayout(5, 1));
       availableFighterAttributes.setForeground(Color.RED);
       availableFighterAttributes.setBackground(Color.BLACK);
       upgradeAttribute = new JPanel(new GridLayout(5, 1));
       upgradeAttribute.setForeground(Color.RED);
       upgradeAttribute.setBackground(Color.BLACK);

       buttons[0] = new JButton("50 HealthPoints");
       buttons[0].setBackground(Color.BLACK);
       buttons[0].setForeground(Color.RED);
       buttons[0].setFont(new Font(Font.SANS_SERIF, 3, 20));
       buttons[0].setName("Health Points");
       
       buttons[1] = new JButton("50 Physical Damage");
       buttons[1].setName("Physical Damage");
       buttons[1].setBackground(Color.BLACK);
       buttons[1].setForeground(Color.RED);
       buttons[1].setFont(new Font(Font.SANS_SERIF, 3, 20));
       
       
       buttons[2] = new JButton("50 Blast Damage");
       buttons[2].setName("Blast Damage");
       buttons[2].setBackground(Color.BLACK);
       buttons[2].setForeground(Color.RED);
       buttons[2].setFont(new Font(Font.SANS_SERIF, 3, 20));
       
       buttons[3] = new JButton("1 Ki");
       buttons[3].setName("Ki");
       buttons[3].setBackground(Color.BLACK);
       buttons[3].setForeground(Color.RED);
       buttons[3].setFont(new Font(Font.SANS_SERIF, 3, 20));
       
       buttons[4] = new JButton("1 Stamina");
       buttons[4].setName("Stamina");
       buttons[4].setBackground(Color.BLACK);
       buttons[4].setForeground(Color.RED);
       buttons[4].setFont(new Font(Font.SANS_SERIF, 3, 20));
       
       
       
       upgradeAttribute.add(buttons[0]);
       upgradeAttribute.add(buttons[1]);
       upgradeAttribute.add(buttons[2]);
       upgradeAttribute.add(buttons[3]);
       upgradeAttribute.add(buttons[4]);
       
    	   
		
	
       availableAbilityPoints = new JTextArea();
       
       
       thedamnthing = new JPanel(new BorderLayout());
       thedamnthing.setBackground(Color.BLACK);
       
       
       thedamnthing.add(upgradeAttribute, BorderLayout.EAST);
       
       GoBack = new JButton("Back");
       GoBack.setName("Back");
       GoBack.setBackground(Color.BLACK);
       GoBack.setOpaque(true);
       GoBack.setFocusPainted(false);
       GoBack.setBorder(null);
       GoBack.setForeground(Color.RED);
       GoBack.setPreferredSize(new Dimension(5, 20));
       GoBack.setFont(new Font(Font.SANS_SERIF, 3, 15));
       
       add(GoBack, BorderLayout.SOUTH);
       add(thedamnthing, BorderLayout.CENTER);
       
       attributesLabels = new JLabel[5];
       for (int i = 0; i < attributesLabels.length; i++) {
		attributesLabels[i]=new JLabel("");
	}
       
       
       
	}
	 
	public void displayFighterAttribute(Game g)
	 
	 {
		
		 
		 attributesLabels[0].setText("Health Points: " +g.getPlayer().getActiveFighter().getMaxHealthPoints() + "");
		 attributesLabels[0].setForeground(Color.RED);
		 attributesLabels[0].setFont(new Font( Font.SANS_SERIF, 3, 20));
		 attributesLabels[1].setText("Physical Damage: "+ g.getPlayer().getActiveFighter().getPhysicalDamage() + "");
		 attributesLabels[1].setForeground(Color.RED);
		 attributesLabels[1].setFont(new Font( Font.SANS_SERIF, 3, 20));
		 attributesLabels[2].setText("Blast Damage: "+ g.getPlayer().getActiveFighter().getBlastDamage() + "");
		 attributesLabels[2].setForeground(Color.RED);
		 attributesLabels[2].setFont(new Font( Font.SANS_SERIF, 3, 20));
		 attributesLabels[3].setText("Max Ki: "+g.getPlayer().getActiveFighter().getMaxKi() + "");
		 attributesLabels[3].setForeground(Color.RED);
		 attributesLabels[3].setFont(new Font( Font.SANS_SERIF, 3, 20));
		 attributesLabels[4].setText("Max Stamina: "+g.getPlayer().getActiveFighter().getMaxStamina() + "");
		 attributesLabels[4].setForeground(Color.RED);
		 attributesLabels[4].setFont(new Font( Font.SANS_SERIF, 3, 20));
		 
		 
		 availableFighterAttributes.add(attributesLabels[0]);
		 availableFighterAttributes.add(attributesLabels[1]);
		 availableFighterAttributes.add(attributesLabels[2]);
		 availableFighterAttributes.add(attributesLabels[3]);
		 availableFighterAttributes.add(attributesLabels[4]);
		 
		 thedamnthing.add(availableFighterAttributes, BorderLayout.WEST);
		 
		 repaint();
		 revalidate();
	 }
	 
	 public void displayFighterAbilityPoints(Game g)
	 {
		 
	     availableAbilityPoints.setForeground(Color.RED);
	     availableAbilityPoints.setBackground(Color.BLACK);
	     availableAbilityPoints.setFont(new Font( Font.SANS_SERIF, 5, 20));
	     availableAbilityPoints.setText( "YOUR ABLITY POINTS: " +g.getPlayer().getActiveFighter().getAbilityPoints());
	     add(availableAbilityPoints, BorderLayout.NORTH);
	     availableAbilityPoints.setEditable(false);
	      
	 }
	 
	
	 
	
	
	 
	 public JPanel getAvailableFighterAttributes() {
			return availableFighterAttributes;
		}
		public JPanel getUpgradeAttribute() {
			return upgradeAttribute;
		}
		public JPanel getThedamnthing() {
			return thedamnthing;
		}
		public JLabel[] getAttributesLabels() {
			return attributesLabels;
		}
		public JTextArea getAvailableAbilityPoints() {
			return availableAbilityPoints;
		}
		public ArrayList<JButton> getDoNotBotherToUnderstand() {
			return DoNotBotherToUnderstand;
		}
		public JButton getGoBack() {
			return GoBack;
		}
		public JButton[] getButtons() {
			return buttons;
		}
		public void setButtons(JButton[] buttons) {
			this.buttons = buttons;
		}
	 public static void main(String[] args) {
		new UpgradeFighterView();
	}
	 
	
	 

}
