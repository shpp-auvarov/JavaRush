package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName() {
        return columnName;
    }

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    @Override
    public boolean isShown() {

        return realOrder[ordinal()] == -1 ? false : true;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    @Override
    public void hide() {
        realOrder[ordinal()] = -1;
    }

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        Map<Integer, Integer> base = new TreeMap<>();
        for (int i = 0; i < realOrder.length; i++) {
            base.put(realOrder[i], i);
        }
        Column[] array = Column.values();
        for (Map.Entry<Integer, Integer> entry : base.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key != -1) {
                result.add(array[value]);
            }
        }
        return result;
    }
}
