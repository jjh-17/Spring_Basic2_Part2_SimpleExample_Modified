package spring_basic2.part2_SimpleExample_Modified.order;

public interface OrderService {
    Order createOrder(Long memberId, String productName, int productPrice);
}
