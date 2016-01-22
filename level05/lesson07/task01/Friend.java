package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String name;
    private int age;
    private boolean sex;
    public void initialize(String name1){
        this.name = name1;
    }
    public void initialize(String name1, int age1){
        this.name = name1;
        this.age = age1;
    }
    public void initialize(String name1, int age1, boolean sex1){
        this.name = name1;
        this.age = age1;
        this.sex = sex1;
    }

    //напишите тут ваш код
}
