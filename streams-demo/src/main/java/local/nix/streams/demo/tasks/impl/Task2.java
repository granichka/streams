package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Task2 implements Task {

    @Override
    public void doTask() {

        System.out.println("Дана коллекция лет (java.time.Year). Вернуть високосные годы в виде списка, отсортированного по возрастанию.");
        System.out.println("Пусть дан следующий список лет (java.time.Year):");
        List<Year> list= new ArrayList<>();
            list.add(Year.of(2012));
            list.add(Year.of(2008));
            list.add(Year.of(2020));
            list.add(Year.of(2002));
            list.add(Year.of(2018));
         System.out.println(list);

         List<Year> result = StreamUtil.getSortedLeapYears(list);
         System.out.println("Результат:");
         for(Year year: result) {
             System.out.print(year + " ");
         }

    }
}
