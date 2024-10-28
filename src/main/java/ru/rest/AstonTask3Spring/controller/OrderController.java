package ru.rest.AstonTask3Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rest.AstonTask3Spring.entity.Order;
import ru.rest.AstonTask3Spring.service.OrderService;
import ru.rest.AstonTask3Spring.util.JsonResponseOrderUtil;

import java.util.List;
import java.util.Optional;
import java.util.Map;

/**
 * Контроллер для управления заказами.
 *
 * <p>Предоставляет REST full API для выполнения операций с заказами,
 * включая получение, создание, обновление и удаление заказов.</p>
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    /**
     * Конструктор для внедрения зависимости OrderService.
     *
     * @param orderService Сервис для работы с заказами.
     */
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Получить список всех заказов.
     *
     * @return Список всех заказов в формате JSON.
     */
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders.stream().map(JsonResponseOrderUtil::toJson).toList());
    }

    /**
     * Получить заказ по его идентификатору.
     *
     * @param id Идентификатор заказа.
     * @return Заказ в формате JSON, если найден; иначе статус 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOrderById(@PathVariable int id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(o -> ResponseEntity.ok(JsonResponseOrderUtil.toJson(o)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Создать новый заказ.
     *
     * @param order Заказ для создания.
     * @return Созданный заказ в формате JSON со статусом 201.
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.insertOrder(order);
        return ResponseEntity.status(201).body(JsonResponseOrderUtil.toJson(savedOrder));
    }

    /**
     * Обновить существующий заказ.
     *
     * @param id Идентификатор заказа для обновления.
     * @param order Обновленные данные заказа.
     * @return Обновленный заказ в формате JSON.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateOrder(@PathVariable int id, @RequestBody Order order) {
        order.setId(id);
        Order updatedOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(JsonResponseOrderUtil.toJson(updatedOrder));
    }

    /**
     * Удалить заказ по его идентификатору.
     *
     * @param id Идентификатор заказа для удаления.
     * @return Статус 204, если удаление успешно; иначе статус 404.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        boolean isDeleted = orderService.deleteOrder(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * Получить список заказов по идентификатору пользователя.
     *
     * @param userId Идентификатор пользователя.
     * @return Список заказов для указанного пользователя в формате JSON.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getOrdersByUserId(@PathVariable int userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders.stream().map(JsonResponseOrderUtil::toJson).toList());
    }
}