package ru.rest.AstonTask3Spring;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.rest.AstonTask3Spring.config.SpringConfig;

/**
 * Главный класс приложения, который запускает HTTP сервер и настраивает контекст Spring.
 */
public class Main {

    /**
     * Метод, который является точкой входа в приложение.
     *
     * @param args аргументы командной строки
     * @throws Exception если происходит ошибка при создании контекста или запуске сервера
     */
    public static void main(String[] args) throws Exception {

        // Создаем контекст Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        // Настраиваем HTTP сервер
        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");

        // Устанавливаем обработчик для сервера
        server.setHandler(contextHandler);

        // Создаем DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setApplicationContext(context);

        // Регистрируем через ServletHolder
        ServletHolder holder = new ServletHolder(dispatcherServlet);
        contextHandler.addServlet(holder, "/*");

        // Запускаем сервер
        server.start();
        server.join();
    }
}