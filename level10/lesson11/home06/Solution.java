package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        public String name;
        public String family;
        public int age;
        public String address;
        public Boolean sex;
        public String country;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String family) {
            this.name = name;
            this.family = family;
        }

        public Human(String name, String family, int age) {
            this.name = name;
            this.family = family;
            this.age = age;
        }

        public Human(String name, String family, int age, String address) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.address = address;
        }

        public Human(String name, String family, int age, String address, Boolean sex) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.address = address;
            this.sex = sex;
        }

        public Human(String name, String family, int age, String address, Boolean sex, String country) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.address = address;
            this.sex = sex;
            this.country = country;
        }

        public Human(String name, String family, int age, String address, String country) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.address = address;
            this.country = country;
        }

        public Human(String name, String family, int age, Boolean sex, String country) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.sex = sex;
            this.country = country;
        }

        public Human(String name, String family, Boolean sex, String address, String country) {
            this.name = name;
            this.family = family;
            this.sex = sex;
            this.address = address;
            this.country = country;
        }

        public Human(String name, String family, Boolean sex, String country) {
            this.name = name;
            this.family = family;
            this.sex = sex;
            this.country = country;
        }
    }
}
