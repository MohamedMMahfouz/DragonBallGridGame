package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dragonball.model.attack.Attack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.game.Game;


public class BattleView extends JFrame{

	private JPanel info;
	private JPanel FighterActions;
	private JTextArea meInfo;
	private JTextArea foeInfo;
	private JTextArea Turn;
	private JTextArea Actions;
	private JButton attack;
	private JButton block;
	private JButton use;
	private JPanel chooseAttack;
	private JButton physicalAtack;
	private JButton superAttack;
	private JButton ultimateAttack;
	private JButton back1;
	private JPanel Attacks;
	private JButton back2;
	private ArrayList<JButton> A;
	private JButton OpponnentMove;
	private JTextArea SayianText;
	private JLabel BattleEnded;
	private JTextArea whoWon;
	private JTextArea xpUpdate;
	private JTextArea level;
	private JTextArea boss;
	private JButton Go;
	private JLabel bkg ;
	public BattleView(){
		
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Battle MODE !!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50,50, 800, 800);
		setLayout(new BorderLayout());
		
		bkg = new JLabel(new ImageIcon("battlebkg.png"));
		add(bkg);
		bkg.setLayout(new BorderLayout());
		
		//ImageIcon x = new ImageIcon("gokub.png");
		//JLabel me = new JLabel(new ImageIcon("Frieza.png"));
		//bkg.add(me , BorderLayout.EAST );
		
		//ImageIcon y = new ImageIcon("Frieza.png");
		//JLabel foe = new JLabel(new ImageIcon("Frieza.png"));
		//bkg.add(foe, BorderLayout.WEST);
		
		info = new JPanel();
		info.setLayout(new BorderLayout());
		meInfo = new JTextArea();
		meInfo.setEditable(false);
		meInfo.setForeground(Color.RED);
		meInfo.setBackground(Color.BLACK);
		foeInfo = new JTextArea();
		foeInfo.setEditable(false);
		foeInfo.setForeground(Color.RED);
		foeInfo.setBackground(Color.BLACK);
		info.add(meInfo , BorderLayout.EAST);
		info.add(foeInfo , BorderLayout.WEST);
		info.setBackground(Color.BLACK);
		info.setVisible(true);
		//this.setVisible(true);
		bkg.add(info, BorderLayout.NORTH);
		
		FighterActions = new JPanel();
		FighterActions.setLayout(new BorderLayout());
		Turn=new JTextArea( 2 , 100);
		Turn.setBackground(Color.black);
		Turn.setForeground(Color.RED);
		Turn.setEditable(false);
		
		Actions=new JTextArea(2 , 100);
		Actions.setBackground(Color.black);
		Actions.setForeground(Color.RED);
		Actions.setEditable(false);
		
		FighterActions.setBackground(Color.black);
		add(FighterActions , BorderLayout.SOUTH);
		FighterActions.add(Turn, BorderLayout.WEST);
		FighterActions.add(Actions, BorderLayout.SOUTH);
		
		SayianText = new JTextArea();
		SayianText.setForeground(Color.red);
		SayianText.setBackground(Color.black);
		SayianText.setEditable(false);
		
		
		FighterActions.setVisible(true);
		
		JPanel ActionButtons = new JPanel(new FlowLayout());
		
		attack = new JButton("attack");
		attack.setName("attack");
		attack.setBackground(Color.BLACK);
		attack.setForeground(Color.red);
		block = new JButton("block");
		block.setName("block");
		block.setBackground(Color.BLACK);
		block.setForeground(Color.blue);
		use = new JButton("use");
		use.setName("use");
		use.setBackground(Color.BLACK);
		use.setForeground(Color.GREEN);
		
		OpponnentMove = new JButton("Opponnent Move");
		OpponnentMove.setName("OpponnentMove");
		OpponnentMove.setBackground(Color.BLACK);
		OpponnentMove.setForeground(Color.YELLOW);
		
