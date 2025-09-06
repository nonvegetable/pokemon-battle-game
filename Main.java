import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("1. Start Game");
			System.out.println("2. Quit");
			System.out.print("Enter the number: ");
			int startInput = scanner.nextInt();
			System.out.print("\n");
			
			if(startInput == 1){
				System.out.println("Game started");
				//startGame();
				break;
			} else if(startInput == 2){
				System.out.println("Game quit");
				//endGame();
				break;
			}
			else{
				System.out.println("Enter the proper input.");
			}
		}
	}
}
