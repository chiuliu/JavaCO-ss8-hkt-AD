package ra.Service;

import ra.model.Singer;

import java.util.Scanner;

public class SingerService {
    public static Singer[] singers = new Singer[0];
    private static int id = 1;


    // Tìm kiến ca sĩ qua Id
    public static Singer findById(int id) {
        for (int i = 0; i < singers.length; i++) {
            if (singers[i].getSingerId() == id) {
                return singers[i];
            }
        }
        return null;
    }

    //******************************CRUD******************************/
    //Thêm ca sĩ
    public static void addSinger(Scanner sc) {
        System.out.println("Nhập số ca sĩ cần thêm : ");
        int number = Integer.parseInt(sc.nextLine());
        Singer[] newSingers = new Singer[singers.length + number];
        for (int i = 0; i < singers.length; i++) {
            newSingers[i] = singers[i];
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập ca sĩ " + (i + 1));
            Singer singer = new Singer();
            singer.inputData(sc);
            singer.setSingerId(id);
            newSingers[singers.length + i] = singer;
            id++;
        }
        singers = newSingers;
        System.out.println("Đã thêm thành công " + number + " ca sĩ");
    }

    //Hiển thị ds ca sĩ
    public static void showListSinger() {
        if (singers.length == 0) {
            System.err.println("Danh sách rỗng ...");
        } else {
            System.out.println("--------------Thông tin ca sĩ---------------");
            for (Singer singer : singers) {
                singer.displayData();
            }
        }
    }

    //Sửa qua Id
    public static void updateSinger(Scanner sc) {
        System.out.println("Nhập tên ca sĩ muốn sửa");
        int singerId = Integer.parseInt(sc.nextLine());
        if (findById(singerId) == null) {
            System.err.println("Không tìm thấy ca sĩ trên");
            return;
        }
        System.out.println("Danh sách thông tin ca sĩ");
        Singer editSinger = findById(singerId);
        editSinger.displayData();
        System.out.println("Nhập thông tin mới cho ca sĩ");
        editSinger.inputData(sc);
        System.out.println("Đã sửa !!!");
    }
    //Xóa theo id
    public static void deleteSinger(Scanner sc) {
        System.out.println("Nhập tên ca sĩ muốn xóa");
        int singerId = Integer.parseInt(sc.nextLine());
        if (findById(singerId) == null) {
            System.err.println("Không tìm thấy ca sĩ trên");
            return;
        }
        for(int i = 0;i<SongService.songs.length;i++) {
            if(singerId == SongService.songs[i].getSinger().getSingerId()){
                System.err.println("Ca sĩ đã có bài hát, không thể xóa");
                return;
            }
        }
        Singer[] deleteSingers = new Singer[singers.length - 1];
        int index = 0;
        for (int i = 0; i < singers.length; i++) {
            if(singers[i].getSingerId() != singerId) {
                deleteSingers[index++] = singers[i];
            }
        }
        System.out.println("Đã xóa thành công");
        singers = deleteSingers;
    }
    /*----------------------------------Validate --------------------------------------*/

    public static String validateSingerName(String singerName,Scanner sc){
       while (true){
           if(singerName.trim().isEmpty()){
               System.err.println("Tên ca sĩ không được để trống, vui lòng nhập lại ...");
               System.out.println("Nhập tên ca sĩ");
               singerName = sc.nextLine();
           }else{
               return singerName;
           }
       }
    }

    public static int validateSingerAge(int singerAge,Scanner sc){
        while (true){
            if(singerAge <= 0){
                System.err.println("Tuổi ca sĩ phải lớn hơn 0, vui lòng nhập lại");
                System.out.println("Nhập tuổi của ca sĩ : ");
                singerAge = Integer.parseInt(sc.nextLine());
            }else{
                return singerAge;
            }
        }
    }

    public static String validateSingerNationality(String singerNationality,Scanner sc){
        while (true){
            if(singerNationality.trim().isEmpty()){
                System.err.println("Quốc tịch không được để trống, vui lòng nhập lại : ");
                System.out.println(" Nhập quốc tịch cho ca sĩ : ");
                singerNationality = sc.nextLine();
            }else{
                return singerNationality;
            }
        }
    }

    public static String validateSingerGenre(String singerGenre,Scanner sc){
        while (true){
            if(singerGenre.trim().isEmpty()){
                System.err.println("Thể loại không được để trống, vui lòng nhập lại : ");
                System.out.println("Nhập thể loại : ");
                singerGenre = sc.nextLine();
            }else{
                return singerGenre;
            }
        }
    }
}
