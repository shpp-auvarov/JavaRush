package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args) {
        Map<String, String> base = new HashMap<>();
        base.put("name", "Ivanov");
        base.put("country", "Ukraine");
        base.put("city", "Kiev");
        base.put("age", null);
        System.out.println(getCondition(base));
    }
    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for(Map.Entry<String, String> element : params.entrySet()){
            if(element.getValue()!=null){
                if(count!=0){
                    stringBuilder.append(" and ");
                }
                stringBuilder.append(String.format("%s = '%s'", element.getKey(), element.getValue()));
                count++;
            }
        }

        return stringBuilder;
    }
}
