package org.toeknee.signUp.servlet;

/**
 * Created by toeknee on 11/18/15.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.toeknee.signUp.util.SignInUtil;

public class CoreServlet extends HttpServlet {
    private static final long serialVersionUID;

    static {
        serialVersionUID = 4440739483644821986L;
    }

    /**
     * request check: to check if the request is from weChat server
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // encoded signature from weChat
        String signature;
        signature = request.getParameter("signature");
        // timestamp from weChat
        String timestamp;
        timestamp = request.getParameter("timestamp");
        // a random number from weChat
        String nonce;
        nonce = request.getParameter("nonce");
        // a random string from weChat
        String echostr;
        echostr = request.getParameter("echostr");

        PrintWriter out;
        out = response.getWriter();
        // if ciphertext equals to signature then print and return the string
        if (SignInUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }

    /**
     * ?????????????????????
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ????????????????
    }
}