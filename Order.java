package taskKiosk;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MainMenu> orderItems;

    public Order() {
        orderItems = new ArrayList<>();
    }

    public void addToOrder(MainMenu item) {
        orderItems.add(item);
    }

    public List<MainMenu> getOrderItems() {
        return orderItems;
    }

    public void printOrder() {
        System.out.println("주문 내역:");
        for (MainMenu item : orderItems) {
            System.out.println(item.getName() + " | " + item.getPrice());
        }
    }

    public void printPriceTotal() {
        System.out.println("총 주문 금액은 아래와 같습니다.");
        double priceTotal = 0;
        for (MainMenu item : orderItems) {
            priceTotal += item.getPrice();
        }
        System.out.println("총 금액: " + priceTotal);

    }

    public void printOrderWaitingNumber() {
        for (int i = 0; i < orderItems.size(); i++) {
            MainMenu item = orderItems.get(i);
            int waitingNumber = i + 1;
            System.out.println("손님 " + waitingNumber + "명이 대기중입니다.");
        }
    }


    public static void stop3Second() { // 3초 지연 후 실행 메서드
        try{
            Thread.sleep(3000);
        } catch(Exception e) {
            System.out.println(e);
        }

    }

    public void clearOrder() {orderItems.clear();}


}