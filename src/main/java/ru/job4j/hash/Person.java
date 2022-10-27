package ru.job4j.hash;

import java.util.Arrays;
import java.util.Objects;

/*
Сначала, необходимо исключить избыточные поля, которые не участвуют в equals.
Далее необходимо выбрать базу: число, которое будет основой вычисления hash-кода.
По историческим причинам обычно за базу берут число 31.
В целом, мы можем выбрать за базу любое число, но принято выбирать 31.
Многие IDE генерят hashCode именно с такой базой.
Правила вычисления hashCode:
Присваиваем переменной result ненулевое значение - базу.
Далее для каждого значимого поля в объекте вычисляем hashCode, по следующим правилам:
1. Если поле boolean - (f ? 1 : 0)
2.Если поле byte, char, short или int - (int)f
3.Если поле long - (int)(f ^ (f >>> 32))
4.Если поле float, то Float.floatToIntBits(f);
5. Если поле double, то Double.doubleToLongBits(f), а затем как с long.
6. Если поле это ссылка на другой объект, то рекурсивно вызвать hashCode()
7. Если поле null - то возвращаем 0.
8. Если поле это массив - то обрабатываем так, как будто каждый элемент массива - это поле объекта.
После каждого обработанного поля объединяем его hashCode с текущим значением:
result = 31 * result + c; //c - это hashCode обработанного поля.
Ниже приведен пример.
 */

public class Person {
    private boolean gender;
    private int age;
    private long weight;
    private float height;
    private double money;
    private String name;
    private Person[] children;

    public Person(boolean gender, int age, long weight, float height, double money, String name, Person[] children) {
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.money = money;
        this.name = name;
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person user = (Person) o;
        return gender == user.gender && age == user.age && weight == user.weight && Float.compare(user.height, height) == 0 && Double.compare(user.money, money) == 0 && Objects.equals(name, user.name) && Arrays.equals(children, user.children);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result += gender ? 1 : 0
                + age
                + (int) (weight ^ weight >>> 32)
                + Float.floatToIntBits(height)
                + (int) (Double.doubleToLongBits(money) ^ Double.doubleToLongBits(money) >>> 32)
                + name.hashCode();
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
}
