package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name;
    private int height;
    private String color;
    public void initialize(String name1){
        this.name = name1;
    }
    public void initialize(String name1, int height1){
        this.name = name1;
        this.height = height1;
    }
    public void initialize(String name1, int height1, String color1){
        this.name = name1;
        this.height = height1;
        this.color = color1;
    }
    //напишите тут ваш код

}
