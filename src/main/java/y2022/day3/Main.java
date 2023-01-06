package y2022.day3;

import common.FileReader;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int sum = FileReader.readFile(2022, 3).stream()
                .map(l -> new String[]{l.substring(0, l.length() / 2), l.substring(l.length() / 2)})
                .mapToInt(e -> getRank(e[0]).filter(r -> getRank(e[1]).anyMatch(s -> r == s)).findFirst().getAsInt())
                .sum();

        System.out.println("Solution part 1: " + sum);
    }

    private static IntStream getRank(String s) {
        return s.chars().map(i -> i >= 'a' && i <= 'z' ? i - 'a' + 1 : i - 'A' + 1 + 26);
    }
}
