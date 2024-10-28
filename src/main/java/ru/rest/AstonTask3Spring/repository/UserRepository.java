package ru.rest.AstonTask3Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rest.AstonTask3Spring.entity.User;

/**
 * Репозиторий для работы с сущностью {@link User}.
 * <p>
 * Этот интерфейс предоставляет методы для выполнения операций CRUD (создание, чтение,
 * обновление, удаление) над пользователями, а также позволяет находить пользователя
 * по имени или электронной почте.
 * </p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Находит пользователя по имени пользователя.
     *
     * @param username имя пользователя, по которому необходимо найти пользователя
     * @return найденный пользователь или null, если пользователь с таким именем не найден
     */
    User findByUsername(String username);

    /**
     * Находит пользователя по электронной почте.
     *
     * @param email электронная почта, по которой необходимо найти пользователя
     * @return найденный пользователь или null, если пользователь с такой электронной почтой не найден
     */
    User findByEmail(String email);
}