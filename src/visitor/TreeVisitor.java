package visitor;

import nodes.Node;

public class TreeVisitor extends Visitor{

	@Override
	public void visit(Node node) {
//		if(node.getLower()) {
//			System.out.println(node.getName());
//		}
		if(node.getLevel()!=0) {
			if(node.getLower()) {
				System.out.print("  ");
			}else {
				System.out.print("│ ");
			}
			for(int i=0;i<node.getLevel();i++) {
				System.out.print("  ");
			}
		}
		if(node.getLast()) {
			System.out.print("└─");
		}else{
			System.out.print("├─");
		}
		
		System.out.println(node.getIcon()+" "+node.getName());
		node.setKidsLower();
		
	}

}
