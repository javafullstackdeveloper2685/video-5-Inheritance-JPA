# 🎮 Наследование в JPA и Дискриминаторная Колонка

Этот проект демонстрирует использование **наследования в JPA** (JPA Inheritance) и стратегий объектно-реляционного отображения (ORM) для реализации игровой логики.

---

## 🗂️ Основные понятия

### 1. **Объектно-реляционное отображение (ORM)**
- Это процесс отображения классов Java на таблицы реляционной базы данных.

### 2. **Наследование в JPA**
- Позволяет использовать механизмы наследования из объектно-ориентированного программирования (ООП) для моделирования общих атрибутов и поведения в базе данных.

### 3. **Дискриминаторная колонка**
- Это колонка в таблице базы данных, которая определяет, к какому типу относится объект.

---

## 🚀 Стратегии наследования в JPA

### **1. `@Inheritance(strategy = InheritanceType.SINGLE_TABLE)`**
- Все данные хранятся в одной таблице.
- Дискриминаторная колонка определяет тип сущности.
- **Плюсы:** Высокая производительность, меньше объединений (JOIN).
- **Минусы:** Возможны `NULL` значения в колонках.

### **2. `@Inheritance(strategy = InheritanceType.JOINED)`**
- Общие данные хранятся в базовой таблице, а специфические — в дочерних таблицах.
- Таблицы объединяются с помощью `JOIN`.
- **Плюсы:** Чистая структура данных, без `NULL` значений.
- **Минусы:** Медленные запросы из-за объединений.

### **3. `@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)`**
- Каждая сущность хранится в своей таблице.
- Нет базовой таблицы.
- **Плюсы:** Быстрый доступ к конкретным сущностям.
- **Минусы:** Неэффективные запросы для всей иерархии.

---

## 🔗 Связь с ООП

Наследование в JPA — это способ отобразить иерархии классов Java в реляционную базу данных. Это полезно для доменно-ориентированного проектирования, где разные типы объектов имеют общие атрибуты.

---

## 📂 Пример кода

### Базовый класс

```java
@MappedSuperclass
public abstract class GamerEntity {
    @Id
    @GeneratedValue
    private UUID uuid;
    private int level;
    private int experience;
}
```
### Дочерний класс 1

````java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "player_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Mage")
public class MageEntity extends GamerEntity {
    private int healthPower;
    private int attackPower;
}

````

### Дочерний класс 2

````java
@Entity
@DiscriminatorValue("Warrior")
public class WarriorEntity extends GamerEntity {
    private int healthPower;
    private int attackPower;
}

````