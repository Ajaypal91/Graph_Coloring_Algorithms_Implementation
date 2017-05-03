package modules;
import java.util.ArrayList;

import graph.Graph;
import graph.Vertex;

public class Colors {

	private static String[] colors = {"Red", "Green", "Blue", "Yellow","White","Black","Grey","Orange","Pink","Voilet" ,"Purple",
									"Brown", "Magenta","Gold", "Cyan", "Lavender","Maroon","Indigo","Silver","Sky Blue","Teal","Lime",
									"Salmon","Tan","Blue-Green","Orchid","Goldenrod","Azure","Plum","Crimson","Steel Blue","Slate-Grey",
									"Fuzzy Wuzzy", "Fulvous", "Fuchsia Rose", "Fuchsia Purple", "Fuchsia Pink", "Fuchsia (Crayola)", "Fuchsia", "Frogert", "Fresh Air", "French Wine", "French Violet", "French Sky Blue", "French Rose", "French Raspberry", "French Puce", "French Plum", "French Pink", "French Mauve", "French Lime", "French Lilac", "French Fuchsia", "French Blue", "French Bistre", "French Beige", "Forest Green (Web)", "Forest Green (Traditional)", "Folly", "Fluorescent Yellow", "Fluorescent Pink", "Fluorescent Orange", "Floral White", "Flirt", "Flax", "Flavescent", "Flattery", "Flamingo Pink", "Flame", "Firebrick", "Fire Engine Red", "Fiery Rose", "Field Drab", "Ferrari Red", "Fern Green", "Feldspar", "Feldgrau", "Fashion Fuchsia", "Fandango Pink", "Fandango", "Falu Red", "Fallow", "Faberge Fuchsia", "Eucalyptus", "Eton Blue", "English Violet", "English Vermillion", "English Red", "English Lavender", "English Green", "Eminence", "Emerald", "Electrical Computer Crimson", "Electric Yellow", "Electric Violet", "Electric Ultramarine", "Electric Purple", "Electric Lime", "Electric Lavender", "Electric Indigo", "Electric Green", "Electric Cyan", "Electric Blue", "Egyptian Blue", "Eggshell", "Eggplant", "Eerie Black", "Ecru", "Ebony", "Earth Yellow", "Dutch White", "Dust Storm", "Duke Blue", "Drab", "Donkey Brown", "Dolphin Gray", "Dollar Bill", "Dogwood Rose", "Dodie Yellow", "Dodger Blue", "Dirt", "Dingy Dungeon", "Dim Gray", "Diamond", "Desire", "Desert Sand", "Desert", "Desaturated Cyan", "Denim Blue", "Denim", "Deer", "Deep Violet", "Deep Tuscan Red", "Deep Taupe", "Deep Spring Bud", "Deep Space Sparkle", "Deep Sky Blue", "Deep Saffron", "Deep Ruby", "Deep Red", "Deep Puce", "Deep Pink", "Deep Peach", "Deep Moss Green", "Deep Mauve", "Deep Maroon", "Deep Magenta", "Deep Lilac", "Deep Lemon", "Deep Koamaru", "Deep Jungle Green", "Deep Green-Cyan Turquoise", "Deep Green", "Deep Fuchsia", "Deep Coffee", "Deep Chestnut", "Deep Champagne", "Deep Cerise", "Deep Carrot Orange", "Deep Carmine Pink", "Deep Carmine", "Deep Aquamarine", "Debian Red", "Davy's Grey", "Dartmouth Green", "Dark Yellow", "Dark Violet", "Dark Vanilla", "Dark Turquoise", "Dark Terra Cotta", "Dark Taupe", "Dark Tangerine", "Dark Tan", "Dark Spring Green", "Dark Slate Gray", "Dark Slate Blue", "Dark Sky Blue", "Dark Sienna", "Dark Sea Green", "Dark Scarlet", "Dark Salmon", "Dark Red", "Dark Raspberry", "Dark Purple", "Dark Puce", "Dark Powder Blue", "Dark Pink", "Dark Pastel Red", "Dark Pastel Purple", "Dark Pastel Green", "Dark Pastel Blue", "Dark Orchid", "Dark Orange", "Dark Olive Green", "Dark Moss Green", "Dark Midnight Blue", "Dark Medium Gray", "Dark Magenta", "Dark Liver (Horses)", "Dark Liver", "Dark Lavender", "Dark Lava", "Dark Khaki", "Dark Jungle Green", "Dark Imperial Blue", "Dark Imperial Blue", "Dark Gunmetal", "Dark Green (X11)", "Dark Green", "Dark Gray (X11)", "Dark Goldenrod", "Dark Electric Blue", "Dark Cyan", "Dark Coral", "Dark Chestnut", "Dark Cerulean", "Dark Candy Apple Red", "Dark Byzantium", "Dark Brown-Tangelo", "Dark Brown", "Dark Blue-Gray", "Dark Blue", "Dandelion", "Daffodil", "Cyclamen", "Cyber Yellow", "Cyber Grape", "Cyan-Blue Azure", "Cyan Cornflower Blue", "Cyan Cobalt Blue", "Cyan Azure", "Cyan (Process)", "Cyan", "Cultured", "Crimson Red", "Crimson Glory", "Crimson", "Cream", "Coyote Brown", "Cotton Candy", "Cosmic Latte", "Cosmic Cobalt", "Cornsilk", "Cornflower Blue", "Cornell Red", "Corn", "Cordovan", "Coral Reef", "Coral Red", "Coral Pink", "Coral", "Coquelicot", "Copper Rose", "Copper Red", "Copper Penny", "Copper (Crayola)", "Copper", "Cool Grey", "Cool Black", "Congo Pink", "Columbia Blue", "Coffee", "Coconut", "Cocoa Brown", "Cobalt Blue", "Classic Rose", "Claret", "Citron", "Citrine", "Cinnamon[Citation Needed]", "Cinnamon Satin", "Cinnabar", "Cinereous", "Chrome Yellow", "Chocolate (Web)", "Chocolate (Traditional)", "Chlorophyll Green", "Chinese Violet", "Chinese Red", "China Rose", "China Pink", "Chestnut", "Cherry Blossom Pink", "Cherry", "Chartreuse (Web)", "Chartreuse (Traditional)", "Charm Pink", "Charleston Green", "Charcoal", "Champagne Pink", "Champagne", "Chamoisee", "CG Red", "CG Blue", "Cerulean Frost", "Cerulean Blue", "Cerulean", "Cerise Pink", "Cerise", "Celestial Blue", "Celeste", "Celadon Green", "Celadon Blue", "Celadon", "Ceil", "Cedar Chest", "Catawba", "Catalina Blue", "Castleton Green", "Carrot Orange", "Carolina Blue", "Carnelian", "Carnation Pink", "Carmine Red", "Carmine Pink", "Carmine (M&P)", "Carmine", "Caribbean Green", "Cardinal", "Caput Mortuum", "Capri", "Candy Pink", "Candy Apple Red", "Canary Yellow", "Canary", "Camouflage Green", "Cameo Pink", "Camel", "Cambridge Blue", "Cal Poly Pomona Green", "Café Noir", "Café Au Lait", "Cadmium Yellow", "Cadmium Red", "Cadmium Orange", "Cadmium Green", "Cadet Grey", "Cadet Blue", "Cadet", "Byzantium", "Byzantine", "Button Blue", "Burnt Umber", "Burnt Sienna", "Burnt Orange", "Burnished Brown", "Burlywood", "Burgundy", "Bulgarian Rose", "Buff", "Bud Green", "Bubbles", "Bubble Gum", "Brunswick Green", "Brown-Nose", "Brown Yellow", "Brown Sugar", "Brown (Web)", "Brown (Traditional)", "Bronze Yellow", "Bronze", "British Racing Green", "Brink Pink", "Brilliant Rose", "Brilliant Lavender", "Brilliant Azure", "Bright Yellow (Crayola)", "Bright Ube", "Bright Turquoise", "Bright Pink", "Bright Navy Blue", "Bright Maroon", "Bright Lilac", "Bright Lavender", "Bright Green", "Bright Cerulean", "Brick Red", "Brass", "Brandeis Blue", "Boysenberry", "Bottle Green", "Boston University Red", "Booger Buster", "Bone", "Bondi Blue", "Bole", "Blush", "Bluebonnet", "Blueberry", "Blue-Violet", "Blue-Magenta Violet", "Blue-Green", "Blue-Gray", "Blue Yonder", "Blue Sapphire", "Blue Lagoon", "Blue Jeans", "Blue Bolt", "Blue Bell", "Blue (RYB)", "Blue (Pigment)", "Blue (Pantone)", "Blue (NCS)", "Blue (Munsell)", "Blue (Crayola)", "Blue", "Blond", "Blizzard Blue", "Bleu De France", "Blast-Off Bronze", "Blanched Almond", "Black Shadows", "Black Olive", "Black Leather Jacket", "Black Coral", "Black Bean", "Black", "Bittersweet Shimmer", "Bittersweet", "Bitter Lime", "Bitter Lemon", "Bistre Brown", "Bistre", "Bisque", "Big Foot Feet", "Big Dip O’ruby", "Beige", "Begonia", "Beaver", "Beau Blue", "Bazaar", "Battleship Grey", "Battery Charged Blue", "Barn Red", "Barbie Pink", "Bangladesh Green", "Banana Yellow", "Banana Mania", "Ball Blue", "Baker-Miller Pink", "Baby Powder", "Baby Pink", "Baby Blue Eyes", "Baby Blue", "B'dazzled Blue", "Azureish White", "Azure Mist", "Azure (Web Color)", "Azure", "Aztec Gold", "Awesome", "Avocado", "AuroMetalSaurus", "Aureolin", "Auburn", "Atomic Tangerine", "Atlantic Blue", "Asparagus", "Ash Gray", "Arylide Yellow", "Artichoke", "Arsenic", "Army Green", "Arctic Lime", "Aquamarine", "Aqua", "Apricot", "Apple Green", "Ao (English)", "Antique White", "Antique Ruby", "Antique Fuchsia", "Antique Bronze", "Antique Brass", "Anti-Flash White", "Android Green", "Amethyst", "American Rose", "Amber (SAE/ECE)", "Amber", "Amazonite", "Amazon Store", "Amaranth Red", "Amaranth Purple", "Amaranth Pink", "Amaranth Deep Purple", "Amaranth", "Almond", "Alloy Orange", "Alizarin Crimson", "Alien Armpit", "Alabaster", "Alabama Crimson", "Air Superiority Blue", "Air Force", "Blue (USAF)", "Air Force Blue (RAF)", "African Violet", "Aero Blue", "Aero", "Acid Green", "Absolute Zero"};
	
	
	public static String getColor(int index){
		return colors[index%colors.length];
	}
	
