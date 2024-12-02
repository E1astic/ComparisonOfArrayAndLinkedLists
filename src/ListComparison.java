import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Класс предназначен для замера времени выполнения трех основных операций - добавления, получения и удаления
 * элементов в ArrayList и LinkedList при заданной размерности коллекций {@link #size}.
 * Класс имеет 3 основных метода для сравнения - {@link #compareAddition()}, {@link #compareGetting()}, {@link #compareRemoval()}.
 * Каждый из них возвращает массив из двух элементов, содержащих время выполнения в ArrayList и LinkedList в миллисекундах.
 */
public class ListComparison {
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private int size;
    private Timer timer;
    public void setSize(int size){
        this.size=size;
    }
    public int getSize(){
        return size;
    }
    public ListComparison(){
        arrayList=new ArrayList<>();
        linkedList=new LinkedList<>();
        size=0;
        timer=new Timer();
    }
    public ListComparison(int size){
        this.size=size;
        arrayList=new ArrayList<>();
        linkedList=new LinkedList<>();
        timer=new Timer();
    }

    /**
     * В методе происходит замер времени операции добавления элементов
     * в случайную позицию 'index' среди допустимых.
     * В случае ArrayList временная сложность добавления - O(n-index)
     * В случае LinkedList временная сложность добавления - O(n).
     *
     * Результат записывается в массив из двух элементов, где
     * первый элемент - время выполнения в ArrayList,
     * второй элемент - время выполнения в LinkedList.
     */
    public double[] compareAddition(){
        Random random=new Random();
        double[]results=new double[2];

        timer.startTimer();
        for(int i=0;i<size;++i){
            arrayList.add(random.nextInt(arrayList.size()+1), random.nextInt(100));
        }
        timer.finishTimer();
        results[0]=timer.getResultTimeMillis();

        timer.startTimer();
        for(int i=0;i<size;++i){
            linkedList.add(random.nextInt(linkedList.size()+1), random.nextInt(100));
        }
        timer.finishTimer();
        results[1]=timer.getResultTimeMillis();

        return results;
    }

    /**
     * В методе происходит замер времени операции получения элементов
     * со случайным индексом 'index'.
     * В случае ArrayList временная сложность получения - O(1)
     * В случае LinkedList временная сложность получения - O(n).
     *
     * Результат записывается в массив из двух элементов, где
     * первый элемент - время выполнения в ArrayList,
     * второй элемент - время выполнения в LinkedList.
     */
    public double[] compareGetting() throws EmptyListException {
        if(arrayList.isEmpty() || linkedList.isEmpty())
            throw new EmptyListException();

        Random random=new Random();
        double[]results=new double[2];

        timer.startTimer();
        for(int i=0;i<size;++i){
            arrayList.get(random.nextInt(size));
        }
        timer.finishTimer();
        results[0]=timer.getResultTimeMillis();

        timer.startTimer();
        for(int i=0;i<size;++i){
            linkedList.get(random.nextInt(size));
        }
        timer.finishTimer();
        results[1]=timer.getResultTimeMillis();

        return results;
    }

    /**
     * В методе происходит замер времени операции удаления элементов
     * со случайным индексом 'index' среди допустимых.
     * В случае ArrayList временная сложность удаления - O(n-index)
     * В случае LinkedList временная сложность удаления - O(n).
     *
     * Результат записывается в массив из двух элементов, где
     * первый элемент - время выполнения в ArrayList,
     * второй элемент - время выполнения в LinkedList.
     */
    public double[] compareRemoval() throws EmptyListException {
        if(arrayList.isEmpty() || linkedList.isEmpty())
            throw new EmptyListException();

        Random random=new Random();
        double[]results=new double[2];

        timer.startTimer();
        while(size>0){
            arrayList.remove(random.nextInt(arrayList.size()));
            --size;
        }
        timer.finishTimer();
        results[0]=timer.getResultTimeMillis();

        timer.startTimer();
        while(size>0){
            linkedList.remove(random.nextInt(linkedList.size()));
            --size;
        }
        timer.finishTimer();
        results[1]=timer.getResultTimeMillis();

        return results;
    }
}
