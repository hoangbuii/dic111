import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static DictionaryCommandline cmd = new DictionaryCommandline();

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void showText(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " does not exsit!");
        }
    }

    public static void mainMenu() {
        showText("mainmenu.txt");
    }

    public static void add(Scanner scan) {
        clearScreen();
        System.out.print("Target: ");
        String target = scan.next();
        System.out.print("Explain: ");
        String explain = scan.next();
        cmd.addAWord(target, explain);
        System.out.print("Success!");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }

    public static void search(Scanner scan) {
        clearScreen();
        System.out.print("Search: ");
        String target = scan.next();
        boolean running = true;
        ArrayList<Word> result = cmd.dictionarySearcher(target);
        do {
            clearScreen();
            for (int i = 0; i < result.size(); i++) {
                String line = result.get(i).getWordTarget() + ": " 
                + result.get(i).getWordExplain();
                System.out.println(line);
            }
            showText("search.txt");
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    add(scan);
                    break;
                case 2:
                    
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    break;
            }
        } while (running);
    }

    public static void main(String[ ] args) {
        Scanner scan = new Scanner(System.in);
        clearScreen();
        mainMenu();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
        boolean running = true;
        int page = 1;
        do {
            clearScreen();
            cmd.showPageWord(page);
            showText("showword.txt");
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    if (page > 1) {
                        page--;
                    } 
                    break;
                case 2:
                    page++;
                    break;
                case 3:
                    search(scan);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                break;
            }
        } while (running);
        scan.close();
    }
}
