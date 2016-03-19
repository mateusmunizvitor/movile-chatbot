package movile;

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class StateMachine {

	private String userid;
	private TreeNode tree;
	private ArrayList<Item> items;
	
	public StateMachine(String userid, TreeNode restaurants){
		this.userid = userid;
		this.tree = restaurants;
	}
	
	public void listOptions(){
	}
	
	public void processMessage(String message){
		message = message.replaceAll("/", "");
		int choice;
		try {
		choice = Integer.parseInt(message);
		}
		catch (ParseException e){
			// print what
			e.printStackTrace();
			return;
		}
		if (tree.getChildren().get(choice) == null){
			// print That option doesnt exist
		}
		tree = 
		
		switch (tree.type){
		case "root":
			//What do you feel like today?
			break;
		case "category":
			//We have found the following <tree.name> places:
			listOptions();
			break;
		case "restaurants":
			//print Escolheu restaurante MarioPizza
			break;
		case "meal":
			
			break;
		case "menu":
			
			break;
		}
		
	}
	
	public double getTotalPrice(){
		double ret = 0;
		for (int i = 0; i < items.size(); i++){
			ret += items.get(i).getPrice();
		}
		return ret;
	}
}
