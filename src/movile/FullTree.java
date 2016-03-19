package movile;

public class FullTree {
	 
    public static TreeNode instanciate ()
    {
        TreeNode root = new TreeNode("root","root",null,null);
 
        TreeNode cursor;
 
        /* Categorias de Restaurantes */
        root.addChild("category","pizza",null);
        root.addChild("category","hamburguer",null);
        //root.addChild("category","japonese",null);
       
        /* Categoria de Pizza */
        cursor = root.getChild("pizza");
       
        cursor.addChild("restaurant","Friend Brothers Pizzaria",null);
        cursor.addChild("restaurant","Grand Pizza Plaza",null);
        cursor.addChild("restaurant","The-All-Pizza Market",null);
       
        cursor = cursor.getChild("Friend Brothers Pizzaria");
       
        cursor.addChild("meal", "Main Course", null);
        cursor.addChild("meal", "Beverages", null);
       
        cursor = cursor.getChild("Main Course");
       
        cursor.addChild("food", "Portuguese", new Item("Portuguese", "1345", 20.5));
        cursor.addChild("food", "Pepperoni", new Item("Pepperoni", "1342", 21.5));
        cursor.addChild("food", "Muzarella", new Item("Muzarella", "1292", 17.9));
       
        cursor = cursor.getFather().getChild("Beverages");
       
        cursor.addChild("food", "Beer", new Item("Beer", "643", 7.9));
        cursor.addChild("food", "Soda", new Item("Soda", "659", 6.9));
        cursor.addChild("food", "Juice", new Item("Juice", "694", 8.9));
       
        /*----------------------------------------------------------------------------------- */
       
        cursor = root.getChild("pizza").getChild("Grand Pizza Plaza");
       
        cursor.addChild("meal", "Main Course", null);
        cursor.addChild("meal", "Beverages", null);
       
        cursor = cursor.getChild("Main Course");
       
        cursor.addChild("food", "Zuchinni", new Item("Zuchinni", "342", 23.5));
        cursor.addChild("food", "Parma", new Item("Parma", "344", 24.9));
        cursor.addChild("food", "Four Cheese", new Item("Four Cheese", "354", 20.9));
       
        cursor = cursor.getFather().getChild("Beverages");
       
        cursor.addChild("food", "Beer", new Item("Beer", "643", 7.9));
        cursor.addChild("food", "Soda", new Item("Soda", "659", 6.9));
       
        /*----------------------------------------------------------------------------------- */
       
        cursor = root.getChild("pizza").getChild("The-All-Pizza Market");
       
        cursor.addChild("meal", "Main Course", null);
        cursor.addChild("meal", "Beverages", null);
       
        cursor = cursor.getChild("Main Course");
       
        cursor.addChild("food", "Calabresa", new Item("Calabresa", "112", 20.5));
        cursor.addChild("food", "Chicken", new Item("Chicken", "117", 20.9));
        cursor.addChild("food", "Cheese", new Item("Cheese", "132", 15.9));
       
        cursor = cursor.getFather().getChild("Beverages");
       
        cursor.addChild("food", "Beer", new Item("Beer", "643", 7.9));
        cursor.addChild("food", "Soda", new Item("Soda", "659", 6.9));
       
        /*----------------------------------------------------------------------------------- */
       
        /* Categoria de Hamburguer */
        cursor = root.getChild("hamburguer");
       
        cursor.addChild("restaurant", "Bob's Burguer", null);
        cursor.addChild("restaurant", "The BurguerNug", null);
        cursor.addChild("restaurant", "Hamburg Place", null);
       
        cursor = cursor.getChild("Bob's Burguer");
       
        cursor.addChild("meal", "Entries", null);  
        cursor.addChild("meal", "Main Course", null);
       
        cursor = cursor.getChild("Entries");
       
        cursor.addChild("food", "Bob's Big Fries", new Item("Bob's Big Fries", "234", 12.5));
        cursor.addChild("food", "Mini Burguers", new Item("Mini Burguers", "237", 8.5));
        cursor.addChild("food", "Muzza Breadsticks", new Item("Muzza Breadsticks", "129", 10.9));
       
        cursor = cursor.getFather().getChild("Main Course");
       
        cursor.addChild("food", "Bob's Traditional", new Item("Bob's Traditional", "673", 19.9));
        cursor.addChild("food", "X-Bob", new Item("X-Bob", "654", 17.9));
        cursor.addChild("food", "The Bacon-nator", new Item("The Bacon-nator", "698", 17.9));
       
        /*----------------------------------------------------------------------------------- */
       
        cursor = root.getChild("hamburguer").getChild("The BurguerNug");
               
        cursor.addChild("meal", "Entries", null);
        cursor.addChild("meal", "Main Course", null);
        cursor.addChild("meal", "Beverages", null);
       
        cursor = cursor.getChild("Entries");
       
        cursor.addChild("food", "Nug Nuggets", new Item("Nug Nuggets", "1290", 6.7));
        cursor.addChild("food", "Classic Fries", new Item("Classic Fries", "1456", 7.9));
       
        cursor = cursor.getFather().getChild("Main Course");
       
        cursor.addChild("food", "The Nug", new Item("The Nug", "189", 22.9));
        cursor.addChild("food", "Double Nug", new Item("Double Nug", "145", 26.9));
        cursor.addChild("food", "Master Nug", new Item("Mater Nug", "176", 30.9));
       
        cursor = cursor.getFather().getChild("Beverages");
       
        cursor.addChild("food", "Regular Coke", new Item("Regular Coke", "65", 5.9));
        cursor.addChild("food", "NugShake", new Item("NugShake", "78", 9.9));
       
        /*----------------------------------------------------------------------------------- */
       
        cursor = root.getChild("hamburguer").getChild("Hamburg Place");
                       
        cursor.addChild("meal", "Entries", null);
        cursor.addChild("meal", "Main Course", null);
        cursor.addChild("meal", "Beverages", null);
       
        cursor = cursor.getChild("Entries");
       
        /* MUDAR NOME */
        cursor.addChild("food", "Nug Nuggets", new Item("Nug Nuggets", "1290", 6.7));
        cursor.addChild("food", "Classic Fries", new Item("Classic Fries", "1456", 7.9));
       
        cursor = cursor.getFather().getChild("Main Course");
       
        cursor.addChild("food", "The Nug", new Item("The Nug", "189", 22.9));
        cursor.addChild("food", "Double Nug", new Item("Double Nug", "145", 26.9));
        cursor.addChild("food", "Master Nug", new Item("Mater Nug", "176", 30.9));
       
        cursor = cursor.getFather().getChild("Beverages");
       
        cursor.addChild("food", "Regular Coke", new Item("Regular Coke", "65", 5.9));
        cursor.addChild("food", "NugShake", new Item("NugShake", "78", 9.9));
        /* MUDAR NOME */
       
        /*----------------------------------------------------------------------------------- */
       
        /* Categoria de Comida Japonesa */
        //cursor = root.getChild("japonese");
       
//        cursor.addChild("restaurant", "Maki Heaven", null);
//        cursor.addChild("restaurant", "Sushi Mart", null);
//        cursor.addChild("restaurant", "Akita's Club", null);
//       
//        cursor = root.getChild("Maki Heaven");
//       
//        cursor.addChild("meal", "Entries", null);
//        cursor.addChild("meal", "Main Course", null);
//        cursor.addChild("meal", "Beverages", null);
//       
//        cursor = root.getChild("Sushi Mart");
//       
//        cursor.addChild("meal", "Entries", null);
//        cursor.addChild("meal", "Main Course", null);
//        cursor.addChild("meal", "Beverages", null);
//       
//        cursor = root.getChild("Akita's Club");
//       
//        cursor.addChild("meal", "Entries", null);
//        cursor.addChild("meal", "Main Course", null);
//        cursor.addChild("meal", "Beverages", null);
//       
       
       
        return root;
       
    }
   
}