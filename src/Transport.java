public interface Transport {

    void deliver();

    String getType();

    void setStatus(DeliveryStatus status);

    DeliveryStatus getStatus();

}
