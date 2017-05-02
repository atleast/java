package net.lastone.controller;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
public class ServletRequestListenerDemo implements ServletRequestListener{
    public void requestInitialized(ServletRequestEvent event){
        System.out.println(
                "request initialized: http://"
                + event.getServletRequest().getRemoteAddr()
                + event.getServletContext().getContextPath()
        );
    }
    public void requestDestroyed(ServletRequestEvent event){
        System.out.println(
                "request destroyed: http://"
                        + event.getServletRequest().getRemoteAddr()
                        + event.getServletContext().getContextPath()
        );
    }
}