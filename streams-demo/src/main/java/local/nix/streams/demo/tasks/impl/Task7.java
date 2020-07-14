package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task7 implements Task {

    @Override
    public void doTask() {

        System.out.println("Дан массив целых чисел. Разбить его на четные и нечетные, отсортировать и те, и другие по убыванию.");
        System.out.println("Введите размерность массива");
        int n = 0;
        Integer[] arr = {};
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String number = br.readLine();
            n = Integer.parseInt(number);
            arr = new Integer[n];
            System.out.println("Введите " + n + " элементов массива (после ввода каждого элемента нажмите Enter)");
            for(int i = 0; i < n; i++) {
                String element = br.readLine();
                arr[i] = Integer.parseInt(element);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ваш исходный массив:");
        for(Integer integer: arr) {
            System.out.print(integer + " ");
        }

        System.out.println();
        System.out.println("Результат:");
        StreamUtil.getEvenAndOddNumbersOfArrayInReverseOrder(arr);

    }
}
