package laba_7.task_3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//3.	Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.
public class Popular_word {
    public static void main(String[] args) {
        File inp_file = new File("C:\\Users\\metel\\IdeaProjects\\my_lab_7\\src\\laba_7\\task_3\\text.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String text = scanner.nextLine();
        text = text.toLowerCase(Locale.ROOT);
        String[] sentences = text.split("[.?!]");
        String[] words = sentences[0].split("[ «»—:]");

        boolean foundFlag;

        for (String word : words) {
            foundFlag = true;
            for (int i = 1; i < sentences.length; i++) {
                if(sentences[i].contains(word)) {
                    foundFlag = false;
                }
            }
            if(foundFlag){
                System.out.print("Word in first sentence: ");
                System.out.println(word);
                break;
            }
        }

    }
}
