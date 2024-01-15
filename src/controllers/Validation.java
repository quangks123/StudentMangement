
package controllers;

import java.util.Scanner;

public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public int inputNum() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }
    
    
    public String inputString() {
        return sc.nextLine().trim();
    }
    
    public boolean checkID(String id) {
        if (!(id.length() == 8)) {
            return false;
        }
        if (!checkNum(id.substring(2))) {
            return false;
        }
        if (!id.substring(0, 2).equalsIgnoreCase("DE")) {
            return false;
        }
        return true;
    }
    
    public boolean checkNum(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
