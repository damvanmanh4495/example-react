package com.sapo.edu.demo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Customer {
    private String acctNo;
    private String pin;
    private BigDecimal balance;

    public Customer(String accountNo,String pin,BigDecimal balance) {
        this.acctNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public Customer() {
        super();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void inputForm(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ten tai khoan: \t");
        do{
            try {
                this.acctNo = sc.nextLine();
                break;
            }catch (Exception e){
                System.err.printf("Vui long nhap lai ! \t");
                sc.next();
            }
        }while (true);

        System.out.printf("Mat khau: \t");
        do{
            try {
                this.pin = sc.nextLine();
                break;
            }catch (Exception e){
                System.err.printf("Vui long nhap mat khau ! \t");
                sc.next();
            }
        }while (true);

        System.out.printf("So tien khoi tao: \t");
        do {
            try {
                this.balance = sc.nextBigDecimal();
                break;
            } catch (Exception e){
                System.err.printf("Vui long nhap lai so tien: \t");
                sc.next();
            }
        }while (true);
    }
}
