import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		int nbr1 = scan.nextInt();
		int nbr2 = scan.nextInt();
		
		System.out.println("Summan av talen är " + (nbr1+nbr2));
		System.out.println("Produkten av talen är " + (nbr1*nbr2));
		System.out.println("Differansen av talen är " + (nbr1-nbr2));
		try {
			System.out.println("Kvoten av talen är " + (nbr1/nbr2));
		}
		catch(Exception e) {
			System.out.println("Kan inte dela med noll");
		}
	}
}
