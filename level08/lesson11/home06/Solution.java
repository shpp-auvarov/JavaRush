package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> children7 = new ArrayList<Human>();
        Human child1 = new Human("child1", true, 12, children7);
        Human child2 = new Human("child2", true, 11, children7);
        Human child3 = new Human("child2", false, 10, children7);
        ArrayList<Human> children = new ArrayList<Human>();
        Collections.addAll(children, child1, child2, child3);
        Human father = new Human("father", true, 35, children);
        Human mother = new Human("mother", true, 35, children);
        ArrayList<Human> children2 = new ArrayList<Human>();
        Collections.addAll(children2, father);
        ArrayList<Human> children3 = new ArrayList<Human>();
        Collections.addAll(children3, mother);

        Human grandpa1 = new Human("grandpa1", true, 55, children2);
        Human grandpa2 = new Human("grandpa2", true, 55, children3);
        Human grandma1 = new Human("grandma1", false, 61, children2);
        Human grandma2 = new Human("grandma2", false, 57, children3);

        System.out.println(grandpa1.toString());
        System.out.println(grandpa2.toString());
        System.out.println(grandma1.toString());
        System.out.println(grandma2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());


    }

    public static class Human
    {
        //напишите тут ваш код
        public String name;
        public Boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, Boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
