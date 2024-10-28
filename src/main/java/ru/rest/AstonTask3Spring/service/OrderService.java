package ru.rest.AstonTask3Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rest.AstonTask3Spring.entity.Order;
import ru.rest.AstonTask3Spring.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный класс OrderService предоставляет методы для работы с заказами.
 * Он инкапсулирует бизнес-логику, связанную с заказами, и использует
 * OrderRepository для взаимодействия с базой данных.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * Конструктор класса OrderService.
     *
     * @param orderRepository репозиторий для работы с заказами.
     */
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Получает список всех заказов.
     *
     * @return список заказов.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Получает заказ по его идентификатору.
     *
     * @param id идентификатор заказа.
     * @return Optional, содержащий заказ, если он найден, иначе - пустой Optional.
     */
    public Optional<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    /**
     * Вставляет новый заказ в базу данных.
     *
     * @param order объект заказа для сохранения.
     * @return сохраненный объект заказа.
     */
    public Order insertOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Обновляет существующий заказ.
     *
     * @param order объект заказа с обновленными данными.
     * @return обновленный объект заказа.
     */
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Удаляет заказ по его идентификатору.
     *
     * @param id идентификатор заказа, который нужно удалить.
     * @return true, если заказ был успешно удален, иначе false.
     */
    public boolean deleteOrder(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Получает список заказов по идентификатору пользователя.
     *
     * @param userId идентификатор пользователя, чьи заказы нужно получить.
     * @return список заказов, связанных с указанным пользователем.
     */
    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }
}