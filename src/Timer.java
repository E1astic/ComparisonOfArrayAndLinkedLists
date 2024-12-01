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
    public void startTimer(){
        nanoTimeStart=System.nanoTime();
        isCorrectStart=true;
        nanoTimeFinish=0;
    }
    public void finishTimer(){
        if(isCorrectStart) {
            nanoTimeFinish = System.nanoTime();
            isCorrectStart=false;
        }
    }
    public double getResultTimeMillis(){
        if(nanoTimeFinish!=0)
            return ((nanoTimeFinish - nanoTimeStart)/1_000_000.0);
        if(nanoTimeStart!=0)
            return ((System.nanoTime() - nanoTimeStart)/1_000_000.0);
        return 0;
    }
}
