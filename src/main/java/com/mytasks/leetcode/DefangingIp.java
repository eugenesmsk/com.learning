package com.mytasks.leetcode;
//https://leetcode.com/problems/defanging-an-ip-address/

public class DefangingIp {
    public String defangIPaddr(String address) {
        /*
        //Slow version
        String[] s = address.split("");
        StringBuilder builder = new StringBuilder();
        for(String str: s) {
            if(str.equals(".")) {
                builder.append("[.]");
            }
            else {builder.append(str);}
        }
        return builder.toString();
         */

        //Fast version
        int sLength = address.length();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < sLength; i++) {
            if(address.charAt(i) == '.') {
                builder.append("[.]");
            }
            else {
                builder.append(address.charAt(i));
            }
        }
        return builder.toString();
    }
}

class Test1 {
    public static void main(String[] args) {
        DefangingIp ip = new DefangingIp();
        System.out.println(ip.defangIPaddr("192.168.45.2"));
    }
}
