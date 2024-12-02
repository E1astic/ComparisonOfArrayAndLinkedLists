/**
 * Класс предназначен для замера времени выполнения любых операций.
 * Имеет методы {@link #startTimer()}, {@link #finishTimer()}, {@link #getResultTimeMillis()}.
 * Возвращает время выполнения в миллисекундах.
 * */
public class Timer {
    private long nanoTimeStart;
    private long nanoTimeFinish;
    private boolean isCorrectStart;

    public long getNanoTimeStart() {
        return nanoTimeStart;
    }
    public long getNanoTimeFinish() {
        return nanoTimeFinish;
    }

    public Timer(){
        nanoTimeStart=0;
        nanoTimeFinish=0;
        isCorrectStart=false;
    }

    /**
     * Данный метод записывает время начала выполнения какой-либо операции в поле {@link #nanoTimeStart},
     * обнуляет время окончания выполнения предыдущей операции,
     * устанавливает флаг {@link #isCorrectStart} в значение true
     */
    public void startTimer(){
        nanoTimeStart=System.nanoTime();
        isCorrectStart=true;
        nanoTimeFinish=0;
    }

    /**
     * Данный метод записывает время окончания выполнения какой-либо операции в поле {@link #nanoTimeFinish} в случае,
     * если таймер был активирован ранее,
     * и обнуляет значение флага {@link #isCorrectStart}.
     */
    public void finishTimer(){
        if(isCorrectStart) {
            nanoTimeFinish = System.nanoTime();
            isCorrectStart=false;
        }
    }

    /**
     * Данный метод возвращает время выполнения какой-либо операции в миллисекундах,
     * обрабатывая несколько возможных случаев.
     * Если таймер был активирован и завершен, то возвращается время выполнения.
     * Если таймер был активирован, но не завершен, то возвращается время от активации таймера до текущего момента.
     * Если таймер не был активирован, возвращается 0.
     */
    public double getResultTimeMillis(){
        if(nanoTimeFinish!=0)
            return ((nanoTimeFinish - nanoTimeStart)/1_000_000.0);
        if(nanoTimeStart!=0)
            return ((System.nanoTime() - nanoTimeStart)/1_000_000.0);
        return 0.0;
    }
}
