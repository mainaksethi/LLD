package models;

public class BuyOrder {

    private Long timestamp;
    private Integer quantity;
    private Integer price;
    private String stock;

    public BuyOrder(Long timestamp, Integer quantity, Integer price, String stock) {
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.price = price;
        this.stock = stock;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
