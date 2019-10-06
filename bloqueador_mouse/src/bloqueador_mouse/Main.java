package bloqueador_mouse;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class Main implements Runnable, MouseListener, MouseMotionListener {
	static Robot robot;
	static JPanel p;
	static boolean pressed = false;
	// default constructor

	// main class
	public static void main(String[] args) {
		// create a frame
		JFrame f = new JFrame("UNNE");

		URL iconPath = Main.class.getResource("/unne_escritorio.jpg");
		System.out.println(iconPath);
		ImageIcon icon = new ImageIcon(iconPath);
		f.setIconImage(icon.getImage());
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle barraHerramientas = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

		// set the size of the frame
		f.setSize(200, 200);

		// close the frame when close button is pressed
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setLocation(new Point(screensize.width - f.getWidth(), barraHerramientas.height - f.getHeight()));

		// create an object of mouse class
		Main m = new Main();
		p = new JPanel();
		p.setBackground(Color.GREEN);
		// add mouseListener to the frame
		p.addMouseListener(m);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 20, 100, 20 };
		gridBagLayout.rowHeights = new int[] { 20, 100, 20 };
		gridBagLayout.columnWeights = new double[] { 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		f.getContentPane().setLayout(gridBagLayout);

		// create anew panel

		// add panel to the frame
		GridBagConstraints gbc_p = new GridBagConstraints();
		gbc_p.fill = GridBagConstraints.BOTH;
		gbc_p.gridx = 1;
		gbc_p.gridy = 1;
		gbc_p.weightx = 0.1;
		gbc_p.weighty = 0.1;
		f.getContentPane().add(p, gbc_p);
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		f.setVisible(true);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getX() and getY() functions return the
	// x and y coordinates of the current
	// mouse position
	// getClickCount() returns the number of
	// quick consecutive clicks made by the user

	// this function is invoked when the mouse is pressed
	public void mousePressed(MouseEvent e) {

		// show the point where the user pressed the mouse
		pressed = true;

		System.out.println("mouse pressed at point:" + e.getX() + " " + e.getY());
	}

	// this function is invoked when the mouse is released
	public void mouseReleased(MouseEvent e) {

		// show the point where the user released the mouse click

	}

	// this function is invoked when the mouse exits the component
	public void mouseExited(MouseEvent e) {

		// show the point through which the mouse exited the frame

		System.out.println("mouse exited through point:" + e.getX() + " " + e.getY());
		// robot.mouseRelease(InputEvent.BUTTON1_MASK);

	}

	// this function is invoked when the mouse enters the component
	public void mouseEntered(MouseEvent e) {

		// show the point through which the mouse entered the frame
		// label2.setText("mouse entered at point:" + e.getX() + " " + e.getY());
		// System.out.println("mouse entered at point:" + e.getX() + " " + e.getY());
		if (pressed) {
			robot.mouseRelease(InputEvent.BUTTON2_MASK);
			System.out.println("Mouse liberado");
			pressed = false;
			p.setBackground(Color.GREEN);
		} else {
			robot.mousePress(InputEvent.BUTTON2_MASK);
			System.out.println("Mouse presionado");
			p.setBackground(Color.red);
		}

	}

	// this function is invoked when the mouse is pressed or released
	public void mouseClicked(MouseEvent e) {

		// getClickCount gives the number of quick,
		// consecutive clicks made by the user
		// show the point where the mouse is i.e
		// the x and y coordinates

		System.out
				.println("mouse clicked at point:" + e.getX() + " " + e.getY() + "mouse clicked :" + e.getClickCount());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("moviendose:" + e.getX() + " " + e.getY() + "mouse clicked :" + e.getClickCount());
	}
}
