package pk3;

import  static pk3.Transaction.transactions;
import static  pk3.Trader.*;


import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class test {




    public static void main(String[] args) {
       transactions.stream()
                .filter(t->t.getYear()==2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("********************");
       List<Transaction> stream=transactions.stream()
               .filter(t->t.getYear()==2011)
               .sorted(comparing(Transaction::getValue)).collect(toList());

       for (Transaction t:stream){
           System.out.println(t);
       }
       //2-	Récupérer toutes les villes (sans les doublons) dont les «traders » travaillent ;
        transactions.stream().
                map(t->t.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("**********3**********");
       // 3-	Récupérer tous les « traders » résidant dans Cambridge, trier les en fonction du name ;
        transactions.stream()
                .map(tr->tr.getTrader())
                .filter(t->t.getCity().equals("Cambridge"))
                .sorted(comparing(Trader::getName))

                .forEach(System.out::println);

        //4-	Récupérer les noms des « traders » triés par l’ordre alphabétique ;
        System.out.println("************ordre alpha*******");
        transactions.stream()
                .map(tr->tr.getTrader().getName()).
                sorted().forEach(System.out::println);

        //5-	Y’a-t-il un trader résidant à Milan ?
        System.out.println("**********5**********");
        transactions.stream()
                 .map(tr->tr.getTrader())
                 .filter(t->t.getCity().equals("Milan")).forEach(System.out::println);

        //6 6-	Renvoyer le maximum des transactions ;
        System.out.println("**********6**********");
         int max= transactions.stream()
                .map(tr->tr.getValue())
                .reduce(transactions.get(0).getValue(),Integer::max);

        System.out.println(max);

        System.out.println("**********7**********");
       int min= transactions.stream().map(tr->tr.getValue()).reduce(transactions.get(0).getValue(),(Integer::min));
        System.out.println(min);
        System.out.println("**********8**********");
        List<Integer> t=transactions.stream()
                .map(transaction -> transaction.getValue())
                .sorted((s1,s2)-> s2.compareTo(s1)).
                limit(3).
                collect(toList());

        for (Integer tr:t){
            System.out.println(tr);
        }
        System.out.println("**********9**********");
        List<Integer> t2=transactions.stream()
                .map(transaction -> transaction.getValue())
                .sorted((s1,s2)->s1.compareTo(s2))
                .limit(3)
                .collect(toList());

        for (Integer tr:t2){
            System.out.println(tr);
        }




    }


}
