package com.taygo.utility;

import java.text.*;
import java.util.*;

public class EmailFormat {
    public static String email;
    public void email() {
        SimpleDateFormat formatter = new SimpleDateFormat ("MMddyyHHmmss");
        String e = formatter.format (new Date ());
        email = "uday" + e + "@getnada.com";
        System.out.println ("teste print: " + email);
    }

    public String  currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat ("MMddyyHHmmss");
        String currentDate;
        currentDate = formatter.format (new Date ());
       return currentDate;
    }
}
