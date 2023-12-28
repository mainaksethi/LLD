package dao;

import models.BuyOrder;
import models.SellOrder;
import service.UiManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class OrderRepository {

    PriorityQueue<SellOrder> sellOrderPriorityQueue = new PriorityQueue<>(new Comparator<SellOrder>() {

        @Override
        public int compare(SellOrder o1, SellOrder o2) {
            if (o1.getPrice() == o2.getPrice()) {
                return o1.getQuantity() - o2.getQuantity();
            }
            return o1.getPrice() - o2.getPrice();
        }
    });

    PriorityQueue<BuyOrder> buyOrderPriorityQueue = new PriorityQueue<>(new Comparator<BuyOrder>() {

        @Override
        public int compare(BuyOrder o1, BuyOrder o2) {
            if (o1.getPrice() == o2.getPrice()) {
                return o2.getQuantity() - o1.getQuantity();
            }
            return o2.getPrice() - o1.getPrice();
        }
    });

    public void executeOrder(SellOrder sellOrder) {
        List<BuyOrder> buyOrderList = new ArrayList<>();
        if (sellOrderPriorityQueue.isEmpty()) {
            return;
        }

        BuyOrder buyOrder = buyOrderPriorityQueue.peek();

        while(buyOrder.getPrice() < sellOrder.getPrice()) {
            buyOrderList.add(buyOrder);
            buyOrderPriorityQueue.poll();
            if (buyOrderPriorityQueue.isEmpty()) {
                break;
            }
            buyOrder = buyOrderPriorityQueue.peek();
        }

        buyOrderList.sort(new Comparator<BuyOrder>() {
            @Override
            public int compare(BuyOrder o1, BuyOrder o2) {
                if(o1.getTimestamp() < o2.getTimestamp()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        int leftOverQuantity = sellOrder.getQuantity();

        for (BuyOrder b: buyOrderList) {
            if (leftOverQuantity > b.getQuantity()) {
                UiManager.printOrder(b.getStock(), b.getPrice(), sellOrder.getPrice());
                leftOverQuantity -= b.getQuantity();
                b.setQuantity(-1);
            } else {
                UiManager.printOrder(b.getStock(), b.getPrice(), sellOrder.getPrice());
                b.setQuantity(leftOverQuantity);
                leftOverQuantity = 0;
            }
        }

        for(BuyOrder b: buyOrderList) {
            if (b.getQuantity() != -1) {
                buyOrderPriorityQueue.add(b);
            }
        }

        if (leftOverQuantity > 0 ) {
            sellOrder.setQuantity(leftOverQuantity);
            sellOrderPriorityQueue.add(sellOrder);
        }
    }

    public void executeOrder(BuyOrder s1) {
        // Similar to buy order
    }

}
