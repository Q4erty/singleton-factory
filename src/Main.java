public class Main {
    public static void main(String[] args) {
        LogisticsManager manager = LogisticsManager.getInstance();

        Logistics roadLogistics = new RoadLogistics();
        Logistics seaLogistics = new SeaLogistics();

        Transport truck1 = roadLogistics.createTransport();
        Transport truck2 = roadLogistics.createTransport();
        Transport ship1 = seaLogistics.createTransport();

        manager.registerTransport(truck1);
        manager.registerTransport(truck2);
        manager.registerTransport(ship1);

        try {
            Thread.sleep(1000);
            manager.showDeliverySummary();

            Thread.sleep(3000);
            manager.showDeliverySummary();

            Thread.sleep(3000);
            manager.showDeliverySummary();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
