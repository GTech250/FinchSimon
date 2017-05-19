package Code.graphics.simonGame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;

import Code.simpleOutput.MazeTest;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class SimonSays extends MazeTest{
	
	private static final int RESPONSE_TIME = 4500;
	public static final int FOWARD = 0;
	public static final int REVERSE = 1;
	public static final int LEFT_TURN = 2;
	public static final int RIGHT_TURN = 3;
	public static final int LEFT_ROTATE = 4;
	public static final int RIGHT_ROTATE = 5;
	public static double rando;
	public static String SimonMsg;
	public static int currentAction;
	
	private static Finch myFinch;
	
	
	public static void isSimon(){
		rando = Math.random()+1;
		if (rando >= 1.4 && rando < 2.0){
			SimonMsg = "Simon Says:";
		}
		else if(rando >= 0 && rando < 1.4){
			SimonMsg = " ";
		}
	}
	public static void FinchSimon(){
		if (currentAction == 0){
			isSimon();
			myFinch.saySomething(SimonMsg + " Go Foward");
			
		}
		else if (currentAction == 1){
			isSimon();
			myFinch.saySomething(SimonMsg + " Go Reverse");
		}
		else if (currentAction == 2){
			isSimon();
			myFinch.saySomething(SimonMsg + " Turn Left");
		}
		else if (currentAction == 3){
			isSimon();
			myFinch.saySomething(SimonMsg + " Turn Right");
		}
		else if (currentAction == 4){
			isSimon();
			myFinch.saySomething(SimonMsg + " Rotate Right");
		}
		else if (currentAction == 5){
			isSimon();
			myFinch.saySomething(SimonMsg + " Rotate Right");
		}
	}

	public static void main(final String[] args){
		myFinch = new Finch();
		new MazeTest();
		SimonSays simon =  new SimonSays();
		Random random = new Random();
		long startTime;
		boolean didIt;
		
		int winCount = 0;

		for(int i = 0; i < 10; i++)
		{
			simon.getFinch().setLED(Color.RED); // turn the beak red until the command is completed
			startTime = System.currentTimeMillis(); // set the trial start time
			didIt = false;
			currentAction = random.nextInt(6);
			FinchSimon();
			switch(currentAction){
			
			 case FOWARD:
                 while(System.currentTimeMillis() - startTime < RESPONSE_TIME)
                 {
                    if(isFoward == true && SimonMsg == "Simon Says:")
                     {
                            simon.getFinch().setLED(Color.GREEN);
                            didIt = true;
                            isFoward = false;
                     }
                    else if(isFoward == true && SimonMsg == " "){
                    		didIt = false;
                    		isFoward = false;
                    }
                            
                     }
                 break;
             case REVERSE:
             	while(System.currentTimeMillis() - startTime < RESPONSE_TIME)
                 {
             		if(isReverse == true && SimonMsg == "Simon Says:")
                    {
                            simon.getFinch().setLED(Color.GREEN);
                            didIt = true;
                            isReverse = false;
                    }
             		else if(isReverse == true && SimonMsg == " "){
                		didIt = false;
                		isReverse = false;
                }
                 }
                 break;
             case LEFT_TURN:
                 while(System.currentTimeMillis() - startTime < RESPONSE_TIME)
                 {
                	 if(isLTurn == true && SimonMsg == "Simon Says:")
                     {
                             simon.getFinch().setLED(Color.GREEN);
                             didIt = true;
                             isLTurn = false;
                     }
                	 else if(isFoward == true && SimonMsg == " "){
                 		didIt = false;
                 		isLTurn = false;
                 }
                 }
                 break;
             case RIGHT_TURN:
                 while(System.currentTimeMillis() - startTime < RESPONSE_TIME)
                 {
                	 if(isRTurn == true && SimonMsg == "Simon Says:")
                     {
                             simon.getFinch().setLED(Color.GREEN);
                             didIt = true;
                             isRTurn = false;
                     }
                	 else if(isLTurn == true && SimonMsg == " "){
                 		didIt = false;
                 		isLTurn = false;
                 }
                 }
                 break;
             case LEFT_ROTATE:
                 while(System.currentTimeMillis() - startTime < RESPONSE_TIME)
                 {
                	 if(isLRotate == true && SimonMsg == "Simon Says:")
                     {
                             simon.getFinch().setLED(Color.GREEN);
                             didIt = true;
                             isLRotate = false;
                     }
                	 else if(isLRotate == true && SimonMsg == " "){
                 		didIt = false;
                 		isLRotate = false;
                 }
                 }
                 break;
             case RIGHT_ROTATE:
                 while(System.currentTimeMillis() - startTime < RESPONSE_TIME)
                 {
                	 if(isRRotate == true && SimonMsg == "Simon Says:")
                     {
                             simon.getFinch().setLED(Color.GREEN);
                             didIt = true;
                             isRRotate = false;
                     }
                	 else if(isRRotate == true && SimonMsg == " "){
                 		didIt = false;
                 		isRRotate = false;
                 }
                 }
                 break;
			}

			if(didIt == false) {
             myFinch.saySomething("Missed one");
             simon.getFinch().setLED(Color.RED);
             simon.getFinch().buzz(1000, 200);
         } // beep if incorrect

			// If you succeeded, increase win count by 1
			if(didIt) {
             myFinch.saySomething("Got it!");
             winCount++;
			}
		}
		myFinch.saySomething("You got " + winCount + " out of 10 tries.");
		System.out.println("You got " + winCount + " out of 10 tries.");
		myFinch.sleep(5000);
		System.exit(0);
	}



	
	
	
	
	public Finch getFinch()
	{
		return myFinch;
	}
	
}


