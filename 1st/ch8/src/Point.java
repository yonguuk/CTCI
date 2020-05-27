public class Point{
    int row;
    int col;

    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public void setRow(int n){
        row = n;
    }

    public void setCol(int n){
        col = n;
    }

    @Override
    public int hashCode() {
        return (row+ " " + col).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Point a = (Point)obj;
        if(this.row == a.row && this.col == a.col)
            return true;
        else
            return false;
    }
}