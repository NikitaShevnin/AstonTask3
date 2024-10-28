package ru.rest.AstonTask3Spring.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Класс сущности Order, представляющий заказ в системе.
 * <p>
 * Этот класс содержит информацию о заказе, такую как идентификатор пользователя,
 * наименование продукта, дату заказа и количество.
 * Он используется в качестве сущности JPA, управляемой Hibernate.
 * </p>
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    /**
     * Пустой конструктор для инициализации объекта Order без параметров.
     */
    public Order() {
    }

    /**
     * Конструктор для инициализации объекта Order с заданными параметрами.
     *
     * @param userId идентификатор пользователя, сделавшего заказ.
     * @param productName наименование продукта, который был заказан.
     * @param orderDate дата, когда был сделан заказ.
     * @param quantity количество заказа.
     */
    public Order(int userId, String productName, Date orderDate, int quantity) {
        this.userId = userId;
        this.productName = productName;
        this.orderDate = orderDate;
        this.quantity = quantity;
    }

    /**
     * Получает идентификатор заказа.
     *
     * @return идентификатор заказа.
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор заказа.
     *
     * @param id идентификатор заказа.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получает идентификатор пользователя, сделавшего заказ.
     *
     * @return идентификатор пользователя.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Устанавливает идентификатор пользователя, сделавшего заказ.
     *
     * @param userId идентификатор пользователя.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Получает наименование продукта, который был заказан.
     *
     * @return наименование продукта.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Устанавливает наименование продукта, который был заказан.
     *
     * @param productName наименование продукта.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Получает дату, когда был сделан заказ.
     *
     * @return дата заказа.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Устанавливает дату, когда был сделан заказ.
     *
     * @param orderDate дата заказа.
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Получает количество заказа.
     *
     * @return количество заказа.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Устанавливает количество заказа.
     *
     * @param quantity количество заказа.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}