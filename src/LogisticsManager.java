import java.util.ArrayList;
import java.util.List;

public class LogisticsManager {

    private static volatile LogisticsManager instance;
    private final List<Transport> activeTransports = new ArrayList<>();

    private LogisticsManager() {
    }

    public static LogisticsManager getInstance() {
        if (instance == null) {
            synchronized (LogisticsManager.class) {
                if (instance == null) {
                    instance = new LogisticsManager();
                }
            }
        }
        return instance;
    }

    public void registerTransport(Transport transport) {
        activeTransports.add(transport);
        new Thread(() -> {
            transport.deliver();
            updateDeliveryStatus(transport, transport.getStatus());
        }).start();
    }

    public void updateDeliveryStatus(Transport transport, DeliveryStatus status) {
        transport.setStatus(status);
    }

    public void showDeliverySummary() {
        System.out.println("\nInfo about delivers:");
        for (Transport t : activeTransports) {
            System.out.println(t.getType() + " - " + t.getStatus());
        }
        System.out.println("===========================\n");
    }

}
