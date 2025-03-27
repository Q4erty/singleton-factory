public class RoadLogistics extends Logistics {

    @Override
    public Truck createTransport() {
        return new Truck();
    }

}
