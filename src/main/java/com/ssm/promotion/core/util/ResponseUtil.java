package com.ssm.promotion.core.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
