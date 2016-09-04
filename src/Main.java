import java.util.function.IntSupplier;

public class Main {
    public static void main(String[] args) {
        MoneySet set = MoneySet.valueOf(13720);
        MoneySet set2 = MoneySet.valueOf(3000);
        set.add(set2);

        IntSupplier func;
        func = set::getAmount;
        System.out.println(func.getAsInt());
        System.out.println(set.toString());
    }
}
