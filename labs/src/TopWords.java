import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Den220\\IdeaProjects\\labs\\src\\TopWords.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> wordsCount = new HashMap<>();
        try {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
                if (!word.isEmpty()) {
                    if (wordsCount.containsKey(word)) {
                        int count = wordsCount.get(word);
                        wordsCount.put(word, count + 1);
                    } else {
                        wordsCount.put(word, 1);
                    }
                }
            }
            scanner.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordsCount.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (int i = 0; i < 10 & i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}