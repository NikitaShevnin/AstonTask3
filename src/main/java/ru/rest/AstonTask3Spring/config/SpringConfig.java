package ru.rest.AstonTask3Spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Properties;

/**
 * Конфигурационный класс для настройки Spring и JPA.
 * <p>
 * Этот класс включает в себя настройку EntityManagerFactory,
 * источника данных (DataSource) и включает поддержку
 * JPA с использованием Hibernate.
 * </p>
 */
@Configuration
@EnableJpaRepositories(basePackages = "ru.rest.AstonTask3Spring.repository")
@EnableTransactionManagement  // Включаем управление транзакциями
public class SpringConfig {

    /**
     * Создает и настраивает LocalContainerEntityManagerFactoryBean.
     *
     * @param dataSource источник данных для подключения к базе данных.
     * @return настроенный экземпляр LocalContainerEntityManagerFactoryBean.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("ru.rest.AstonTask3Spring.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // Настройки JPA
        em.setJpaProperties(hibernateProperties());

        return em;
    }

    /**
     * Определяет свойства Hibernate для настройки.
     *
     * @return свойства, необходимые для настройки Hibernate.
     */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); // Обновляем диалект на актуальный
        return properties;
    }

    /**
     * Создает источник данных для подключения к базе данных.
     *
     * @return настроенный экземпляр DataSource.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/astonTask3DB");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    /**
     * Создает и настраивает платформу управления транзакциями.
     *
     * @param entityManagerFactory фабрика EntityManager.
     * @return настроенный экземпляр PlatformTransactionManager.
     */
    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}