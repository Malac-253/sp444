package views;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import models.MyRemoteClient;
import models.Section;

public class junk {
MyRemoteClient UserclientModel;

	



private boolean internalTesting = true;

private ArrayList<Section> PlanListBYPASS = new ArrayList<Section>();
@FXML // ResourceBundle that was given to the FXMLLoader
private ResourceBundle resources;

@FXML // URL location of the FXML file that was given to the FXMLLoader
private URL location;

@FXML // fx:id="NameLabel"
private Label NameLabel; // Value injected by FXMLLoader

@FXML // fx:id="TreeView"
private TreeView<?> TheTreeView; // Value injected by FXMLLoader

private TreeView<String> TheTreeView2;

@FXML // fx:id="viewComments"
private Button viewComments; // Value injected by FXMLLoader

@FXML // fx:id="commentListView"
private ListView<?> commentListView; // Value injected by FXMLLoader

@FXML // fx:id="commentResolve"
private Button commentResolve; // Value injected by FXMLLoader

@FXML // fx:id="commentDelete"
private Button commentDelete; // Value injected by FXMLLoader

@FXML // fx:id="commentAddText"
private TextArea commentAddText; // Value injected by FXMLLoader

@FXML // fx:id="commentAdd"
private Button commentAdd; // Value injected by FXMLLoader


private void addNodes(Section p, TreeItem<String> t) {
	PlanListBYPASS.add(p);
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


@FXML
void onClickCommentAdd(ActionEvent event) {
	if(internalTesting){System.out.println("InTt - (5.5): (A) onClickCommentAdd(ActionEvent event)");}
	
}

@FXML
void onClickCommentDelete(ActionEvent event) {
	if(internalTesting){System.out.println("InTt - (5.5): (B) onClickCommentDelete(ActionEvent event)");}

}

@FXML
void onClickCommentResolve(ActionEvent event) {
	if(internalTesting){System.out.println("InTt - (5.5): (C) onClickCommentResolve(ActionEvent event)");}
}

@FXML
void onClickCommentView(ActionEvent event) {
	if(internalTesting){System.out.println("InTt - (5.5): (D) onClickCommentView(ActionEvent event)");}
	
	System.out.println(TheTreeView.getSelectionModel().getSelectedItem());
	System.out.println(PlanListBYPASS);
	

}

@FXML // This method is called by the FXMLLoader when initialization is complete
void initialize() {
    assert TheTreeView != null : "fx:id=\"TheTreeView\" was not injected: check your FXML file 'OnePlanView.fxml'.";

}
}
