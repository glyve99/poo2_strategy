import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy{
	private final BufferedReader READER
		= new BufferedReader (new InputStreamReader(System.in));
	private CreditCard card;
	
	public void collectPaymentDetails() {
		try {
			System.out.println("Insira o número do cartão: ");
			String number = READER.readLine();
			System.out.println("Insira a data de expiração: ");
			String date = READER.readLine();
			System.out.println("Insira o CVV: ");
			String cvv = READER.readLine();
			card = new CreditCard(number, date, cvv);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean pay(double paymentAmmount) {
		if(cardIsPresent()) {
			System.out.println("Pagando " + paymentAmmount + " usando cartão de crédito.");
			return true;
		} else {
			return false;
		}
	}
	
	private boolean cardIsPresent() {
		return card != null;
	}
}