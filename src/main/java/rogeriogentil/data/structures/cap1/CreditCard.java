package rogeriogentil.data.structures.cap1;

/**
 *
 * @author rogerio
 */
public class CreditCard {
   
   private String customer;
   private String bank;
   private String account;
   private int limit;
   protected double balance;

   public CreditCard(String customer, String bank, String account, int limit, double balance) {
      this.customer = customer;
      this.bank = bank;
      this.account = account;
      this.limit = limit;
      this.balance = balance;
   }

   public CreditCard(String customer, String bank, String account, int limit) {
      this(customer, bank, account, limit, 0.0);
   }

   public String getCustomer() {
      return customer;
   }

   public String getBank() {
      return bank;
   }

   public String getAccount() {
      return account;
   }

   public int getLimit() {
      return limit;
   }

   public double getBalance() {
      return balance;
   }
   
   public boolean charge(double price) {
      if (price + balance > limit)
         return false;
      
      balance += price;
      return true;
   }
   
   public void makePayment(double amount) {
      // R-1.12
      if (amount < 0) return;
      balance -= amount;
   }
   
   // R-1.11
   public void updateLimit(int newLimit) {
      this.limit = newLimit;
   }
   
   public static void printSummary(CreditCard card) {
      System.out.println("-------------------------------------");
      System.out.println("Customer = " + card.customer);
      System.out.println("Bank = " + card.bank);
      System.out.println("Account = " + card.account);
      System.out.println("Balance = " + card.balance);
      System.out.println("Limit = " + card.limit);
      System.out.println("-------------------------------------");
   }
   
   public static void main(String[ ] args) {
      CreditCard[ ] wallet = new CreditCard[3];
      wallet[0] = new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);
      wallet[1] = new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500);
      wallet[2] = new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);
      
      for (int val = 1; val <= 16; val++) {
         wallet[0].charge(3*val);
         wallet[1].charge(3*val);//wallet[1].charge(2*val);
         wallet[2].charge(3*val);//wallet[2].charge(val);
      }
      
      for (CreditCard card : wallet) {
         CreditCard.printSummary(card);
         while (card.getBalance( ) > 200.0) {
            card.makePayment(200);
            System.out.println("New balance = " + card.getBalance());
         }
      }
      
      // R-1.11
      for (int i = 0; i < wallet.length; i++) {
         System.out.println("Old limit on wallet[" + i + "] = " + wallet[i].limit);
         
         int newLimit = wallet[i].limit * 2;
         wallet[i].updateLimit(newLimit);
         
         System.out.println("New limit on wallet[" + i + "] = " + wallet[i].limit);
      }
      
      // R-1.12
      for (CreditCard card : wallet) {
            card.makePayment(-100);
            System.out.println("New balance = " + card.getBalance());        
      }
   }
}
