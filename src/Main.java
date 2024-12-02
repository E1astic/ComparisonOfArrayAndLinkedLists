import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        int capacity1=1_000;
        int capacity2=10_000;
        int capacity3=50_000;

        ListComparison comparison1=new ListComparison(capacity1);
        ListComparison comparison2=new ListComparison(capacity2);
        ListComparison comparison3=new ListComparison(capacity3);

        double[] resultsAddition1=comparison1.compareAddition();
        double[] resultsAddition2=comparison2.compareAddition();
        double[] resultsAddition3=comparison3.compareAddition();
        try {
            double[] resultsGetting1 = comparison1.compareGetting();
            double[] resultsRemoval1 = comparison1.compareRemoval();
            ListComparisonTable resultsTable1=new ListComparisonTable();
            System.out.println(resultsTable1.createResultsTable(capacity1, resultsAddition1, resultsGetting1, resultsRemoval1));

            double[] resultsGetting2 = comparison2.compareGetting();
            double[] resultsRemoval2 = comparison2.compareRemoval();
            ListComparisonTable resultsTable2=new ListComparisonTable();
            System.out.println(resultsTable2.createResultsTable(capacity2, resultsAddition2, resultsGetting2, resultsRemoval2));

            double[] resultsGetting3 = comparison3.compareGetting();
            double[] resultsRemoval3 = comparison3.compareRemoval();
            ListComparisonTable resultsTable3=new ListComparisonTable();
            System.out.println(resultsTable3.createResultsTable(capacity3, resultsAddition3, resultsGetting3, resultsRemoval3));
        }
        catch(EmptyListException e){
            System.out.println("Списки пусты. Заполните их методом compareAddition().");
        }
    }
}