package views;

/**
 * Sample Skeleton for 'OnePlanView.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import models.MyRemoteClient;
import models.Section;

public class OnePlanViewController {

	
	MyRemoteClient UserclientModel;

	
	private boolean internalTesting = true;

	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="NameLabel"
    private Label NameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="TreeView"
    private TreeView<?> TheTreeView; // Value injected by FXMLLoader

    private TreeView<String> TheTreeView2;
    
    private void addNodes(Section p, TreeItem<String> t) {
  		t.setExpanded(true);
  		for (Section child : p.children) {
  			TreeItem<String> node = new TreeItem<String>(child.showContent());
  			t.getChildren().add(node);
  			addNodes(child, node);
  		}
  	}
    
    public void setClient(MyRemoteClient TheUserclientModel)
    {
    	TheTreeView2 = (TreeView<String>) TheTreeView;
    	
    	if(internalTesting){System.out.println("InTt - (5 X): Block 5 - Tree view of BP");}
    	
    	UserclientModel=TheUserclientModel;
    	//ArrayList<BusinessPlan> Dulplicate= UserclientModel.askForAllBP();
		
		Section root = UserclientModel.getCurrentBP().getRoot();
		String rootContent = root.showContent();
		
		if(internalTesting){System.out.println("InTt - (5.1): " + root);}
		if(internalTesting){System.out.println("InTt - (5.2): " + rootContent);}
		
		TreeItem<String> rootItem = new TreeItem<String>(rootContent);
		addNodes(root, rootItem);
		
		if(internalTesting){System.out.println("InTt - (5.3): " + root);}
		if(internalTesting){System.out.println("InTt - (5.4): " + rootItem);}
		    
		TheTreeView2.setShowRoot(true);
		TheTreeView2.setRoot(rootItem);
		
		NameLabel.textProperty().set(UserclientModel.getCurrentBP().name);
    }
    

    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert TheTreeView != null : "fx:id=\"TheTreeView\" was not injected: check your FXML file 'OnePlanView.fxml'.";

    }
}
