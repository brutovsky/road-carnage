/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Levchuk
 */
public class Menu extends javax.swing.JPanel {

	/**
	 * Creates new form Menu
	 */
	public Menu() {
		initComponents();
	}

	private void bEnter() {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/ESC.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clip2.start();
	}

	private File backgroundSource = new File(System.getProperty("user.dir") + "/src/images/startimage.jpg"),
			logoSource = new File(System.getProperty("user.dir") + "/src/images/logo.png");
	private BufferedImage background, logo;

	public void paintComponent(Graphics g) {
		try {
			background = ImageIO.read(backgroundSource);
		} catch (IOException ex) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			logo = ImageIO.read(logoSource);
		} catch (IOException ex) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
		}
		g.drawImage(background, 0, 0, null);
		g.drawImage(logo, 60, 100, null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		levelsB = new javax.swing.JButton();
		exitB = new javax.swing.JButton();
		cheatsB = new javax.swing.JButton();
		garageB = new javax.swing.JButton();

		setMaximumSize(new java.awt.Dimension(1000, 700));
		setMinimumSize(new java.awt.Dimension(1000, 700));
		setPreferredSize(new java.awt.Dimension(1000, 700));

		levelsB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/levelsSmall.gif"));
		levelsB.setBorderPainted(false);
		levelsB.setContentAreaFilled(false);
		levelsB.setFocusPainted(false);
		levelsB.setFocusable(false);
		levelsB.setIconTextGap(0);
		levelsB.setMaximumSize(new java.awt.Dimension(510, 38));
		levelsB.setMinimumSize(new java.awt.Dimension(510, 38));
		levelsB.setPreferredSize(new java.awt.Dimension(510, 38));
		levelsB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				levelsBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				levelsBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				levelsBMousePressed(evt);
			}
		});

		exitB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/exitSmall.gif"));
		exitB.setBorderPainted(false);
		exitB.setContentAreaFilled(false);
		exitB.setFocusPainted(false);
		exitB.setFocusable(false);
		exitB.setMaximumSize(new java.awt.Dimension(145, 38));
		exitB.setMinimumSize(new java.awt.Dimension(145, 38));
		exitB.setPreferredSize(new java.awt.Dimension(145, 38));
		exitB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				exitBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				exitBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				exitBMousePressed(evt);
			}
		});

		cheatsB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/cheatsSmall.gif"));
		cheatsB.setBorderPainted(false);
		cheatsB.setContentAreaFilled(false);
		cheatsB.setDefaultCapable(false);
		cheatsB.setFocusPainted(false);
		cheatsB.setFocusable(false);
		cheatsB.setIconTextGap(0);
		cheatsB.setMaximumSize(new java.awt.Dimension(522, 38));
		cheatsB.setMinimumSize(new java.awt.Dimension(522, 38));
		cheatsB.setPreferredSize(new java.awt.Dimension(522, 38));
		cheatsB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cheatsBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cheatsBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				cheatsBMousePressed(evt);
			}
		});

		garageB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/garageSmall.gif"));
		garageB.setBorderPainted(false);
		garageB.setContentAreaFilled(false);
		garageB.setDefaultCapable(false);
		garageB.setFocusPainted(false);
		garageB.setFocusable(false);
		garageB.setIconTextGap(0);
		garageB.setMaximumSize(new java.awt.Dimension(258, 38));
		garageB.setMinimumSize(new java.awt.Dimension(258, 38));
		garageB.setPreferredSize(new java.awt.Dimension(258, 38));
		garageB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				garageBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				garageBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				garageBMousePressed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(239, 239, 239)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(cheatsB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(levelsB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(245, 245, 245))
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(371, 371, 371).addComponent(garageB,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(427, 427, 427).addComponent(exitB,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(380, 380, 380)
						.addComponent(levelsB, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(21, 21, 21)
						.addComponent(garageB, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(21, 21, 21)
						.addComponent(cheatsB, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(21, 21, 21)
						.addComponent(exitB, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28)));
	}// </editor-fold>//GEN-END:initComponents

	private void levelsBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_levelsBMouseEntered
		bEnter();
		levelsB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/levelsBig.gif"));
	}// GEN-LAST:event_levelsBMouseEntered

	private void levelsBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_levelsBMouseExited
		levelsB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/levelsSmall.gif"));
	}// GEN-LAST:event_levelsBMouseExited

	private void garageBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_garageBMouseEntered
		bEnter();
		garageB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/garageBig.gif"));
	}// GEN-LAST:event_garageBMouseEntered

	private void garageBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_garageBMouseExited
		garageB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/garageSmall.gif"));
	}// GEN-LAST:event_garageBMouseExited

	private void cheatsBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cheatsBMouseEntered
		bEnter();
		cheatsB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/cheatsBig.gif"));
	}// GEN-LAST:event_cheatsBMouseEntered

	private void cheatsBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cheatsBMouseExited
		cheatsB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/cheatsSmall.gif"));
	}// GEN-LAST:event_cheatsBMouseExited

	private void exitBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_exitBMouseEntered
		bEnter();
		exitB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/exitBig.gif"));
	}// GEN-LAST:event_exitBMouseEntered

	private void exitBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_exitBMouseExited
		exitB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/exitSmall.gif"));
	}// GEN-LAST:event_exitBMouseExited

	private void levelsBMousePressed(MouseEvent evt) {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/DONE.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clip2.start();
		levelsAction();
	}

	public void levelsAction() {

	}

	private void garageBMousePressed(MouseEvent evt) {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/DONE.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clip2.start();
		garageAction();
	}

	public void garageAction() {

	}

	private void cheatsBMousePressed(MouseEvent evt) {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/DONE.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clip2.start();
		cheatsAction();
	}

	public void cheatsAction() {

	}

	private void exitBMousePressed(MouseEvent evt) {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/DONE.wav").getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip2.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clip2.start();
		exitAction();
	}

	public void exitAction() {

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cheatsB;
	private javax.swing.JButton exitB;
	private javax.swing.JButton garageB;
	private javax.swing.JButton levelsB;
	// End of variables declaration//GEN-END:variables
}