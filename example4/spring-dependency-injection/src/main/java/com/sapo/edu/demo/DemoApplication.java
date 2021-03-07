package com.sapo.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private Atm bidvAtm;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        customer.inputForm();

        String choise = null;
        do {
            System.out.println();
            System.out.println("*********MENU*********");
            System.out.println("1. Rút tiền");
            System.out.println("2. Gửi tiền");
            System.out.println("3. Thông tin tài khoản");
            System.out.println("4. Thoat");
            System.out.println("Lua chon cua ban la: ");
            choise = sc.nextLine();

            switch (choise){
                case "1":
                    moneyDraw(sc, customer );
                    break;
                case "2":
                    moneySend(sc, customer);
                    break;
                case "3":
                    bidvAtm.displayCustomerInfo(customer);
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap lai lua chon cua ban");
            }
        } while (true);

    }

    public void moneyDraw(Scanner sc, Customer customer){
        bidvAtm.printCurrentMoney();
        System.out.printf("Nhap so tien can rut: \t");
        BigDecimal moneyDraw = null;
        do {
            try {
                moneyDraw = sc.nextBigDecimal();
                break;
            } catch (Exception e){
                System.err.printf("Vui long nhap lai: \t");
                sc.next();
            }
        }while (true);
        bidvAtm.withDraw(customer, moneyDraw);
        bidvAtm.printCurrentMoney();
    }

    public void moneySend(Scanner sc, Customer customer){
        System.out.printf("Nhap so tien muon gui:\t");
        BigDecimal moneySend = null;
        do {
            try{
                moneySend = sc.nextBigDecimal();
                break;
            } catch (Exception e){
                System.out.printf("Vui long nhap lai: \t");
                sc.next();
            }
        } while (true);
        bidvAtm.deposit(customer, moneySend);
        bidvAtm.printCurrentMoney();
    }


}
