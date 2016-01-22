package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name;
    private int age;
    private int weight;
    private String color;
    private String adres;
    public void initialize(String name1){
        this.name = name1;
    }
    public void initialize(String name1, int weight1, int age1){
        this.name = name1;
        this.weight = weight1;
        this.age = age1;

    }
    public void initialize(String name1, int age1){
        this.name = name1;
        this.age = age1;
        this.weight = 10;
    }
    public void initialize(int weight1, String color1){
        this.weight = weight1;
        this.color = color1;
    }
    public void initialize(int weight1, String color1, String adres1){
        this.weight = weight1;
        this.color = color1;
        this.adres = adres1;
    }

    //напишите тут ваш код

}
