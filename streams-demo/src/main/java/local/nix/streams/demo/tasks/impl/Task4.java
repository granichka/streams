package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 implements Task {


    @Override
    public void doTask() {

        System.out.println("Дан список строк со словами, разделенными одним или более пробелами. Вернуть список слов-палиндромов.");
        System.out.println("Пусть дан список строк");
        List<String> list = new ArrayList<>(Arrays.asList("аба прогноз  заз", "ушу    арифметика", "   поп", "цветок казак       трактор"));
        System.out.println(list);
        System.out.println("Тогда список слов-палиндромов:");
        StreamUtil.getListOfPalindromeWorldsFromStrings(list);
    }
}
