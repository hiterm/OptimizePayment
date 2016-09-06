import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class MoneySet {

    public static final int NUMBER_OF_COIN_TYPES = 9;
    private int c1;
    private int c5;
    private int c10;
    private int c50;
    private int c100;
    private int c500;
    private int b1000;
    private int b5000;
    private int b10000;

    public int getC1() {
        return c1;
    }

    public int getC5() {
        return c5;
    }

    public int getC10() {
        return c10;
    }

    public int getC50() {
        return c50;
    }

    public int getC100() {
        return c100;
    }

    public int getC500() {
        return c500;
    }

    public int getB1000() {
        return b1000;
    }

    public int getB5000() {
        return b5000;
    }

    public int getB10000() {
        return b10000;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public void setC5(int c5) {
        this.c5 = c5;
    }

    public void setC10(int c10) {
        this.c10 = c10;
    }

    public void setC50(int c50) {
        this.c50 = c50;
    }

    public void setC100(int c100) {
        this.c100 = c100;
    }

    public void setC500(int c500) {
        this.c500 = c500;
    }

    public void setB1000(int b1000) {
        this.b1000 = b1000;
    }

    public void setB5000(int b5000) {
        this.b5000 = b5000;
    }

    public void setB10000(int b10000) {
        this.b10000 = b10000;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int[] faceAmountArr = MoneySet.getFaceAmountArray();
        int[] numbersOfCoinsArr = this.getNumbersOfCoins();

        for (int i = 0; i < NUMBER_OF_COIN_TYPES; i++) {
            sb.append(faceAmountArr[i]);
            sb.append(": ");
            sb.append(numbersOfCoinsArr[i]);
            sb.append(", ");
        }

        return sb.toString();
    }

    public String toShortString() {
        StringBuilder sb = new StringBuilder();

        int[] faceAmountArr = MoneySet.getFaceAmountArray();
        int[] numbersOfCoinsArr = this.getNumbersOfCoins();

        for (int i = 0; i < NUMBER_OF_COIN_TYPES; i++) {
            if (numbersOfCoinsArr[i] > 0) {
                sb.append(faceAmountArr[i]);
                sb.append(": ");
                sb.append(numbersOfCoinsArr[i]);
                sb.append(", ");
            }
        }

        String string = sb.toString();
        if ("".equals(string)) {
            return "0";
        } else {
            return string;
        }
    }

    // コインの数の配列を返す
    public int[] getNumbersOfCoins() {
        int[] result = new int[NUMBER_OF_COIN_TYPES];
        result[0] = this.getC1();
        result[1] = this.getC5();
        result[2] = this.getC10();
        result[3] = this.getC50();
        result[4] = this.getC100();
        result[5] = this.getC500();
        result[6] = this.getB1000();
        result[7] = this.getB5000();
        result[8] = this.getB10000();

        return result;
    }

    public int[] getReversedNumbersOfCoins() {
        int[] normal = this.getNumbersOfCoins();
        int[] reversed = new int[NUMBER_OF_COIN_TYPES];

        for (int i = 0; i < NUMBER_OF_COIN_TYPES; i++) {
            reversed[i] = normal[NUMBER_OF_COIN_TYPES - 1 - i];
        }

        return reversed;
    }

    // コインの数を配列でセットする
    public void setAll(int[] arr) {
        this.setC1(arr[0]);
        this.setC5(arr[1]);
        this.setC10(arr[2]);
        this.setC50(arr[3]);
        this.setC100(arr[4]);
        this.setC500(arr[5]);
        this.setB1000(arr[6]);
        this.setB5000(arr[7]);
        this.setB10000(arr[8]);
    }

    public int getAmount() {
        int amount = 0;
        List<IntSupplier> list = this.getGetterList();
        int[] arr = MoneySet.getFaceAmountArray();
        for (int i = 0; i < list.size(); i++) {
            amount += arr[i] * list.get(i).getAsInt();
        }
        return amount;
    }

    // setterの入ったリストを返す
    public List<IntConsumer> getSetterList() {
        List<IntConsumer> list = new ArrayList<>();

        list.add(this::setC1);
        list.add(this::setC5);
        list.add(this::setC10);
        list.add(this::setC50);
        list.add(this::setC100);
        list.add(this::setC500);
        list.add(this::setB1000);
        list.add(this::setB5000);
        list.add(this::setB10000);

        return list;
    }

    public List<IntConsumer> getReversedSetterList() {
        List<IntConsumer> list = this.getSetterList();
        Collections.reverse(list);
        return list;
    }

    // getterの入ったリストを返す
    public List<IntSupplier> getGetterList() {
        List<IntSupplier> list = new ArrayList<>();

        list.add(this::getC1);
        list.add(this::getC5);
        list.add(this::getC10);
        list.add(this::getC50);
        list.add(this::getC100);
        list.add(this::getC500);
        list.add(this::getB1000);
        list.add(this::getB5000);
        list.add(this::getB10000);

        return list;
    }

    public List<IntSupplier> getReversedGetterList() {
        List<IntSupplier> list = this.getGetterList();
        Collections.reverse(list);
        return list;
    }

    // 額面の入った配列を返す
    public static int[] getFaceAmountArray() {
        int[] arr = { 1, 5, 10, 50, 100, 500, 1000, 5000, 10000 };
        return arr;
    }

    public static int[] getReversedFaceAmountArray() {
        int[] arr = { 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
        return arr;
    }

    // intからそのamountを持つMoneySetを作る
    public static MoneySet valueOf(int n) {
        MoneySet result = new MoneySet();

        int[] faceAmountArr = MoneySet.getReversedFaceAmountArray();
        List<IntConsumer> setterList = result.getReversedSetterList();

        int rest = n;
        for (int i = 0; i < faceAmountArr.length; i++) {
            int tmp = rest / faceAmountArr[i]; // 枚数を計算
            setterList.get(i).accept(tmp); // setする
            rest = rest % faceAmountArr[i];
        }

        return result;
    }

    // thisにaddendを足す
    // コインやお札の枚数を足すだけ
    public void add(MoneySet addend) {
        List<IntSupplier> thisGetterList = this.getGetterList();
        List<IntSupplier> addendGetterList = addend.getGetterList();
        List<IntConsumer> thisSetterList = this.getSetterList();

        for (int i = 0; i < thisGetterList.size(); i++) {
            int sum = thisGetterList.get(i).getAsInt() + addendGetterList.get(i).getAsInt();
            thisSetterList.get(i).accept(sum);
        }
    }

    // 最適化したものを返す（例：1円玉7枚 -> 1円玉2枚 + 5円玉1枚）
    public MoneySet getOptimizedSet() {
        return MoneySet.valueOf(this.getAmount());
    }

    // 最適な支払い方法を返す
    // もしお金が足りなければnull
    public MoneySet getSetForPayment(int payment) {
        if (this.getAmount() < payment) {
            return null;
        }

        MoneySet result = new MoneySet();
        List<IntSupplier> thisGetterList = this.getGetterList();
        int[] faceAmountArr = MoneySet.getFaceAmountArray();
        List<IntConsumer> resultSetterList = result.getSetterList();

        int rest = payment;
        int n = thisGetterList.size();
        for (int i = 0; i < n - 1; i++) {   // 最後の1つ手前までループ
            int currentNum = thisGetterList.get(i).getAsInt();
            int currentFace = faceAmountArr[i];
            int nextFace = faceAmountArr[i + 1];
            IntConsumer currentResultSetter = resultSetterList.get(i);

            int currentPartOfPayment = rest % nextFace;
            if (currentPartOfPayment <= currentFace * currentNum) {     // 支払えるとき
                currentResultSetter.accept(currentPartOfPayment / currentFace);
                rest -= currentPartOfPayment;               // 支払った分は除く
            } else {                                        // 支払えないとき
                rest += nextFace - currentPartOfPayment;    // お釣りをもらって繰上げ
            }
        }

        result.setB10000(rest / 10000);     // 10000は別に処理

        return result;
    }

}
