public class Silver implements Valuable {
    @Override
    public int returnValue() {
        int price_per_ounce = 16;
        return price_per_ounce;
    }

    @Override
    public String toString() {
        return "Silver";
    }
}
