package com.design.mode.test01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zyb
 * @date: 2020/9/21 16:27
 */
public class CartesianTest {
    public static void main(String[] args) {
        System.out.println(sum());
    }

    private static List<Card> sum() {
        Integer[] a = {1, 2, 3, 4};
        Integer[] b = {4, 3, 2, 1};
        List<Integer> aList = Arrays.asList(a);
        List<Integer> bList = Arrays.asList(b);

        return aList.stream().flatMap(v1 -> bList.stream().map(v2 -> new Card(v1, v2))).collect(Collectors.toList());
    }

    static class Card {
        Integer first;
        Integer second;

        Card(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getSecond() {
            return second;
        }

        public void setSecond(Integer second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}
