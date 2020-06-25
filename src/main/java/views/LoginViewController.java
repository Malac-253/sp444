/**
 * Sample Skeleton for 'LoginView.fxml' Controller Class
 */

package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.MyRemoteClient;

public class LoginViewController {
	
	MyRemoteClient UserclientModel;
	Stage stage;
	
	private boolean internalTesting = true;
	
	public void setClient(MyRemoteClient TheUserclientModel)
    {
    	UserclientModel=TheUserclientModel;
    }
	public void setStage(Stage Thestage)
    {
		stage=Thestage;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="notPass"
    private Text notPass; // Value injected by FXMLLoader

    @FXML // fx:id="login"
    private TextField login; // Value injected by FXMLLoader

    @FXML // fx:id="pass"
    private PasswordField pass; // Value injected by FXMLLoader

    @FXML // fx:id="login1"
    private TextField login1; // Value injected by FXMLLoader

    @FXML // fx:id="submit"
    private Button submit; // Value injected by FXMLLoader

    @FXML
    void onClickSubmit(ActionEvent event) {
    	notPass.setOpacity(0);
    	// Block 3 - logging in
    	if(internalTesting){System.out.println("InTt - (3 X): Block 3 - logging in");}
    	
    	String username = login.getText();
    	String password = pass.getText();
    	String host = login1.getText();
    	
    	if(internalTesting){
    		System.out.println("InTt - (3.1): (A) onClickSubmit(ActionEvent event)");
    		System.out.println("InTt - (3.1): (B) Entered text -> USER: "+username + " Pass:"+ password+ " Host:"+ host);
    	}
    	
    	//Checking login
    	UserclientModel.askForLogin(username,password);
    	
    	if(UserclientModel.getLoginPerson()!=null) {
			if(internalTesting){
				System.out.println("InTt - (3.1): (C) User: " + UserclientModel.getLoginPerson().getUsername()+" logined.");
			}else {
				System.out.println("User: " + UserclientModel.getLoginPerson().getUsername()+" logined.");
			}
			
			//Getting Main View shell
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainViewController.class.getResource("../views/MainView.fxml")); 
				BorderPane MainView = null;
				
			//Getting Main View "all"
				FXMLLoader loader2 = new FXMLLoader();
				loader2.setLocation(MainViewController.class.getResource("../views/PlanListView.fxml")); 
				BorderPane MainView2 = null;
			
			//Loading the views
				try {MainView = loader.load();} catch (IOException e) {e.printStackTrace();}
				try {MainView2 = loader2.load();} catch (IOException e) {e.printStackTrace();}
				
			//Get and setting Main view Controller
				MainViewController ControllerB = loader.getController(); //Get controller1
				PlanListViewController ControllerC = loader2.getController(); //Get controller
				MainView.setCenter(MainView2);
				
				if(internalTesting){System.out.println("InTt - (3.2): Getting Main Controller, View, and Shell");}
						
				ControllerB.setClient(UserclientModel);//Setting the Client
				ControllerB.setStage(stage);//Setting stage
				ControllerB.setView(MainView);
				ControllerC.setClient(UserclientModel);//Setting the Client
				ControllerC.setStage(stage);//Setting stage
				ControllerC.setView(MainView);
				if(internalTesting){System.out.println("InTt - (3.4): Setting the Client to work with");}
			
			//Loading up the main Scene
				Scene s = new Scene(MainView);
				stage.setScene(s);
				stage.show();
				if(internalTesting){System.out.println("InTt - (3.5): Initiating the stage and view");}
				// Block 4 - Main System
		    	if(internalTesting){System.out.println("InTt - (4 X): Block 4 - Main System");}
		}
		else {
			notPass.setOpacity(1);
			if(internalTesting){
				System.out.println("InTt - (3.1): (C) Wrong username password combination.");
			}else {
				System.out.println("Wrong username password combination.");
				
			}
		}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert notPass != null : "fx:id=\"notPass\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert login1 != null : "fx:id=\"login1\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'LoginView.fxml'.";

    }
}

