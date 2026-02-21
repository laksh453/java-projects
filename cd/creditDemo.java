package javaproject;
//object developer code
public class creditDemo{
public static void main(String[] args) {
	        // Create objects using different constructors
	        creditCard c1 = new creditCard(1111, "Laksh", 5000);
	        creditCard c2 = new creditCard(2222, "Srujan", 7000);
	        creditCard c3 = new creditCard(3333, "shiva", 3000);

	        // Compute rewards
	        System.out.println(" Rewards: " + c1.calculateRewards());
	        System.out.println( " Rewards: " + c2.calculateRewards());
	        System.out.println( " Rewards: " + c3.calculateRewards());

	        // Compare dues
	        System.out.println(c1.compareDue(c2));
	        System.out.println(c2.compareDue(c3));
	        
	        // Find 2nd highest due
	        creditCard[] cards = {c1, c2, c3};
	        System.out.println("Second Highest Due: " + creditCard.secondMaxDue(cards));
	    }
	}

