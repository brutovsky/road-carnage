/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.*;
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
import javax.swing.ImageIcon;

/**
 *
 * @author Levchuk
 */

public class Levels extends javax.swing.JPanel {
	private File backgroundSource = new File(System.getProperty("user.dir") + "/src/images/roadbackground.jpg");
	private BufferedImage background;
	private static int levelsUnlocked = 1;
	private static double highscore = 0;

	public void setHighscore(double input) {
		highscore = input;
		repaint(new Rectangle(0,0,700,100));
	}

	private void bPositive() {
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

	private void bNegative() {
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

	public void paintComponent(Graphics g) {
		try {
			background = ImageIO.read(backgroundSource);
		} catch (IOException ex) {
			Logger.getLogger(Levels.class.getName()).log(Level.SEVERE, null, ex);
		}
		g.drawImage(background, 0, 0, 1000, 700, null);
		g.setColor(Color.red);
		g.setFont(new Font("Century Gothic Bold", 30, 40));
		g.drawString("Highscore : " + (int) (highscore * 100) / 100f + " km", 350, 75);
	}

	public void unlockAll() {
		levelsUnlocked = 5;
	}

	public void unlockLevel(int level){
		levelsUnlocked = level;
	}

	/**
	 * Creates new form Levels
	 */
	public Levels() {
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

		cityB = new javax.swing.JButton();
		arcticB = new javax.swing.JButton();
		jungleB = new javax.swing.JButton();
		desertB = new javax.swing.JButton();
		worldwideB = new javax.swing.JButton();
		backB = new javax.swing.JButton();
		warningB = new javax.swing.JButton();
		worldtourName = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		desertName = new javax.swing.JButton();
		arcticName = new javax.swing.JButton();
		jungleName = new javax.swing.JButton();
		cityName = new javax.swing.JButton();

		setMaximumSize(new java.awt.Dimension(1000, 700));
		setMinimumSize(new java.awt.Dimension(1000, 700));
		setPreferredSize(new java.awt.Dimension(1000, 700));

		cityB.setBorderPainted(false);
		cityB.setContentAreaFilled(false);
		cityB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/city.jpg"));
		cityB.setFocusPainted(false);
		cityB.setFocusable(false);
		cityB.setIconTextGap(0);
		cityB.setPreferredSize(new java.awt.Dimension(200, 200));
		cityB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cityBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cityBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				cityBMousePressed(evt);
			}
		});

