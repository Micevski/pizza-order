package mk.finki.ukim.mk.lab1.web;

import mk.finki.ukim.mk.lab1.model.Order;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/selectPizzaSize")
public class SelectPizzaSize extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final ApplicationEventPublisher publisher;

    public SelectPizzaSize(SpringTemplateEngine springTemplateEngine, ApplicationEventPublisher publisher) {
        this.springTemplateEngine = springTemplateEngine;
        this.publisher = publisher;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        String pizzaName = req.getParameter("pizza");
        Order order = new Order();
        order.setPizzaType(pizzaName);
        publisher.publishEvent(new ApplicationEvent(this){});
        req.getSession().setAttribute("order", order);
        webContext.setVariable("pizzaName", pizzaName);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("selectPizzaSize.html", webContext, resp.getWriter());
    }
}
