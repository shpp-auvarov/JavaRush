package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution(){}
    public Solution(String F2){}
    public Solution(char F3){}

    private Solution(boolean F41){}
    private Solution(Integer F51){}
    private Solution(byte F61){}

    protected Solution(Character F7){}
    protected Solution(double F8){}
    protected Solution(Double F9){}

    Solution(short F10){}
    Solution(Short F11){}
    Solution(float F12){}
}

