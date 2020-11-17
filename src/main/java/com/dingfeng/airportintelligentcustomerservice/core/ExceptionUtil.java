package com.dingfeng.airportintelligentcustomerservice.core;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
    public static Throwable getExceptionType(Exception e) {
        return e;
    }

    public static String getExceptionMessage(Exception e) {
        return e.getMessage();
    }

    public static String getExceptionSrintStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
