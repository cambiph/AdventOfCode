package y2022.day1;

import common.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = FileReader.readFile(2022, 1);
        List<Integer> partitions = partitionList(lines);
        Collections.sort(partitions, Collections.reverseOrder());
        System.out.println("Most calories: " + partitions.get(0));
        int topThree = partitions.subList(0,3).stream().reduce(Integer::sum).get();
        System.out.println("Total of top three " + topThree);
    }

    private static List<Integer> partitionList(List<String> list) {
        List<Integer> partitions = new ArrayList<>();
        int previous = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isEmpty()) {
                List<String> partition = list.subList(previous, i);
                Integer partitionSum = partition.stream().map(Integer::parseInt).reduce(Integer::sum).get();
                partitions.add(partitionSum);
                previous = i + 1;
            }
        }
        return partitions;
    }

}
