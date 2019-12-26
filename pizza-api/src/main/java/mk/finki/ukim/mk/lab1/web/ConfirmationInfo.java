package mk.finki.ukim.mk.lab1.web;

import mk.finki.ukim.mk.lab1.model.Order;
import mk.finki.ukim.mk.lab1.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        Order order = (Order) req.getSession().getAttribute("order");
        order.setClientName(clientName);
        order.setClientAddress(clientAddress);
        order = orderService.placeOrder(order);
        resp.setContentType("text/html; charset=UTF-8");
        webContext.setVariable("pizzaName", order.getPizzaType());
        webContext.setVariable("pizzaSize", order.getPizzaSize());
        webContext.setVariable("clientName", clientName);
        webContext.setVariable("clientAddress", clientAddress);
        webContext.setVariable("clientIP", req.getRemoteAddr());
        webContext.setVariable("clientBrowser", req.getHeader("User-Agent"));
        webContext.setVariable("orderId", order.getId());
        this.springTemplateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
    }
}
