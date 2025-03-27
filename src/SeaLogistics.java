public class SeaLogistics extends Logistics {

    @Override
    public Truck createTransport() {
        return new Ship();
    }

}
