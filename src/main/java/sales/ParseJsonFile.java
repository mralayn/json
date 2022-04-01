package sales;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseJsonFile {

    public static void main(String[] args) {

        FileReader fileReader = null;
        BufferedReader in = null;
        try {
            fileReader = new FileReader("sales.json");
            in = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        String jsonString = null;
        ArrayList<Sale> list = new ArrayList<>();
        try {
            while ((jsonString = in.readLine()) != null) {
                Sale saleObject = gson.fromJson(jsonString, Sale.class);
                list.add(saleObject);

                System.out.println(saleObject.getSales());
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

