package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("family1", "name1");
        map.put("family2", "name1");
        map.put("family3", "name12");
        map.put("family4", "name21");
        map.put("family5", "name12");
        map.put("family6", "name1123");
        map.put("family7", "name21");
        map.put("family8", "name1231231231");
        map.put("family9", "nameasdfasdf1");
        map.put("family10", "nasdfame1");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copyMap = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copyMap.entrySet()){
            int i = 0;
            for (Map.Entry<String, String> pair2 : copyMap.entrySet()){
                if (pair.getValue().equals(pair2.getValue())){
                    i++;
                }
            }
            if (i > 1){
                removeItemFromMapByValue(map, pair.getValue());
            }
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
