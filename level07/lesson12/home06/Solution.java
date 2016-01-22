package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandpa1 = new Human("grandpa1", true, 60);
        Human grandpa2 = new Human("grandpa2", true, 60);
        Human grandma1 = new Human("grandma1", false, 60);
        Human grandma2 = new Human("grandma2", false, 60);
        Human father = new Human("father", true, 40, grandpa1, grandma1);
        Human mother = new Human("mother", false, 40, grandpa2, grandma2);
        Human doughter = new Human("doughter", false, 20, father, mother);
        Human son = new Human("son", true, 20, father, mother);
        Human son1 = new Human("son1", true, 20, father, mother);
        System.out.println(grandpa1);
        System.out.println(grandpa2);
        System.out.println(grandma1);
        System.out.println(grandma2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(doughter);
        System.out.println(son);
        System.out.println(son1);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private Boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, Boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, Boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
