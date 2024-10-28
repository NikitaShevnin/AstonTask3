package ru.rest.AstonTask3Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rest.AstonTask3Spring.entity.Order;

import java.util.List;

/**
 * Репозиторий для работы с сущностью {@link Order}.
 * <p>
 * Этот интерфейс предоставляет методы для выполнения операций CRUD (создание, чтение,
 * обновление, удаление) над заказами, а также позволяет находить заказы по идентификатору пользователя.
 * </p>
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * Находит все заказы, связанные с указанным идентификатором пользователя.
     *
     * @param userId идентификатор пользователя, чьи заказы необходимо найти
     * @return список заказов, принадлежащих пользователю с указанным идентификатором
     */
    List<Order> findByUserId(int userId);
}