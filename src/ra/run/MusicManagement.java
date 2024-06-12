package ra.run;

import ra.Controller.SearchController;
import ra.Controller.SingerController;
import ra.Controller.SongController;

import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("****************************************");
            System.out.print(" Music Management ");
            System.out.println("****************************************");
            System.out.println("1.Quản lý ca sĩ");
            System.out.println("2.Quản lý bài hát");
            System.out.println("3.Tìm kiếm bài hát");
            System.out.println("4.Thoát");
            System.out.println("========================================================");
            System.out.println("Mời bạn lựa chọn : ");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    SingerController.menuSingerManagement(sc);
                    break;
                case 2:
                    SongController.menuSongManagement(sc);
                    break;
                case 3:
                    SearchController.searchManagement(sc);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại : ");
            }
        }

    }
}