		ActionButtons.setBackground(Color.BLACK);
		ActionButtons.add(attack );
		ActionButtons.add(block );
		ActionButtons.add(use);
		ActionButtons.add(OpponnentMove);
		FighterActions.add(ActionButtons, BorderLayout.EAST);
		bkg.add(FighterActions , BorderLayout.SOUTH);
		
		chooseAttack = new JPanel(new FlowLayout());
		//chooseAttack.setSize(new Dimension(100, 100));
		repaint();
		validate();
		physicalAtack = new JButton("Physical Attack");
		physicalAtack.setName("physicalAttack");
		physicalAtack.setBackground(Color.black);
		physicalAtack.setForeground(Color.red);
		
		/*ultimateAttack = new JButton("Ultimate Attack");
		ultimateAttack.setName("ultimateAttack");
		ultimateAttack.setBackground(Color.black);
		ultimateAttack.setForeground(Color.red);

		superAttack = new JButton("Super Attack");
		superAttack.setName("superAttack");
		superAttack.setBackground(Color.black);
		superAttack.setForeground(Color.red);
		*/
		back1 = new JButton("BACK");
		back1.setName("back1");
		back1.setBackground(Color.black);
		back1.setForeground(Color.red);
		
		/*chooseAttack.add(physicalAtack);
		chooseAttack.add(superAttack);
		chooseAttack.add(ultimateAttack);
		
		*/
		chooseAttack.add(back1);
		chooseAttack.setBackground(Color.BLACK);
		chooseAttack.setVisible(false);//remove after test
		
		Attacks = new JPanel(new FlowLayout());
		Attacks.setBackground(Color.black);
		repaint();
		validate();
		back2 = new JButton("BACK");
		back2.setName("back2");
		back2.setBackground(Color.BLACK);
		back2.setForeground(Color.red);
		
		Attacks.add(back2);
		
		BattleEnded = new JLabel(new ImageIcon("endedbkg.jpg"));
		BattleEnded.setLayout(new FlowLayout());
		bkg.setVisible(true);//shelha lama t5ls
		BattleEnded.setVisible(false);
		//add(BattleEnded , BorderLayout.CENTER);//comment
		//BattleEnded.setVisible(true);//comment
	
		whoWon=new JTextArea();
		whoWon.setEditable(false);
		bkg.add(chooseAttack, BorderLayout.CENTER);
		setVisible(false);//
		
