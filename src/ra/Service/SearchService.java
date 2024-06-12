package ra.Service;

import ra.model.Singer;

import java.util.Scanner;

public class SearchService {


    /*===============Tìm kiếm bài hát===================*/
    public static void searchSong(Scanner sc){
        if(SongService.songs.length == 0){
            System.err.println("Danh sách bài hát rỗng, vui lòng nhập lại");
            return;
        }
        if(SingerService.singers.length == 0){
            System.err.println("Danh sách ca sĩ rỗng, vui lòng nhập lại");
            return;
        }
        System.out.println("Nhập bài hát hoặc thể loại : ");
        String search = sc.nextLine();
        int count = 0;
        for(int i = 0; i< SongService.songs.length;i++){
            if(SongService.songs[i].getSinger().getSingerName().contains(search) || SongService.songs[i].getSinger().getGenre().contains(search)){
                    SongService.songs[i].displayData();
                    count++;
            }
        }
        if(count == 0){
            System.err.println("Không tìm thấy bài hát trên");
        }else {
            System.out.println("Tìm thấy " + count + " bài hát");
        }
    }


    /*===============Tìm kiếm ca sĩ ===================*/
    public static void searchSinger(Scanner sc){
        if(SongService.songs.length == 0){
            System.err.println("Danh sách bài hát rỗng , bạn cần nhập bài hát trước");
            return;
        }
        if(SingerService.singers.length == 0){
            System.err.println("Danh sách ca sĩ rỗng, vui lòng thêm trước");
            return;
        }
        System.out.println("Nhập tên ca sĩ hoặc thể loại : ");
        String search = sc.nextLine();
        int count = 0;
        for (int i = 0; i < SingerService.singers.length;i++){
            if(SingerService.singers[i].getSingerName().contains(search) || SingerService.singers[i].getGenre().contains(search)){
                SingerService.singers[i].displayData();
                count++;
            }
        }
        if(count == 0){
            System.err.println("Không tìm thấy ca sĩ trên");
        }else{
            System.out.println("Đã tìm thấy " + count + " ca sĩ");
        }
    }


    /*===============Sắp xếp===================*/
    public static void sortSingerByName(){
        for(int i = 0; i < SingerService.singers.length;i++){
            for(int j = i+1; j < SingerService.singers.length;j++){
                if(SingerService.singers[i].getSingerName().compareTo(SingerService.singers[j].getSingerName())>0){
                    Singer temp = SingerService.singers[i];
                    SingerService.singers[i] = SingerService.singers[j];
                    SingerService.singers[j] = temp;
                }
            }
        }
    }

    /*=================Hiển thị 10 bài hát được đăng mới nhất===================*/
    public static void displayTenSongsSoon(){
        if(SongService.songs.length < 10){
            System.err.println(" Danh sách bài hát tối thiểu là 10 ");
            return;
        }
        int count = 0;
        for(int i = SongService.songs.length-1; count <= 10 ;i--){
            SongService.songs[i].displayData();
            count++;
        }
    }
}
