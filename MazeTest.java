package Code.simpleOutput;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Created by: Tom Lauwers
 * Date: 10/15/2010
 * Simple program to have the Finch do a dance
 */


import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class MazeTest implements ActionListener{
	public int color;
	private static Random rng = new Random();
	public JFrame Frame = new JFrame();
	public static JPanel Border = new JPanel();
	public static JPanel Center = new JPanel();
	public static JButton Button1 = new JButton("Foward");
	public static JButton Button2 = new JButton("Reverse");
	public static JButton Button3 = new JButton("Left Turn");
	public static JButton Button4 = new JButton("Right Turn");
	public static JButton Button5 = new JButton("Rotate Left");
	public static JButton Button6 = new JButton("Rotate Right");
	public BorderLayout bord = new BorderLayout();
	public GridLayout grid = new GridLayout(0,2);
	public static boolean isFoward = false;
	public static boolean isReverse = false;
	public static boolean isLTurn = false; 
	public static boolean isRTurn = false;
	public static boolean isLRotate = false;
	public static boolean isRRotate = false;
	public static Finch myFinch = new Finch();

	 
   public static void main(final String[] args){
	   	//new MazeTest();	
	   	
	  
	    
    //myFinch.quit();
     // System.exit(0);
    }
   public MazeTest(){
	    Button1.addActionListener(this);	
	    Button2.addActionListener(this);
	    Button3.addActionListener(this);
	    Button4.addActionListener(this);
	    Button5.addActionListener(this);
	    Button6.addActionListener(this);
	    Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Maze Controller 9001");
	    Frame.setVisible(true);
	    Frame.setSize(700,700);
	    Border.setLayout(bord);
	    Frame.add(Border);
	    Border.add(Center, BorderLayout.CENTER);
	    Center.setLayout(grid);
	    Border.add(Button1, BorderLayout.NORTH);
	    Border.add(Button2, BorderLayout.SOUTH);
	    Border.add(Button3, BorderLayout.WEST);
	    Border.add(Button4, BorderLayout.EAST);
	    Center.add(Button5);
	    Center.add(Button6);
	    
   }
   public Color[] nextColor = new Color[] {
			Color.red, Color.green, Color.blue, Color.cyan, Color.magenta, Color.yellow, Color.pink, Color.white
		};
 
  public void changeColor(){
		color += rng.nextInt(nextColor.length - 1) + 1;
		if (color >= nextColor.length) color -= nextColor.length;
		myFinch.setLED(nextColor[color]);
	}
 
   
   public void actionPerformed(ActionEvent e) {
	   if (e.getSource() == Button1){
			myFinch.setWheelVelocities(225, 225, 1000);
			isFoward = true;
			//myFinch.saySomething("");
			//changeColor();
		}
		if (e.getSource() == Button2){
			myFinch.setWheelVelocities(-225, -225, 1000);
			isReverse = true;
			//myFinch.saySomething("It was a bug I swear.");
			//changeColor();
		}
		if (e.getSource() == Button3){
			myFinch.setWheelVelocities(0, 200, 800);
			isLTurn = true;
			//myFinch.saySomething("Don't mess this up.");
			//changeColor();
		}
		if (e.getSource() == Button4){
			myFinch.setWheelVelocities(0, -200, 800);
			isRTurn = true;
			//myFinch.saySomething("Don't mess this up.");
			//changeColor();
		}
		if (e.getSource() == Button5){
			myFinch.setWheelVelocities(0, 225, 100);
			isLRotate = true;
			//myFinch.saySomething("");
			//changeColor();
		}
		if (e.getSource() == Button6){
			myFinch.setWheelVelocities(225, 0, 100);
			isRRotate = true;
			//myFinch.saySomething("");
			//changeColor();
   }
   }
}

