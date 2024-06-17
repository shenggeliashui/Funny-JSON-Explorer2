import factory.AbsFactory;
import factory.JsonFactory;
import icons_family.FlowerIcons;
import icons_family.Icons;
import icons_family.PokerIcons;
import iterator.Iterator;
import visitor.RectVisitor;
import visitor.TreeVisitor;
import visitor.Visitor;

public class FunnyJsonExplorer {
	Visitor visitor;
	Iterator iterator;
	AbsFactory factory;
	
	public FunnyJsonExplorer(String filePath, String style, String iconFamily) {
		factory=new JsonFactory();
		load(filePath, style,iconFamily);
		show();
	}
	
	public void load(String filePath, String style, String iconFamily) {
		Icons icons=new Icons();
		
		switch (iconFamily){
		case "Poker_Faces": {
			icons=new PokerIcons();
			break;
		}
		case "Flowers": {
			icons=new FlowerIcons();
			break;
		}
		default:
			System.out.println("Error paramers!");
		}

		factory.createContainer(filePath, icons);
		iterator=factory.getIterator();
		
		switch(style) {
		case "Tree":{
			visitor=new TreeVisitor();
			break;
		}
		case "Rectangle":{
			visitor=new RectVisitor();
			break;
		}
		}
	}
	public void show() {
		while(iterator.hasNext()) {
			iterator.getNext().accept(visitor);
		}
	}
}
