import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class pathSearcher {

    public void search(int start, int finish, String path, String Base) {

        int value = (int) (finish - start);

        String temp = "";
        int id = 0;

        for (int i = 0; i < value; i++) {
            String fileContent = new String();
            try {

                id = start + i;
                FileReader file = new FileReader(path + "/" + (start + i) + "/Patient.dat", StandardCharsets.UTF_16LE);
                BufferedReader fileStream = new BufferedReader(file);

                temp = fileStream.readLine();
                while (temp != null) {
                    fileContent = fileContent + "\n" + temp;
                    temp = fileStream.readLine();
                }
                fileStream.close();
                String name = fileContent.split("\n")[4];
                String proName = fileContent.split("\n")[5];

                System.out.print(id);
                System.out.print(";" + name.split("=")[1] + ";" + proName.split("=")[1] + ";;;0");

                addToDataBase("\n" + id + ";" + name.split("=")[1] + ";" + proName.split("=")[1] + ";;;0", Base);

            } catch (FileNotFoundException e) {
                System.out.println("File not found exception");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

    public void addToDataBase(String data, String dataPath) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(dataPath, true);
        byte[] strToBytes = data.getBytes(StandardCharsets.UTF_16LE);
        outputStream.write(strToBytes);
        outputStream.close();
    }

}
