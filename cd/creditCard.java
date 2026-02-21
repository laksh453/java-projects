package javaproject;
public class creditCard {
// static variables
   public  static String bankName;
     public static  double rewardPer100;
// instance variables
   private long cardNo;
   private String holderName;
   private  double outstandingAmount;

   public  creditCard() {
        cardNo = 0;
        holderName = " unknown";
        outstandingAmount = 0.0;
    }
// constructer with cardno,holdername
   public  creditCard(long cardNo, String holderName) {
        this.cardNo = cardNo;
        this.holderName = holderName;
        this.outstandingAmount = 0.0;
    }
// constructer with cardno,holdername,outstanding name
     public creditCard(long cardNo, String holderName, double outstandingAmount) {
        this.cardNo = cardNo;
        this.holderName = holderName;
        this.outstandingAmount = outstandingAmount;
    }

    public  double calculateRewards() {
        return (outstandingAmount / 100) * rewardPer100;
    }

   public  String compareDue(creditCard other) {
        if (this.outstandingAmount > other.outstandingAmount)
            return this.holderName + " has higher due";
        else if (this.outstandingAmount < other.outstandingAmount)
            return other.holderName + " has higher due";
        else
            return "Both have equal due";
    }

    double totalDue(double lateFee) {
        return outstandingAmount + lateFee;
    }

    public static double secondMaxDue(creditCard[] cards) {
        double max1 = 0;
        		 double max2 = 0;
        for (creditCard c : cards) {
            if (c.outstandingAmount > max1) {
                max2 = max1;
                max1 = c.outstandingAmount;
            } else if (c.outstandingAmount > max2 && c.outstandingAmount < max1) {
                max2 = c.outstandingAmount;
            }
        }
        return max2;
       
    }
  
}
