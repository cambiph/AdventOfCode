package y2021.day2;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    static int horizontalStartPosition = 0;
    static int depthStartPosition = 0;
    static int aimStartPosition = 0;

    public static void main(String[] args) throws IOException {
        puzzle1();
        puzzle2();
    }

    private static void puzzle1() throws IOException {
        MultiValuedMap<String, Integer> map = readInput();
        Map<String, Integer> movement = map.entries().stream().collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));

        int horizontalPosition = horizontalStartPosition + movement.get("forward");
        int depthPosition = depthStartPosition + movement.get("down") - movement.get("up");
        System.out.println("Solution part 1: " + horizontalPosition * depthPosition);
    }

    public static void puzzle2() throws IOException {
        List<Move> map = readInputAsList();
        map.forEach(e -> {
            switch (e.getDirection()) {
                case "down":
                    aimStartPosition += e.getAmount();
                    break;
                case "up":
                    aimStartPosition -= e.getAmount();
                    break;
                case "forward":
                    horizontalStartPosition += e.getAmount();
                    if (aimStartPosition != 0) {
                        depthStartPosition += aimStartPosition * e.getAmount();
                    }
                    break;
            }
        });
        System.out.println("Solution part 2: " + horizontalStartPosition * depthStartPosition);
    }

    private static MultiValuedMap<String, Integer> readInput() throws IOException {
        MultiValuedMap<String, Integer> map = new ArrayListValuedHashMap<>();
        Files.readAllLines(Path.of("src/main/java/y2021/day2/input.txt")).forEach(l -> {
            String[] split = l.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        });
        return map;
    }

    private static List<Move> readInputAsList() throws IOException {
        List<Move> moves = new ArrayList<>();
        Files.readAllLines(Path.of("src/main/java/y2021/day2/input.txt")).forEach(l -> {
            String[] split = l.split(" ");
            moves.add(new Move(split[0], Integer.parseInt(split[1])));
        });
        return moves;
    }
}
