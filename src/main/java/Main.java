import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static int start;
    public static int finish;
    public static String path;
    public static String pathFolder;

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("config.txt");
            BufferedReader ex = new BufferedReader(reader);
            String line;

            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case (0):
                        line = ex.readLine();
                        line = line.split(":")[1];
                        start = Integer.parseInt(line);
                        break;
                    case (1):
                        line = ex.readLine();
                        line = line.split(":")[1];
                        finish = Integer.parseInt(line);
                        break;
                    case (2):
                        line = ex.readLine();
                        line = line.split(":")[1];
                        path = line;
                        break;
                    case (3):
                        line = ex.readLine();
                        line = line.split(":")[1];
                        pathFolder = line;
                        break;
                }
//                System.out.println(start);
//                System.out.println(finish);
//                System.out.println(path);
//                System.out.println(pathFolder);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pathSearcher searcher = new pathSearcher();
            searcher.search(start, finish, pathFolder, path);
        }


    }
}


