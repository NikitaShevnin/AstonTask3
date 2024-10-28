package ru.rest.AstonTask3Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rest.AstonTask3Spring.entity.User;
import ru.rest.AstonTask3Spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный класс UserService предоставляет методы для работы с пользователями.
 * Он инкапсулирует бизнес-логику, связанную с пользователями, и использует
 * UserRepository для взаимодействия с базой данных.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Конструктор класса UserService.
     *
     * @param userRepository репозиторий для работы с пользователями.
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Получает список всех пользователей.
     *
     * @return список пользователей.
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Получает пользователя по его идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Optional, содержащий пользователя, если он найден, иначе - пустой Optional.
     */
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    /**
     * Вставляет нового пользователя в базу данных.
     *
     * @param user объект пользователя для сохранения.
     * @return сохраненный объект пользователя.
     */
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Обновляет существующего пользователя.
     *
     * @param user объект пользователя с обновленными данными.
     * @return обновленный объект пользователя.
     */
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Удаляет пользователя по его идентификатору.
     *
     * @param id идентификатор пользователя, который нужно удалить.
     * @return true, если пользователь был успешно удален, иначе false.
     */
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Находит пользователя по имени пользователя.
     *
     * @param username имя пользователя
     * @return найденный пользователь или null, если не найден
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Находит пользователя по электронной почте.
     *
     * @param email электронная почта
     * @return найденный пользователь или null, если не найден
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}