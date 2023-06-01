package taskKiosk;

public class MenuItem {
    private String name;
    private String desc;

    // 생성자 메서드
    public MenuItem(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    // getters, setters
    public String getName(){return name;}
    public String getDesc(){return desc;}

}
