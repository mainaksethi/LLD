package service;

import dao.OrderRepository;
import models.BuyOrder;
import models.SellOrder;

public class StockExchangeService {

    private OrderRepository orderRepository;

    public StockExchangeService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addBuyOrder(BuyOrder buyOrder) {
        orderRepository.executeOrder(buyOrder);
    }

    public void addSellOrder(SellOrder sellOrder) {
        orderRepository.executeOrder(sellOrder);
    }

}
