package taskKiosk;

public class MainMenu extends MenuItem {

    // 메뉴의 종류, 종류별 설명, 종류별 가격
    // 메뉴 이름과 설명은 MenuItem 에서 상속 받아야 함
    double price;

    public MainMenu(String name, String desc, double price){
        super(name, desc); // 상속 받아온 조상의 생성자 호출
        this.price = price;
    }

    public double getPrice() {return price;}


}
