package per.yang.c3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by songbao.yang on 2017/7/5.
 */
public class OSProcess {

    public static void main(String[] args) throws IOException {

        if (args.length != 1){
            System.err.println("usage:------");
            System.exit(0);
        }

        ProcessBuilder processBuilder = new ProcessBuilder(args[0]);
        Process process = processBuilder.start();
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

