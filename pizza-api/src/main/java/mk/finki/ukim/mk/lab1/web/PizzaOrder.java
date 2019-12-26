package mk.finki.ukim.mk.lab1.web;

import mk.finki.ukim.mk.lab1.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrder(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String pizzaSize = req.getParameter("pizza_size");
        resp.setContentType("text/html; charset=UTF-8");
        Order order = (Order)req.getSession().getAttribute("order");
        order.setPizzaSize(pizzaSize);
        req.getSession().setAttribute("order", order);
        webContext.setVariable("pizzaName", order.getPizzaType());
        webContext.setVariable("pizzaSize", pizzaSize);
        this.springTemplateEngine.process("deliveryInfo.html", webContext, resp.getWriter());
    }
}
