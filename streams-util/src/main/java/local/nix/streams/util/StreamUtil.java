package local.nix.streams.util;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamUtil {

        public static List<BigInteger> getFirstNGeneratedSimpleNumbers(int n, Stream<BigInteger> bigIntegerStream) {
            return bigIntegerStream.filter(NumberUtil::IsSimple).limit(n).collect(Collectors.toList());
        }

        public static void getPartsOfStringsThatMatchRegex(List<String> list, String regex) {
            Pattern pattern = Pattern.compile(regex);

            list.stream().forEach(s -> {
                Matcher matcher = pattern.matcher(s);
                while(matcher.find()) {
                    System.out.println(matcher.group());
                }
            });
        }

        public static void getListOfPalindromeWorldsFromStrings(List<String> list) {

            list.stream().forEach(s -> {
                String[] mas = s.split("[\\s]+");
                for(String string: mas) {
                    if(string.length() != 0) {
                        StringBuilder sb = new StringBuilder(string);
                        if(sb.reverse().toString().equals(string)) {
                            System.out.println(string);
                        }
                    }
                }
            });
        }

        public static UnaryOperator getCompositeUnaryOperator(List<UnaryOperator> list) {
            return list.stream().reduce(s -> s, (a, b) -> s -> b.apply(a.apply(s)));
        }

        public static Map<Month, Long> getNumberOfRecordsOfEachMonth(List<LocalDate> list) {
            return list.stream().collect(groupingBy(LocalDate::getMonth, counting()));
        }

        public static void getEvenAndOddNumbersOfArrayInReverseOrder(Integer[] arr) {

            Supplier<Stream<Integer>> streamForTasks = () -> Arrays.stream(arr);


            streamForTasks.get().filter(s -> s.intValue() % 2 == 0).sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
            System.out.println();
            streamForTasks.get().filter(s -> s.intValue() % 2 != 0).sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));

        }

        public static List<Year> getSortedLeapYears(List<Year> list) {
            return list.stream().filter(Year::isLeap).sorted().collect(Collectors.toList());
        }

        public static void getMinMaxAndSumOfArrayElements(double[] arr) {
            Supplier<DoubleStream> streamForTasks = () -> Arrays.stream(arr);

            OptionalDouble max = streamForTasks.get().max();
            OptionalDouble min = streamForTasks.get().min();
            OptionalDouble avrg = streamForTasks.get().average();
            double sum = streamForTasks.get().sum();
            System.out.println("Максимум: " + max.getAsDouble() + ";" + " Минимум: " + min.getAsDouble() + ";" + " Среднее арифметическое: " + avrg.getAsDouble() + ";" + " Сумма: " + sum + ".");
        }


}
