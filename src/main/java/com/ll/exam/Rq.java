package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        this.req = req;
        this.resp = resp;
        this.req.setCharacterEncoding("UTF-8");
        this.resp.setCharacterEncoding("UTF-8");
        this.resp.setContentType("text/html; charset=utf-8");
    }

    public int getIntParam(String s, int i) {
        if(s==null){
            return i;
        }

        try {
            return Integer.parseInt(req.getParameter(s));
        }
        catch (Exception e){
            return i;
        }
    }

    public void appendBody(String body) throws IOException {
        try{
            resp.getWriter().append(body);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