	public static void printColors(Graph G){
		
		System.out.println("<-------------------->");
		
		G.printGraphColoringTechnique();
		
		ArrayList<Vertex> vertices = G.getVertices();
		
		for (Vertex v: vertices){
			
			if (  v.color < vertices.size() && v.color >=0 ){
				System.out.println("Vertex: " + v.props.get("value") + " has color = " + colors[v.color]);
			}
			else {
				System.out.println("Vertex: " + v.props.get("value") + " has no color defined");
			}
			
		}
		G.printCardinality();
		System.out.println("<-------------------->");
		
	}
	
//	public static void printSudokuColors(Graph G){
//		
//		System.out.println("<-------------------->");
//		
//		G.printGraphColoringTechnique();
//		
//		ArrayList<Vertex> vertices = G.getVertices();
//		
//		for (Vertex v: vertices){
//			
//			if (v.color >=0 ){
//				System.out.println("Vertex: " + v.props.get("value") + " has color = " + v.color);
//			}
//			else {
//				System.out.println("Vertex: " + v.props.get("value") + " has no color defined");
//			}
//			
//		}
//		
//		System.out.println("<-------------------->");
//		
//	}
	
	public static void printSudoku(Graph G){
		
		ArrayList<Vertex> vertices = G.getVertices();
		
		System.out.println("-------------");
		for(int i =0; i< 9; i++){
			
			if(i%3 == 0){
				System.out.println("-------------");
			}
			
			for (int j =0; j < 9; j++){
				if (j%3==0)
					System.out.print("|");
				System.out.print(vertices.get(i*9+j).color);
			}
			System.out.print("|");
			System.out.println();
			
		}
		System.out.println("-------------");
		
	}
	
	public static void printVertexCoverage(Graph G, int i){
		 
		 int numberOfVerticesColored = 0;
		 
		 ArrayList<Vertex> vertices = G.getVertices();
		 
		 for (Vertex v : vertices){
			 if (v.color >= 0)
				 numberOfVerticesColored++;
		 }
		
		 System.out.println("The percentage of vertex colored with " + i + " colors = " + ((float)(numberOfVerticesColored)/((float)G.getVertices().size()))*100 + "%") ;
		 System.out.println("<-------------------->");
	}
	
	public static int maximumColorsAvailable(){
		return colors.length;
	}
	
}
