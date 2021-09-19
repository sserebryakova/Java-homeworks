package lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static File myFile;
    public static void main(String[] args) throws IOException {
        myFile = new File("file.csv");
        myFile.createNewFile();

        String[] header = new String[3];
        for(int i = 0; i < 3; i++) {
            header[i] = "Value " + (i + 1);
        }

        Integer[][] values = new Integer[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                values[i][j] = i * 3 + j;
            }
        }
        AppData data = new AppData(header, values);
        save(data);
        AppData newData = load(myFile.getName());
        save(newData);
        //myFile.delete();
    }

    public static void save(AppData data) {
        try (FileWriter writer = new FileWriter(myFile.getName())) {
            writer.write(String.join(",", data.getHeader()));
            writer.write("\n");
            for (int i = 0; i < data.getData().length; i++) {
                writer.write(Arrays.toString(data.getData()[i]).replaceAll("\\[|\\]|\\ ", ""));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData load(String fileName) {
        AppData data = new AppData();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            data.setHeader(bufferedReader.readLine().split(","));
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                dataList.add(stringToDataRow(tempString));
            }
            data.setData(dataList.toArray(new Integer[][]{{}}));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Integer[] stringToDataRow(String str) {
        String[] strings = str.split(",");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
