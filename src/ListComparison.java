import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

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
        arrayList=new ArrayList<>(size);
        linkedList=new LinkedList<>();
        timer=new Timer();
    }

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
