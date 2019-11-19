import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Demo {
	private static HashMap<Integer, Double> priceOnProducts = new HashMap<>();
	private final static BufferedReader reader
	= new BufferedReader (new InputStreamReader(System.in));
	private static Order order = new Order();
	private static PayStrategy strategy;
	
	static {
		priceOnProducts.put(1, 2200.00);
		priceOnProducts.put(2, 1850.00);
		priceOnProducts.put(3, 1100.00);
		priceOnProducts.put(4, 890.00);
	}
	
	public static void main(String[] args) throws IOException {
		while(!order.isClosed()) {
			double cost;
			
			String continueChoice;
			do {
				System.out.println("Por favor, selecione um produto: \n" +
						"1 - Placa mãe \n" +
						"2 - CPU \n" +
						"3 - HDD \n" +
						"4 - Memória \n");
				int choice = Integer.parseInt(reader.readLine());
				cost = priceOnProducts.get(choice);
				System.out.print("Contagem: ");
				int count = Integer.parseInt(reader.readLine());
				order.setTotalCost(cost * count);
				System.out.println("Você deseja continuar escolhendo produtos? S/N: ");
				continueChoice = reader.readLine();
			} while(continueChoice.equalsIgnoreCase("S"));
			
			if(strategy == null) {
				System.out.println("Por favor, selecione um método de pagamento: \n" +
						"1 - PayPal \n" +
						"2 - Cartão de crédito \n");
				String paymentMethod = reader.readLine();
				
				if(paymentMethod.equals("1"))
					strategy = new PayByPayPal();
				else
					strategy = new PayByCreditCard();
			}
			
			order.processOrder(strategy);
			
			System.out.print("Pagar " + order.getTotalCost() + " unidades ou continuar comprando? P/C: ");
			String proceed = reader.readLine();
			
			if(proceed.equalsIgnoreCase("P")) {
				if(strategy.pay(order.getTotalCost()))
					System.out.println("Pago com sucesso!");
				else
					System.out.println("Falha no pagamento.");
			}
			order.setClosed();
		}
	}
	
}