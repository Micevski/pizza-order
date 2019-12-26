package mk.finki.ukim.mk.lab1.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MethodLoggerListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(String.format("[WP-Log] {%s}", applicationEvent.getSource().toString()));

    }
}
