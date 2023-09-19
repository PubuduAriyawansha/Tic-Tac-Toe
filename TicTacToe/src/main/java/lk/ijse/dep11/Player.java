package lk.ijse.dep11;

public class Player {
    char mark;
    static Board board;

    public Player(char mark) {
        this.mark = mark;
    }

    public void play(int x, int y){
        board.set(x,y,mark);
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
}
