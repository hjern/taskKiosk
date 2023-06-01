package task;

import taskKiosk.MainMenu;
import taskKiosk.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//        1. 메인 메뉴판 화면
//        - 메인 메뉴판이 출력되며 메뉴판에는 상품 메뉴가 출력됩니다. // 완료
//        - 상품 메뉴는 간단한 설명과 함께 출력되며 최소 3개 이상 출력됩니다. // 완료 -- quest. 글자 간격 조절 필요
//        - 상품 메뉴 아래에는 Order(주문)와 Cancel(주문취소) 옵션을 출력해줍니다. // 완료
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                Order order = new Order();

                // Create dessert menu: ArrayList<MainMenu> dessertMenu = new ArrayList<>();
                ArrayList<MainMenu> dessertMenu = createDessertMenu();
                // Create cocktail menu: ArrayList<MainMenu> cocktailMenu = new ArrayList<>();
                ArrayList<MainMenu> cocktailMenu = createCocktailMenu();
                // Create whisky menu: ArrayList<MainMenu> whiskyMenu = new ArrayList<>();
                ArrayList<MainMenu> whiskyMenu = createWhiskyMenu();

                showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
            }

            public static void showMainMenu(Scanner sc, ArrayList<MainMenu> dessertMenu, ArrayList<MainMenu> cocktailMenu, ArrayList<MainMenu> whiskyMenu, Order order) {
                System.out.println();
                System.out.println("< Jae In Dessert Bar > 에 오신 것을 환영합니다.");
                System.out.println("아래 메뉴판을 토대로 주문해주시기 바랍니다.");
                System.out.println();
                System.out.println("[ Jae In Menu ]");
                System.out.println("1. Dessert          | 형언할 수 없는, 그럼에도 단아한 달콤한");
                System.out.println("2. Cocktail         | 사로잡아내는, 그러므로 사로잡히는");
                System.out.println("3. Whisky           | 숨 막히도록 고혹적인, 그러므로 위험한");
                System.out.println();
                System.out.println("[ Order Menu ]");
                System.out.println("4. Order            | 장바구니를 확인하고 주문합니다.");
                System.out.println("5. Cancel           | 진행 중인 주문을 취소합니다.");
                System.out.println();

                System.out.println("메뉴 선택");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        showDessertMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                        break;
                    case 2:
                        showCocktailMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                        break;
                    case 3:
                        showWhiskyMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                        break;
                    case 4:
                        if (order.getOrderItems().isEmpty()) {
                            System.out.println();
                            System.out.println("장바구니가 비어 있습니다. 주문할 상품을 선택해주세요.");
                            System.out.println("3초 후 메뉴판으로 이동합니다. 감사합니다.");
                            Order.stop3Second(); // 3초 후에 돌아가는 인터페이스
                            showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                        } else {
//              4. 주문 화면
//              - `5.Order` 입력시 장바구니 목록을 출력해줍니다. // 완료
//              - 장바구니에서는 추가된 메뉴들과 총 가격의 합을 출력해줍니다. // 완료
//              - `1.주문` 입력시 주문완료 화면으로 넘어가고, `2.메뉴판` 입력시 다시 메인메뉴로 돌아옵니다. // 완료
                            System.out.println();
                            System.out.println("아래와 같이 주문하시겠습니까? 주문 내역을 확인해주세요.");
                            System.out.println("[ Order ]");
                            order.printOrder();
                            System.out.println();
                            System.out.println("[ Total ]");
                            order.printPriceTotal();
                            System.out.println();
                            System.out.println("주문에 이상이 없다면 주문을 선택해 주세요.");
                            System.out.println("1. 주문           | 2. 메뉴판");
                            System.out.println();
                            System.out.println("입력");
                            int orderConfirmation = sc.nextInt();
                            sc.nextLine();

                            if(orderConfirmation == 1){
//                          5. 주문완료 화면
//                          - `1.주문` 입력시 대기번호를 발급해줍니다. // 구현 필요
//                          - 장바구니는 초기화되고 3초 후에 메인 메뉴판으로 돌아갑니다. // 완료

                                System.out.println("주문이 완료되었습니다.");
                                System.out.println("고객님의 대기 순번은 [ 1번 ]입니다.");
                                System.out.println("3초 후 메뉴판으로 이동합니다. 감사합니다.");
                                order.clearOrder();
                                Order.stop3Second(); // 3초 후에 돌아가는 인터페이스
                                showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);

                            } else {
                                showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                            }
                        }
                        break;
                    case 5:
                        if (order.getOrderItems().isEmpty()) {
                            System.out.println();
                            System.out.println("장바구니가 비어 있어 취소할 주문이 없습니다.");
                            System.out.println("3초 후 메뉴판으로 이동합니다. 감사합니다.");
                            Order.stop3Second(); // 3초 후에 돌아가는 인터페이스
                            showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                        } else {
                            System.out.println();
                            System.out.println("진행하던 주문을 취소하고, 새로 주문하시겠습니까?");
                            System.out.println("1. 확인           | 2. 취소");
                            System.out.println();
                            System.out.println("입력");
                            int cancelConfirmation = sc.nextInt();
                            sc.nextLine();

                            if(cancelConfirmation==1){
                                System.out.println();
                                System.out.println("모든 주문을 취소하였으며 3초 후 메뉴판으로 이동합니다. 감사합니다.");
                                order.clearOrder();
                                Order.stop3Second(); // 3초 후에 돌아가는 인터페이스
                                showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                            } else {
                                System.out.println();
                                System.out.println("주문이 유지됩니다. 3초 후 메뉴판으로 이동합니다.");
                                Order.stop3Second(); // 3초 후에 돌아가는 인터페이스
                                showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                            }
                        }
                        break;
                    default:
                        System.out.println("번호를 잘못 입력하셨습니다.");
                        showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                        break;
                }
            }

