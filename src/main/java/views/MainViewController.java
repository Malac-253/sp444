package views;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.MyRemoteClient;

public class MainViewController {
	
	MyRemoteClient UserclientModel;
	Stage stage;
	private boolean internalTesting = true;
	BorderPane MainView;
	
	public void setClient(MyRemoteClient TheUserclientModel)
    {
    	UserclientModel=TheUserclientModel;
    	
    }
	public void setStage(Stage Thestage)
    {
		stage=Thestage;
    }
	public void setView(BorderPane TheMainView)
    {
		MainView=TheMainView;
    }
	
	
	//BPListView.setItems(BPList);
	
	@FXML
	private Button SeePlans;
	
	@FXML
	private Button MakePlan;
	
    
    @FXML
    void onClickMakePlan(ActionEvent event) {
    	if(internalTesting){System.out.println("InTt - (4.1): (A) onClickMakePlan");}
    	//Getting Main View shell
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainViewController.class.getResource("../views/MainView.fxml")); 
		BorderPane MainView3 = null;
		
	//Getting Main View "all"
		FXMLLoader loader2 = new FXMLLoader();
		loader2.setLocation(MainViewController.class.getResource("../views/NewPlanView.fxml")); 
		BorderPane MainView4 = null;
	
	//Loading the views
		try {MainView3 = loader.load();} catch (IOException e) {e.printStackTrace();}
		try {MainView4 = loader2.load();} catch (IOException e) {e.printStackTrace();}
		
	//Get and setting Main view Controller
		MainViewController ControllerB = loader.getController(); //Get controller1
		//PlanListViewController ControllerC = loader2.getController(); //Get controller
		MainView3.setCenter(MainView4);
		
		if(internalTesting){System.out.println("InTt - (4.2): (A) Getting Main Controller, View, and Shell (NewPlanView)");}
				
		ControllerB.setClient(UserclientModel);//Setting the Client
		ControllerB.setStage(stage);//Setting stage
		ControllerB.setView(MainView3);
		//ControllerC.setClient(UserclientModel);//Setting the Client
		//ControllerC.setStage(stage);//Setting stage
		//ControllerC.setView(MainView3);
		if(internalTesting){System.out.println("InTt - (4.3): Setting the Client to work with");}
	
	//Loading up the main Scene
		Scene s = new Scene(MainView3);
		stage.setScene(s);
		stage.show();
		if(internalTesting){System.out.println("InTt - (4.4): (A) Initiating the stage and view");}
    }

    @FXML
    void onClickSeePlans(ActionEvent event) {
    	if(internalTesting){System.out.println("InTt - (4.1): (B) onClickSeePlans");}
	    //Getting Main View shell
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainViewController.class.getResource("../views/MainView.fxml")); 
			BorderPane MainView3 = null;
			
		//Getting Main View "all"
			FXMLLoader loader2 = new FXMLLoader();
			loader2.setLocation(MainViewController.class.getResource("../views/PlanListView.fxml")); 
			BorderPane MainView4 = null;
		
		//Loading the views
			try {MainView3 = loader.load();} catch (IOException e) {e.printStackTrace();}
			try {MainView4 = loader2.load();} catch (IOException e) {e.printStackTrace();}
			
		//Get and setting Main view Controller
			MainViewController ControllerB = loader.getController(); //Get controller1
			PlanListViewController ControllerC = loader2.getController(); //Get controller
			MainView3.setCenter(MainView4);
			
			if(internalTesting){System.out.println("InTt - (4.2): (B) Getting Main Controller, View, and Shell (PlanListView)");}
					
			ControllerB.setClient(UserclientModel);//Setting the Client
			ControllerB.setStage(stage);//Setting stage
			ControllerB.setView(MainView3);
			ControllerC.setClient(UserclientModel);//Setting the Client
			ControllerC.setStage(stage);//Setting stage
			ControllerC.setView(MainView3);
			if(internalTesting){System.out.println("InTt - (4.3): (B) Setting the Client to work with");}
		
		//Loading up the main Scene
			Scene s = new Scene(MainView3);
			stage.setScene(s);
			stage.show();
			if(internalTesting){System.out.println("InTt - (4.4): (B) Initiating the stage and view");}
		
    	
    }   


}
