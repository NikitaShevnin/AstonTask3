package ru.rest.AstonTask3Spring.entity;

import jakarta.persistence.*;

/**
 * Класс сущности User, представляющий пользователя в системе.
 * <p>
 * Этот класс содержит информацию о пользователе, такую как
 * имя пользователя, пароль и email. Он используется в качестве
 * сущности JPA, управляемой Hibernate.
 * </p>
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Пустой конструктор для инициализации объекта User без параметров.
     */
    public User() {
    }

    /**
     * Конструктор для инициализации объекта User с заданными параметрами.
     *
     * @param username имя пользователя.
     * @param password пароль пользователя.
     * @param email адрес электронной почты пользователя.
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Получает идентификатор пользователя.
     *
     * @return идентификатор пользователя.
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор пользователя.
     *
     * @param id идентификатор пользователя.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получает имя пользователя.
     *
     * @return имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     *
     * @param username имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Получает пароль пользователя.
     *
     * @return пароль пользователя.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Устанавливает пароль пользователя.
     *
     * @param password пароль пользователя.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Получает адрес электронной почты пользователя.
     *
     * @return адрес электронной почты пользователя.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Устанавливает адрес электронной почты пользователя.
     *
     * @param email адрес электронной почты пользователя.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}