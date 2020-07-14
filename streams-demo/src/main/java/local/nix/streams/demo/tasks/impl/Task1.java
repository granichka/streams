package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 implements Task {

    @Override
    public void doTask() {

        System.out.println("Дан массив double[]. Найти максимальное число, минимальное число, среднее арифметическое и сумму.");
        System.out.println("Введите размерность массива");
        int n = 0;
        double[] arr = {};
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String number = br.readLine();
            n = Integer.parseInt(number);
            arr = new double[n];
            System.out.println("Введите " + n + " вещественных элементов массива (после ввода каждого элемента нажмите Enter)");
            for(int i = 0; i < n; i++) {
                String element = br.readLine();
                arr[i] = Double.parseDouble(element);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ваш исходный массив:");
        for(double element: arr) {
            System.out.print(element + "  ");
        }

        System.out.println();
        System.out.println("Результат:");
        StreamUtil.getMinMaxAndSumOfArrayElements(arr);

    }
}
