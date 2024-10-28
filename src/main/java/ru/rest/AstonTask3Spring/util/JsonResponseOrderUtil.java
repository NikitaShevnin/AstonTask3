package ru.rest.AstonTask3Spring.util;

import ru.rest.AstonTask3Spring.entity.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Утилитарный класс для преобразования объекта заказа в JSON-ответ.
 *
 * <p>Этот класс предоставляет статический метод для конвертации объекта {@link Order} в
 * формат JSON, представленный в виде объекта {@link Map}. Это упрощает процесс
 * подготовки данных для отправки в виде ответа клиенту при работе с REST API.</p>
 */
public class JsonResponseOrderUtil {

    /**
     * Преобразует объект заказа в JSON-ответ.
     *
     * @param order объект заказа, который необходимо преобразовать
     * @return объект Map, представляющий данные заказа в формате JSON,
     *         содержащий идентификатор заказа, идентификатор пользователя,
     *         название продукта, дату заказа и количество.
     */
    public static Map<String, Object> toJson(Order order) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", order.getId());
        response.put("userId", order.getUserId());
        response.put("productName", order.getProductName());
        response.put("orderDate", order.getOrderDate());
        response.put("quantity", order.getQuantity());
        return response;
    }
}