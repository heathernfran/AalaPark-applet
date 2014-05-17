/**
	The applet depicts a scene from the fictitious TV show, Aala Park.
	
	@author Heather Frantisak
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Aala extends JApplet
{
	private Image photo;
	private Image logs;
	
	private Color darkOrange = new Color(242, 122, 30);
	private Color lightYellow = new Color(255, 245, 79);
	private Color naturalShade = new Color(184, 139, 91);
	private Color darkRed = new Color(138, 0, 14);
	private Color lightGreen = new Color(106, 195, 139);
	private Color darkBlue = new Color(0, 99, 168);
	
	private JPanel buttonsPanel = new JPanel();
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	
	private boolean animateFire = true;
	
	private Timer timer;
	private final int TIME_DELAY = 600;
	
	/**
		The init method.
	*/
	
	public void init()
	{
		getContentPane().setBackground(Color.white);
		
		photo = getImage(getDocumentBase(), "AalaParkPhoto.png");	
		logs = getImage(getDocumentBase(), "logs.png");	
		
		add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.add(startButton);
		startButton.addActionListener(new TimerListener());
		buttonsPanel.add(stopButton);
		stopButton.addActionListener(new TimerListener());
		
		timer = new Timer(TIME_DELAY, new TimerListener());
	}
	
	/**
		The paint method.
		@param g The applet's Graphics object.
	*/
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		drawPhoto(g);
		
		if (animateFire)
			drawFire1(g);
		else
			drawFire2(g);
			
		drawLogs(g);
		drawFig1(g);
		drawFig2(g);
	}
	
	public void drawPhoto(Graphics g)
	{
		// Background photograph
		g.drawImage(photo, 0, 0, this);
	}
	
	public void drawFire1(Graphics g)
	{
		int[] xCoords1 = { 494, 500, 520, 556, 590, 600, 606, 650, 668, 680, 696, 700, 720, 740, 760 };
		int[] yCoords1 = { 420, 340, 290, 355, 390, 320, 300, 200, 315, 350, 388, 310, 240, 345, 432 };
		g.setColor(lightYellow);
		g.fillPolygon(xCoords1, yCoords1, 15);

		int[] xCoords2 = { 494, 515, 520, 545, 590, 620, 626, 650, 650, 660, 696, 716, 720, 732, 760 };
		int[] yCoords2 = { 420, 380, 315, 375, 410, 370, 325, 268, 335, 365, 420, 350, 325, 382, 432 };
		g.setColor(darkOrange);
		g.fillPolygon(xCoords2, yCoords2, 15);
	}

	public void drawFire2(Graphics g)
	{
		int[] xCoords = { 494, 520, 538, 576, 615, 640, 648, 670, 705, 715, 720, 735, 745, 768, 760 };
		int[] yCoords = { 420, 340, 290, 355, 390, 320, 300, 200, 315, 350, 388, 310, 240, 345, 432 };
		g.setColor(lightYellow);
		g.fillPolygon(xCoords, yCoords, 15);
		
		int[] xCoords2 = { 494, 540, 545, 570, 615, 665, 670, 675, 695, 705, 720, 740, 745, 756, 760 };
		int[] yCoords2 = { 420, 380, 315, 375, 410, 370, 325, 268, 335, 365, 420, 350, 325, 382, 432 };
		g.setColor(darkOrange);
		g.fillPolygon(xCoords2, yCoords2, 15);
	}
	
	public void drawLogs(Graphics g)
	{
		// Logs in front of fire.
		g.drawImage(logs, 0, 0, this);
	}
	
	public void drawFig1(Graphics g)
	{	
		// Figure in foreground, on floor.
		// Top garment
		int[] xCoords1 = { 700, 700, 735, 770, 770 };
		int[] yCoords2 = { 550, 520, 495, 520, 550 };
		g.setColor(darkRed);
		g.fillPolygon(xCoords1, yCoords2, 5);
		
		// Botton garment -- left
		g.setColor(Color.black);
		g.fillRect(705,550,30,15);
		
		// Bottom garment -- right
		g.setColor(Color.black);
		g.fillRect(740,550,30,15);
		
		// Head
		g.setColor(naturalShade);
		g.fillOval(700,455,75,65);
		
		// Eye
		g.setColor(Color.white);
		g.fillOval(705,470,20,20);
		g.setColor(Color.black);
		g.fillOval(706,475,6,6);
	}
	
	public void drawFig2(Graphics g)
	{
		// Figure in background, on bench.
		// Bottom garment -- left
		g.setColor(darkBlue);
		g.fillRect(450,420,25,22);
		
		// Bottom garment -- right
		g.setColor(darkBlue);
		g.fillRect(480,420,25,25);
		
		// Top garment
		g.setColor(lightGreen);
		g.fillRect(450,380,60,45);
		
		// Head
		g.setColor(naturalShade);
		g.fillOval(445,340,65,55);
		
		// Eye
		g.setColor(Color.white);
		g.fillOval(487,348,15,15);
		g.setColor(Color.black);
		g.fillOval(497,354,5,5);
	}
	
	/**
		The TimerListener is an action listener class that
		processes the timer with buttons displayed.
	*/
	
	private class TimerListener implements ActionListener
	{
		/**
			The actionPerformed method executes when the user clicks
			one of the buttons.
			@param e The event object.
		*/
	
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == startButton)
				timer.start();
				
				animateFire = ! animateFire;
				repaint();

				animateFire = animateFire;
				repaint();
			
			if (e.getSource() == stopButton)
				timer.stop();
		}
	}
}