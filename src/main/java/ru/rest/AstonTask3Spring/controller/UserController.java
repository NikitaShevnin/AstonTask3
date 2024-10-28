package ru.rest.AstonTask3Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rest.AstonTask3Spring.entity.User;
import ru.rest.AstonTask3Spring.service.UserService;
import ru.rest.AstonTask3Spring.util.JsonResponseUserUtil;

import java.util.List;
import java.util.Optional;
import java.util.Map;

/**
 * Контроллер для управления пользователями.
 *
 * <p>Предоставляет REST full API для выполнения операций с пользователями,
 * включая получение, создание, обновление и удаление пользователей.</p>
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Конструктор для внедрения зависимости UserService.
     *
     * @param userService Сервис для работы с пользователями.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получить список всех пользователей.
     *
     * @return Список всех пользователей в формате JSON.
     */
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users.stream().map(JsonResponseUserUtil::toJson).toList());
    }

    /**
     * Получить пользователя по его идентификатору.
     *
     * @param id Идентификатор пользователя.
     * @return Пользователь в формате JSON, если найден; иначе статус 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(u -> ResponseEntity.ok(JsonResponseUserUtil.toJson(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Создать нового пользователя.
     *
     * @param user Пользователь для создания.
     * @return Созданный пользователь в формате JSON со статусом 201.
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
        User savedUser = userService.insertUser(user);
        return ResponseEntity.status(201).body(JsonResponseUserUtil.toJson(savedUser));
    }

    /**
     * Обновить существующего пользователя.
     *
     * @param id Идентификатор пользователя для обновления.
     * @param user Обновленные данные пользователя.
     * @return Обновленный пользователь в формате JSON.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(JsonResponseUserUtil.toJson(updatedUser));
    }

    /**
     * Удалить пользователя по его идентификатору.
     *
     * @param id Идентификатор пользователя для удаления.
     * @return Статус 204, если удаление успешно; иначе статус 404.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * Получить пользователя по имени пользователя.
     *
     * @param username Имя пользователя.
     * @return Пользователь в формате JSON, если найден; иначе статус 404.
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<Map<String, Object>> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return user != null ? ResponseEntity.ok(JsonResponseUserUtil.toJson(user)) : ResponseEntity.notFound().build();
    }

    /**
     * Получить пользователя по электронной почте.
     *
     * @param email Электронная почта.
     * @return Пользователь в формате JSON, если найден; иначе статус 404.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<Map<String, Object>> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return user != null ? ResponseEntity.ok(JsonResponseUserUtil.toJson(user)) : ResponseEntity.notFound().build();
    }
}