package local.nix.streams.demo;

import local.nix.streams.demo.tasks.Task;
import local.nix.streams.demo.tasks.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    public static void main(String[] args) {

            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Введите номер задания от 1 до 8");
                String number = br.readLine();
                int task = Integer.parseInt(number);

                        switch(task) {
                            case 1: openTask(new Task1()); break;
                            case 2: openTask(new Task2()); break;
                            case 3: openTask(new Task3()); break;
                            case 4: openTask(new Task4()); break;
                            case 5: openTask(new Task5()); break;
                            case 6: openTask(new Task6()); break;
                            case 7: openTask(new Task7()); break;
                            case 8: openTask(new Task8()); break;
                            default: System.out.println("Неправильно введен номер задания"); break;
                        }


            } catch (IOException e) {
                e.printStackTrace();
            }

    }


    private static void openTask(Task task) {
        task.doTask();
    }
}
