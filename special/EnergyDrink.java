public class EnergyDrink extends Kaja{
   private int boost;

    public EnergyDrink(int taplalas, int ar, int boost) {
        super(taplalas, ar);
        this.boost=boost;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }
}
