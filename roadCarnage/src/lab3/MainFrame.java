/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import states.Game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.WindowConstants;

/**
 *
 * @author Levchuk
 */
public class MainFrame extends javax.swing.JFrame {

	//main frame
	public static MainFrame sas;
	//

	private int balance;
	private double highscore;
	private Menu2 menu = new Menu2();
	private Cheats2 cheats = new Cheats2();
	private Levels2 levels = new Levels2();
	private FirstCar2 firstcar = new FirstCar2();
	private SecondCar2 secondcar = new SecondCar2();
	private ThirdCar2 thirdcar = new ThirdCar2();
	private FourthCar2 fourthcar = new FourthCar2();
	private FifthCar2 fifthcar = new FifthCar2();
	private int carChosen = 1;
	Clip clip;

	public MainFrame() {
		tuneFrame();
		setMusic();
		setPieces();
	}

	private void setPieces() {
		addPieces();
		menu.setBounds(0, 0, 1000, 700);
		cheats.setBounds(0, 700, 1000, 700);
		levels.setBounds(0, -700, 1000, 700);
		firstcar.setBounds(1000, 0, 1000, 700);
		secondcar.setBounds(2000, 0, 1000, 700);
		thirdcar.setBounds(3000, 0, 1000, 700);
		fourthcar.setBounds(4000, 0, 1000, 700);
		fifthcar.setBounds(5000, 0, 1000, 700);
	}

	private void addPieces() {
		add(menu);
		add(cheats);
		add(levels);
		add(firstcar);
		add(secondcar);
		add(thirdcar);
		add(fourthcar);
		add(fifthcar);
	}

	private void setMusic() {
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/Joyride.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	private void refreshcars() {
		firstcar.repaint();
		secondcar.repaint();
		thirdcar.repaint();
		fourthcar.repaint();
		fifthcar.repaint();
	}

	private void tuneFrame() {
		setLayout(null);
		setSize(1000, 700);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	public static void main(String[] args) {
		sas = new MainFrame();

		sas.setVisible(true);
	}

	class Menu2 extends Menu {
		@Override
		public void levelsAction() {
			for (int i = 0; i < 700; i++) {

				levels.setLocation(0, levels.getY() + 1);
				menu.setLocation(0, menu.getY() + 1);
				cheats.setLocation(0, cheats.getY() + 1);

			}
		}

		@Override
		public void cheatsAction() {
			for (int i = 0; i < 700; i++) {

				levels.setLocation(0, levels.getY() - 1);
				menu.setLocation(0, menu.getY() - 1);
				cheats.setLocation(0, cheats.getY() - 1);

			}
		}

		@Override
		public void garageAction() {

			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() - 1, 0);
				firstcar.setLocation(firstcar.getX() - 1, 0);
				secondcar.setLocation(secondcar.getX() - 1, 0);
				thirdcar.setLocation(thirdcar.getX() - 1, 0);
				fourthcar.setLocation(fourthcar.getX() - 1, 0);
				fifthcar.setLocation(fifthcar.getX() - 1, 0);
			}
		}

		@Override
		public void exitAction() {
			clip.stop();
			dispose();
			try {
				finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class Cheats2 extends Cheats {
		@Override
		public void action() {
			for (int i = 0; i < 700; i++) {

				levels.setLocation(0, levels.getY() + 1);
				menu.setLocation(0, menu.getY() + 1);
				cheats.setLocation(0, cheats.getY() + 1);

			}
		}

		@Override
		public void addMoney() {
			balance += 1488;
			firstcar.setBalance(balance);
			secondcar.setBalance(balance);
			thirdcar.setBalance(balance);
			fourthcar.setBalance(balance);
			fifthcar.setBalance(balance);
		}

		@Override
		public void unlockLevels() {
			levels.unlockAll();
		}
	}

	class Levels2 extends Levels {
		@Override
		public void action() {
			for (int i = 0; i < 700; i++) {

				levels.setLocation(0, levels.getY() - 1);
				menu.setLocation(0, menu.getY() - 1);
				cheats.setLocation(0, cheats.getY() - 1);

			}
		}

		@Override
		public void desertAction() {
			sas.setVisible(false);
			sas.clip.stop();

			AppGameContainer app = null;
			Game game = new Game("Game");
			try {
				app = new AppGameContainer(game);
				app.setDisplayMode(1000,700,false);
				app.setTargetFrameRate(60);
				app.start();
				app.destroy();
			} catch (SlickException e) {
				e.printStackTrace();
			}

			sas.setVisible(true);
			sas.clip.start();

		}

		@Override
		public void jungleAction() {

		}

		@Override
		public void arcticAction() {

		}

		@Override
		public void cityAction() {

		}

		@Override
		public void worldwideAction() {

		}
	}

	class FirstCar2 extends FirstCar {
		@Override
		public void action() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void rAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() - 1, 0);
				firstcar.setLocation(firstcar.getX() - 1, 0);
				secondcar.setLocation(secondcar.getX() - 1, 0);
				thirdcar.setLocation(thirdcar.getX() - 1, 0);
				fourthcar.setLocation(fourthcar.getX() - 1, 0);
				fifthcar.setLocation(fifthcar.getX() - 1, 0);
			}
		}

		@Override
		public void eAction() {
			carChosen = 1;
		}
	}

