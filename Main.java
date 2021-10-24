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

    public static void add(Scanner scan) {
        clearScreen();
        System.out.print("Target: ");
        String target = scan.next();
        System.out.print("Explain: ");
        String explain = scan.next() + scan.nextLine();
        clearScreen();
        System.out.println("Add " + target +": " + explain + "?");
        System.out.println("1. Yes\n2. No");
        int choose = scan.nextInt();
        if (choose == 1) {
            cmd.addAWord(target, explain);
            System.out.print("Success!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
        } else {
            System.out.print("Canceled!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
        }
    }

    public static void change(Scanner scan) {
        clearScreen();
        System.out.print("Target: ");
        String target = scan.next();
        System.out.print("Explain: ");
        String explain = scan.next() + scan.nextLine();
        clearScreen();
        System.out.println("Change " + target +": " + explain + "?");
        System.out.println("1. Yes\n2. No");
        int choose = scan.nextInt();
        if (choose == 1) {
            cmd.dictionaryChange(target, explain);
            System.out.print("Success!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
        } else {
            System.out.print("Canceled!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
        }
        
    }

    public static void remove(Scanner scan) {
        clearScreen();
        System.out.print("Target: ");
        String target = scan.next();
        clearScreen();
        System.out.println("Change " + target + "?");
        System.out.println("1. Yes\n2. No");
        int choose = scan.nextInt();
        if (choose == 1) {
            cmd.dictionaryRemove(target);
            System.out.print("Success!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
        } else {
            System.out.print("Canceled!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
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
            System.out.println("Search: " + target);
            System.out.println("---------------------------");
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
                    change(scan);
                    break;
                case 3:
                    remove(scan);
                    break;
                case 4:
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
        showText("intro.txt");
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
                    add(scan);
                    break;
                case 5:
                    change(scan);
                    break;
                case 6 :
                    remove(scan);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                break;
            }
        } while (running);
        scan.close();
    }
}
