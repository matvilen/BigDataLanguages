package laba_7.task_4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//3.	Все слова текста рассортировать в порядке убывания их длин, при этом
// все слова одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.
public class Vov_Sort {
    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\metel\\IdeaProjects\\my_lab_7\\src\\laba_7\\task_4\\text.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String glasniye = "УуЕеЫыАаОоЭэЁёЯяИиЮю";

        String text = scanner.nextLine();
        text = text.toLowerCase(Locale.ROOT);
        text = text.replace("  ", " ");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split("[.?!, «»—:;]")));

        Comparator<String> valueComparator = new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                if (e1.length() > e2.length()) {
                    return -1;
                } else if (e1.length() < e2.length()) {
                    return 1;
                } else {
                    int count1 = 0;
                    int count2 = 0;
                    for (int i = 0; i < e1.length(); i++) {
                        if (glasniye.contains(e1.substring(i, i + 1))) {
                            count1++;
                        }
                    }
                    for (int i = 0; i < e2.length(); i++) {
                        if (glasniye.contains(e2.substring(i, i + 1))) {
                            count2++;
                        }
                    }
                    return (count1 - count2);
                }
            }
        };

        words.removeAll(Collections.singleton(""));
        Collections.sort(words, valueComparator);
        System.out.println(words);
    }
}
