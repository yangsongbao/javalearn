package per.yang.lock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by songbao.yang on 2017/5/22.
 */
public class Main {



    public static void main(String[] args) throws IOException {

        String name = "yangsongbao";

        ProcessBuilder pb = new ProcessBuilder(name);
        Process process = pb.start();

        InputStream inputStream = process.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        bufferedReader.close();


    }

}
