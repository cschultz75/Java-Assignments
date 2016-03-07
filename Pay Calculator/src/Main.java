import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

		System.out.println("Enter your wage");

		double wage = input.nextDouble();

		System.out.println("Enter your hours");

		double hours = input.nextDouble();

		double standardPay = (wage * hours);

		double overtimePay = (wage * .5) * (hours - 40) + (wage * hours);

		if (hours > 40) {
			System.out.println("Gross Pay: " + currency.format(overtimePay));
		} else {
			System.out.println("Gross Pay: " + currency.format(standardPay));
		}
	}
}