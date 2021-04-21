package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.oracle.webservices.internal.api.EnvelopeStyle.Style;

import dragonball.controller.GameController;
import dragonball.controller.GameModel;
import dragonball.model.cell.Cell;
import dragonball.model.cell.FoeCell;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import sun.tools.jar.resources.jar;

public class GameView extends JFrame  {

	private JPanel cells;
	private JTextArea info;
	private JPanel directions;
	private JButton[][] Cells;
	static ImageIcon bkg= new ImageIcon("mapbkg.jpg");
	private JButton up;
	private JButton down ;
	private JButton right;
	private JButton left ;
	private ImageIcon FighterImage;
	
	private JButton createFighter;
	private JButton switchFighter;
	
	private JButton assignAttack;
	private JButton upgrade;
	private JButton save;
	
	
	
	public GameView(){
		//title
		setTitle("Adventures of Dragon Ball");
		//exit on pressing X
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50,50, 800, 800);
		
		cells = new JPanel();
		cells.setLayout(new GridLayout(0,10));
		add(cells, BorderLayout.CENTER);
		info = new JTextArea();
		info.setPreferredSize(new Dimension(300, getHeight()));
		info.setBackground(Color.BLACK);
		info.setEditable(false);
		info.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 14));
		JPanel textPanel= new JPanel();
		textPanel.add(info , BorderLayout.NORTH);
		add(textPanel , BorderLayout.EAST);
		directions = new JPanel();
		directions.setLayout(new FlowLayout());
		add(directions, BorderLayout.PAGE_END);
		Cells = new JButton[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				
				Cells[i][j] = new JButton(bkg);
				// add it to the products buy buttons panel
				cells.add(Cells[i][j]);
			
			}
			}
		ImageIcon upD = new ImageIcon("up.png");
		up = new JButton(upD);
		ImageIcon leftD = new ImageIcon("left.png");
		left = new JButton(leftD);
		ImageIcon downD = new ImageIcon("down.png");
		down = new JButton(downD);
		ImageIcon rightD = new ImageIcon("right.png");
		right = new JButton(rightD);
		right.setName("right");
		left.setName("left");
		up.setName("up");
		down.setName("down");
		
		directions.add(up);
		directions.add(left);
		directions.add(down);
		directions.add(right);
		
		createFighter = new JButton("Create Fighter");
		createFighter.setName("createFighter");
		createFighter.setBackground(Color.BLACK);
		createFighter.setForeground(Color.red);
		
		switchFighter = new JButton("Switch Fighter");
		switchFighter.setName("switchFighter");
		switchFighter.setBackground(Color.BLACK);
		switchFighter.setForeground(Color.red);
		
		assignAttack = new JButton("Assgin Attack");
		assignAttack.setName("assginAttack");
		assignAttack.setBackground(Color.BLACK);
		assignAttack.setForeground(Color.red);
		
		upgrade = new JButton("Upgrade Fighter");
		upgrade.setName("upgrade");
		upgrade.setBackground(Color.BLACK);
		upgrade.setForeground(Color.red);
		
		save = new JButton("SAVE");
		save.setName("save");
		save.setBackground(Color.BLACK);
		save.setForeground(Color.red);
		
		
		JPanel cs= new JPanel(new GridLayout(2, 2));
		cs.add(switchFighter );
		cs.add(createFighter );
		cs.add(save);
		cs.add(assignAttack);
		cs.add(upgrade);
		cs.setBackground(Color.BLACK);
		

		directions.add(cs , BorderLayout.PAGE_END);
		directions.setBackground(Color.black);
		
		up.setBackground(Color.RED);
		right.setBackground(Color.RED);
		left.setBackground(Color.RED);
		down.setBackground(Color.RED);
		
		textPanel.setBackground(Color.BLACK);
		setVisible(false);
	}
	

public void move(int ib , int jb , int i, int j){
		Cells[i][j].setIcon(FighterImage);
		Cells[ib][jb].setIcon(bkg);
	
	}


	public void updateInfo(Game g){
	//add player name later
	info.setText("Player's Name: "+g.getPlayer().getName()+"\n"+"Fighter's name: "+g.getPlayer().getActiveFighter().getName()+"\n"+"Level: "+g.getPlayer().getActiveFighter().getLevel()+"\n"
			+"Dragon Balls: "+g.getPlayer().getDragonBalls()+"\n"+"Senzu Beans: "+g.getPlayer().getSenzuBeans());
	info.setFont(new Font(Font.SANS_SERIF ,12 ,20));
	info.setForeground(Color.red);
}
public void addFighter(ImageIcon image){
	Cells[9][9].setIcon(image);
	this.FighterImage=image;
}
public void setBoss(Game g){
	FoeCell c= (FoeCell)g.getWorld().getMap()[0][0];
	Cells[0][0].setIcon(new ImageIcon("gohan.jpg"));
	if(c.getFoe().getName().equalsIgnoreCase("goku")){
		Cells[0][0].setIcon(new ImageIcon("goku.jpg"));
	}
	if(c.getFoe().getName().equalsIgnoreCase("krillin")){
		Cells[0][0].setIcon(new ImageIcon("krillin.jpg"));
	}
	if(c.getFoe().getName().equalsIgnoreCase("yamcha")){
		Cells[0][0].setIcon(new ImageIcon("yamcha.jpg"));
	}
	if(c.getFoe().getName().equalsIgnoreCase("vegeta")){
		Cells[0][0].setIcon(new ImageIcon("vegeta.jpg"));
	}
	
	
}
public void changeFighterImg(ImageIcon img, int row, int column)
{
	Cells[row][column].setIcon(img);
	this.FighterImage = img;
	repaint();
	revalidate();
}

public JButton getUp() {
	return up;
}

public JButton getDown() {
	return down;
}

public JButton getRight() {
	return right;
}

public JButton getLeft() {
	return left;
}

public JButton getCreateFighter() {
	return createFighter;
}

public JButton getSwitchFighter() {
	return switchFighter;
}


public JButton getAssignAttack() {
	return assignAttack;
}


public JButton getUpgrade() {
	return upgrade;
}


public JButton getSave() {
	return save;
}

}
