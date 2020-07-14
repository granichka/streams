package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task6 implements Task {

    @Override
    public void doTask() {

        System.out.println("Дан список дней рождения сотрудников фирмы (Collection<LocalDate>). Вернуть количество дней рожденья в каждом месяце (Map<Month, Integer>).");
        System.out.println("Пусть дан следующий список дней рождения сотрудников фирмы (год-месяц-день):");

        List<LocalDate> list = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate date2 = LocalDate.of(1998, Month.OCTOBER, 13);
        LocalDate date3 = LocalDate.of(1976, Month.OCTOBER, 2);
        LocalDate date4 = LocalDate.of(1981, Month.FEBRUARY, 21);
        LocalDate date5 = LocalDate.of(1980, Month.OCTOBER, 6);

        list.add(date1);
        list.add(date2);
        list.add(date3);
        list.add(date4);
        list.add(date5);

        System.out.println(list);
        System.out.println("Тогда число дней рождения в каждом месяце:");
        Map<Month, Long> birthDays = StreamUtil.getNumberOfRecordsOfEachMonth(list);
        System.out.println(birthDays);
    }
}
