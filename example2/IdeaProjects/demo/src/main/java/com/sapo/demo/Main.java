package com.sapo.demo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Scanner sc = new Scanner(System.in);
            int choise;
            do {
                showMenu();
                System.out.println("Choise function: ");
                choise = Integer.parseInt(sc.nextLine());
                switch (choise) {
                    case 1:
                        containsAnyDemo(sc);
                        break;
                    case 2:
                        containsIgnoreCaseDemo(sc);
                        break;
                    case 3:
                        countMatchesDemo(sc);
                        break;
                    case 4:
                        appendIfMissingDemo(sc);
                        break;
                    case 5:
                        prependIfMissingDemo(sc);
                        break;
                    case 6:
                        upperCaseDemo(sc);
                        break;
                    case 7:
                        lowerCaseDemo(sc);
                        break;
                    case 8:
                        isNumberSpaceDemo(sc);
                        break;
                    case 9:
                        System.exit(0);
                    default:
                        System.out.println("Moi ban nhap lai lua chon");
                }
            } while (true);
    }
    public static void showMenu(){
        System.out.println();
        System.out.println("**********************MENU**********************");
        System.out.println("1. Method containsAny ");
        System.out.println("2. Method containsIgnoreCase");
        System.out.println("3. Method countMatches");
        System.out.println("4. Method appendIfMissing");
        System.out.println("5. Method prependIfMissing");
        System.out.println("6. Method uppercase");
        System.out.println("7. Method lowercase");
        System.out.println("8. Method isNumericSpace");
        System.out.println("9. Exit");
    }

    public static void containsAnyDemo(Scanner sc){
        System.out.printf("nhap chuoi can test (kiem tra chuoi co chua cac ky tu a, b, c: \t)");
        String stringInput = sc.nextLine();
        boolean rs = StringUtils.containsAny(stringInput, "a", "b", "c");
        if (rs){
            System.out.println("Chuoi chua 1 trong cac ky tu a, b, c");
        }else {
            System.out.println("Chuoi khong chua cac ky tu a, b, c");
        }
    }

    public static void containsIgnoreCaseDemo(Scanner sc){
        System.out.printf("nhap chuoi 'Hello world' de so sanh voi chuoi 'HELLO WORLD: \t'");
        String stringInput = sc.nextLine();
        boolean rs = StringUtils.containsIgnoreCase(stringInput, "HELLO WORLD");
        if (rs){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public static void countMatchesDemo(Scanner sc){
        System.out.printf("Nhap chuoi can kiem tra \t");
        String stringInput = sc.nextLine();
        System.out.printf("Nhap ky tu can dem \t");
        String word = sc.nextLine();
        int num = StringUtils.countMatches(stringInput, word);
        System.out.printf("So ky tu \t" + word + "\t trong chuoi la: " + num);
    }

    public static void appendIfMissingDemo(Scanner sc){
        System.out.printf("Nhap chuoi can kiem tra:\t");
        String string = sc.nextLine();
        System.out.printf("Nhap chuoi can them vao ky tu cuoi cung:\t");
        String strMore = sc.nextLine();
        String stringRs = StringUtils.appendIfMissing(string, strMore);
        System.out.println("Ket qua sau khi noi chuoi:\t" + stringRs);
    }
    public static void prependIfMissingDemo(Scanner sc){
        System.out.printf("Nhap chuoi can kiem tra:\t");
        String string = sc.nextLine();
        System.out.printf("Nhap chuoi can them vao ky tu dau tien:\t");
        String strMore = sc.nextLine();
        String stringRs = StringUtils.prependIfMissing(string, strMore);
        System.out.println("Ket qua sau khi noi chuoi:\t" + stringRs);
    }

    public static void upperCaseDemo(Scanner sc){
        System.out.printf("Nhap chuoi can viet hoa:\t");
        String stringInput = sc.nextLine();
        String stringRs = StringUtils.upperCase(stringInput);
        System.out.println("Ket qua:\t" + stringRs);
    }

    public static void lowerCaseDemo(Scanner sc){
        System.out.printf("Nhap chuoi can viet thuong:\t");
        String stringInput = sc.nextLine();
        String stringRs = StringUtils.lowerCase(stringInput);
        System.out.println("Ket qua:\t" + stringRs);
    }

    public static void isNumberSpaceDemo(Scanner sc){
        System.out.printf("Nhap chuoi can kiem tra  :\t");
        String stringInput = sc.nextLine();
        boolean rs = StringUtils.isNumericSpace(stringInput);
        if (rs){
            System.out.println("Chuoi la cac khoang trang hoac so");
        }else {
            System.out.println("Chuoi khong co khoang trang va so");
        }
    }
}
