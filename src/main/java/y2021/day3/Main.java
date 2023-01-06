package y2021.day3;

import common.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            List<Integer> bits = getNthBits(readInput(), i);
            int mostCommonBit = getMostCommonBit(bits);
            int leastCommonBit = getLeastCommonBit(bits);
            gammaRate.append(mostCommonBit);
            epsilonRate.append(leastCommonBit);
        }

        int decimalGammaRate = Integer.parseInt(gammaRate.toString(), 2);
        int decimalEpsilonRate = Integer.parseInt(epsilonRate.toString(), 2);
        System.out.println("gammaRate = " + gammaRate + " (binary) " + decimalGammaRate + " (decimal)");
        System.out.println("epsilonRate = " + epsilonRate + " (binary) " + decimalEpsilonRate + " (decimal)");
        System.out.println("Power consumption: " + decimalGammaRate * decimalEpsilonRate);
    }

    private static List<String> readInput() {
        return FileReader.readFile(2021, 3);
    }

    private static int getMostCommonBit(List<Integer> bits) {
        long occurencesOfZero = getOccurencesOfBit(bits, 0);
        long occurencesOfOne = getOccurencesOfBit(bits, 1);
        return occurencesOfZero > occurencesOfOne ? 0 : 1;
    }

    private static int getLeastCommonBit(List<Integer> bits) {
        long occurencesOfZero = getOccurencesOfBit(bits, 0);
        long occurencesOfOne = getOccurencesOfBit(bits, 1);
        return occurencesOfZero < occurencesOfOne ? 0 : 1;
    }

    private static long getOccurencesOfBit(List<Integer> bits, int x) {
        return bits.stream().filter(i -> i == x).count();
    }

    private static List<Integer> getNthBits(List<String> lines, int position) {
        List<Integer> first = new ArrayList<>();
        lines.forEach(l -> first.add(Integer.valueOf(l.substring(position,position + 1))));
        return first;
    }
}
