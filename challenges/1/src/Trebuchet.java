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
        try (Stream<String> stream = Files.lines(Paths.get("/home/ana-sofia/Documents/training/java-advent-code-2023/challenges/1/src/input.txt"))) {
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
    public int getCalibration(String stringToSearch){
        Pattern integerPattern = Pattern.compile("\\d");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }


        String calibration = integerList.get(0) + integerList.getLast();
       return Integer.parseInt(calibration);

    }
}