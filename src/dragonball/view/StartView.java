package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.model.player.Player;

public class StartView extends JFrame {
	private JButton newGame;
	private JButton load;
	private Game CurrentGame;
	private StartNewGameView view;
	private JLabel bkg;
	private JPanel frame;
	private JTextField playerName;

	
	public StartView(StartNewGameView view){
		bkg = new JLabel(new ImageIcon("bkg.png"));
		this.view=view;
		
		bkg.setBounds(0,0,1920,1080);
		bkg.setFocusable(true);
		setTitle("Adventures of Dragon Ball");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50,50, 800, 800);
		setExtendedState(MAXIMIZED_BOTH);
		
		add(bkg);
		bkg.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		newGame = new JButton("New Game");
		newGame.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		newGame.setPreferredSize(new Dimension(200, 50));
		newGame.setName("newGame");
		load = new JButton("Load Game");
		load.setPreferredSize(new Dimension(200, 50));
		load.setName("load");
		load.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		newGame.setForeground(Color.RED);
		newGame.setContentAreaFilled(false);
		newGame.setBorderPainted(false);
		load.setForeground(Color.red);
		newGame.setOpaque(false);
		load.setOpaque(false);
		load.setContentAreaFilled(false);
		load.setBorderPainted(false);
		bkg.add(newGame , gbc);
		bkg.add(load, gbc);
		
		playerName = new JTextField();
		playerName.setColumns(20);
		JLabel Pnl = new JLabel("Player's Name ", JLabel.CENTER);
		Pnl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		Pnl.setForeground(Color.RED);
		Pnl.setLabelFor(playerName);
		JPanel labelP = new JPanel(new GridLayout(2,1));
		JPanel fieldP = new JPanel(new GridLayout(2,1));
		
		//Pnl.setOpaque(false);
		labelP.add(playerName);
		//labelP.add(FighterName);
		fieldP.add(Pnl);
		//fieldP.add(Pns);
		bkg.add(fieldP , gbc);
		bkg.add(labelP, gbc);
		fieldP.setOpaque(false);
		labelP.setOpaque(false);
		view.setVisible(false);//7otaha fel viiew nfso
		setVisible(true);
		
		playerName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		playerName.setOpaque(false);
		playerName.setForeground(Color.RED);
		
		newGame.setEnabled(false);
		load.setEnabled(true);
		/*frame = new JPanel();
		frame.setLayout(new FlowLayout());
		add(frame);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
	
		newGame = new JButton("New Game");
		newGame.setPreferredSize(new Dimension(200, 50));
		newGame.setName("newGame");
		load = new JButton("Load Game");
		load.setPreferredSize(new Dimension(200, 50));
		load.setName("load");
		
		frame.add(newGame);
		frame.add(load);
		
		playerName = new JTextField();
		playerName.setColumns(20);
		JLabel Pnl = new JLabel("PLayer's Name ", JLabel.RIGHT);
		Pnl.setLabelFor(playerName);
		JPanel labelP = new JPanel(new GridLayout(2,1));
		JPanel fieldP = new JPanel(new GridLayout(2,1));
		FighterName = new JTextField();
		FighterName.setColumns(20);
		JLabel Pns = new JLabel("Fighter's Name ", JLabel.RIGHT);
		
		//Pns.setLabelFor(FighterName);
		labelP.add(playerName);
		//labelP.add(FighterName);
		fieldP.add(Pnl);
		//fieldP.add(Pns);
		frame.add(fieldP , BorderLayout.WEST);
		frame.add(labelP, BorderLayout.EAST);
		frame.add(bkg);
		frame.setBackground(Color.black);
		view.setVisible(false);//7otaha fel viiew nfso
		setVisible(true);
		
		/*if(CurrentGame.getLastSavedFile() != "" && CurrentGame.getLastSavedFile() != null ){
			load.setEnabled(true);
		}
		*/
		}
	
	public JButton getNewGame() {
		return newGame;
	}

	public JButton getLoad() {
		return load;
	}

	public Game getCurrentGame() {
		return CurrentGame;
	}

	public StartNewGameView getView() {
		return view;
	}

	public JLabel getBkg() {
		return bkg;
	}

	public JPanel getFrame() {
		return frame;
	}

	public String getPlayerName() {
		return playerName.getText();
	}
	public JTextField getPlayerNameField(){
		return playerName;
	}

	

	
	
		public void addView(StartNewGameView v){
			this.view=v;
		}
}

