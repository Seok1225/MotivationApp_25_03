package org.example.motivation.controller;

import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    int lastId = 0;
    List<Motivation> motivations = new ArrayList<>();
    Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    public void add() {
        int id = lastId + 1;
        System.out.print("body : ");
        String body = sc.nextLine();
        System.out.print("source : ");
        String source = sc.nextLine();

        Motivation motivation = new Motivation(id, body, source);
        motivations.add(motivation);

        System.out.printf("%d번 motivation이 등록되었습니다.\n", id);
        lastId++;
    }

    public void list() {
        if (motivations.isEmpty()) {
            System.out.println("등록된 motivation이 없습니다.");
            return;
        }

        System.out.println("=".repeat(40));
        System.out.printf("   id    |     source     |      body      \n");
        System.out.println("-".repeat(40));

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);
            System.out.printf("   %-5d | %-12s | %-15s\n",
                    motivation.getId(),
                    motivation.getSource().length() > 10 ? motivation.getSource().substring(0, 10) + "..." : motivation.getSource(),
                    motivation.getBody());
        }

        System.out.println("=".repeat(40));
    }

    public void remove(String[] cmdParts) {
        if (cmdParts.length < 2) {
            System.out.println("삭제할 motivation id를 입력하세요. (예: remove 3)");
            return;
        }

        int id;
        try {
           id = Integer.parseInt(cmdParts[1]);
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력하세요.");
            return;
        }

        Motivation toRemove = null;
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                toRemove = motivation;
                break;
            }
        }

        if (toRemove == null) {
            System.out.println(id + "번 motivation이 존재하지 않습니다.");
        } else {
            motivations.remove(toRemove);
            System.out.println(id + "번 motivation이 삭제되었습니다.");
        }
    }
}