public class Ship implements Transport {

    private DeliveryStatus status = DeliveryStatus.IN_PROGRESS;

    @Override
    public void deliver() {
        try {
            System.out.println(getType() + " started delivering");
            Thread.sleep(4000);
            setStatus(DeliveryStatus.COMPLETED);
            System.out.println(getType() + " finalized the delivery");
        } catch (InterruptedException e) {
            setStatus(DeliveryStatus.CANCELLED);
            System.out.println(getType() + " delivery canceled");
        }
    }

    @Override
    public String getType() {
        return "Ship";
    }

    @Override
    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    @Override
    public DeliveryStatus getStatus() {
        return status;
    }

}
