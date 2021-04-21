package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class SwitchFighterView extends JFrame{
	
	private JPanel MyFighters;
	
	
	

	public SwitchFighterView() {
	
		
		setTitle("SWITCH FIGHTER");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50,50, 800, 800);
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		setVisible(false);//to be commented
		
		
		MyFighters = new JPanel(new GridLayout(0, 5));
		MyFighters.setBackground(Color.BLACK);
		
		add(MyFighters, BorderLayout.CENTER);
		repaint();
		revalidate();	
		
		
	

     }
	
	/*public void displayFighters(Game g)
	{
		for ( PlayableFighter fighter : g.getPlayer().getFighters()) {
			JButton fighterbutton = new JButton();
			fighterbutton.setText(fighter.getName());
			fighterbutton.setName("setfighter");
			
			MyFighters.add(fighterbutton);
			MyfightersArray.add(fighterbutton);
			repaint();
			revalidate();
	}
	}
	*/
	
	public void addFighter(JButton b, String c)
	{	
		b.setText(b.getText()+"\n "+c);
		b.setName(c);
		b.setFont(new Font(Font.SANS_SERIF, 3, 20));
		b.setForeground(Color.red);
		b.setBackground(Color.BLACK);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setVerticalTextPosition(JButton.TOP);
		MyFighters.add(b);
		
		repaint();
		revalidate();
	}
	

	public static void main(String[] args) {
		new SwitchFighterView();
	}
	
}