/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
public class SecondCar extends javax.swing.JPanel {

	/**
	 * Creates new form FirstCar
	 */
	public SecondCar() {
		initComponents();
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

		jButton1 = new javax.swing.JButton();
		nameB = new javax.swing.JButton();
		backB = new javax.swing.JButton();
		useB = new javax.swing.JButton();
		rarrowB = new javax.swing.JButton();
		larrowB = new javax.swing.JButton();

		jButton1.setText("jButton1");

		setMaximumSize(new java.awt.Dimension(1000, 700));
		setMinimumSize(new java.awt.Dimension(1000, 700));
		setPreferredSize(new java.awt.Dimension(1000, 700));

		nameB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/stinger.png"));
		nameB.setBorderPainted(false);
		nameB.setContentAreaFilled(false);
		nameB.setFocusPainted(false);
		nameB.setFocusable(false);
		nameB.setIconTextGap(0);
		nameB.setMaximumSize(new java.awt.Dimension(453, 38));
		nameB.setMinimumSize(new java.awt.Dimension(453, 38));
		nameB.setPreferredSize(new java.awt.Dimension(453, 38));

		backB.setBorderPainted(false);
		backB.setContentAreaFilled(false);
		backB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/backSmall.png"));
		backB.setFocusPainted(false);
		backB.setFocusable(false);
		backB.setIconTextGap(0);
		backB.setMaximumSize(new java.awt.Dimension(120, 120));
		backB.setMinimumSize(new java.awt.Dimension(120, 120));
		backB.setPreferredSize(new java.awt.Dimension(120, 120));
		backB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				backBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				backBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				backBMousePressed(evt);
			}
		});

		useB.setBorderPainted(false);
		useB.setContentAreaFilled(false);
		useB.setFocusPainted(false);
		useB.setFocusable(false);
		useB.setIconTextGap(0);
		useB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/buy100small.gif"));
		useB.setMaximumSize(new java.awt.Dimension(453, 50));
		useB.setMinimumSize(new java.awt.Dimension(453, 50));
		useB.setPreferredSize(new java.awt.Dimension(453, 50));
		useB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				useBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				useBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				useBMousePressed(evt);
			}
		});

		rarrowB.setBorderPainted(false);
		rarrowB.setContentAreaFilled(false);
		rarrowB.setFocusPainted(false);
		rarrowB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/rarrowsmall.png"));
		rarrowB.setFocusable(false);
		rarrowB.setIconTextGap(0);
		rarrowB.setMaximumSize(new java.awt.Dimension(90, 78));
		rarrowB.setMinimumSize(new java.awt.Dimension(90, 78));
		rarrowB.setPreferredSize(new java.awt.Dimension(90, 78));
		rarrowB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				rarrowBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				rarrowBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				rarrowBMousePressed(evt);
			}
		});

		larrowB.setBorderPainted(false);
		larrowB.setContentAreaFilled(false);
		larrowB.setFocusPainted(false);
		larrowB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/larrowsmall.png"));
		larrowB.setFocusable(false);
		larrowB.setIconTextGap(0);
		larrowB.setMaximumSize(new java.awt.Dimension(90, 78));
		larrowB.setMinimumSize(new java.awt.Dimension(90, 78));
		larrowB.setPreferredSize(new java.awt.Dimension(90, 78));
		larrowB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				larrowBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				larrowBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				larrowBMousePressed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout
								.createSequentialGroup()
								.addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(144, 144, 144)
								.addComponent(nameB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(163, 163, 163)
								.addComponent(larrowB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(useB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(32, 32, 32).addComponent(rarrowB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(154, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(48, 48, 48).addComponent(nameB,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(larrowB, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(57, 57, 57))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(useB, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(67, 67, 67))
								.addGroup(layout.createSequentialGroup()
										.addComponent(rarrowB, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
	}// </editor-fold>//GEN-END:initComponents

	private void equipS() {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/CLANK!.wav").getAbsoluteFile());
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

	private void buyS() {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/buysound.wav").getAbsoluteFile());
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

	private void errorS() {
		Clip clip2 = null;
		AudioInputStream audioInputStream = null;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(System.getProperty("user.dir") + "/src/sounds/wrong.wav").getAbsoluteFile());
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

	private void backBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backBMouseEntered
		bEnter();
		backB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/backBig.png"));
	}// GEN-LAST:event_backBMouseEntered

	private void backBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backBMouseExited
		backB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/backSmall.png"));
	}// GEN-LAST:event_backBMouseExited

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

	private void backBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backBMousePressed
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
		action();
	}// GEN-LAST:event_backBMousePressed

	public void action() {

	}

	private void useBMouseEntered(java.awt.event.MouseEvent evt) {
		bEnter();
		if (bought == false)
			useB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/buy100big.gif"));
		else
			useB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/equipbig.gif"));
	}// GEN-LAST:event_useBMouseEntered

	private void useBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_useBMouseExited
		if (bought == false)
			useB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/buy100small.gif"));
		else
			useB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/equipsmall.gif"));
	}// GEN-LAST:event_useBMouseExited

	public void eAction() {

	}

	public void mAction() {

	}

	private void useBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_useBMousePressed
		if (bought == false && balance >= 100) {
			buyS();
			// money problem
			buy();
			balance -= 100;
			mAction();
			useB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/equipBig.gif"));
			repaint();
		} else if (balance < 100 && bought == false) {
			errorS();
		} else if (bought == true) {
			equipS();
			eAction();
		}

	}// GEN-LAST:event_useBMousePressed

	private void rarrowBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_rarrowBMouseEntered
		bEnter();
		rarrowB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/rarrowbig.png"));
	}// GEN-LAST:event_rarrowBMouseEntered

	public void rAction() {

	}

	private void rarrowBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_rarrowBMouseExited
		rarrowB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/rarrowsmall.png"));
	}// GEN-LAST:event_rarrowBMouseExited

	private void rarrowBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_rarrowBMousePressed
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
		rAction();
	}// GEN-LAST:event_rarrowBMousePressed

	private void larrowBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_larrowBMouseEntered
		bEnter();
		larrowB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/larrowbig.png"));
	}// GEN-LAST:event_larrowBMouseEntered

	private void larrowBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_larrowBMouseExited
		larrowB.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/images/larrowsmall.png"));
	}// GEN-LAST:event_larrowBMouseExited

	private void larrowBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_larrowBMousePressed
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
		lAction();
	}

	public void lAction() {

	}

	private File backgroundSource = new File(System.getProperty("user.dir") + "/src/images/garage.jpg"),
			carSource = new File(System.getProperty("user.dir") + "/src/images/Stinger-GTA2.png"),
			speedSource = new File(System.getProperty("user.dir") + "/src/images/speed.gif"),
			strengthSource = new File(System.getProperty("user.dir") + "/src/images/strength.gif"),
			barFSource = new File(System.getProperty("user.dir") + "/src/images/barF.png"),
					agilitySource = new File(System.getProperty("user.dir") + "/src/images/agility.gif"),
			barESource = new File(System.getProperty("user.dir") + "/src/images/barE.png");
	private BufferedImage background, car,agility, barF, barE, speed, strength;

	public void paintComponent(Graphics g) {
		try {
			background = ImageIO.read(backgroundSource);
		} catch (IOException ex) {
			Logger.getLogger(SecondCar.class.getName()).log(Level.SEVERE, null, ex);
		}
		g.drawImage(background, 0, 0, 1000, 700, null);
		try {
			car = ImageIO.read(carSource);
		} catch (IOException ex) {
			Logger.getLogger(SecondCar.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			barF = ImageIO.read(barFSource);
		} catch (IOException ex) {
			Logger.getLogger(SecondCar.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			barE = ImageIO.read(barESource);
		} catch (IOException ex) {
			Logger.getLogger(SecondCar.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			speed = ImageIO.read(speedSource);
		} catch (IOException ex) {
			Logger.getLogger(SecondCar.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			strength = ImageIO.read(strengthSource);
		} catch (IOException ex) {
			Logger.getLogger(SecondCar.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			agility=ImageIO.read(agilitySource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(agility,567,370,null);
		g.drawImage(car, 210, 170, 150, 300, null);
		g.drawImage(speed, 575, 170, null);
		g.drawImage(strength, 525, 270, null);
		g.drawImage(barF, 497, 218, null);
		g.drawImage(barF, 561, 218, null);
		g.drawImage(barF, 625, 218, null);
		g.drawImage(barE, 689, 218, null);
		g.drawImage(barE, 753, 218, null);
		// Now strength
		g.drawImage(barF, 497, 318, null);
		g.drawImage(barF, 561, 318, null);
		g.drawImage(barE, 625, 318, null);
		g.drawImage(barE, 689, 318, null);
		g.drawImage(barE, 753, 318, null);
		
		g.drawImage(barF, 497, 418, null);
		g.drawImage(barF, 561, 418, null);
		g.drawImage(barE, 625, 418, null);
		g.drawImage(barE, 689, 418, null);
		g.drawImage(barE, 753, 418, null);
		g.setColor(Color.green);
		g.setFont(new Font("Century Gothic Bold", 28, 28));
		g.drawString("Balance:" + balance, 780, 50);

	}

	private boolean bought = false;
	private int balance = 0;

	public void setBalance(int input) {
		balance = input;
	}

	public int getBalance() {
		return balance;
	}

	public void buy() {
		bought = true;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton backB;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton larrowB;
	private javax.swing.JButton nameB;
	private javax.swing.JButton rarrowB;
	private javax.swing.JButton useB;
	// End of variables declaration//GEN-END:variables
}
