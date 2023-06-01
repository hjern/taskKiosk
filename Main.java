package taskKiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//        1. 메인 메뉴판 화면
//        - 메인 메뉴판이 출력되며 메뉴판에는 상품 메뉴가 출력됩니다. // 완료
//        - 상품 메뉴는 간단한 설명과 함께 출력되며 최소 3개 이상 출력됩니다. // 완료 -- quest. 글자 간격 조절 필요
//        - 상품 메뉴 아래에는 Order(주문)와 Cancel(주문취소) 옵션을 출력해줍니다. // 진행 필요
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                Order order = new Order();

                // 디저트 데이터 추가
                ArrayList<MainMenu> dessertMenu = new ArrayList<>();
                dessertMenu.add(new MainMenu("NAMU", "지바라라떼, 헤즐럿 프랄리네, 솔티캐러멜", 7.8));
                dessertMenu.add(new MainMenu("Burdock Mille-feuille", "우엉크림, 피칸 프랄리네", 7.8));
                dessertMenu.add(new MainMenu("Opal", "참외 무스, 망고 크레유, 골든 키위", 8.0));
                dessertMenu.add(new MainMenu("Cherry Blossom", "비타베리, 리치크림, 벚꽃", 10.0));

                // 칵테일 데이터 추가
                ArrayList<MainMenu> cocktailMenu = new ArrayList<>();
                cocktailMenu.add(new MainMenu("Partissier's Gimlet", "진, 라임즙", 16.0));
                cocktailMenu.add(new MainMenu("Coffee Beer", "콜드브루, 스카치 위스키", 17.0));
                cocktailMenu.add(new MainMenu("Korean melon", "참외, 딜, 핸드릭스", 18.0));
                cocktailMenu.add(new MainMenu("Old Fashioned", "버번, 캐러멜오렌지", 17.0));

                // 위스키 데이터 추가
                ArrayList<MainMenu> whiskyMenu = new ArrayList<>();
                whiskyMenu.add(new MainMenu("Balvenie 12 Years - Single Barrel -", "부드러운 질감에서 묻어나는 단향", 25.0));
                whiskyMenu.add(new MainMenu("GlenDronach 12 Years", "쉐리 캐스크를 느끼기에 아낌 없는 질감과 스파이시함", 23.0));
                whiskyMenu.add(new MainMenu("Dartigalongue XO", "부드러운 질감을 배신하는, 거친 넘김", 21.0));
                whiskyMenu.add(new MainMenu("Glengoyne 12years", "몰트에서 느낄 수 있는 가장 부드러운 향", 23.0));

                showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu);
            }

                public static void showMainMenu(Scanner sc, ArrayList<MainMenu> dessertMenu, ArrayList<MainMenu> cocktailMenu, ArrayList<MainMenu> whiskyMenu) {
                    System.out.println();
                    System.out.println("< Jae In Dessert Bar > 에 오신 것을 환영합니다.");
                    System.out.println("아래 메뉴판을 토대로 주문해주시기 바랍니다.");
                    System.out.println();
                    System.out.println("[ Jae In Menu ]");
                    System.out.println();
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
                            showDessertMenu(sc, dessertMenu);
                            break;
                        case 2:
                            showCocktailMenu(sc, cocktailMenu);
                            break;
                        case 3:
                            showWhiskyMenu(sc, whiskyMenu);
                            break;
                        case 4:
                            // Implement order functionality
                            break;
                        case 5:
                            // Implement cancel functionality
                            break;
                        default:
                            System.out.println("번호를 잘못 입력하셨습니다.");
                            showMainMenu(sc, dessertMenu, cocktailMenu, whiskyMenu);
                            break;
                    }
                }

                public static void showDessertMenu(Scanner sc, ArrayList<MainMenu> dessertMenu) {
                    System.out.println("[ Dessert Menu ]");
                    for (int i = 0; i < dessertMenu.size(); i++) {
                        MainMenu menu = dessertMenu.get(i);
                        System.out.println((i + 1) + ". " + menu.getName() + " | " + menu.getPrice() + " | " + menu.getDesc());
                    }

                    System.out.println();
                    System.out.println("메뉴 선택");
                    int orderDessert = sc.nextInt();
                    sc.nextLine();

                    // Rest of the code for ordering dessert
                }

                public static void showCocktailMenu(Scanner sc, ArrayList<MainMenu> cocktailMenu) {
                    System.out.println("[ Cocktail Menu ]");
                    for (int i = 0; i < cocktailMenu.size(); i++) {
                        MainMenu menu = cocktailMenu.get(i);
                        System.out.println((i + 1) + ". " + menu.getName() + " | " + menu.getPrice() + " | " + menu.getDesc());
                    }

                    System.out.println();
                    System.out.println("메뉴 선택");
                    int orderCocktail = sc.nextInt();
                    sc.nextLine();

                    // Rest of the code for ordering cocktail
                }

                public static void showWhiskyMenu(Scanner sc, ArrayList<MainMenu> whiskyMenu) {
                    System.out.println("[ Whisky Menu ]");
                    for (int i = 0; i < whiskyMenu.size(); i++) {
                        MainMenu menu = whiskyMenu.get(i);
                        System.out.println((i + 1) + ". " + menu.getName() + " | " + menu.getPrice() + " | " + menu.getDesc());
                    }

                    System.out.println();
                    System.out.println("메뉴 선택");
                    int orderWhisky = sc.nextInt();
                    sc.nextLine();

                    // Rest of the code for ordering whisky
                }
            }