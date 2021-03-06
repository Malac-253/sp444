package main;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.BusinessPlan;
import models.Comment;
import models.MyRemoteClient;
import models.MyRemoteImpl;
import models.Person;
import models.VMOSA;

import views.LoginViewController;

//import views.MainViewController;

public class Main extends Application {
	
	static MyRemoteImpl Mainserver;
	static MyRemoteClient UserclientModel;
	private boolean internalTesting = true;

	@Override
	public void start(Stage stage) throws Exception {
			
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
					BPExampleA.name ="Example A - PHY210 � SYLLABUS - Don't edit me !!!!"; 
					BPExampleA.year = 2017; 
					BPExampleA.department ="000"; 
					BPExampleA.isEditable = false; 
					BPExampleA.addSection(BPExampleA.root);
					BPExampleA.root.content=("Why Physics - Physics uses simple models to understand how nature works. "
							+ "These models explain phenomena over a vast range of scales from the " + "subatomic to cosmological � that�s 45 orders of magnitude or a one with "
							+ "45 zeros after it! Almost all of the technology and science that pervades "+ "our lives: televisions, cell phones, computers, X-ray images, MRI�s, "
							+ "space telescopes, etc. come from discoveries made by physicists seeking, "+ "not to develop technology, but to understand how nature works. We have ");
					Comment BPCExampleAA = new Comment(testA,"Physics uses simple models - 12");
					Comment BPCExampleAB = new Comment(Master,"Almost all of the technology - 56");
					BPExampleA.root.addComment(BPCExampleAA);
					BPExampleA.root.addComment(BPCExampleAB);
					BPExampleA.root.children.get(0).content=("Instructor\r\n" + "Professor � Bruce Rodenborn\r\n"
							+ "Office: Lamotte 006\r\n" + "Email: bruce.rodenborn@centre.edu\r\n" + "\r\n" + "IMPORTANT: Questions about homework should be raised during class or in my office "
							+ "hours. Email support in physics is inefficient at best. I need to see your written " + "work in order to provide effective help with physics.\r\n" + "Office Hours\r\n" 
							+ "My Office hours are listed here: https://physics.centre.edu/course-pages/phy210/office-hours/\r\n" + "or contact me to find another time that works. If you are struggling or feel ");
					Comment BPCExampleAC = new Comment(testA,"bruce.rodenborn@centre.edu - ee");
					Comment BPCExampleAD = new Comment(testB,"I need to see your written - 90");
					BPExampleA.root.children.get(0).addComment(BPCExampleAC);
					BPExampleA.root.children.get(0).addComment(BPCExampleAD);
					BPExampleA.addSection(BPExampleA.root.children.get(0));
				storedBP.add(BPExampleA);
				//Example B
					BusinessPlan BPExampleB = new VMOSA();
					BPExampleB.name="Example B- CSC 374 Theory of Computation � SYLLABUS - Don't edit me !!!!";
					BPExampleB.year = 2018;
					BPExampleB.department ="000";
					BPExampleB.isEditable=true;
					BPExampleB.addSection(BPExampleB.root);
					BPExampleB.root.content=("About this Course - This is a course in the theoretical foundations of computer"
							+ " science. It is an introduction to the study of\r\n" + "abstract models of computation and " + "languages and to the use of formal methods in computer science.\r\n" + "Topics include "
							+ "finite state automata and regular expressions, context free grammars and pushdown automata, " + "Turing machines, Church's thesis, decision problems, and undecidable problems.\r\n" + "Expectations (Preconditions)\r\n" 
							+ "Prerequisite: C- or better in CSC 270 (or CSC 223) and MAT 200 or MAT 300 with a grade of C- or higher,\r\n" + "or permission of the instructor. ");
					BPExampleB.root.addComment(new Comment(Master,"CSC 374 Theory of Computation - 56"));
					BPExampleB.root.addComment(new Comment(testA,"his is a course in the theoretical foundations of computer - 12"));
					BPExampleB.root.addComment(new Comment(testB,"state automata and regular expressions - 67"));
					BPExampleB.root.addComment(new Comment(testC,"Turing machines, Church's thesis - 29"));
					BPExampleB.root.children.get(0).content=("Learning Outcomes (Postconditions)\r\n" 
							+ "After successfully completing this course, you should be able to:\r\n" + "� identify different formal language classes and their relationships;\r\n" 
							+ "� design grammars and recognizers for different formal languages;\r\n" + "� demonstrate knowledge of basic mathematical models of computation;\r\n" 
							+ "� describe the relationship between models of computation and formal languages;\r\n" + "� discuss limitations on what computers can do, and provide examples of unsolvable problems;\r\n");
					BPExampleB.addSection(BPExampleB.root.children.get(0));
					BPExampleB.root.children.get(0).addComment(new Comment(Master,"Learning Outcomes (Postconditions) - 20"));
					BPExampleB.root.children.get(0).addComment(new Comment(testA,"different formal languages - 95"));
					BPExampleB.root.children.get(0).addComment(new Comment(testB,"computation and formal langu ages - 81"));
					BPExampleB.root.children.get(0).addComment(new Comment(testC,"discuss limitations on what computers - 35"));
				storedBP.add(BPExampleB);
				//Example C
					BusinessPlan BPExampleC = new VMOSA();
					BPExampleC.name="Example C - Fran�ais 120 : Partie II � SYLLABUS - Don't edit me !!!!";
					BPExampleC.year = 2019;
					BPExampleC.department ="000";
					BPExampleC.isEditable=true;
					BPExampleC.addSection(BPExampleC.root);
					BPExampleC.root.content=("Reading: For successful completion of this class, you will need to " + "study vocabulary and grammar on your own.  Your textbook also contains many reading "
							+ "passages and presents strategies for learning to read efficiently even when you do " + "not understand all the words. Reading is one of the best ways to acquire vocabulary "
							+ "and increase your ability to express yourself. French and English sound very different, " + "but there are many words that look like and often mean the same thing.  Make an "
							+ "appointment with Prof. Wood if any structure is particularly challenging! ");
					BPExampleC.root.children.get(0).content=("Foremost, wishing everyone good health and a measure of " + "cheer! The online model we�ll be working with is based on the �tutor� model where you "
							+ "are given readings, tasks, and assignments, and at least once every week you will meet "
							+ "one-on-one with professor Wood to debrief and to get feedback. (You are encouraged to "
							+ "meet with prof. Wood more than once per week, but once is the minimal threshold)");
					BPExampleC.addSection(BPExampleC.root.children.get(0));
					BPExampleC.root.addComment(new Comment(Master,"Fran�ais 120 : Partie II � SYLLABUS - 92"));
					BPExampleC.root.addComment(new Comment(testA,"For successful completion of this class - 73"));
					BPExampleC.root.addComment(new Comment(testB,"ebrief and to get feedbacks - 67"));
					BPExampleC.root.addComment(new Comment(testC,"French and English sound very different - 61"));
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
					BPExampleD.root.children.get(0).addComment(new Comment(Master,"M - 00"));
					BPExampleD.root.children.get(0).addComment(new Comment(testA,"I - 00"));
					BPExampleD.root.children.get(0).addComment(new Comment(testB,"B - 00"));
					BPExampleD.root.children.get(0).addComment(new Comment(testC,"TAC - 00"));
					BPExampleD.root.children.get(0).content=("I will do better in teh future. And i will put this stuff to use this summer");
					BPExampleD.addSection(BPExampleD.root.children.get(0));
					BPExampleD.root.addComment(new Comment(Master,"Good luck - 00"));
					BPExampleD.root.addComment(new Comment(testA,"For successful completion of your plans - 00"));
					BPExampleD.root.addComment(new Comment(testB,"must be/do more - 00"));
					BPExampleD.root.addComment(new Comment(testC,"these plans are very hard - 00"));
				storedBP.add(BPExampleD);
			//adding to BP's and user to the main Server
				Mainserver.setStoredBP(storedBP);
				if(internalTesting){System.out.println("InTt - (1.3): adding test BP");}
				Mainserver.setStoredUser(storedUser);
				if(internalTesting){System.out.println("InTt - (1.4): adding test user");}
		
		
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
		
	}
	public static void main (String [] args) {
		launch(args);
		//run it
	}
}