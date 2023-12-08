import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Trebuchet {

    public static void main(String[] args) throws IOException {
        Trebuchet t = new Trebuchet();
        int totalCalibration = 0;
        try (Stream<String> stream = Files.lines(Paths.get("challenges/1/resources/input.txt"))) {
            totalCalibration = stream.mapToInt(t::getCalibration).sum();
        }

        System.out.println(totalCalibration);
    }

    /**
     * 1abc2
     * pqr3stu8vwx
     * a1b2c3d4e5f
     * treb7uchet
     */

    //1º parte
    public int getCalibration(String stringToSearch){
        Pattern integerPattern = Pattern.compile("\\d");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        String calibration = integerList.getFirst() + integerList.getLast();
       return Integer.parseInt(calibration);
    }

    //2º parte
    public int getCalibration2ndPart(String stringToSearch){
        Pattern integerPattern = Pattern.compile("([1-9])|(one|two|three|four|five|six|seven|eight|nine)");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        String calibration = "" + convertToInt(integerList.getFirst()) + convertToInt(integerList.getLast());
       // System.out.println(calibration);
        return Integer.parseInt(calibration);

    }

    public int convertToInt(String extendNumber){
        return switch (extendNumber) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            default -> Integer.parseInt(extendNumber);
        };
    }
}