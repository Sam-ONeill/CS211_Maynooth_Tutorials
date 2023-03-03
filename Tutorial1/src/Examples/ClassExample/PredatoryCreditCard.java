package Examples.ClassExample;

public class PredatoryCreditCard extends CreditCard {
    //Additional instance variable
    private double apr; //annual percentage rate
    // Constructor for this class

    public PredatoryCreditCard(String cust, String bk, String acnt, int lim, double initialBal, double rate) {
        super(cust, bk, acnt, lim, initialBal);
        // initialize superclass attributes
        apr = rate;
    }

    // A new method for assessing monthly interest charges
    public void processMonth() {
        if (balance > 0) { // only charge interest on a positive balance
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12); // compute monthly rate
            balance *= monthlyFactor; //assess interest
        }
    }

    // Overriding the charge method defined in the superclass
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);      // call inherited method
        if (isSuccess)
            balance += 5;        // assess a $5 penalty
        return isSuccess;
    }


    public static void main(String[] args) {
        PredatoryCreditCard[] wallet = new PredatoryCreditCard[3];
        wallet[0] = new PredatoryCreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000, 0, 2.0);
        wallet[1] = new PredatoryCreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500, 0, 1.5);
        wallet[2] = new PredatoryCreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 0, 2.0);


        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3 * val);
            wallet[1].charge(2 * val);
            wallet[2].charge(val);
            wallet[0].processMonth();
            wallet[1].processMonth();
            wallet[2].processMonth();
        }

        for (CreditCard card : wallet) {
            printSummary(card); // calling static method
            while (card.getBalance() > 200.0) {
                wallet[0].processMonth();
                //card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }
}