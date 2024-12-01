public class ListComparisonTable {

    public String createResultsTable(int capacity, double[]resultOfAddition, double[]resultOfGetting, double[]resultOfRemoval){
        StringBuilder table=new StringBuilder("");
        table.append("\t\t\t\t\tРазмерность - " + capacity + "\n");
        table.append("Добавление:  ArrayList - "+resultOfAddition[0]+" мс   LinkedList - "+resultOfAddition[1]+" мс\n");
        table.append("Получение:  ArrayList - " + resultOfGetting[0] + " мс   LinkedList - " + resultOfGetting[1] + " мс\n");
        table.append("Удаление:  ArrayList - " + resultOfRemoval[0] + " мс   LinkedList - " + resultOfRemoval[1] + " мс\n");
        return table.toString();
    }
}
