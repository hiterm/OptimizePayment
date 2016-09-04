import java.util.function.IntSupplier;

public class Main {
    public static void main(String[] args) {
        MoneySet set;
        set = MoneySet.valueOf(13720);

        IntSupplier func;
        func = set::getAmount;
        System.out.println(func.getAsInt());
    }
}
