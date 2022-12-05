package y2022.day2;

import y2022.common.FileReader;

import java.util.List;

public class Main {

    static int rock = 1;
    static int paper = 2;
    static int scissor = 3;
    static int draw = 3;
    static int win = 6;

    static int loss = 0;
    public static void main(String[] args) {
        List<String> lines = FileReader.readFile(2022, 2);
        int score = 0;
        int score2 = 0;
        for (String line : lines) {
            String[] split = line.split(" ");
            String first = split[0];
            String second = split[1];

            switch(first) {
                case "A" -> {
                    switch (second) {
                        case "X" -> { score+= rock + draw; score2+= scissor + loss; }
                        case "Y" -> { score+= paper + win; score2+= rock + draw; }
                        case "Z" -> { score+= scissor + loss; score2+= paper + win; }
                    }
                }
                case "B" -> {
                    switch(second) {
                        case "X" -> { score+= rock + loss; score2+= rock + loss; }
                        case "Y" -> { score+= paper + draw; score2+= paper + draw; }
                        case "Z" -> { score+= scissor + win; score2+= scissor + win; }
                    }
                }
                case "C" -> {
                    switch (second) {
                        case "X" -> { score+= rock + win; score2+= paper + loss; }
                        case "Y" -> { score+= paper + loss; score2+= scissor + draw; }
                        case "Z" -> { score+= scissor + draw; score2+= rock + win; }
                    }
                }
            }
        }
        System.out.println("Solution part 1: " + score);
        System.out.println("Solution part 2: " + score2);

    }
}