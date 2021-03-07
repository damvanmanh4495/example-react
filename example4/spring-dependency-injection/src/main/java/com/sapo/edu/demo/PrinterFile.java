package com.sapo.edu.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PrinterFile implements Printer {


    private Logger log = LoggerFactory.getLogger(PrinterFile.class);
    @Override
    public void printCustoner(Customer customer) {
        log.info("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {

        log.info(message);
    }
}
