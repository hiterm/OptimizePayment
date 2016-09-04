import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class MoneySet {

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
        
        int[] arr = MoneySet.getFaceAmountArray();
        List<IntSupplier> list = this.getGetterList();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(": ");
            sb.append(list.get(i).getAsInt());
            sb.append(", ");
        }

        return sb.toString();
    }

    public int getAmount() {
        return c1 + 5 * c5 + 10 * c10 + 50 * c50 + 100 * c100 + 500 * c500 + 1000 * b1000 + 5000 * b5000
                + 10000 * b10000;
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
    
    // setterの入ったリストを返す
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

    // TODO
    // 最適な支払い方法を返す
    // もしお金が足りなければnull
    public MoneySet getSetForPayment(int payment) {
        if (this.getAmount() < payment) {
            return null;
        }

        MoneySet result = new MoneySet();
        int rest = payment;
        int tmp = payment % 10;
        if (tmp < c1 + 5 * c5) {
        }
        return result;
    }

    // TODO
    private static int[] getPaymentSetOfTwoTypes(int numberOfOne, int numberOfFive, int rest) {
        return new int[] { 0, 1 };
    }

}