//        2. 상품 메뉴판 화면
//        - 상품 메뉴 선택시 해당 카테고리의 메뉴판이 출력됩니다.
//        - 메뉴판에는 각 메뉴의 이름과 가격과 간단한 설명이 표시됩니다.
            public static void showDessertMenu(Scanner sc, ArrayList<MainMenu> dessertMenu, ArrayList<MainMenu> cocktailMenu, ArrayList<MainMenu> whiskyMenu, Order order) {
                System.out.println();
                System.out.println("< Jae In Dessert Bar > 에 오신 것을 환영합니다.");
                System.out.println("아래 메뉴판을 토대로 주문해주시기 바랍니다.");
                System.out.println();
                System.out.println("[ Dessert Menu ]");
                for (int i = 0; i < dessertMenu.size(); i++) {
                    MainMenu menu = dessertMenu.get(i);
                    System.out.println((i + 1) + ". " + menu.getName() + " | " + menu.getPrice() + " | " + menu.getDesc());
                }
                System.out.println();

                System.out.println("메뉴 선택");
                int orderDessert = sc.nextInt();
                sc.nextLine();

                if (orderDessert >= 1 && orderDessert <= dessertMenu.size()) {
                    MainMenu selectedDessert = dessertMenu.get(orderDessert - 1);
                    System.out.println();
                    System.out.println((orderDessert) + ". " + selectedDessert.getName() + " | " + selectedDessert.getPrice() + " | " + selectedDessert.getDesc());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println();
                    System.out.println("1. 확인           | 2. 취소");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    if (choice == 1) {
                        order.addToOrder(selectedDessert);
                        System.out.println();
                        System.out.println("메뉴를 주문해주셔서 감사합니다.");
                    } else if (choice == 2) {
                        System.out.println("주문을 취소하며, 메뉴판으로 돌아갑니다.");
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    }
                } else {
                    System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
                }

                showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
            }

                public static void showCocktailMenu(Scanner sc, ArrayList<MainMenu> dessertMenu, ArrayList<MainMenu> cocktailMenu, ArrayList<MainMenu> whiskyMenu, Order order) {
                    System.out.println();
                    System.out.println("< Jae In Dessert Bar > 에 오신 것을 환영합니다.");
                    System.out.println("아래 메뉴판을 토대로 주문해주시기 바랍니다.");
                    System.out.println();
                    System.out.println("[ Cocktail Menu ]");
                    for (int i = 0; i < cocktailMenu.size(); i++) {
                        MainMenu menu = cocktailMenu.get(i);
                        System.out.println((i + 1) + ". " + menu.getName() + " | " + menu.getPrice() + " | " + menu.getDesc());
                    }
                    System.out.println();

                    System.out.println("메뉴 선택");
                    int orderCocktail = sc.nextInt();
                    sc.nextLine();

                    if (orderCocktail >= 1 && orderCocktail <= cocktailMenu.size()) {
                        MainMenu selectedCocktail = cocktailMenu.get(orderCocktail - 1);
                        System.out.println();
                        System.out.println((orderCocktail) + ". " + selectedCocktail.getName() + " | " + selectedCocktail.getPrice() + " | " + selectedCocktail.getDesc());
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println();
                        System.out.println("1. 확인           | 2. 취소");

                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 1) {
                            order.addToOrder(selectedCocktail);
                            System.out.println();
                            System.out.println("메뉴를 주문해주셔서 감사합니다.");
                        } else if (choice == 2) {
                            System.out.println("주문을 취소하며, 메뉴판으로 돌아갑니다.");
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                        }
                    } else {
                        System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
                    }

                    showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                }

                public static void showWhiskyMenu(Scanner sc, ArrayList<MainMenu> dessertMenu, ArrayList<MainMenu> cocktailMenu, ArrayList<MainMenu> whiskyMenu, Order order) {
                    System.out.println();
                    System.out.println("< Jae In Dessert Bar > 에 오신 것을 환영합니다.");
                    System.out.println("아래 메뉴판을 토대로 주문해주시기 바랍니다.");
                    System.out.println();
                    System.out.println("[ Whisky Menu ]");
                    for (int i = 0; i < whiskyMenu.size(); i++) {
                        MainMenu menu = whiskyMenu.get(i);
                        System.out.println((i + 1) + ". " + menu.getName() + " | " + menu.getPrice() + " | " + menu.getDesc());
                    }
                    System.out.println();

                    System.out.println("메뉴 선택");
                    int orderWhisky = sc.nextInt();
                    sc.nextLine();

                    if (orderWhisky >= 1 && orderWhisky <= whiskyMenu.size()) {
                        MainMenu selectedWhisky = whiskyMenu.get(orderWhisky - 1);
                        System.out.println();
                        System.out.println((orderWhisky) + ". " + selectedWhisky.getName() + " | " + selectedWhisky.getPrice() + " | " + selectedWhisky.getDesc());
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println();
                        System.out.println("1. 확인           | 2. 취소");

                        int choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 1) {
                            order.addToOrder(selectedWhisky);
                            System.out.println();
                            System.out.println("메뉴를 주문해주셔서 감사합니다.");
                        } else if (choice == 2) {
                            System.out.println("주문을 취소하며, 메뉴판으로 돌아갑니다.");
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                        }
                    } else {
                        System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
                    }

                    showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu, order);
                }

                private static ArrayList<MainMenu> createDessertMenu() {
                    ArrayList<MainMenu> dessertMenu = new ArrayList<>();
                    dessertMenu.add(new MainMenu("NAMU", "지바라라떼, 헤즐럿 프랄리네, 솔티캐러멜", 7.8));
                    dessertMenu.add(new MainMenu("Burdock Mille-feuille", "우엉크림, 피칸 프랄리네", 7.8));
                    dessertMenu.add(new MainMenu("Opal", "참외 무스, 망고 크레유, 골든 키위", 8.0));
                    dessertMenu.add(new MainMenu("Cherry Blossom", "비타베리, 리치크림, 벚꽃", 10.0));
                    return dessertMenu;
                }
                private static ArrayList<MainMenu> createCocktailMenu() {
                    ArrayList<MainMenu> cocktailMenu = new ArrayList<>();
                    cocktailMenu.add(new MainMenu("Partissier's Gimlet", "진, 라임즙", 16.0));
                    cocktailMenu.add(new MainMenu("Coffee Beer", "콜드브루, 스카치 위스키", 17.0));
                    cocktailMenu.add(new MainMenu("Korean melon", "참외, 딜, 핸드릭스", 18.0));
                    cocktailMenu.add(new MainMenu("Old Fashioned", "버번, 캐러멜오렌지", 17.0));
                    return cocktailMenu;
                }
                private static ArrayList<MainMenu> createWhiskyMenu() {
                    ArrayList<MainMenu> whiskyMenu = new ArrayList<>();
                    whiskyMenu.add(new MainMenu("Balvenie 12 Years - Single Barrel -", "부드러운 질감에서 묻어나는 단향", 25.0));
                    whiskyMenu.add(new MainMenu("GlenDronach 12 Years", "쉐리 캐스크를 느끼기에 아낌 없는 질감과 스파이시함", 23.0));
                    whiskyMenu.add(new MainMenu("Dartigalongue XO", "부드러운 질감을 배신하는, 거친 넘김", 21.0));
                    whiskyMenu.add(new MainMenu("Glengoyne 12years", "몰트에서 느낄 수 있는 가장 부드러운 향", 23.0));
                    return whiskyMenu;
                }
            }