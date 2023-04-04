package mylib;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws PythonExecutionException, IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 1000; i++) {
            arr.add(rd.nextInt(20));
        }
        Plot plt = Plot.create();
        plt.hist().add(arr);
        plt.show();

        Integer[] xarr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] yarr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        ArrayList<Integer> xvals = new ArrayList<>(Arrays.asList(xarr));
        ArrayList<Integer> yvals = new ArrayList<>(Arrays.asList(yarr));
        Plot plt2 = Plot.create();
        plt2.plot().add(xvals, yvals);
        plt2.show();
    }
}