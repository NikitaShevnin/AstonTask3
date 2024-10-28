package ru.rest.AstonTask3Spring.util;

import ru.rest.AstonTask3Spring.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Утилитарный класс для преобразования объекта пользователя в JSON-ответ.
 *
 * <p>Этот класс предоставляет статический метод для конвертации объекта {@link User} в
 * формат JSON, представленный в виде объекта {@link Map}. Это упрощает процесс
 * подготовки данных для отправки в виде ответа клиенту при работе с REST API.</p>
 */
public class JsonResponseUserUtil {

    /**
     * Преобразует объект пользователя в JSON-ответ.
     *
     * @param user объект пользователя, который необходимо преобразовать
     * @return объект Map, представляющий данные пользователя в формате JSON,
     *         содержащий идентификатор пользователя, имя пользователя и email.
     *         Пароль не включается в ответ по соображениям безопасности.
     */
    public static Map<String, Object> toJson(User user) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("username", user.getUsername());
        response.put("email", user.getEmail());
        return response;
    }
}