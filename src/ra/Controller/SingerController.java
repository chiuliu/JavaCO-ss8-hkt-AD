package ra.Controller;

import ra.Service.SingerService;
import ra.model.Singer;

import java.util.Scanner;

public class SingerController {
    Scanner sc = new Scanner(System.in);

    public static void menuSingerManagement(Scanner sc) {
        while (true) {
            System.out.print("**********************************");
            System.out.print(" Welcome to the Singer Management ");
            System.out.println("**********************************");
            System.out.println("1.Nhập số ca sĩ bạn muốn thêm ");
            System.out.println("2.Hiển thị danh sách ca sĩ ");
            System.out.println("3.Sửa thông tin ca sĩ");
            System.out.println("4.Xóa thông tin ca sĩ (theo Id)");
            System.out.println("5.Quay lại ");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    SingerService.addSinger(sc);
                    break;
                case 2:
                    SingerService.showListSinger();
                    break;
                case 3:
                    SingerService.updateSinger(sc);
                    break;
                case 4:
                    SingerService.deleteSinger(sc);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Bạn cần nhập đúng mục!!!");
            }
        }
    }
}
