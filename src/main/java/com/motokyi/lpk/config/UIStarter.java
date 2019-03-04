package com.motokyi.lpk.config;

import com.motokyi.lpk.ui.MainWindow;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.swing.*;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class UIStarter implements ApplicationListener<ContextRefreshedEvent> {
    private static MainWindow ui = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (isNull(ui)) {
            SwingUtilities.invokeLater(() -> ui = new MainWindow());
        }
    }
}
