public class Main {
    public static void main(String[] args) {
        MoneySet set = MoneySet.valueOf(1448);
        int payment = 694;
        MoneySet result = set.getSetForPayment(payment);

        System.out.println("財布の中身: " + set.getAmount());
        System.out.println("代金: " + payment);
        System.out.println("支払い: " + result.toShortString());
        System.out.println("おつり: " + (result.getAmount() - payment));
    }
}
