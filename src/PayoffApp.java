import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PayoffApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CreditCard discover = new CreditCard(20.5, 146.4, "Discover");

        List<Double> aprs = new ArrayList<>();
        List<CreditCard> cards = new ArrayList<>();

        System.out.println(discover.getName());
        while(scan.hasNextLine()) {
            String name = scan.nextLine();

            double apr = scan.nextDouble();
            double balance = scan.nextDouble();

            // Consume \n after balance input 
            if(scan.hasNextLine()) scan.nextLine();

            cards.add(new CreditCard(apr, balance, name));
            aprs.add(apr);

            String aprString = String.format("%.2f%%", apr);
            String balanceString = String.format("$%.2f", balance);
            System.out.println(name + ": " + "APR: " + aprString + " Balance: " + balanceString);
        }
        Collections.sort(aprs, Collections.reverseOrder());
        System.out.println(aprs);
    }
}
