package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어가 입력되지 않았습니다.");
                continue;
            }

            String[] cmdParts = cmd.split(" |\\?", 2);
            String action = cmdParts[0];

            switch (action) {
                case "add":
                    motivationController.add();
                    break;
                case "list":
                    motivationController.list();
                    break;
                case "remove":
                    if (cmdParts.length == 2 && cmdParts[1].startsWith("id=")) {
                        cmdParts[1] = cmdParts[1].substring(3);
                    }
                    motivationController.remove(cmdParts);
                    break;
                case "edit":
                    if (cmdParts.length == 2 && cmdParts[1].startsWith("id=")) {
                        cmdParts[1] = cmdParts[1].substring(3);
                    }
                    motivationController.edit(cmdParts);
                    break;
                default:
                    System.out.println("사용할 수 없는 명령어입니다.");
            }
        }
    }
}