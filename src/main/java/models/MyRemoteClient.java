package models;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class MyRemoteClient {

	private BusinessPlan currentBP=null;
	private Person loginPerson=null;
	private MyRemote server;
	private boolean internalTesting = true;
	
	public MyRemoteClient(MyRemote server) {
		this.server=server;
	}
	
	public BusinessPlan getCurrentBP() {
		return currentBP;
	}

	public void setCurrentBP(BusinessPlan currentBP) {
		this.currentBP = currentBP;
	}

	public Person getLoginPerson() {
		return loginPerson;
	
	}
	
    public static void main(String[] args) {

    }
    
    public void Hello() {
    	try {
    		String response = server.sayHello();
            System.out.println("Response: " + response );
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    } 
    
    public void askForLogin(String username, String password) {
		try {
			loginPerson=server.verifyLoginPerson(username,password);
		} catch (RemoteException e) {
			 System.err.println("Client exception: " + e.toString());
	         e.printStackTrace();
		}
		if(loginPerson!=null) {
			if(internalTesting){
				System.out.println("InTt - (CLT): User: " + loginPerson.getUsername()+" logined.");
			}else {
				System.out.println("User: " + loginPerson.getUsername()+" logined.");
			}
		}
		else {
			if(internalTesting){
				System.out.println("InTt - (CLT): User: Wrong username password combination.");
			}else {
				System.out.println("Wrong username password combination.");
			}
		}
	}
	
    public void logOut() {
    	loginPerson=null;
    	try {
			server.logOut();
			System.out.println("user logout from Client side.");
    	}catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    
    public void changeEditable(int year,boolean bol) {
    	if(loginPerson.getIsAdmin()==true) {
    		try {
        		server.changeEditable(year,bol);
        	}catch (RemoteException e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		System.out.println("Sorry, You're not a admin. You CAN'T change a BusinessPlan's isEditable.");
    	}
    }
    
    public void addPerson(String username, String password, String department, Boolean isAdmin) {
    	if(loginPerson.getIsAdmin()==true) {
    		try {
    			server.addPerson(username,password,department,isAdmin);
        	}catch (RemoteException e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		System.out.println("Sorry, You're not a admin. You CAN'T add a person");
    	}
    }
    //only client's department
    public ArrayList<BusinessPlan> askForAllBP() {
    	try {
			ArrayList<BusinessPlan> copy=server.findDepAllBP();
			return copy;
		} catch (RemoteException e) {
			System.err.println("Client exception: " + e.toString());
	        e.printStackTrace();
		}
    	return null;
    }
    public void askForBP(int year){
    	try {
    		currentBP=server.findBP(year);
    	}catch (RemoteException e) {
			 System.err.println("Client exception: " + e.toString());
	         e.printStackTrace();
		}
//    	if(currentBP!=null) {
//    		System.out.println("currentBP found."+currentBP);
//		}
//    	else {
//    		System.out.println("currentBP not found.");
//    	}
    }
    
	public void newBP(String Type) {
		if(Type=="VMOSA") {
			BusinessPlan BP = new VMOSA();
			currentBP=BP;
			currentBP.department=loginPerson.getDepartment();
		}
		else if(Type=="BYBPlan"){
			BusinessPlan BP = new BYBPlan();
			currentBP=BP;
			currentBP.department=loginPerson.getDepartment();
		}
		else if(Type=="CNTRAssessment") {
			BusinessPlan BP = new CNTRAssessment();
			currentBP=BP;
			currentBP.department=loginPerson.getDepartment();
		}
		else {
			System.out.println("The Type of the BusinessPlan is not available to create.");
		}
	}
	
	//upload BP after create a new BP or revised the old one
    public String uploadBP() {
    	if(currentBP.year<1819||currentBP.year>3000) {
    		return "Please use appropriate year attribute.";
    	}
    	else {
    		try {
    			String Message=server.addBP(currentBP);	
    			return Message;
    		}catch (RemoteException e) {
    			e.printStackTrace();
    		}
    	}
    	return null;
    }
    
	//add new BP 
    public String addBP() {
    	if(currentBP.year<1819||currentBP.year>3000) {
    		return "Please use appropriate year attribute.";
    	}
    	else {
    		try {
    			String Message=server.addNewBP(currentBP);	
    			return Message;
    		}catch (RemoteException e) {
    			e.printStackTrace();
    		}
    	}
    	return null;
    }


}
    