		Go= new JButton("GO");
		Go.setName("Go");
		Go.setForeground(Color.GREEN);
		Go.setBackground(Color.black);
		BattleEnded.add(Go, BorderLayout.SOUTH);
		
		
		repaint();
		validate();
	}
	
	public void addAttacksButtons(Battle b){
		int Asize = b.getAssignedAttacks().size();
		A=new ArrayList<JButton>();
		physicalAtack = new JButton("Physical Attack");
		physicalAtack.setFont(new Font(Font.SANS_SERIF, 30, 30));
		physicalAtack.setForeground(Color.red);
		physicalAtack.setBackground(Color.black);
		physicalAtack.setName("physicalAttack");
		A.add(physicalAtack);
		chooseAttack.add(A.get(0));
		for (int i = 1; i < Asize; i++) {
			JButton c = new JButton(b.getAssignedAttacks().get(i).getName());
			c.setFont(new Font(Font.SANS_SERIF, 30, 30));
			c.setForeground(Color.red);
			c.setBackground(Color.black);
			c.setName("physicalAttack");
			A.add(c);
			chooseAttack.add(A.get(i));
		}
	}
	public void updatePlayersInfo(Battle b){
		Fighter ana = (Fighter)b.getMe();
		meInfo.setText(ana.getName()+"\n"+"Level: "+ana.getLevel()+"\n"+"MAX Health: "+ana.getMaxHealthPoints()+"  Current Health: "+ana.getHealthPoints()+"\n"+"MAX KI: "
		+ana.getMaxKi()+"  Current KI: "+ana.getKi()+"\n"+"MAX Stamina: "+ana.getMaxStamina()+"  Current Stamina: "+ana.getStamina()
		);
		meInfo.setFont(new Font(Font.SANS_SERIF, 4, 20));
		info.add(meInfo , BorderLayout.EAST);
		Fighter f = (Fighter)b.getFoe();
		foeInfo.setText(f.getName()+"\n"+"Level: "+f.getLevel()+"\n"+"MAX Health: "+f.getMaxHealthPoints()+"  Current Health: "+f.getHealthPoints()+"\n"+"MAX KI: "
		+f.getMaxKi()+"  Current KI: "+f.getKi()+"\n"+"MAX Stamina: "+f.getMaxStamina()+"  Current Stamina: "+f.getStamina()
		);
		foeInfo.setFont(new Font(Font.SANS_SERIF, 4, 20));
		info.add(foeInfo , BorderLayout.WEST);

	}
	
	public void updateSayianText(Game g){
		
		if(g.getPlayer().getActiveFighter() instanceof Saiyan){
			Saiyan ana =(Saiyan) g.getPlayer().getActiveFighter();
			if(ana.isTransformed()){
				SayianText.setText("YOU ARE TRANSFORMED!!");
						SayianText.setFont(new Font(Font.SANS_SERIF, 4, 20));
						SayianText.setForeground(Color.yellow);
			}else{
				SayianText.setText("YOU ARE NOT TRANSFORMED!!");
				SayianText.setFont(new Font(Font.SANS_SERIF, 4, 20));
				SayianText.setForeground(Color.red);
			}
			FighterActions.add(SayianText, BorderLayout.CENTER);
		}else{
			SayianText.removeAll();
		}
		SayianText.setEditable(false);
		
	}
	public void UpdateWhoWon(BattleEvent e ){
		whoWon= new JTextArea();
		Fighter x = (Fighter)e.getWinner();
		whoWon.setText("\n"+x.getName()+" HAS WON");
		whoWon.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		whoWon.setForeground(Color.BLUE);
		whoWon.setBackground(Color.black);
		whoWon.setEditable(false);
		whoWon.setOpaque(false);
		BattleEnded.add(whoWon , BorderLayout.CENTER);
	}
	public void updateXP(Game g){
		xpUpdate = new JTextArea();
		Fighter f= (Fighter) g.getBattle().getFoe();
		String AN="";
		ArrayList<Attack> att= new ArrayList<>();
		att.addAll(f.getSuperAttacks());
		att.addAll(f.getUltimateAttacks());
		for (int i = 0; i < att.size(); i++) {
			AN+=" "+att.get(i).getName();
		}
		
			
		xpUpdate.setText("\n YOUR UPDATED XP: "+g.getPlayer().getActiveFighter().getXp()+"\n"+"YOU GOT new ATTACKS :"+AN);
		xpUpdate.setFont(new Font(Font.SANS_SERIF, 10, 20));
		xpUpdate.setForeground(Color.BLUE);
		xpUpdate.setBackground(Color.black);
		xpUpdate.setEditable(false);
		xpUpdate.setOpaque(false);
		BattleEnded.add(xpUpdate);
	}
	
	public void updateLeveL(Game g, int a){
		level=new JTextArea();
		int ab=g.getPlayer().getActiveFighter().getAbilityPoints()-a;
		level.setText("\n NEW LEVEL : "+g.getPlayer().getActiveFighter().getLevel()+"\n"+"YOUR NEW TARGET XP: "+
				g.getPlayer().getActiveFighter().getTargetXp()+"\n YOU GAINED "+ab+" ABILITY POINTS" );
		level.setFont(new Font(Font.SANS_SERIF, 10, 20));
		level.setForeground(Color.BLUE);
		level.setBackground(Color.black);
		level.setEditable(false);
		level.setOpaque(false);
		BattleEnded.add(level);
		
	}
	public void updateBoss(Battle b){
		boss = new JTextArea();
		boss.setText("YOU Defeated A BOSS! A NEW MAP HAS BEEN UNLOCKED");
		boss.setFont(new Font(Font.SANS_SERIF, 10, 20));
		boss.setForeground(Color.BLUE);
		boss.setBackground(Color.black);
		boss.setOpaque(false);
		BattleEnded.add(boss);
		boss.setEditable(false);
	}
	public void setFightersImage(Battle b){
		JLabel me = new JLabel();
		if((Fighter) b.getMe() instanceof Saiyan){
		 me.setIcon(new ImageIcon("Sayianb.png"));
			
		}
		if((Fighter) b.getMe() instanceof Namekian){
			 me.setIcon(new ImageIcon("namekianb.png"));
		}
		if((Fighter) b.getMe() instanceof Frieza){
			 me.setIcon(new ImageIcon("Friezab.png"));
		}
		if((Fighter) b.getMe() instanceof Majin){
			me.setIcon(new ImageIcon("majin.png"));
		}
		if((Fighter) b.getMe() instanceof Earthling){
			 me.setIcon(new ImageIcon("Earthlingb.png"));
		}
		bkg.add(me , BorderLayout.EAST );
		Fighter f = (Fighter) b.getFoe();
		JLabel foe = new JLabel(new ImageIcon("Tennenmenb.png"));
		if(f.getName().equalsIgnoreCase("goku")){
			 foe.setIcon(new ImageIcon("Gokub.png"));
		}
		if(f.getName().equalsIgnoreCase("gohan (kid)")){
			 foe.setIcon(new ImageIcon("gohanb.png"));
		}
		if(f.getName().equalsIgnoreCase("krillin")){
			 foe.setIcon(new ImageIcon("krillinb.png"));
		}
		if(f.getName().equalsIgnoreCase("yamcha")){
			 foe.setIcon(new ImageIcon("yamchab.png"));
		}
		if(f.getName().equalsIgnoreCase("vegeta")){
			 foe.setIcon(new ImageIcon("vegetab.png"));
		}
		if(f.getName().equalsIgnoreCase("Raspberry")){
			 foe.setIcon(new ImageIcon("Raspberryb.png"));
		}
		if(f.getName().equalsIgnoreCase("navel")){
			 foe.setIcon(new ImageIcon("navelb.png"));
		}
		if(f.getName().equalsIgnoreCase("Jinkoumen")){
			 foe.setIcon(new ImageIcon("jinkoumenb.png"));
		}
		bkg.add(foe , BorderLayout.WEST );
	}
	public JTextArea getBoss() {
		return boss;
	}

	public JTextArea getWhoWon() {
		return whoWon;
	}

	public JTextArea getXpUpdate() {
		return xpUpdate;
	}

	public JTextArea getLevel() {
		return level;
	}

	public JButton getPhysicalAtack() {
		return physicalAtack;
	}

	public JButton getSuperAttack() {
		return superAttack;
	}

	public JTextArea getSayianText() {
		return SayianText;
	}



	public JButton getUltimateAttack() {
		return ultimateAttack;
	}

	public void updateTurn(String x){
		Turn.setText(x);
		Turn.setFont(new Font(Font.SANS_SERIF, 4, 12));
		
	}
	
	public void updateActions(String x){
		Actions.setText(x);
		Actions.setFont(new Font(Font.SANS_SERIF, 4, 12));
	}
	
	public static void main(String[] args) {
		BattleView v= new BattleView();
	}

	public JPanel getAttacks() {
		return Attacks;
	}

	public void setAttacks(JPanel attacks) {
		Attacks = attacks;
	}

	public JButton getAttack() {
		return attack;
	}

	public JButton getBlock() {
		return block;
	}

	public JButton getUse() {
		return use;
	}

	public JButton getBack1() {
		return back1;
	}

	public JLabel getBattleEnded() {
		return BattleEnded;
	}

	public ArrayList<JButton> getA() {
		return A;
	}

	public JPanel getChooseAttack() {
		return chooseAttack;
	}

	public JButton getOpponnentMove() {
		return OpponnentMove;
	}

	public JButton getGo() {
		return Go;
	}

	public JLabel getBkg() {
		return bkg;
	}
	
	
}
