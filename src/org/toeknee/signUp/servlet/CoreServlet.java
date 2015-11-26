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

import org.toeknee.signUp.service.CoreService;
import org.toeknee.signUp.util.SignInUtil;

public class CoreServlet extends HttpServlet {
    private static final long serialVersionUID;

    static {
        serialVersionUID = 4440739483644821986L;
    }

    @Override
    /**
     * request check: to check if the request is from weChat server
     *
     * @param request
     * @param response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // encoded signature from weChat
        String signature = request.getParameter("signature");
        // timestamp from weChat
        String timestamp = request.getParameter("timestamp");
        // a random number from weChat
        String nonce = request.getParameter("nonce");
        // a random string from weChat
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        // if ciphertext equals to signature then print and return the string
        if (SignInUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }

    @Override
    /**
     * get the request from server and post a response
     *
     * @param request
     * @param response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set character encoding for Chinese
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // encoded signature from weChat
        String signature = request.getParameter("signature");
        // timestamp from weChat
        String timestamp = request.getParameter("timestamp");
        // a random string from weChat
        String nonce = request.getParameter("nonce");

        PrintWriter out = response.getWriter();
        if (SignInUtil.checkSignature(signature, timestamp, nonce)) {
            // if ciphertext equals to signature then print and response
            String respXml = CoreService.processRequest(request);
            out.print(respXml);
        }
        out.close();
        out = null;
    }
}