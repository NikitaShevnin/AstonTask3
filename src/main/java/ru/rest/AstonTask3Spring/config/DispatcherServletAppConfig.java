package ru.rest.AstonTask3Spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурационный класс для настройки веб-приложения с использованием Spring MVC.
 *
 * <p>
 * Данный класс включает аннотации:
 * <ul>
 *   <li>{@link Configuration} - обозначает, что этот класс является источником конфигурации Spring.</li>
 *   <li>{@link EnableWebMvc} - включает поддержку Spring MVC.</li>
 *   <li>{@link ComponentScan} - указывает Spring сканировать пакет "ru.rest.AstonTask3Spring"
 *       для обнаружения компонентов, сервисов и контроллеров.</li>
 * </ul>
 * </p>
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.rest.AstonTask3Spring")
public class DispatcherServletAppConfig implements WebMvcConfigurer {
}