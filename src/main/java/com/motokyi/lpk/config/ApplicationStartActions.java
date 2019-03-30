package com.motokyi.lpk.config;

import com.motokyi.lpk.ui.MainWindow;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartActions implements ApplicationListener<ContextRefreshedEvent> {
    private final MainWindow ui;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!ui.isVisible()) {
            ui.setVisible(true);
        }
    }
}
