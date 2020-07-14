package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Task8 implements Task {


    @Override
    public void doTask() {
        System.out.println("Дан список унарных операторов UnaryOperator<T>. Объединить их в один унарный оператор, который применяет их все.");
        System.out.println("Пусть даны следующие унарные операторы");
        System.out.println("s -> s.toUpperCase()");
        System.out.println("s -> s + \" stroka\"");
        System.out.println("s -> \" \" + s + \" \"");
        List<UnaryOperator> list = new ArrayList<>();

        UnaryOperator<String> uo1 = s -> s.toUpperCase();
        UnaryOperator<String> uo2 = s -> s + " stroka";
        UnaryOperator<String> uo3 = s -> " " + s + " ";

        list.add(uo1);
        list.add(uo2);
        list.add(uo3);

        UnaryOperator composite = StreamUtil.getCompositeUnaryOperator(list);

        System.out.println("Введите строку для проверки");
        String test = "";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            test = br.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Результат:");
        System.out.println(composite.apply(test));

    }
}
