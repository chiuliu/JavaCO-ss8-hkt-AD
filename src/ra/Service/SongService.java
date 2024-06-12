package ra.Service;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SongService {
    public static Song[] songs = new Song[0];
    public static Song findById(String id) {
        for (int i = 0; i < songs.length; i++) {
            if (songs[i].getSongId().equals(id)) {
                return songs[i];
            }
        }
        return null;
    }
    /*-----------------------------------------CRUD----------------------------------------*/
    //Thêm bài hát
    public static void addSong(Scanner sc){
        System.out.println("Nhập số lượng bài hát cần thêm :  ");
        int number = Integer.parseInt(sc.nextLine());
        Song[] newSongs = new Song[songs.length + number];
        for (int i = 0; i < songs.length; i++) {
            newSongs[i] = songs[i];
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập bài hát thứ : " + (i + 1));
            Song songNew = new Song();
            songNew.inputData(sc);
            newSongs[songs.length + i] = songNew;
        }
        songs = newSongs;
        System.out.println("Thêm thành công " + number + " bài hát");
    }
    // Danh sách bài hát
    public static void listSong(){
        if (songs.length == 0) {
            System.err.println("Danh sách rỗng : ");
        } else {
            System.out.println("--------------Danh sách ca sĩ ---------------");
            for (Song song : songs) {
                song.displayData();
            }
        }
    }
    //Sửa bài hát
    public static void updateSong(Scanner sc){
        System.out.println("Nhập id bài hát muốn sửa : ");
        String id = sc.nextLine();
        if(findById(id) == null){
            System.err.println("Không tìm thấy bài hát ...");
            return;
        }
        Song songUpdate = findById(id);
        System.out.println("Thông tin bài hất");
        songUpdate.displayData();
        System.out.println("Nhập thông tin bài hát mới : ");
        songUpdate.inputData(sc);
        System.out.println("Sửa bài hát thành công : ");
    }
    // Xóa bài hát
    public static void deleteSong(Scanner sc){
        System.out.println("Nhập id bài hát muốn xóa ");
        String id = sc.nextLine();
        if(findById(id) == null){
            System.err.println("Không tìm thấy bài hát ...");
            return;
        }
        int index = 0;
        Song[] song = new Song[songs.length - 1];
        for (int i = 0; i < songs.length; i++) {
            if(!songs[i].getSongId().equals(id)){
                song[index++] = songs[i];
            }
        }
        songs = song;
        System.out.println("Xóa bài hát thành công");
    }
    /*---------------------------------------------VALIDATE ------------------------------------*/
    // songId–mãbàihát –String(Có4kýtựvàbắtđầubằngkítựS,khôngtrùnglặp)
    public static String validateSongId(String id,Scanner sc){
        String songidRegex = "S\\w{3}";
        while (true){
            if(Pattern.matches(songidRegex,id)){
                if(findById(id) == null){
                    return id;
                }
                else {
                    System.err.println("Id đã có, vui lòng nhập lại");
                }
            }else{
                System.err.println("Mã bài hát bắt đầu bằng kí tự S và gồm 4 ký tự : ");
            }
            System.out.println("Nhập mã bài hát : ");
             id = sc.nextLine();
        }
    }

    // songName – tên bài hát – String (Không được để trống)
    public static String validateSongName(String songName,Scanner sc){
        while (true){
            if(songName.trim().isEmpty()){
                System.err.println("Tên bài hát không được để trống , nhập lại :");
                System.out.println("Nhập tên bài hát");
                songName = sc.nextLine();
            }else{
                return songName;
            }
        }

    // songWriter - người sáng tác- String (không được để trống)
    }
    public static String validateSongWriter(String songWriter, Scanner sc){
        while (true){
            if(songWriter.isEmpty()){
                System.err.println("Người sáng tác không được để trống , nhập lại :");
                System.out.println("Nhập người sáng tác : ");
                songWriter = sc.nextLine();
            }else{
                return songWriter;
            }
        }
    }

    // singer - ca sĩ - Singer (không được null)
    public static Singer validateSingerId(int singerId, Scanner sc){
        while(true){
            if(SingerService.findById(singerId) == null){
                System.err.println("Không tìm thấy ca sĩ theo Id : " + singerId);
                System.out.println("Input Singer ");
                singerId = Integer.parseInt(sc.nextLine());
            }else{
                return SingerService.findById(singerId);
            }
        }
    }
    // descriptions – mô tả bài hát – String
    public static String validateDescription(String description, Scanner sc){
        while (true){
            if(description.isEmpty()){
                System.err.println("Mô tả bài hát không được để trống , nhập lại :");
                System.out.println("Nhập mô tả bài hát : ");
                description = sc.nextLine();
            }else{
                return description;
            }
        }
    }

}
