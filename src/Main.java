import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class Main {
	public static void main(String[] args) {
		MoneySet set = new MoneySet();
		
		IntConsumer consumer = set::setB5000;
		consumer.accept(3);
		
		IntSupplier func;
		func = set::getAmount;
		System.out.println(func.getAsInt());
	}
}
