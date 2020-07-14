package local.nix.streams.demo.tasks.impl;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.util.StreamUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Task5 implements Task {


    @Override
    public void doTask() {

        System.out.println("Сгенерировать бесконечную последовательность простых целых чисел (тип числа - BigInteger)." +
                           "Вернуть список из n первых вероятных простых чисел.");
        System.out.println("Введите n (сколько первых простых чисел будет взято из последовательности)");
        int n = 0;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String number = br.readLine();
            n = Integer.parseInt(number);
        } catch(IOException e) {
            e.printStackTrace();
        }

        Stream<BigInteger> bigIntegerStream = Stream.iterate(BigInteger.TWO, number -> number.add(BigInteger.ONE));
        List<BigInteger> result = StreamUtil.getFirstNGeneratedSimpleNumbers(n, bigIntegerStream);


        for(BigInteger bi: result) {
            System.out.print(bi + " ");
        }

    }
}
