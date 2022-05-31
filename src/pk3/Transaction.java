package pk3;

import java.util.Arrays;
import java.util.List;

public class Transaction {
    private Trader trader;
    private int year;
    private int value;


    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {

        return (trader == null ? 0 : trader.hashCode()) + year + value;
    }

    @Override
    public boolean equals(Object other) {

        if (other instanceof Transaction) {
            Transaction o = (Transaction) other;
            return this.trader.equals(o.trader) && this.year == o.year && this.value == o.value;
        }
        return false;

    }

    @Override
    public String toString() {
        return trader + ", year : " + year + ", value: " + value;
    }
static    Trader raoul = new Trader("Raoul", "Cambridge");
    static   Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );





    public static void main(String[] args) {




    }

}



/*
*

* */




