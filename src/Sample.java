public class Sample {
    public static void main(String[] args) {
        MoneySet wallet = MoneySet.valueOf(1448);
        int payment = 694;
        MoneySet result = wallet.getSetForPayment(payment);

        System.out.println("財布の中身: " + wallet.getAmount());
        System.out.println("代金: " + payment);
        System.out.println("支払い: " + result.getAmount());
        System.out.println("おつり: " + (result.getAmount() - payment));
    }
}
