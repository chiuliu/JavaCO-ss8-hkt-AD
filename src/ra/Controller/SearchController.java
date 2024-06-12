package ra.Controller;

import ra.Service.SearchService;

import java.util.Scanner;

public class SearchController {
    Scanner sc = new Scanner(System.in);

    public static void searchManagement(Scanner sc) {
        while (true) {
            System.out.print("**********************************");
            System.out.print("Welcome to the Search Management");
            System.out.println("**********************************");
            System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại .");
            System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5.Thoát");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    SearchService.searchSong(sc);
                    break;
                case 2:
                    SearchService.searchSinger(sc);
                    break;
                case 3:
                    SearchService.sortSingerByName();
                    break;
                case 4:
                    SearchService.displayTenSongsSoon();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Bạn nhập không hợp lệ, vui lòng nhập lại : ");
            }
        }
    }
}