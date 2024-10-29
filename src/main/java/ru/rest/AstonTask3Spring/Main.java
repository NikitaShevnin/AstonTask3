package ru.rest.AstonTask3Spring;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext; // Импортируйте этот класс
import ru.rest.AstonTask3Spring.config.DispatcherServletAppConfig;

/**
 * Главный класс приложения, который запускает HTTP сервер и настраивает контекст Spring.
 */
public class Main {

    /**
     * Метод, который является точкой входа в приложение.
     *
     * @param args аргументы командной строки
     * @throws Exception если происходит ошибка при создании сервера
     */
    public static void main(String[] args) throws Exception {

        // Создаем WebApplicationContext
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(DispatcherServletAppConfig.class); // Регистрируем конфигурацию

        // Настраиваем HTTP сервер
        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");

        // Устанавливаем обработчик для сервера
        server.setHandler(contextHandler);

        // Создаем DispatcherServlet с использованием WebApplicationContext
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // Регистрируем через ServletHolder
        ServletHolder holder = new ServletHolder(dispatcherServlet);
        contextHandler.addServlet(holder, "/*");

        // Запускаем сервер
        server.start();
        server.join();
    }
}