package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.glass.events.KeyEvent;

import dragonball.model.attack.Attack;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;

import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.AssignSuperAttackView;
import dragonball.view.AssignUltimateAttackView;
import dragonball.view.BattleView;
import dragonball.view.DragonView;
import dragonball.view.GameView;
import dragonball.view.MyAttacks;
import dragonball.view.StartNewGameView;
import dragonball.view.StartView;
import dragonball.view.SwitchFighterView;
import dragonball.view.UpgradeFighterView;


public class GameModel implements GameListener, ActionListener,KeyListener , WindowListener{

	static Game CurrentGame;
	private boolean loadFlag=false;
	private GameView view;
	private StartView Startview;
	private StartNewGameView ChooseFighterView;
	private BattleView battleView;
	private int level;
	private int iA;
	private int jA;
	private Dragon dragon;
	private DragonView dragonView;
	private UpgradeFighterView upgradeFighterView;
	private SwitchFighterView switchfighterview;
	private ArrayList<JButton> MyfightersArray;
	private AssignSuperAttackView assignsuperattackview;
	private AssignUltimateAttackView assignultimateattackview;
	private SuperAttack oldsuper;
	private UltimateAttack oldultimate;
	private MyAttacks myattacks;
	private ImageIcon E = new ImageIcon("Earthlingi.jpg");
	private ImageIcon M = new ImageIcon("Majini.jpg");
	private ImageIcon S = new ImageIcon("Sayiani.gif");
	private ImageIcon N = new ImageIcon("Namekiani.jpg");
	private ImageIcon F = new ImageIcon("Friezai.gif");
	private ImageIcon curr;
	int ability;
	public GameModel() {
		
		try {
			
			CurrentGame = new Game();
			ChooseFighterView = new StartNewGameView();
			Startview = new StartView(ChooseFighterView);
			Startview.addView(ChooseFighterView);
			
		} catch (MissingFieldException | UnknownAttackTypeException e) {
			// TODO Auto-generated catch block
			return;
		}
		if(loadFlag)
			try {
				CurrentGame.load(CurrentGame.getLastSavedFile());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		CurrentGame.setListener(this);
		view= new GameView();
		Startview.getNewGame().addActionListener(this);
		Startview.getLoad().addActionListener(this);
		setChooseFighterViewListeners();
		
		view.getUp().addActionListener(this);
		view.getDown().addActionListener(this);
		view.getLeft().addActionListener(this);
		view.getRight().addActionListener(this);
		
		view.getCreateFighter().addActionListener(this);
		view.getUpgrade().addActionListener(this);
		view.getAssignAttack().addActionListener(this);
		view.getSwitchFighter().addActionListener(this);
		
		
		
		
		view.addWindowListener(this);
		view.getUp().addKeyListener( this);
		view.getDown().addKeyListener(this);
		view.getLeft().addKeyListener(this);
		view.getRight().addKeyListener(this);
		view.getSave().addActionListener(this);
		Startview.getPlayerNameField().addKeyListener( this);
		ChooseFighterView.getSayian().addKeyListener(this);
		ChooseFighterView.getMajin().addKeyListener(this);
		ChooseFighterView.getNamekian().addKeyListener(this);
		ChooseFighterView.getFrieza().addKeyListener(this);
		ChooseFighterView.getEarthling().addKeyListener(this);
		ChooseFighterView.getFighterNameField().addKeyListener(this);
		
		switchfighterview = new SwitchFighterView();
		
		 MyfightersArray = new ArrayList<JButton>();
		
		 
		 Startview.addWindowListener(this);
		 ChooseFighterView.addWindowListener(this);
		 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton) e.getSource();
		int ib = CurrentGame.getWorld().getPlayerRow();
		int jb = CurrentGame.getWorld().getPlayerColumn();
		iA=ib;
		jA=jb;
		
		switch (pressed.getName()) {
		case "newGame" :
			try {
				CurrentGame = new Game();
			} catch (MissingFieldException | UnknownAttackTypeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				StartNewGameView ChooseFighterView = new StartNewGameView();
			}
			
			// el mfrod el view y5tar image el fighter this.ChooseFighter();
			ChooseFighterView.setVisible(true);
			Startview.dispose();
			CurrentGame.setListener(this);
			view.setBoss(CurrentGame);
			
			break;
		case "load" : 
		
		
		
		try {
			CurrentGame.load("saved");
			view.setVisible(true);
			Startview.dispose();
			view.setBoss(CurrentGame);
			view.updateInfo(CurrentGame);
			 
		     Fighter cu = CurrentGame.getPlayer().getActiveFighter();
		    
		     if (cu instanceof Earthling){
		    	 view.changeFighterImg(E, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
		    	 curr=E;
		     }
		     
		     else if (cu instanceof Namekian){
		    	 view.changeFighterImg(N, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
		    	 curr=N;
		     }
		     else if (cu instanceof Saiyan){
		    	 view.changeFighterImg(S, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
		    	 curr=S;
		     }
		     else if (cu instanceof Frieza){
		    	 view.changeFighterImg(F, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
		    	 curr=F;
		     }
		     else if (cu instanceof Majin){
		    	 view.changeFighterImg(M, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
		    	 curr=M;
		     }
			
			
		} catch (ClassNotFoundException | IOException e1) {
			
			JOptionPane.showMessageDialog(null, "THERE ARE NO SAVED GAMES! START A NEW GAME");
			
		}
		CurrentGame.setListener(this);
			break;
		case "Namekian" : 
			JButton b = new JButton(ChooseFighterView.getNamekian().getText(), ChooseFighterView.getNamekian().getIcon());
			switchfighterview.addFighter(b, ChooseFighterView.getFighterName() );
			MyfightersArray.add(b);
			b.setName("setfighter");
			b.addActionListener(this);
			if(CurrentGame.getPlayer().getFighters().size() >= 1){
				CurrentGame.getPlayer().getFighters().add(new Namekian(ChooseFighterView.getFighterName()));
				ChooseFighterView.dispose();
				view.setVisible(true);
				break;
			}
			CurrentGame.getPlayer().createFighter('N',  ChooseFighterView.getFighterName());
			CurrentGame.getPlayer().setName(Startview.getPlayerName());
			view.updateInfo(CurrentGame);
			ChooseFighterView.dispose();
			
			view.addFighter(N);
			view.setVisible(true);
			curr= N;
			
			break;
		case "Frieza" : 
			JButton ca = new JButton(ChooseFighterView.getFrieza().getText(), ChooseFighterView.getFrieza().getIcon());
			switchfighterview.addFighter(ca, ChooseFighterView.getFighterName() );
			MyfightersArray.add(ca);
			ca.setName("setfighter");
			ca.addActionListener(this);
			if(CurrentGame.getPlayer().getFighters().size() >= 1){
				CurrentGame.getPlayer().getFighters().add(new Frieza(ChooseFighterView.getFighterName()));
				ChooseFighterView.dispose();
				view.setVisible(true);
				break;
			}
		CurrentGame.getPlayer().createFighter('F', ChooseFighterView.getFighterName());
		CurrentGame.getPlayer().setName(Startview.getPlayerName());
		view.updateInfo(CurrentGame);
		ChooseFighterView.dispose();
		
		view.addFighter(F);
		view.setVisible(true);
		curr=F;
		
			break;
		case "Sayian" : 
			JButton sa = new JButton(ChooseFighterView.getSayian().getText(), ChooseFighterView.getSayian().getIcon());
			switchfighterview.addFighter(sa, ChooseFighterView.getFighterName() );
			MyfightersArray.add(sa);
			sa.setName("setfighter");
			sa.addActionListener(this);
			if(CurrentGame.getPlayer().getFighters().size() >= 1){
				CurrentGame.getPlayer().getFighters().add(new Saiyan(ChooseFighterView.getFighterName()));
				ChooseFighterView.dispose();
				view.setVisible(true);
				break;
			}
		CurrentGame.getPlayer().createFighter('S',  ChooseFighterView.getFighterName());
		CurrentGame.getPlayer().setName(Startview.getPlayerName());
		view.updateInfo(CurrentGame);
		ChooseFighterView.dispose();
		view.addFighter(S);
		view.setVisible(true);
		curr=S;

		break;
		case "Majin" : 
			
			JButton ma = new JButton(ChooseFighterView.getMajin().getText(), ChooseFighterView.getMajin().getIcon());
			switchfighterview.addFighter(ma, ChooseFighterView.getFighterName() );
			MyfightersArray.add(ma);
			ma.setName("setfighter");
			ma.addActionListener(this);
			if(CurrentGame.getPlayer().getFighters().size() >= 1){
				CurrentGame.getPlayer().getFighters().add(new Majin(ChooseFighterView.getFighterName()));
				ChooseFighterView.dispose();
				view.setVisible(true);
				break;
			}
		CurrentGame.getPlayer().createFighter('M',  ChooseFighterView.getFighterName());
		CurrentGame.getPlayer().setName(Startview.getPlayerName());
		view.updateInfo(CurrentGame);
		ChooseFighterView.dispose();
		view.addFighter(M);
		view.setVisible(true);
		curr=M;
		
			break;
		case "Earthling" : 
			JButton ea = new JButton(ChooseFighterView.getEarthling().getText(), ChooseFighterView.getEarthling().getIcon());
			switchfighterview.addFighter(ea, ChooseFighterView.getFighterName() );
			MyfightersArray.add(ea);
			ea.setName("setfighter");
			ea.addActionListener(this);
			if(CurrentGame.getPlayer().getFighters().size() >= 1){
				CurrentGame.getPlayer().getFighters().add(new Earthling(ChooseFighterView.getFighterName()));
				ChooseFighterView.dispose();
				view.setVisible(true);
				break;
			}
		CurrentGame.getPlayer().createFighter('E',  ChooseFighterView.getFighterName());
		CurrentGame.getPlayer().setName(Startview.getPlayerName());
		view.updateInfo(CurrentGame);
		ChooseFighterView.dispose();
		view.addFighter(E);
		view.setVisible(true);
		curr=E;
			break;
		case "right" :
		CurrentGame.getWorld().moveRight();
		view.updateInfo(CurrentGame);
		int i=CurrentGame.getWorld().getPlayerRow();
		int j = CurrentGame.getWorld().getPlayerColumn();
		view.move(ib, jb ,i, j);
		view.repaint();
		view.validate();
	break;
	case "left" :
		CurrentGame.getWorld().moveLeft();
		view.updateInfo(CurrentGame);
		int il=CurrentGame.getWorld().getPlayerRow();
		int jl =CurrentGame.getWorld().getPlayerColumn();
		view.move( ib, jb , il, jl);
		view.repaint();
		view.validate();
		
		break;
	case "up" :
		CurrentGame.getWorld().moveUp();
		view.updateInfo(CurrentGame);
		int iu=CurrentGame.getWorld().getPlayerRow();
		int ju = CurrentGame.getWorld().getPlayerColumn();
		view.move(ib , jb , iu, ju);
		view.repaint();
		view.validate();
		
		break;
	case "down" :
		CurrentGame.getWorld().moveDown();
		view.updateInfo(CurrentGame);
		int id=CurrentGame.getWorld().getPlayerRow();
		int jd = CurrentGame.getWorld().getPlayerColumn();
		view.move( ib , jb , id, jd);
		
		view.repaint();
		view.validate();
		break;
	case "createFighter":
		view.setVisible(false);
		ChooseFighterView = new StartNewGameView();
		ChooseFighterView.addWindowListener(this);
		ChooseFighterView.setVisible(true);
		setChooseFighterViewListeners();
		break;
	case"switchFighter": 
		switchfighterview.setVisible(true);
		switchfighterview.addWindowListener(this);
		view.setVisible(false);
		switchfighterview.setVisible(true);
		view.repaint();
		view.revalidate();
		
		break;
	case "setfighter" :
		int index = MyfightersArray.indexOf(pressed);
	     PlayableFighter currentFighter = CurrentGame.getPlayer().getFighters().get(index);
	     CurrentGame.getPlayer().setActiveFighter(currentFighter);
	    
	     if (currentFighter instanceof Earthling){
	    	 view.changeFighterImg(E, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
	    	 
	     }
	     
	     else if (currentFighter instanceof Namekian){
	    	 view.changeFighterImg(N, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
	     }
	     else if (currentFighter instanceof Saiyan){
	    	 view.changeFighterImg(S, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
	     }
	     else if (currentFighter instanceof Frieza){
	    	 view.changeFighterImg(F, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
	     }
	     else if (currentFighter instanceof Majin){
	    	 view.changeFighterImg(M, CurrentGame.getWorld().getPlayerRow(), CurrentGame.getWorld().getPlayerColumn());
	     }
	     
	     view.updateInfo(CurrentGame);
	     view.repaint();
	     view.revalidate();
	     
	     switchfighterview.dispose();
	     view.setVisible(true);
	     view.repaint();
	     view.revalidate();
		
		break;
	case "upgrade" :
		if(CurrentGame.getPlayer().getActiveFighter().getAbilityPoints() == 0){
			JOptionPane.showMessageDialog(null, "YOU have NO ABLILITY POINTS");
			break;
			//break;
		}
		view.setVisible(false);
		upgradeFighterView = new UpgradeFighterView();
		upgradeFighterView.addWindowListener(this);
		upgradeFighterView.displayFighterAbilityPoints(CurrentGame);
		upgradeFighterView.displayFighterAttribute(CurrentGame);
		upgradeFighterView.setVisible(true);
		for (int k = 0; k < upgradeFighterView.getButtons().length; k++) {
			upgradeFighterView.getButtons()[k].addActionListener(this);
			
		}
		upgradeFighterView.getGoBack().addActionListener(this);
		upgradeFighterView.repaint();
		upgradeFighterView.revalidate();
		
		break;
	case "Health Points" : 
		try {
			CurrentGame.getPlayer().upgradeFighter(CurrentGame.getPlayer().getActiveFighter(), 'H');
		} catch (NotEnoughAbilityPointsException e1) {
			
			JOptionPane.showMessageDialog(null, "OOPS!! I SEE WHAT YOU DID THERE \n YOU HAVE NO ABILITY POINTS!!");
			upgradeFighterView.dispose();
			view.setVisible(true);
		}
		//upgradeFighterView.removeAttribute();
		upgradeFighterView.displayFighterAttribute(CurrentGame);
		upgradeFighterView.displayFighterAbilityPoints(CurrentGame);
		upgradeFighterView.repaint();
		upgradeFighterView.revalidate();
		break;
	case "Physical Damage":
		try {
			CurrentGame.getPlayer().upgradeFighter(CurrentGame.getPlayer().getActiveFighter(), 'P');
		} catch (NotEnoughAbilityPointsException e1) {
			e1.getMessage();
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "OOPS!! I SEE WHAT YOU DID THERE \n YOU HAVE NO ABILITY POINTS!!");
			upgradeFighterView.dispose();
			view.setVisible(true);
		}
		//upgradeFighterView.removeAttribute();
		upgradeFighterView.displayFighterAttribute(CurrentGame);
		upgradeFighterView.displayFighterAbilityPoints(CurrentGame);
		upgradeFighterView.repaint();
		upgradeFighterView.revalidate();
		break;
	case "Blast Damage" : 
		try {
			CurrentGame.getPlayer().upgradeFighter(CurrentGame.getPlayer().getActiveFighter(), 'B');
		} catch (NotEnoughAbilityPointsException e1) {
			e1.getMessage();
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "OOPS!! I SEE WHAT YOU DID THERE \n YOU HAVE NO ABILITY POINTS!!");
			upgradeFighterView.dispose();
			view.setVisible(true);
		}
		//upgradeFighterView.removeAttribute();
		upgradeFighterView.displayFighterAttribute(CurrentGame);
		upgradeFighterView.displayFighterAbilityPoints(CurrentGame);
		upgradeFighterView.repaint();
		upgradeFighterView.revalidate();
		break;
	case "Ki" : 
		try {
			CurrentGame.getPlayer().upgradeFighter(CurrentGame.getPlayer().getActiveFighter(), 'K');
		} catch (NotEnoughAbilityPointsException e1) {
			e1.getMessage();
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "OOPS!! I SEE WHAT YOU DID THERE \n YOU HAVE NO ABILITY POINTS!!");
			upgradeFighterView.dispose();
			view.setVisible(true);
		}
		//upgradeFighterView.removeAttribute();
		upgradeFighterView.displayFighterAttribute(CurrentGame);
		upgradeFighterView.displayFighterAbilityPoints(CurrentGame);
		upgradeFighterView.repaint();
		upgradeFighterView.revalidate();
		break;
	case "Stamina" : 
		try {
			CurrentGame.getPlayer().upgradeFighter(CurrentGame.getPlayer().getActiveFighter(), 'S');
		} catch (NotEnoughAbilityPointsException e1) {
			JOptionPane.showMessageDialog(null, "OOPS!! I SEE WHAT YOU DID THERE \n YOU HAVE NO ABILITY POINTS!!");
			upgradeFighterView.dispose();
			view.setVisible(true);

		}
		
		//upgradeFighterView.removeAttribute();
		upgradeFighterView.displayFighterAttribute(CurrentGame);   
		//upgradeFighterView.getThedamnthing().remove(upgradeFighterView.getAvailableFighterAttributes());
		upgradeFighterView.displayFighterAbilityPoints(CurrentGame);
		upgradeFighterView.repaint();
		upgradeFighterView.revalidate();
		break;
	case "Back" :
		
		upgradeFighterView.dispose();
		view.setVisible(true);
	    view.repaint();
	    view.revalidate();
		break;
	case "BackFromAssign":
		myattacks.dispose();
		view.setVisible(true);
		break;
		case "assginAttack" :
			
			view.setVisible(false);
			myattacks = new MyAttacks();
			myattacks.addWindowListener(this);
			//myattacks.getBackFromAssign().addActionListener(this);
			myattacks.displayAttacks(CurrentGame);
			for (int k = 0; k < myattacks.getMySuperAttacksArray().size(); k++) {
				myattacks.getMySuperAttacksArray().get(k).addActionListener(this);
			}
			for (int k = 0; k < myattacks.getMyUltimateAttacksArray().size(); k++) {
				myattacks.getMyUltimateAttacksArray().get(k).addActionListener(this);
				
			}
			myattacks.setVisible(true);
			view.repaint();
		    view.revalidate();
			
			
			break;
			
		case "Replace SuperAttack" :
			
			int indexMS = myattacks.getMySuperAttacksArray().indexOf(pressed);
			
			if (pressed.getText() == "Empty")
				oldsuper = null;
			else
		        oldsuper = CurrentGame.getPlayer().getActiveFighter().getSuperAttacks().get(indexMS);
		   
			myattacks.dispose();

		    assignsuperattackview = new AssignSuperAttackView();
		    assignsuperattackview.addWindowListener(this);
		    assignsuperattackview.displayPlayerAttacks(CurrentGame);
		     for (int k = 0; k <assignsuperattackview.getSuperAttacksArray().size(); k++) {
					assignsuperattackview.getSuperAttacksArray().get(k).addActionListener(this);
					
				}
			assignsuperattackview.getGoBack().addActionListener(this);
		     assignsuperattackview.setVisible(true);
		     if (CurrentGame.getPlayer().getSuperAttacks().size() == 0)
		    	 assignsuperattackview.updateLabel(CurrentGame);
		    
		    
		       
		       view.repaint();
		       view.revalidate();
		       
			
			break;
			
		case "BackAssignS":
			assignsuperattackview.dispose();
			view.setVisible(true);	
		    view.repaint();
		    view.revalidate();
			
			break;
			
		case "Replace UltimateAttack": 
			
			int indexMU = myattacks.getMyUltimateAttacksArray().indexOf(pressed);
			if (pressed.getText() == "Empty")
				oldultimate = null;
			else
			    oldultimate = CurrentGame.getPlayer().getActiveFighter().getUltimateAttacks().get(indexMU);
			
			myattacks.dispose();
			assignultimateattackview = new AssignUltimateAttackView();
			assignultimateattackview.addWindowListener(this);
			assignultimateattackview.displayPlayerUltimateAtt(CurrentGame);
			for (int k = 0; k < assignultimateattackview.getUltimateAttacksArray().size(); k++) {
				assignultimateattackview.getUltimateAttacksArray().get(k).addActionListener(this);
			}
			
			assignultimateattackview.getGoBack().addActionListener(this);
		    assignultimateattackview.setVisible(true);
		    if (CurrentGame.getPlayer().getSuperAttacks().size() == 0)
		    	 assignultimateattackview.updateLabel(CurrentGame);
		    
		    view.repaint();
		    view.revalidate();
		    break;
		    
		case "BackAssignU" :
			assignultimateattackview.dispose();
			view.setVisible(true);	
		    view.repaint();
		    view.revalidate();
			
			
			break;
			
			
		case "AssignSuperAttack":
			assignsuperattackview.dispose();
			int indexS = assignsuperattackview.getSuperAttacksArray().indexOf(pressed);
			SuperAttack newSuper = CurrentGame.getPlayer().getSuperAttacks().get(indexS);
			
				try {
					CurrentGame.getPlayer().assignAttack(CurrentGame.getPlayer().getActiveFighter(),
							newSuper, oldsuper);
				} catch (MaximumAttacksLearnedException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "THAT'S ENOUGH! STOP BEING GREEDY! OKAY?");
				} catch (DuplicateAttackException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "YOU DIDN'T NOTICE? ALREADY THERE.");
				} catch (NotASaiyanException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "COME ON, YOU ARE NOT A SAIYAN!");
					
				}
				
			view.setVisible(true);	
		    view.repaint();
		    view.revalidate();
			
			break;
			
		case "AssignUltimateAttack":
		
		assignultimateattackview.dispose();
		int indexU = assignultimateattackview.getUltimateAttacksArray().indexOf(pressed);
		UltimateAttack newUltimate = CurrentGame.getPlayer().getUltimateAttacks().get(indexU);
		
				try {
					CurrentGame.getPlayer().assignAttack(CurrentGame.getPlayer().getActiveFighter(), newUltimate, oldultimate);
				} catch (MaximumAttacksLearnedException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "THAT'S ENOUGH! STOP BEING GREEDY! OKAY?");
				} catch (DuplicateAttackException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "YOU DIDN'T NOTICE? ALREADY THERE.");
				} catch (NotASaiyanException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "COME ON, YOU ARE NOT A SAIYAN!");
				}
				
				
				view.setVisible(true);
				view.repaint();
				view.revalidate();
				break;
		
	case "use":
			try {
				CurrentGame.getBattle().use(CurrentGame.getPlayer(), Collectible.SENZU_BEAN);
			} catch (NotEnoughSenzuBeansException e1) {
				JOptionPane.showMessageDialog(null, "YOU have NO Senzu Beans");
				
			}
		break;
	case "block":
		CurrentGame.getBattle().block();
		break;
	case "attack": 
		battleView.getChooseAttack().setVisible(true);
		battleView.getBlock().setEnabled(false);
		battleView.getAttack().setEnabled(false);
		battleView.getUse().setEnabled(false);
		
		break;
	case "physicalAttack":
		int Aindex = battleView.getA().indexOf(pressed);
			Attack att = CurrentGame.getBattle().getAssignedAttacks().get(Aindex);
			try {
				CurrentGame.getBattle().attack(att);
			} catch (NotEnoughKiException e1) {
				JOptionPane.showMessageDialog(null, "YOU DON'T HAVE ENOUGH KI");
				
			}
			break;
	case "OpponnentMove":
		if(CurrentGame.getBattle().getAttacker() == CurrentGame.getBattle().getFoe()){
			try {
				CurrentGame.getBattle().play();
				//battleView.updateTurn(CurrentGame.getPlayer().getName()+"'s TURN");
			} catch (NotEnoughKiException e1) {
				CurrentGame.getBattle().block();
				//battleView.updateTurn(CurrentGame.getPlayer().getName()+"'s TURN");
			}
			battleView.getOpponnentMove().setEnabled(false);
			battleView.getAttack().setEnabled(true);
			battleView.getUse().setEnabled(true);
			battleView.getBlock().setEnabled(true);
			//battleView.updateActions("The Opponnent made his move !!");
		}
	
		break;
	case "back1": 
		battleView.getChooseAttack().setVisible(false);
		battleView.getBlock().setEnabled(true);
		battleView.getAttack().setEnabled(true);
		battleView.getUse().setEnabled(true);
		break;
	case "Go":
		battleView.dispose();
		view.setVisible(true);
		//view = new GameView();
		break;
	case "senzu":
		
		DragonWish w= dragon.getWishes()[0]; 
		String x = "YOU GOT "+w.getSenzuBeans()+" SENZU BEANS";
		dragonView.updateChoseText(x);
		dragonView.addOK();
		dragonView.getSenzu().setEnabled(false);
		dragonView.getAbility().setEnabled(false);
		dragonView.getSuperA().setEnabled(false);
		dragonView.getUltimateA().setEnabled(false);
		CurrentGame.getPlayer().chooseWish(w);
		break;
	case"ability":
		DragonWish w1= dragon.getWishes()[1];
		String a = "YOU GOT "+w1.getAbilityPoints()+" ABILITY POINTS";
		dragonView.updateChoseText(a);
		dragonView.addOK();
		dragonView.getSenzu().setEnabled(false);
		dragonView.getAbility().setEnabled(false);
		dragonView.getSuperA().setEnabled(false);
		dragonView.getUltimateA().setEnabled(false);
		CurrentGame.getPlayer().chooseWish(w1);
		break;
	case "super":
		DragonWish w2= dragon.getWishes()[2];
		String c = "YOU GOT "+w2.getSuperAttack().getName()+" SUPER ATTACK";
		dragonView.updateChoseText(c);
		dragonView.addOK();
		dragonView.getSenzu().setEnabled(false);
		dragonView.getAbility().setEnabled(false);
		dragonView.getSuperA().setEnabled(false);
		dragonView.getUltimateA().setEnabled(false);
		CurrentGame.getPlayer().chooseWish(w2);
		break;
	case"ultimate":
		
		DragonWish w3= dragon.getWishes()[3];
		String u = "YOU GOT "+w3.getUltimateAttack().getName()+" ULTIMATE ATTACK";
		dragonView.updateChoseText(u);
		dragonView.addOK();
		dragonView.getSenzu().setEnabled(false);
		dragonView.getAbility().setEnabled(false);
		dragonView.getSuperA().setEnabled(false);
		dragonView.getUltimateA().setEnabled(false);
		CurrentGame.getPlayer().chooseWish(w3);
		break;
	case "ok":
		view.updateInfo(CurrentGame);
		dragonView.dispose();
		view.setVisible(true);
		break;
	case "save":
			try {
				CurrentGame.save("saved");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "couldn't save the game, Please try again later!");
			}
			JOptionPane.showMessageDialog(null, "YOUR GAME has been saved");
		break;
	default:
			break;
		}
		
		
	}
	public Game getCurrentGame() {
		return CurrentGame;
	}
	public void setCurrentGame(Game yala) {
		this.CurrentGame = yala;
	}
	
	
	public void setFighter(String n){
		
	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		this.dragon = dragon;
		view.setVisible(false);
		dragonView = new DragonView(dragon);
		dragonView.addWindowListener(this);
		dragonView.getSenzu().addActionListener(this);
		dragonView.getAbility().addActionListener(this);
		dragonView.getSuperA().addActionListener(this);
		dragonView.getUltimateA().addActionListener(this);
		dragonView.getOk().addActionListener(this);
		
		
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		switch (collectible) {
		case SENZU_BEAN:
			JOptionPane.showMessageDialog(null, "OHHH YEAAAAH!! YOU FOUND A SENZU BEAN !!");
			break;
		case DRAGON_BALL: 
			JOptionPane.showMessageDialog(null, "WOOOW!! YOU found a DRAGON BALL !!");
		default:
			break;
		}
		
		
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		Battle b = CurrentGame.getBattle();
		Fighter f = (Fighter)e.getCurrentOpponent();
		NonPlayableFighter Foecheck = (NonPlayableFighter) b.getFoe();
		switch (e.getType()) {
		
		case ENDED:
			battleView.getBkg().setVisible(false);
			battleView.add(battleView.getBattleEnded());
			battleView.getBattleEnded().setVisible(true);
			
			battleView.UpdateWhoWon(e);
			if(e.getWinner() == b.getMe()){
				battleView.updateXP(CurrentGame);
			
				if(CurrentGame.getPlayer().getActiveFighter().getLevel() > level){
					battleView.updateLeveL(CurrentGame , ability);
				}
				
				if(Foecheck.isStrong()){
					
					battleView.updateBoss(b);
					view = new GameView();
					view.getUp().addActionListener(this);
					view.getDown().addActionListener(this);
					view.getLeft().addActionListener(this);
					view.getRight().addActionListener(this);
					view.getCreateFighter().addActionListener(this);
					view.getUpgrade().addActionListener(this);
					view.getAssignAttack().addActionListener(this);
					view.getSwitchFighter().addActionListener(this);
					view.addWindowListener(this);
					view.getUp().addKeyListener( this);
					view.getDown().addKeyListener(this);
					view.getLeft().addKeyListener(this);
					view.getRight().addKeyListener(this);
					view.getSave().addActionListener(this);
					view.addWindowListener(this);
					view.setBoss(CurrentGame);
					view.changeFighterImg(curr, 9, 9);
					view.updateInfo(CurrentGame);
					
				}
				
			}else{
				view.move( iA,jA ,9,9);
			}
			view.setBoss(CurrentGame);
			
			break;
		case NEW_TURN:
				f = (Fighter)b.getAttacker();
				String x="";
				if(f == (Fighter) b.getMe()){
					x=((Fighter) b.getMe()).getName()+"'s TURN"; 
				}else
				x = f.getName()+"'s TURN!";
				battleView.updateTurn(x);
				if(CurrentGame.getBattle().getAttacker() == CurrentGame.getBattle().getFoe()){
					battleView.getOpponnentMove().setEnabled(true);
					battleView.getAttack().setEnabled(false);
					battleView.getUse().setEnabled(false);
					battleView.getBlock().setEnabled(false);
		}		
				
				battleView.updateSayianText(CurrentGame);
			
			break;
			
		case STARTED :
			ability=CurrentGame.getPlayer().getActiveFighter().getAbilityPoints();
			level =CurrentGame.getPlayer().getActiveFighter().getLevel();
			battleView = new BattleView();
			battleView.addWindowListener(this);
			battleView.getAttack().addActionListener(this);
			battleView.getBlock().addActionListener(this);
			battleView.getUse().addActionListener(this);
			battleView.getOpponnentMove().addActionListener(this);
			
			battleView.getBack1().addActionListener(this);
			battleView.getGo().addActionListener(this);
			JOptionPane.showMessageDialog(null, "OH OH !! YOU encountered a FOE!!");
			battleView.setFightersImage(b);
			view.setVisible(false);
			battleView.addAttacksButtons(b);
			battleView.updatePlayersInfo(b);
			battleView.setVisible(true);
			for(int i=0 ; i<battleView.getA().size(); i++){
				battleView.getA().get(i).addActionListener(this);
			}
			battleView.getOpponnentMove().setEnabled(false);
			battleView.updateSayianText(CurrentGame);
			break;
		case ATTACK :
			//Fighter zz= (Fighter) b.getMe();
			/*if (zz.getHealthPoints()<500){
				de();
			}*/
			battleView.updatePlayersInfo(b);
			String aa="";
			if( b.getAttacker() == b.getMe()){
			aa = "YOU ATTACKED!!";
			}else{
				aa="The OPPONNENT ATTACKED !!";
			}
			battleView.updateActions(aa);
			battleView.getChooseAttack().setVisible(false);
			battleView.getOpponnentMove().setEnabled(true);
			battleView.getAttack().setEnabled(false);
			battleView.getUse().setEnabled(false);
			battleView.getBlock().setEnabled(false);
			
		break;
		case BLOCK:
			battleView.updatePlayersInfo(b);
			String s="";
			if(b.getAttacker() == b.getMe()){
			s = "YOU CHOSE BLOCKING!!";
			
			}else{
				s="The Opponnent is BLOCKING";
			}
			battleView.updateActions(s);
		/*	if(CurrentGame.getBattle().getAttacker() == CurrentGame.getBattle().getFoe()){
				try {
					CurrentGame.getBattle().play();
					battleView.updateActions("");
					
				} catch (NotEnoughKiException e1) {
					CurrentGame.getBattle().block();
					
				}
				battleView.updateActions("The Opponnent made his move !!");
			}
		*/
			battleView.getOpponnentMove().setEnabled(true);
			battleView.getAttack().setEnabled(false);
			battleView.getUse().setEnabled(false);
			battleView.getBlock().setEnabled(false);
			break;
		case USE :
			battleView.updatePlayersInfo(b);
			String bl = "YOU USED A SENZU BEAN !!";
			battleView.updateActions(bl);
		/*	if(CurrentGame.getBattle().getAttacker() == CurrentGame.getBattle().getFoe()){
				try {
					CurrentGame.getBattle().play();
					
				} catch (NotEnoughKiException e1) {
					CurrentGame.getBattle().block();
					
				}
				battleView.updateActions("The Opponnent made his move !!");
			}*/
			battleView.getOpponnentMove().setEnabled(true);
			battleView.getAttack().setEnabled(false);
			battleView.getUse().setEnabled(false);
			battleView.getBlock().setEnabled(false);
			
			break;

		default:
			break;
		}
		
	}
	/*public void de(){
		int k=0;
		k=2;
		
	}*/
	public void setChooseFighterViewListeners(){
		ChooseFighterView.getSayian().addActionListener(this);
		ChooseFighterView.getEarthling().addActionListener(this);
		ChooseFighterView.getFrieza().addActionListener(this);
		ChooseFighterView.getMajin().addActionListener(this);
		ChooseFighterView.getNamekian().addActionListener(this);
		
		ChooseFighterView.getSayian().addKeyListener(this);
		ChooseFighterView.getMajin().addKeyListener(this);
		ChooseFighterView.getNamekian().addKeyListener(this);
		ChooseFighterView.getFrieza().addKeyListener(this);
		ChooseFighterView.getEarthling().addKeyListener(this);
		ChooseFighterView.getFighterNameField().addKeyListener(this);
	}
	
	
	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		

		if(Startview.getPlayerName().length() > 0) {
		Startview.getNewGame().setEnabled(true);
		Startview.getLoad().setEnabled(true);
		} else { 
			Startview.getNewGame().setEnabled(false);
			//Startview.getLoad().setEnabled(false);
		}
		
		if(ChooseFighterView.getFighterName().length() > 0) {
			ChooseFighterView.getSayian().setEnabled(true);
			ChooseFighterView.getMajin().setEnabled(true);
			ChooseFighterView.getNamekian().setEnabled(true);
			ChooseFighterView.getFrieza().setEnabled(true);
			ChooseFighterView.getEarthling().setEnabled(true);
			} else { 
				ChooseFighterView.getSayian().setEnabled(false);
				ChooseFighterView.getMajin().setEnabled(false);
				ChooseFighterView.getNamekian().setEnabled(false);
				ChooseFighterView.getFrieza().setEnabled(false);
				ChooseFighterView.getEarthling().setEnabled(false);
			}
		
		int ib = CurrentGame.getWorld().getPlayerRow();
		int jb = CurrentGame.getWorld().getPlayerColumn();
		iA=ib;
		jA=jb;
		
		if ((int)e.getKeyCode() == KeyEvent.VK_RIGHT) {
			CurrentGame.getWorld().moveRight();
			view.updateInfo(CurrentGame);
			int i=CurrentGame.getWorld().getPlayerRow();
			int j = CurrentGame.getWorld().getPlayerColumn();
			view.move(ib, jb ,i, j);
			view.repaint();
			view.validate();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	
        	CurrentGame.getWorld().moveLeft();
			view.updateInfo(CurrentGame);
			int il=CurrentGame.getWorld().getPlayerRow();
			int jl =CurrentGame.getWorld().getPlayerColumn();
			view.move( ib, jb , il, jl);
			view.repaint();
			view.validate();   
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	CurrentGame.getWorld().moveUp();
			view.updateInfo(CurrentGame);
			int iu=CurrentGame.getWorld().getPlayerRow();
			int ju = CurrentGame.getWorld().getPlayerColumn();
			view.move(ib , jb , iu, ju);
			view.repaint();
			view.validate();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	CurrentGame.getWorld().moveDown();
			view.updateInfo(CurrentGame);
			int id=CurrentGame.getWorld().getPlayerRow();
			int jd = CurrentGame.getWorld().getPlayerColumn();
			view.move( ib , jb , id, jd);
			
			view.repaint();
			view.validate();
        }
	}
	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {

		if(Startview.getPlayerName().length() > 0) {
		Startview.getNewGame().setEnabled(true);
		Startview.getLoad().setEnabled(true);
		} else { 
			Startview.getNewGame().setEnabled(false);
			//Startview.getLoad().setEnabled(false);
		}
		if(ChooseFighterView.getFighterName().length() > 0) {
			ChooseFighterView.getSayian().setEnabled(true);
			ChooseFighterView.getMajin().setEnabled(true);
			ChooseFighterView.getNamekian().setEnabled(true);
			ChooseFighterView.getFrieza().setEnabled(true);
			ChooseFighterView.getEarthling().setEnabled(true);
			} else { 
				ChooseFighterView.getSayian().setEnabled(false);
				ChooseFighterView.getMajin().setEnabled(false);
				ChooseFighterView.getNamekian().setEnabled(false);
				ChooseFighterView.getFrieza().setEnabled(false);
				ChooseFighterView.getEarthling().setEnabled(false);
			}
	}
	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		int ib = CurrentGame.getWorld().getPlayerRow();
		int jb = CurrentGame.getWorld().getPlayerColumn();
		iA=ib;
		jA=jb;
		
		if ((int)e.getKeyCode() == KeyEvent.VK_RIGHT) {
			CurrentGame.getWorld().moveRight();
			view.updateInfo(CurrentGame);
			int i=CurrentGame.getWorld().getPlayerRow();
			int j = CurrentGame.getWorld().getPlayerColumn();
			view.move(ib, jb ,i, j);
			view.repaint();
			view.validate();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	
        	CurrentGame.getWorld().moveLeft();
			view.updateInfo(CurrentGame);
			int il=CurrentGame.getWorld().getPlayerRow();
			int jl =CurrentGame.getWorld().getPlayerColumn();
			view.move( ib, jb , il, jl);
			view.repaint();
			view.validate();   
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	CurrentGame.getWorld().moveUp();
			view.updateInfo(CurrentGame);
			int iu=CurrentGame.getWorld().getPlayerRow();
			int ju = CurrentGame.getWorld().getPlayerColumn();
			view.move(ib , jb , iu, ju);
			view.repaint();
			view.validate();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	CurrentGame.getWorld().moveDown();
			view.updateInfo(CurrentGame);
			int id=CurrentGame.getWorld().getPlayerRow();
			int jd = CurrentGame.getWorld().getPlayerColumn();
			view.move( ib , jb , id, jd);
			
			view.repaint();
			view.validate();
        }
		
	}
	
	public static void main(String[] args) {
		new GameModel();
	/*	try {
			CurrentGame=new Game();
		} catch (MissingFieldException | UnknownAttackTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DragonView v = new DragonView(CurrentGame.getDragons().get(0));
		*/
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		
	       
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		
		if (JOptionPane.showConfirmDialog((JFrame)e.getSource(), 
		            "Are you sure to EXIT the GAME ??", "", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }else{
		        	((JFrame) e.getSource()).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        }
		
	}
}
