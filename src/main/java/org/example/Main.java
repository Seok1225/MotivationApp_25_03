package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MotivationApp.Motivation> motivationApps = new ArrayList<>();
        int count = 0;
        System.out.println("== motivation 실행 ==");
        while (true) {
            System.out.print("명령어) ");
            String command = sc.nextLine().trim();
            if (command.equals("add")) {
                System.out.print("motivation: ");
                String text = sc.nextLine();
                System.out.print("source: ");
                String source = sc.nextLine();
                MotivationApp.Motivation motivation = new MotivationApp.Motivation();
                motivation.text = text;
                motivation.source = source;
                motivationApps.add(motivation);
                count++;
                System.out.println(count + "번 motivation이 등록되었습니다");
            } else if (command.equals("list")) {
                System.out.println("=".repeat(50));
                System.out.print("번호    /    source    /    motivation\n");
                for (int i = 0; i < motivationApps.size(); i++) {
                    MotivationApp.Motivation m = motivationApps.get(i);
                    System.out.printf("%d    /    %s    /    %s\n", i + 1, m.source, m.text);
                }
                System.out.println("=".repeat(50));
            } else if (command.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            } else if (command.length() == 0) {
                System.out.println("아무것도 입력하지않았습니다.");
            }
        }
        sc.close();
    }
}

class MotivationApp {
    static class Motivation {
        String text;
        String source;
    }
}