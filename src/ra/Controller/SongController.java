package ra.Controller;


import ra.Service.SongService;

import java.util.Scanner;

public class SongController {

    public static void menuSongManagement(Scanner sc) {
        while (true) {
            System.out.print("**********************************");
            System.out.print("Welcome to the Song Management");
            System.out.println("**********************************");
            System.out.println("1.Nhập số bài hát muốn thêm : ");
            System.out.println("2.Hiện thị danh sách bài hát : ");
            System.out.println("3.Sửa bài hát (theo id)");
            System.out.println("4.Xóa bài hát (theo id)");
            System.out.println("5.Quay lại");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    SongService.addSong(sc);
                    break;
                case 2:
                    SongService.listSong();
                    break;
                case 3:
                    SongService.updateSong(sc);
                    break;
                case 4:
                    SongService.deleteSong(sc);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Bạn cần nhập đúng danh mục từ 1-5, vui lòng nhập lại");
            }
        }
    }
}
