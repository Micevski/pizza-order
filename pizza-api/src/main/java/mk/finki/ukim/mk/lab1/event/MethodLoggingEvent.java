package mk.finki.ukim.mk.lab1.event;

import org.springframework.context.ApplicationEvent;

public class MethodLoggingEvent extends ApplicationEvent {
    private String method;

    public MethodLoggingEvent(Object source, String method) {
        super(source);
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

