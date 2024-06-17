

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] inputs=input.split(" ");
		//获取命令行参数
		String filePath = inputs[2];
        String style = inputs[4];
        String iconFamily = inputs[6];
        FunnyJsonExplorer fje = new FunnyJsonExplorer(filePath, style, iconFamily);
        scanner.close();
	}
	
    
}