package com.test;

import org.apache.commons.lang3.StringUtils;




public  class test extends StringUtils {





    public static void main(String[] args) {
        String string = "          ";
        boolean rs = StringUtils.containsIgnoreCase(string, "BAeldung.com");
        System.out.println(rs);
        boolean rs2 = StringUtils.isNumericSpace(string);
        System.out.println(rs2);
    }


}
