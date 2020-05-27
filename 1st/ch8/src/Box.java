public class Box{
    public int width;
    public int height;
    public int depth;

    public Box(){}

    public Box(int width, int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public boolean canBeAbove(Box bottom){
        if(this.width <= bottom.width && this.height <= bottom.height && this.depth <= bottom.depth)
            return true;
        else
            return false;
    }
}