package views;

/**
 * Sample Skeleton for 'OnePlanView.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import models.BusinessPlan;
import models.Comment;
import models.MyRemoteClient;
import models.Section;

public class OnePlanViewController {

	
	MyRemoteClient UserclientModel;

	
	private boolean internalTesting = true;

	public ObservableList<Comment> CList= FXCollections.observableArrayList();
	private ArrayList<Section> PlanListBYPASS = new ArrayList<Section>();
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="NameLabel"
    private Label NameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="TreeView"
    private TreeView<Section> TheTreeView; // Value injected by FXMLLoader

    private TreeView<Section> TheTreeView2;
    
    @FXML // fx:id="viewComments"
    private Button viewComments; // Value injected by FXMLLoader
    
    @FXML // fx:id="commentListView"
    private ListView<Comment> commentListView; // Value injected by FXMLLoader

    @FXML // fx:id="commentResolve"
    private Button commentResolve; // Value injected by FXMLLoader

    @FXML // fx:id="commentDelete"
    private Button commentDelete; // Value injected by FXMLLoader

    @FXML // fx:id="commentAddText"
    private TextArea commentAddText; // Value injected by FXMLLoader

    @FXML // fx:id="commentAdd"
    private Button commentAdd; // Value injected by FXMLLoader
    
    @FXML // fx:id="notDelete"
    private Text notDelete; // Value injected by FXMLLoader

    
    private void addNodes(Section p, TreeItem<Section> t) {
    	PlanListBYPASS.add(p);
    	t.setExpanded(true);
  		for (Section child : p.children) {
  			TreeItem<Section> node = new TreeItem<Section>(child); //.showContent());
  			t.getChildren().add(node);
  			addNodes(child, node);
  		}
  	}
    
    public void setClient(MyRemoteClient TheUserclientModel)
    {
    	TheTreeView2 = (TreeView<Section>) TheTreeView;
    	
    	if(internalTesting){System.out.println("InTt - (5 X): Block 5 - Tree view of BP");}
    	
    	UserclientModel=TheUserclientModel;
    	//ArrayList<BusinessPlan> Dulplicate= UserclientModel.askForAllBP();
		
		Section root = UserclientModel.getCurrentBP().getRoot();
		Section rootContent = root; //.showContent();
		
		if(internalTesting){System.out.println("InTt - (5.1): " + root);}
		if(internalTesting){System.out.println("InTt - (5.2): " + rootContent);}
		
		TreeItem<Section> rootItem = new TreeItem<Section>(rootContent);
		addNodes(root, rootItem);
		
		if(internalTesting){System.out.println("InTt - (5.3): " + root);}
		if(internalTesting){System.out.println("InTt - (5.4): " + rootItem);}
		    
		TheTreeView2.setShowRoot(true);
		TheTreeView2.setRoot(rootItem);
		
		NameLabel.textProperty().set(UserclientModel.getCurrentBP().name);
    }
    

    @FXML
    void onClickCommentAdd(ActionEvent event) {
    	notDelete.setOpacity(0);
    	if(internalTesting){System.out.println("InTt - (5.5): (A) onClickCommentAdd(ActionEvent event)");}
    	
    	Section ClickedSection = TheTreeView2.getSelectionModel().getSelectedItem().getValue();
    	if(ClickedSection!=null) { // if selected
    		if (commentAddText.getText()!= null || commentAddText.getText()!= "") { //add comment text
    			ClickedSection.addComment(new Comment(UserclientModel.getLoginPerson(),commentAddText.getText()));
    			notDelete.setOpacity(1);
    			notDelete.setFill(Color.GREEN);
    			notDelete.setText("Comment Added");
    			UserclientModel.uploadBP(); //saves comment when made
    			if(internalTesting){System.out.println("InTt - (5.6): (A) Comment Added");}
    		}
    		
    		//updating list
    		CList = FXCollections.observableArrayList();
        	ArrayList<Comment> Dulplicate=ClickedSection.getComments();
    		for (int i=0; i<Dulplicate.size();i++){
    			CList.add(Dulplicate.get(i));
    		}
    		if(internalTesting){System.out.println("InTt - (5.7): (A) All Comments View" + CList);}
    		commentListView.setItems(CList);
    		commentAddText.setText(""); 
    	}
    }

    @FXML
    void onClickCommentDelete(ActionEvent event) {
    	notDelete.setOpacity(0);
    	if(internalTesting){System.out.println("InTt - (5.7): (A) onClickCommentDelete(ActionEvent event)");}
    	Section ClickedSection = TheTreeView2.getSelectionModel().getSelectedItem().getValue();
    	Comment clickedCC=commentListView.getSelectionModel().getSelectedItem();
    	if (ClickedSection!=null) {
	    	if (clickedCC != null )
	    	{
	    		if(clickedCC.getUsername().matches(UserclientModel.getLoginPerson().getUsername())){
	    			ClickedSection.deleteComment(ClickedSection.getComments().indexOf(clickedCC)  ); 
	    			if(internalTesting){System.out.println("InTt - (5.8): (A.A) Comment Deleted");}
	    			notDelete.setOpacity(1);
	    			notDelete.setFill(Color.GREEN);
	    			notDelete.setText("Comment Deleted");
	    			
	    		}else {
	    			if(internalTesting){System.out.println("InTt - (5.8): (A.B) Can't delete comment you didn't make");}
	    			notDelete.setOpacity(1);
	    			notDelete.setFill(Color.RED);
	    			notDelete.setText("Can't delete comment you didn't make");
	    		}
	    		UserclientModel.uploadBP(); //saves comment when made
	    		
	    		//updating list
	    		CList = FXCollections.observableArrayList();
	    		ArrayList<Comment> Dulplicate=ClickedSection.getComments();
	    		for (int i=0; i<Dulplicate.size();i++){
	    			CList.add(Dulplicate.get(i));
	    		}
	    		if(internalTesting){System.out.println("InTt - (5.9): (A) All Comments View" + CList);}
	    		commentListView.setItems(CList);
	    		
	    	}
    	}
    	
    }

    @FXML
    void onClickCommentResolve(ActionEvent event) {
    	Section ClickedSection = TheTreeView2.getSelectionModel().getSelectedItem().getValue();
    	notDelete.setOpacity(0);
    	if(internalTesting){System.out.println("InTt - (5.7): (B) onClickCommentResolve(ActionEvent event)");}
    	Comment clickedCC=commentListView.getSelectionModel().getSelectedItem();
    	if (clickedCC != null )
    	{
    		if(clickedCC.isActive()) {
    			clickedCC.resolvedComment();
    			if(internalTesting){System.out.println("InTt - (5.8): (B.A) Comment Has been Resolve");}
    			notDelete.setOpacity(1);
    			notDelete.setFill(Color.GREEN);
    			notDelete.setText("Comment Has been Resolve");
    		}else {
    			clickedCC.resolvedComment();
    			if(internalTesting){System.out.println("InTt - (5.8): (B.B) Comment is Active ");}
    			notDelete.setOpacity(1);
    			notDelete.setFill(Color.ORANGE);
    			notDelete.setText("Comment is Active");
    		}
    		
    		UserclientModel.uploadBP(); //saves comment when made
    		
    		//updating list
    		CList = FXCollections.observableArrayList();
    		commentListView.setItems(CList);
    		ArrayList<Comment> Dulplicate=ClickedSection.getComments();
    		for (int i=0; i<Dulplicate.size();i++){
    			CList.add(Dulplicate.get(i));
    		}
    		if(internalTesting){System.out.println("InTt - (5.9): (B) All Comments View" + CList);}
    		commentListView.setItems(CList);
    		
	    }
    }

    @FXML
    void onClickCommentView(ActionEvent event) {
    	notDelete.setOpacity(0);
    	if(internalTesting){System.out.println("InTt - (5.5): (B) onClickCommentView(ActionEvent event)");}
    	CList = FXCollections.observableArrayList();
    	Section ClickedSection = TheTreeView2.getSelectionModel().getSelectedItem().getValue();
    	if(ClickedSection!=null) { // if selected
    		
    		//Would dim the delete button if more time
    		
    		ArrayList<Comment> Dulplicate=ClickedSection.getComments();
    		for (int i=0; i<Dulplicate.size();i++){
    			CList.add(Dulplicate.get(i));
    		}
    		if(internalTesting){System.out.println("InTt - (5.6): (D) All Comments View" + CList);}
    		commentListView.setItems(CList);
    		
    		if(Dulplicate.size() == 0) {
    			notDelete.setOpacity(1);
    			notDelete.setFill(Color.ORANGE);
    			notDelete.setText("No Comments Yet - add one !!");
    		}
    		 
    	}
    	

    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert TheTreeView != null : "fx:id=\"TheTreeView\" was not injected: check your FXML file 'OnePlanView.fxml'.";

    }
}
