package movile;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TreeNode {
	private String type;
	private String name;
	private Item item;
	private TreeNode father;
	private ArrayList<TreeNode> children;
	
	public TreeNode(String type, String name, Item item, TreeNode father){
		this.type = type;
		this.name = name;
		this.item = item;
		this.father = father;
		this.children = new ArrayList<TreeNode>();
	}
	
	public void addChild(String type, String name, Item item){
		TreeNode newNode = new TreeNode(type, name, item, this);
		this.children.put(name,newNode);
	}
	
	public TreeNode getChild(String _name){
		for (int i = 0; i < children.size(); i++){
			if (children.get(i).getName() == _name){
				return children.get(i);
			}
		}
		return null;
	}
	
	public String getType(){
		return type;
	}
	
	public String getName(){
		return name;
	}
	
	public Item getItem(){
		return item;
	}
	
	public TreeNode getFather(){
		return father;
	}

	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	
}
