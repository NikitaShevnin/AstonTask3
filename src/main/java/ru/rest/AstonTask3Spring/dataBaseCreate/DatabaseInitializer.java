package ru.rest.AstonTask3Spring.dataBaseCreate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rest.AstonTask3Spring.config.SpringConfig;
import ru.rest.AstonTask3Spring.entity.Order;
import ru.rest.AstonTask3Spring.entity.User;
import ru.rest.AstonTask3Spring.repository.OrderRepository;
import ru.rest.AstonTask3Spring.repository.UserRepository;

import java.util.Date;

/**
 * Класс для инициализации базы данных с тестовыми данными.
 */
public class DatabaseInitializer {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    /**
     * Конструктор класса DatabaseInitializer.
     *
     * @param userRepository репозиторий для работы с пользователями
     * @param orderRepository репозиторий для работы с заказами
     */
    public DatabaseInitializer(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * Метод для инициализации тестовых данных в базе данных.
     * Этот метод создает пользователей и соответствующие им заказы.
     */
    public void initData() {
        // Создаем пользователей
        User user1 = new User("JohnDoe", "password123", "john.doe@example.com");
        User user2 = new User("JaneSmith", "password123", "jane.smith@example.com");
        User user3 = new User("BobJohnson", "password123", "bob.johnson@example.com");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Создаем заказы
        createOrder(user1.getId(), "Product A", 2);
        createOrder(user1.getId(), "Product B", 1);
        createOrder(user2.getId(), "Product C", 5);
        createOrder(user3.getId(), "Product D", 3);
        createOrder(user3.getId(), "Product E", 4);
    }

    /**
     * Метод для создания заказа.
     *
     * @param userId идентификатор пользователя, которому принадлежит заказ
     * @param productName название продукта в заказе
     * @param quantity количество продуктов в заказе
     */
    private void createOrder(int userId, String productName, int quantity) {
        Order order = new Order(userId, productName, new Date(), quantity);
        orderRepository.save(order);
    }

    /**
     * Метод, который является точкой входа в приложение для инициализации базы данных.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserRepository userRepository = context.getBean(UserRepository.class);
        OrderRepository orderRepository = context.getBean(OrderRepository.class);

        DatabaseInitializer databaseInitializer = new DatabaseInitializer(userRepository, orderRepository);
        databaseInitializer.initData();
    }
}