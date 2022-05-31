package com.company;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class Exercice {
  static   List<Point> listPoint = Arrays.asList(new Point(1, -4), new Point(4, 9), new Point(-3, -4), new Point(2, 2),
            new Point(8, 6), new Point(3, 3), new Point(-4, -4));


    public static void main(String[] args) {
        Stream<Integer> stream=listPoint.stream().filter(point -> point.getX()>=0).sorted(comparing(Point::getX)).map(p -> p.getX());
        List<Integer> nouvelleList=stream.collect(toList());

        for (Integer p:nouvelleList
             ) {
            System.out.println(p);
        }
    }

}
