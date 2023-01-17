public class Gold implements Valuable {
    @Override
    public int returnValue() {
        int price_per_lbs =1616;
        return price_per_lbs;
    }

    @Override
    public String toString() {
        return "Gold";
    }
}
