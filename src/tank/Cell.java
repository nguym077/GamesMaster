package tank;

public class Cell {

    private boolean markedFilled = false;
    private boolean markedPurge = false;
    private boolean markedCreate = false;

    public void fillCell(){
        markedFilled = true;
    }

    public void unfillCell(){
        markedFilled = false;
    }

    public boolean isEmpty(){
        return markedFilled == false;
    }

    public boolean isFilled(){
        return markedFilled;
    }

    public boolean isPurgeMarked(){
        return markedPurge;
    }

    public boolean isCreateMarked(){
        return markedCreate;
    }

    public void markPurge(){
        markedPurge = true;
    }

    public void markCreate(){
        markedCreate = true;
    }
}
