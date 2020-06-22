package views;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.BusinessPlan;
import models.MyRemoteClient;

public class PlanListViewController {

	public ObservableList<BusinessPlan> BPList= FXCollections.observableArrayList();
	MyRemoteClient UserclientModel;
	Stage stage;
	BorderPane MainView;
	
	private boolean internalTesting = true;
	
	public void setClient(MyRemoteClient TheUserclientModel)
    {
    	UserclientModel=TheUserclientModel;
    	ArrayList<BusinessPlan> Dulplicate=UserclientModel.askForAllBP();
		for (int i=0; i<Dulplicate.size();i++){
			BPList.add(Dulplicate.get(i));
		}
		if(internalTesting){System.out.println("InTt - (3.3): All Plan View" + BPList);}
		PlanList.setItems(BPList);
    }
	public void setStage(Stage Thestage)
    {
		stage=Thestage;
    }
	public void setView(BorderPane TheMainView)
    {
		MainView=TheMainView;
    }
	
    @FXML
    private Button view;

    @FXML
    private ListView<BusinessPlan> PlanList;
    
    @FXML
    void onClickCopy(ActionEvent event) throws IOException {
    	if(internalTesting){System.out.println("InTt - (4.1): (C) onClickCopy");}
    	BusinessPlan clickedBP=PlanList.getSelectionModel().getSelectedItem();
    	if(clickedBP!=null) { // if selected
    		UserclientModel.askForBP(clickedBP.year); //get by year
    		//Getting Main View shell
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainViewController.class.getResource("../views/MainView.fxml")); 
				BorderPane MainView = null;
				
			//Getting Main View "One"
				FXMLLoader loader2 = new FXMLLoader();
				loader2.setLocation(MainViewController.class.getResource("../views/OnePlanView.fxml")); 
				Node MainView2 = null;
			
			//Loading the views
				//try {
					MainView = loader.load();
					//} catch (IOException e) {e.printStackTrace();}
				//try {
					MainView2 = loader2.load();
					//} catch (IOException e) {e.printStackTrace();}
				
			//Get and setting Main view Controller
				MainViewController ControllerB = loader.getController(); //Get controller1
				OnePlanViewController ControllerC = loader2.getController(); //Get controller
				MainView.setCenter(MainView2);
				
				if(internalTesting){System.out.println("InTt - (4.2): (C) Getting Main Controller, View, and Shell (OnePlanView)");}
						
				ControllerB.setClient(UserclientModel);//Setting the Client
				ControllerB.setStage(stage);//Setting stage
				ControllerB.setView(MainView);
				ControllerC.setClient(UserclientModel);//Setting the Client
				//ControllerC.setStage(stage);//Setting stage
				//ControllerC.setView(MainView);
				
				if(internalTesting){System.out.println("InTt - (4.3): (C) Setting the Client to work with");}
			
			//Loading up the main Scene
				Scene s = new Scene(MainView);
				stage.setScene(s);
				stage.show();
				if(internalTesting){System.out.println("InTt - (4.4): (C) Initiating the stage and view");}

        }
    	
    	
    }
    
}
