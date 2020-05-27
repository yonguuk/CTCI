public abstract class Animal{
    private int order;
    protected String name;
    public Animal(String name){
        this.name = name;
    }
    public void setOrder(int order){
        this.order = order;
    }
    public int getOrder(int order){
        return this.order;
    }
    public boolean isOlderThan(Animal a){
        return this.order < a.order;
    }
    public String getName(){
        return name;
    }
}