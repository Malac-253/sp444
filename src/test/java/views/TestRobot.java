package views;
import static org.junit.jupiter.api.Assertions.fail;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import models.BusinessPlan;
import models.MyRemoteClient;
import models.MyRemoteImpl;
import models.Person;
import models.VMOSA;

@ExtendWith(ApplicationExtension.class)
public class TestRobot {
	static MyRemoteImpl Mainserver;
	static MyRemoteClient UserclientModel;
	private static boolean internalTesting = true;
	
	@BeforeAll
	//Initialize server and client 
	static void Initialization() throws RemoteException
	{		
		// Block 1 - Server Set up
					if(internalTesting){System.out.println("InTt - (1 X): Block 1 - Server Set up");}
				
					//Starting main Server
						Mainserver = new MyRemoteImpl();if(internalTesting){System.out.println("InTt - (1.1): Starting main Server");}
					
					
					//The RMI Stuff - load the Registry - with host
						//int host = 1099;
						//Registry registry = LocateRegistry.createRegistry(host);
						if(internalTesting){System.out.println("InTt - (1.2): load the Registry");}
						

					//adding test user
						ArrayList <Person> storedUser=new ArrayList<Person>();
						Person Master=new Person("Master","x10808A","000", true);	storedUser.add(Master);
						Person testA=new Person("malachi","centre","000", false);	storedUser.add(testA);
						Person testB=new Person("test","test","000", false);		storedUser.add(testB);
						Person testC=new Person("bradshaw","MKB","000", true);		storedUser.add(testC);
						Person testD=new Person("testAD","testAD","000", true);		storedUser.add(testD);
					
					//adding test BP
						ArrayList <BusinessPlan> storedBP=new ArrayList<BusinessPlan>();
						//Example A
							BusinessPlan BPExampleA = new VMOSA();
							BPExampleA.name ="Example A - PHY210 – SYLLABUS - Don't edit me !!!!"; 
							BPExampleA.year = 2017; 
							BPExampleA.department ="000"; 
							BPExampleA.isEditable = false; 
							BPExampleA.addSection(BPExampleA.root);
							BPExampleA.root.content=("Why Physics - Physics uses simple models to understand how nature works. "
									+ "These models explain phenomena over a vast range of scales from the " + "subatomic to cosmological – that’s 45 orders of magnitude or a one with "
									+ "45 zeros after it! Almost all of the technology and science that pervades "+ "our lives: televisions, cell phones, computers, X-ray images, MRI’s, "
									+ "space telescopes, etc. come from discoveries made by physicists seeking, "+ "not to develop technology, but to understand how nature works. We have ");
							BPExampleA.root.children.get(0).content=("Instructor\r\n" + "Professor – Bruce Rodenborn\r\n"
									+ "Office: Lamotte 006\r\n" + "Email: bruce.rodenborn@centre.edu\r\n" + "\r\n" + "IMPORTANT: Questions about homework should be raised during class or in my office "
									+ "hours. Email support in physics is inefficient at best. I need to see your written " + "work in order to provide effective help with physics.\r\n" + "Office Hours\r\n" 
									+ "My Office hours are listed here: https://physics.centre.edu/course-pages/phy210/office-hours/\r\n" + "or contact me to find another time that works. If you are struggling or feel ");
							BPExampleA.addSection(BPExampleA.root.children.get(0));
						storedBP.add(BPExampleA);
						//Example B
							BusinessPlan BPExampleB = new VMOSA();
							BPExampleB.name="Example B- CSC 374 Theory of Computation – SYLLABUS - Don't edit me !!!!";
							BPExampleB.year = 2018;
							BPExampleB.department ="000";
							BPExampleB.isEditable=true;
							BPExampleB.addSection(BPExampleB.root);
							BPExampleB.root.content=("About this Course - This is a course in the theoretical foundations of computer"
									+ " science. It is an introduction to the study of\r\n" + "abstract models of computation and " + "languages and to the use of formal methods in computer science.\r\n" + "Topics include "
									+ "finite state automata and regular expressions, context free grammars and pushdown automata, " + "Turing machines, Church's thesis, decision problems, and undecidable problems.\r\n" + "Expectations (Preconditions)\r\n" 
									+ "Prerequisite: C- or better in CSC 270 (or CSC 223) and MAT 200 or MAT 300 with a grade of C- or higher,\r\n" + "or permission of the instructor. ");
							BPExampleB.root.children.get(0).content=("Learning Outcomes (Postconditions)\r\n" 
									+ "After successfully completing this course, you should be able to:\r\n" + "• identify different formal language classes and their relationships;\r\n" 
									+ "• design grammars and recognizers for different formal languages;\r\n" + "• demonstrate knowledge of basic mathematical models of computation;\r\n" 
									+ "• describe the relationship between models of computation and formal languages;\r\n" + "• discuss limitations on what computers can do, and provide examples of unsolvable problems;\r\n");
							BPExampleB.addSection(BPExampleB.root.children.get(0));
						storedBP.add(BPExampleB);
						//Example C
							BusinessPlan BPExampleC = new VMOSA();
							BPExampleC.name="Example C - Français 120 : Partie II – SYLLABUS - Don't edit me !!!!";
							BPExampleC.year = 2019;
							BPExampleC.department ="000";
							BPExampleC.isEditable=true;
							BPExampleC.addSection(BPExampleC.root);
							BPExampleC.root.content=("Reading: For successful completion of this class, you will need to " + "study vocabulary and grammar on your own.  Your textbook also contains many reading "
									+ "passages and presents strategies for learning to read efficiently even when you do " + "not understand all the words. Reading is one of the best ways to acquire vocabulary "
									+ "and increase your ability to express yourself. French and English sound very different, " + "but there are many words that look like and often mean the same thing.  Make an "
									+ "appointment with Prof. Wood if any structure is particularly challenging! ");
							BPExampleC.root.children.get(0).content=("Foremost, wishing everyone good health and a measure of " + "cheer! The online model we’ll be working with is based on the “tutor” model where you "
									+ "are given readings, tasks, and assignments, and at least once every week you will meet "
									+ "one-on-one with professor Wood to debrief and to get feedback. (You are encouraged to "
									+ "meet with prof. Wood more than once per week, but once is the minimal threshold)");
							BPExampleC.addSection(BPExampleC.root.children.get(0));
						storedBP.add(BPExampleC);
						//Example D
							BusinessPlan BPExampleD = new VMOSA();
							BPExampleD.name="Example D - MAlachi Beerram plan ";
							BPExampleD.year = 2020;
							BPExampleD.department ="000";
							BPExampleD.isEditable=true;
							BPExampleD.addSection(BPExampleD.root);
							BPExampleD.root.content=("I would rather not fail but whose knows at this point ");
							BPExampleD.root.children.get(0).content=("I will do better in teh future. And i will put this stuff to use this summer");
							BPExampleD.addSection(BPExampleD.root.children.get(0));
						storedBP.add(BPExampleD);
					//adding to BP's and user to the main Server
						Mainserver.setStoredBP(storedBP);
						if(internalTesting){System.out.println("InTt - (1.3): adding test BP");}
						Mainserver.setStoredUser(storedUser);
						if(internalTesting){System.out.println("InTt - (1.4): adding test user");}		
	}
	@Start //Before
	private void start(Stage stage)
	{
		try {
			//set initial stage and view
			// Block 2 - Setting up to log in
			if(internalTesting){System.out.println("InTt - (2 X): Block 2 - Setting up to log in");}
			//Initiating the client - Give the client the Server 
				UserclientModel = new MyRemoteClient(Mainserver);if(internalTesting){System.out.println("InTt - (2.1): Initiating the client with Mainserver");}
			//Getting Login View and Controller
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("../views/LoginView.fxml")); 
				BorderPane LoginView = loader.load(); //Get view
				LoginViewController ControllerA = loader.getController(); //Get controller
				if(internalTesting){System.out.println("InTt - (2.2): Getting Login View and Controller");}			
				ControllerA.setClient(UserclientModel);//Setting the Client
				ControllerA.setStage(stage);//the stage
				if(internalTesting){System.out.println("InTt - (2.3): Setting the Client to work with");}			
			//Loading up the main Scene
				Scene s = new Scene(LoginView);
				stage.setScene(s);
				stage.show();
				if(internalTesting){System.out.println("InTt - (2.4): Initiating the stage and view");}
		}catch(Exception e) {
			e.printStackTrace();	//print fail
			fail("Fail");
		}
	}
	
	//robot Type In Text
	private void robotTypeInText(FxRobot robot, String text, String target)
	{
		robot.clickOn(target);
		robot.write(text);
	}
	//robot Pick on item
	@SuppressWarnings("unused")
	private void robotPick(FxRobot robot, String target, String item) 
	{
		robot.clickOn(target);
		robot.clickOn(item);
	}
	//robot Type In number
	@SuppressWarnings("unused")
	private void robotTypeInNumber(FxRobot robot, int text, String target)
	{
		robot.clickOn(target);
		robot.write(Integer.toString(text));
	}
	//robot log in
	private void robotLogIn(FxRobot robot, String username, String password)
	{
		robotTypeInText(robot, username, "#login");
		robotTypeInText(robot, password, "#pass");
		robot.clickOn("#submit");
	}	

	@Test
	public void testAll(FxRobot robot) {
		try {
			Thread.sleep(100);
			//Block 1: login
				//login and create new BPs
				robotLogIn(robot,"testAD","testAD");
			//Block 2: See and make Plans
				robot.clickOn("#MakePlan");
				Thread.sleep(100);
				robot.clickOn("#SeePlan");
				Thread.sleep(100);
				robot.clickOn("#MakePlan");
				Thread.sleep(100);
				robot.clickOn("#SeePlan");
				Thread.sleep(100);
				robot.clickOn("#MakePlan");
				Thread.sleep(100);
				robot.clickOn("#SeePlan");
				Thread.sleep(100);
			//Block 3: Plan view
				
				robot.clickOn("#SeePlan");
				robot.clickOn("#PlanList");
				Thread.sleep(100);
				robot.moveBy(00,-150);
				robot.rightClickOn();
				robot.clickOn("#Select");
				Thread.sleep(100);
				
				robot.clickOn("#SeePlan");
				robot.clickOn("#PlanList");
				Thread.sleep(100);
				robot.moveBy(00,-140);
				robot.rightClickOn();
				robot.clickOn("#Select");
				Thread.sleep(100);
				
				Thread.sleep(2000);
				
				if(internalTesting){System.out.println("InTt - (TESTING): THE TEST IS OVER");}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
