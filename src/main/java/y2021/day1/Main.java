package y2021.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    // https://adventofcode.com/2021/day/1
    public static void main(String[] args) throws IOException {
        List<Integer> integers = readFileAsIntList();
        long count = countIncrements(integers);
        System.out.println("Solution part 1 = " + count);

        List<Integer> partitionList = partitionList(integers, 3);
        long count2 = countIncrements(partitionList);
        System.out.println("Solution part 2 = " + count2);

    }

    private static List<Integer> readFileAsIntList() throws IOException {
        return Files.readAllLines(Path.of("src/main/java/y2021/day1/input.txt")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static long countIncrements(List<Integer> integers) {
        return IntStream.range(0, integers.size() - 1)
                .filter(i -> integers.get(i) < integers.get(i + 1))
                .count();
    }

    private static List<Integer> partitionList(List<Integer> integers, int partitionSize) {
        return IntStream.range(0, integers.size() - (integers.size() % 3))
                .mapToObj(i -> integers.subList(i, i + partitionSize))
                .map(l -> l.stream().reduce(0, Integer::sum))
                .collect(Collectors.toList());
    }
}
