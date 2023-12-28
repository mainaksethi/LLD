package models;

public class SellOrder {
    private Integer quantity;
    private Integer price;
    private String stock;
    private Long timestamp;

    public SellOrder(Integer quantity, Integer price, String stock, Long timestamp) {
        this.quantity = quantity;
        this.price = price;
        this.stock = stock;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
