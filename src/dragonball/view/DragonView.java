package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dragonball.model.dragon.Dragon;

public class DragonView extends JFrame{

	private JLabel bkg;
	private JButton senzu;
	private JButton ability;
	private JButton superA;
	private JButton ultimateA;
	private JPanel chosen;
	private JTextArea chosentext;
	private JButton ok;
	
	public DragonView(Dragon g){
		if(g.getName().equalsIgnoreCase("Shenron")){
			bkg = new JLabel(new ImageIcon("shenron.jpg"));
			add(bkg);
			
			
			
		}else{
			bkg = new JLabel(new ImageIcon("Porunga.jpg")); 
			add(bkg);
			bkg.setVisible(true);
			
		}
		setTitle("Dragon MODE!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50,50, 800, 800);
		setExtendedState(MAXIMIZED_BOTH);
		bkg.setVisible(true);
		bkg.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		senzu = new JButton("SENZU BEANS");
		senzu.setForeground(Color.BLUE);
		senzu.setName("senzu");
		senzu.setOpaque(false);
		senzu.setContentAreaFilled(false);
		senzu.setBorderPainted(false);
		senzu.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		ability = new JButton("ABILITY POINTS");
		ability.setForeground(Color.BLUE);
		ability.setName("ability");
		ability.setOpaque(false);
		ability.setContentAreaFilled(false);
		ability.setBorderPainted(false);
		ability.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		superA= new JButton("SUPER ATTACK");
		superA.setForeground(Color.blue);
		superA.setName("super");
		superA.setOpaque(false);
		superA.setContentAreaFilled(false);
		superA.setBorderPainted(false);
		superA.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		ultimateA= new JButton("ULTIMATE ATTACK");
		ultimateA.setForeground(Color.BLUE);
		ultimateA.setName("ultimate");
		ultimateA.setOpaque(false);
		ultimateA.setContentAreaFilled(false);
		ultimateA.setBorderPainted(false);
		ultimateA.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		
		bkg.add(senzu,gbc);
		bkg.add(ability, gbc);
		bkg.add(superA, gbc);
		bkg.add(ultimateA, gbc);
		chosen = new JPanel();
		chosen.setLayout(new BorderLayout());
		chosen.setOpaque(false);
		chosentext = new JTextArea();
		chosentext.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		chosentext.setForeground(Color.red);
		chosentext.setEnabled(false);
		chosentext.setOpaque(false);
		
		chosen.add(chosentext , BorderLayout.CENTER);
		bkg.add(chosen);
		chosen.setVisible(true);
		
		ok = new JButton("OK");
		ok.setForeground(Color.GREEN);
		ok.setName("ok");
		ok.setOpaque(false);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		ok.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		setVisible(true);
	}

	public void updateChoseText(String x){
		chosentext.setText(x);
		chosen.add(chosentext , BorderLayout.CENTER);
	}
	public JLabel getBkg() {
		return bkg;
	}

	public JButton getSenzu() {
		return senzu;
	}

	public JButton getAbility() {
		return ability;
	}

	public JButton getSuperA() {
		return superA;
	}

	public JButton getUltimateA() {
		return ultimateA;
	}

	public JPanel getChosen() {
		return chosen;
	}

	public JTextArea getChosentext() {
		return chosentext;
	}
	public void addOK(){
		bkg.add(ok);
		
	}
	public JButton getOk(){
		return ok;
	}
	
}
