import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PayByPayPal implements PayStrategy{
	
	private static final HashMap<String, String> DATA_BASE = new HashMap<>();
	private final BufferedReader READER
		= new BufferedReader (new InputStreamReader(System.in));
	private String email;
	private String password;
	private boolean signedIn;
	
	static {
		DATA_BASE.put("jorgelito", "jorge@gmail.com");
		DATA_BASE.put("franchesco", "franchesco@bol.com.br");
	}
	
	@Override
	public void collectPaymentDetails() {
		try {
			while(!signedIn) {
				System.out.print("Insira o endereço de email cadastrado: ");
				email = READER.readLine();
				if(verify()) {
					System.out.println("Logado com sucesso!");
				} else {
					System.out.println("Erro ao autenticar.");
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private boolean verify() {
		setSignedIn(email.contentEquals(DATA_BASE.get(password)));
		return signedIn;
	}
	
	public boolean pay(double paymentAmmount) {
		if(signedIn) {
			System.out.println("Pagando " + paymentAmmount + " usando PayPal");
			return true;
		} else {
			return false;
		}
	}
	
	private void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}
}