	class SecondCar2 extends SecondCar {
		@Override
		public void action() {
			for (int i = 0; i < 2000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void rAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() - 1, 0);
				firstcar.setLocation(firstcar.getX() - 1, 0);
				secondcar.setLocation(secondcar.getX() - 1, 0);
				thirdcar.setLocation(thirdcar.getX() - 1, 0);
				fourthcar.setLocation(fourthcar.getX() - 1, 0);
				fifthcar.setLocation(fifthcar.getX() - 1, 0);
			}
		}

		@Override
		public void lAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void mAction() {
			balance -= 100;
			firstcar.setBalance(balance);
			thirdcar.setBalance(balance);
			fourthcar.setBalance(balance);
			fifthcar.setBalance(balance);
			refreshcars();
		}

		@Override
		public void eAction() {
			carChosen = 2;
		}
	}

	class ThirdCar2 extends ThirdCar {
		@Override
		public void action() {
			for (int i = 0; i < 3000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void rAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() - 1, 0);
				firstcar.setLocation(firstcar.getX() - 1, 0);
				secondcar.setLocation(secondcar.getX() - 1, 0);
				thirdcar.setLocation(thirdcar.getX() - 1, 0);
				fourthcar.setLocation(fourthcar.getX() - 1, 0);
				fifthcar.setLocation(fifthcar.getX() - 1, 0);
			}
		}

		@Override
		public void lAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void mAction() {
			balance -= 200;
			firstcar.setBalance(balance);
			secondcar.setBalance(balance);
			fourthcar.setBalance(balance);
			fifthcar.setBalance(balance);
			refreshcars();
		}

		@Override
		public void eAction() {
			carChosen = 3;
		}
	}

	class FourthCar2 extends FourthCar {
		@Override
		public void action() {
			for (int i = 0; i < 4000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void rAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() - 1, 0);
				firstcar.setLocation(firstcar.getX() - 1, 0);
				secondcar.setLocation(secondcar.getX() - 1, 0);
				thirdcar.setLocation(thirdcar.getX() - 1, 0);
				fourthcar.setLocation(fourthcar.getX() - 1, 0);
				fifthcar.setLocation(fifthcar.getX() - 1, 0);
			}
		}

		@Override
		public void lAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void mAction() {
			balance -= 400;
			firstcar.setBalance(balance);
			thirdcar.setBalance(balance);
			secondcar.setBalance(balance);
			fifthcar.setBalance(balance);
			refreshcars();
		}

		@Override
		public void eAction() {
			carChosen = 4;
		}
	}

	class FifthCar2 extends FifthCar {
		@Override
		public void action() {
			for (int i = 0; i < 5000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void lAction() {
			for (int i = 0; i < 1000; i++) {
				menu.setLocation(menu.getX() + 1, 0);
				firstcar.setLocation(firstcar.getX() + 1, 0);
				secondcar.setLocation(secondcar.getX() + 1, 0);
				thirdcar.setLocation(thirdcar.getX() + 1, 0);
				fourthcar.setLocation(fourthcar.getX() + 1, 0);
				fifthcar.setLocation(fifthcar.getX() + 1, 0);
			}
		}

		@Override
		public void mAction() {
			balance -= 1000;
			firstcar.setBalance(balance);
			thirdcar.setBalance(balance);
			fourthcar.setBalance(balance);
			secondcar.setBalance(balance);
			refreshcars();
		}

		@Override
		public void eAction() {
			carChosen = 5;
		}
	}
}
