/**
 Класс является вспомогательным для класса {@link ListComparison} и
 используется для оформления результатов выполнения в виде таблицы.
 */
public class ListComparisonTable {

    /**
     * Единственный метод класса, оформляющий результаты в виде таблицы.
     * @param capacity размерность тестируемых коллекций
     * @param resultOfAddition время выполнения операции добавления
     * @param resultOfGetting время выполнения операции получения
     * @param resultOfRemoval время выполнения операции удаления
     * @return возвращает строку с временными результатами, оформленную в виде таблицы
     */
    public String createResultsTable(int capacity, double[]resultOfAddition, double[]resultOfGetting, double[]resultOfRemoval){
        StringBuilder table=new StringBuilder("");
        table.append("\t\t\t\t\tРазмерность - " + capacity + "\n");
        table.append("Добавление:  ArrayList - " + resultOfAddition[0] + " мс   LinkedList - " + resultOfAddition[1]+" мс\n");
        table.append("Получение:   ArrayList - " + resultOfGetting[0] + " мс   LinkedList - " + resultOfGetting[1] + " мс\n");
        table.append("Удаление:    ArrayList - " + resultOfRemoval[0] + " мс   LinkedList - " + resultOfRemoval[1] + " мс\n");
        return table.toString();
    }
}