		arcticB.setBorderPainted(false);
		arcticB.setContentAreaFilled(false);
		arcticB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/arctic.jpg"));
		arcticB.setFocusPainted(false);
		arcticB.setFocusable(false);
		arcticB.setIconTextGap(0);
		arcticB.setPreferredSize(new java.awt.Dimension(200, 200));
		arcticB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				arcticBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				arcticBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				arcticBMousePressed(evt);
			}
		});

		jungleB.setBorderPainted(false);
		jungleB.setContentAreaFilled(false);
		jungleB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/jungle.jpg"));
		jungleB.setFocusPainted(false);
		jungleB.setFocusable(false);
		jungleB.setIconTextGap(0);
		jungleB.setPreferredSize(new java.awt.Dimension(200, 200));
		jungleB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jungleBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jungleBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				jungleBMousePressed(evt);
			}
		});

		desertB.setBorderPainted(false);
		desertB.setContentAreaFilled(false);
		desertB.setFocusPainted(false);
		desertB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/desert.jpg"));
		desertB.setFocusable(false);
		desertB.setIconTextGap(0);
		desertB.setPreferredSize(new java.awt.Dimension(200, 200));
		desertB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				desertBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				desertBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				desertBMousePressed(evt);
			}
		});

		worldwideB.setBorderPainted(false);
		worldwideB.setContentAreaFilled(false);
		worldwideB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/worldwide.jpg"));
		worldwideB.setFocusPainted(false);
		worldwideB.setFocusable(false);
		worldwideB.setIconTextGap(0);
		worldwideB.setPreferredSize(new java.awt.Dimension(200, 200));
		worldwideB.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				worldwideBMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				worldwideBMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				worldwideBMousePressed(evt);
			}
		});

		backB.setBorderPainted(false);
		backB.setContentAreaFilled(false);
		backB.setFocusPainted(false);
		backB.setIconTextGap(0);
		backB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/backSmall.png"));
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

		warningB.setBorderPainted(false);
		warningB.setContentAreaFilled(false);
		warningB.setDefaultCapable(false);
		warningB.setFocusPainted(false);
		warningB.setFocusable(false);
		warningB.setIconTextGap(0);
		warningB.setMaximumSize(new java.awt.Dimension(382, 51));
		warningB.setMinimumSize(new java.awt.Dimension(382, 51));
		warningB.setPreferredSize(new java.awt.Dimension(382, 51));
		warningB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				warningBActionPerformed(evt);
			}
		});

		worldtourName.setBorderPainted(false);
		worldtourName.setContentAreaFilled(false);
		worldtourName.setDefaultCapable(false);
		worldtourName.setFocusPainted(false);
		worldtourName.setIconTextGap(0);
		worldtourName.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/worldtour.gif"));
		worldtourName.setMaximumSize(new java.awt.Dimension(200, 50));
		worldtourName.setMinimumSize(new java.awt.Dimension(200, 50));
		worldtourName.setPreferredSize(new java.awt.Dimension(200, 50));

		jButton2.setBorderPainted(false);
		jButton2.setContentAreaFilled(false);
		jButton2.setDefaultCapable(false);
		jButton2.setFocusPainted(false);
		jButton2.setIconTextGap(0);
		jButton2.setMaximumSize(new java.awt.Dimension(200, 50));
		jButton2.setMinimumSize(new java.awt.Dimension(200, 50));
		jButton2.setPreferredSize(new java.awt.Dimension(200, 50));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		desertName.setBorderPainted(false);
		desertName.setContentAreaFilled(false);
		desertName.setDefaultCapable(false);
		desertName.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/mojave.gif"));
		desertName.setFocusPainted(false);
		desertName.setIconTextGap(0);
		desertName.setMaximumSize(new java.awt.Dimension(200, 50));
		desertName.setMinimumSize(new java.awt.Dimension(200, 50));
		desertName.setPreferredSize(new java.awt.Dimension(200, 50));
		desertName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				desertNameActionPerformed(evt);
			}
		});

		arcticName.setBorderPainted(false);
		arcticName.setContentAreaFilled(false);
		arcticName.setDefaultCapable(false);
		arcticName.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/cold.gif"));
		arcticName.setFocusPainted(false);
		arcticName.setIconTextGap(0);
		arcticName.setMaximumSize(new java.awt.Dimension(200, 50));
		arcticName.setMinimumSize(new java.awt.Dimension(200, 50));
		arcticName.setPreferredSize(new java.awt.Dimension(200, 50));
		arcticName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				arcticNameActionPerformed(evt);
			}
		});

		jungleName.setBorderPainted(false);
		jungleName.setContentAreaFilled(false);
		jungleName.setDefaultCapable(false);
		jungleName.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/jungles.gif"));
		jungleName.setFocusPainted(false);
		jungleName.setIconTextGap(0);
		jungleName.setMaximumSize(new java.awt.Dimension(200, 50));
		jungleName.setMinimumSize(new java.awt.Dimension(200, 50));
		jungleName.setPreferredSize(new java.awt.Dimension(200, 50));
		jungleName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jungleNameActionPerformed(evt);
			}
		});

		cityName.setBorderPainted(false);
		cityName.setContentAreaFilled(false);
		cityName.setDefaultCapable(false);
		cityName.setFocusPainted(false);
		cityName.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/capital.gif"));
		cityName.setIconTextGap(0);
		cityName.setMaximumSize(new java.awt.Dimension(200, 50));
		cityName.setMinimumSize(new java.awt.Dimension(200, 50));
		cityName.setPreferredSize(new java.awt.Dimension(200, 50));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(cityB, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cityName, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(83, 83, 83)
														.addGroup(
																layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(worldtourName,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(worldwideB,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(263, 263, 263))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(arcticB, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(arcticName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(80, 80, 80)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jungleB,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jungleName,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(81, 81, 81)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(desertName,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(desertB,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
												.addGap(119, 119, 119))))
								.addGroup(layout.createSequentialGroup().addGap(187, 187, 187)
										.addComponent(warningB, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(37, 37, 37)
								.addComponent(warningB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(43, 43, 43)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(arcticB, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jungleB, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(desertB, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addComponent(backB, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 11, Short.MAX_VALUE).addComponent(jungleName,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(arcticName, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(desertName, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, Short.MAX_VALUE)))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cityB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(worldwideB, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(1, 1, 1)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(worldtourName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cityName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28)));
	}// </editor-fold>//GEN-END:initComponents

	private void desertBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_desertBMouseEntered
		bEnter();
		desertB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/desert.gif"));
	}// GEN-LAST:event_desertBMouseEntered

	private void desertBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_desertBMouseExited
		desertB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/desert.jpg"));
	}// GEN-LAST:event_desertBMouseExited

	private void desertBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_desertBMousePressed
		warningB.setIcon(null);
		bPositive();
		desertAction();
		// The code, that starts desert level
	}

	private void jungleBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jungleBMouseEntered
		bEnter();
		jungleB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/jungle.gif"));
	}// GEN-LAST:event_jungleBMouseEntered

	private void jungleBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jungleBMouseExited
		jungleB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/jungle.jpg"));
	}// GEN-LAST:event_jungleBMouseExited

	private void jungleBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jungleBMousePressed
		if (levelsUnlocked < 2) {
			bNegative();
			warningB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/warning.gif"));
		} else {
			bPositive();
			warningB.setIcon(null);
			jungleAction();
			// The code, that begins jungle level
		}
	}// GEN-LAST:event_jungleBMousePressed

	private void arcticBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_arcticBMouseEntered
		bEnter();
		arcticB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/arctic.gif"));
	}// GEN-LAST:event_arcticBMouseEntered

	private void arcticBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_arcticBMouseExited
		arcticB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/arctic.jpg"));
	}// GEN-LAST:event_arcticBMouseExited

	private void arcticBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_arcticBMousePressed
		if (levelsUnlocked < 3) {
			bNegative();
			warningB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/warning.gif"));
		} else {
			bPositive();
			warningB.setIcon(null);
			arcticAction();
			// The code, that begins Arctic level
		}
	}// GEN-LAST:event_arcticBMousePressed

	private void cityBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cityBMouseEntered
		bEnter();
		cityB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/city.gif"));
	}// GEN-LAST:event_cityBMouseEntered

	private void cityBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cityBMouseExited
		cityB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/city.jpg"));
	}// GEN-LAST:event_cityBMouseExited

	private void cityBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cityBMousePressed
		if (levelsUnlocked < 4) {
			bNegative();
			warningB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/warning.gif"));
		} else {
			bPositive();
			warningB.setIcon(null);
			cityAction();
			// The code, that begins city level
		}
	}

	private void worldwideBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_worldwideBMouseEntered
		bEnter();
		worldwideB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/worldwide.gif"));
	}

	private void worldwideBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_worldwideBMouseExited
		worldwideB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/worldwide.jpg"));
	}

	private void worldwideBMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_worldwideBMousePressed
		if (levelsUnlocked < 5) {
			bNegative();
			warningB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/warning.gif"));
		} else {
			bPositive();
			warningB.setIcon(null);
			worldwideAction();
			// The code, that begins world-tour level
		}
	}

	private void backBMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backBMouseEntered
		bEnter();
		backB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/backBig.png"));
	}// GEN-LAST:event_backBMouseEntered

	private void backBMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backBMouseExited
		backB.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/backSmall.png"));
	}// GEN-LAST:event_backBMouseExited

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton2ActionPerformed

	private void desertNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_desertNameActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_desertNameActionPerformed

	private void arcticNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_arcticNameActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_arcticNameActionPerformed

	private void jungleNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jungleNameActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jungleNameActionPerformed

	private void warningBActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_warningBActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_warningBActionPerformed

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

	public void desertAction() {

	}

	public void jungleAction() {

	}

	public void arcticAction() {

	}

	public void cityAction() {

	}

	public void worldwideAction() {

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton arcticB;
	private javax.swing.JButton arcticName;
	private javax.swing.JButton backB;
	private javax.swing.JButton cityB;
	private javax.swing.JButton cityName;
	private javax.swing.JButton desertB;
	private javax.swing.JButton desertName;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jungleB;
	private javax.swing.JButton jungleName;
	private javax.swing.JButton warningB;
	private javax.swing.JButton worldtourName;
	private javax.swing.JButton worldwideB;
	// End of variables declaration//GEN-END:variables
}
