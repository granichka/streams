package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 implements Task {

    @Override
    public void doTask() {

        System.out.println("Дан список строк. Вырезать из каждой строки участки, удовлетворяющие регулярному выражению.");
        System.out.println("Пусть дан список строк:");
        List<String> list = new ArrayList<>(Arrays.asList("Advanced operations", "Attractive person", "ambassador"));
        System.out.println(list);
        System.out.println("Выберем участки строк, где между двумя буквами а стоят ровно два буквенных символа");
        String regex = "[A,a][a-z]{1}[a-z]{1}a";
        System.out.println("Результат:");
        StreamUtil.getPartsOfStringsThatMatchRegex(list, regex);

    }
}
