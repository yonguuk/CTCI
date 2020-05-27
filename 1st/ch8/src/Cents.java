public class Cents{

    public static final int QUARTER = 25;
    public static final int DIME = 10;
    public static final int NICKEL = 5;
    public static final int PENNY = 1;

    public int numQuarters;
    public int numDimes;
    public int numNickels;
    public int numPennies;
    
    public Cents(){
        numQuarters = 0;
        numDimes = 0;
        numNickels = 0;
        numPennies = 0;
    }

    public int getQuarters(){
        return numQuarters;
    }

    public int getDimes(){
        return numDimes;
    }

    public int getNickels(){
        return numNickels;
    }

    public int getPennies(){
        return numPennies;
    }

    public void addQuarter(){
        ++numQuarters;
    }

    public void addDime(){
        ++numDimes;
    }

    public void addNickel(){
        ++numNickels;
    }

    public void addPenny(){
        ++numPennies;
    }

    public int getTotalSum(){
        return numQuarters*QUARTER + numDimes+DIME + numNickels*NICKEL + numPennies*PENNY;
    }
}