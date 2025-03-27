package factory;

import com.sun.jdi.connect.Transport;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }

}
