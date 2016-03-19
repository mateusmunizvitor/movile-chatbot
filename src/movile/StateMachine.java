package movile;

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class StateMachine {

	private String userid;
	private TreeNode tree;
	private ArrayList<Item> items;
	private final TreeNode purchase;
	private final TreeNode root;
	private TreeNode restaurant;

	public StateMachine(String userid, TreeNode root) {
		this.userid = userid;
		this.tree = root;
		this.purchase = new TreeNode("purchase", "purchase", null, null);
		this.root = root;
		this.restaurant = null;
		this.items = new ArrayList<>();
	}

	public void listOptions() {
	}

	public String processMessage(String message) {
		message = message.replaceAll("/", "").split(" ")[0];
		
		int choice;

		switch (message) {
		case "start":
			break;
		case "back":
			if (tree.getType().equals("restaurant")) {
				items.clear();
				restaurant = null;
				tree = tree.getFather();
			} else if (tree.getType().equals("food")) {
				tree = restaurant;
			} else {
				tree = tree.getFather();
			}
			break;
		case "purchase":
			tree = purchase;
			break;
		default:
			try {
				choice = Integer.parseInt(message);
			} catch (ParseException e) {
				// print what
				e.printStackTrace();
				return "";
			}
			if (choice > tree.getChildren().size() || tree.getChildren().get(choice-1) == null) {
				return "This option doesnt exist. Can you please try again?";
				// print That option doesnt exist
			}
			tree = tree.getChildren().get(choice-1);
		}
		
		String ret = "";

		switch (tree.getType()) {
		case "root":
			ret += "What do you feel like today?\n";
			for (int i = 0; i < tree.getChildren().size(); i++) {
				ret += "/" + (i + 1) + " - " + tree.getChildren().get(i).getName() + "\n";
			}
			ret += "/cancel - Cancel";
			return ret;
		case "category":
			ret += "We have found the following " + tree.getName() + " places:\n";
			for (int i = 0; i < tree.getChildren().size(); i++) {
				ret += "/" + (i + 1) + " - " + tree.getChildren().get(i).getName() + "\n";
			}
			ret += "/back - Back\n";
			ret += "/cancel - Cancel\n";
			return ret;
		case "restaurant":
			ret += "Welcome to " + tree.getName() + "! What would you like?\n";
			restaurant = tree;
			for (int i = 0; i < tree.getChildren().size(); i++) {
				ret += "/" + (i + 1) + " - " + tree.getChildren().get(i).getName() + "\n";
			}
			ret += "/back - Back\n";
			ret += "/cancel - Cancel\n";
			return ret;
		case "meal":
			ret += "For " + tree.getName() + ", we have the following options:\n";
			for (int i = 0; i < tree.getChildren().size(); i++) {
				ret += "/" + (i + 1) + " - " + tree.getChildren().get(i).getName() + " "
						+ tree.getChildren().get(i).getItem().getPrice() + "\n";
			}
			ret += "/back - Back\n";
			ret += "/cancel - Cancel\n";
			return ret;
		case "food":
			ret += "Added " + tree.getItem().getName() + " to the shopping cart!\n";
			items.add(tree.getItem());

			for (int i = 0; i < items.size(); i++) {
				ret += items.get(i).getName() + " - " + items.get(i).getPrice() + "\n";
			}
			ret += "Total: " + getTotalPrice() + "\n";
			ret += "/back - Back\n";
			ret += "/cancel - Cancel\n";
			ret += "/purchase";
			return ret;
		default:
			return "";
		}
	}

	public double getTotalPrice() {
		double ret = 0;
		for (int i = 0; i < items.size(); i++) {
			ret += items.get(i).getPrice();
		}
		return ret;
	}
}
