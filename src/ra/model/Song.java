package ra.model;

import ra.Service.SingerService;
import ra.Service.SongService;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId,songName,descriptions,songWriter;
    private boolean songStatus;
    private Date createdDate;
    private Singer singer;

    // Constructor
        // K tham số

    public Song() {
    }
       // Đủ tham số

    public Song(String songId, String songName, String descriptions, String songWriter, boolean songStatus, Date createdDate, Singer singer) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.songWriter = songWriter;
        this.songStatus = songStatus;
        this.createdDate = createdDate;
        this.singer = singer;
    }

    // Getter/Setter

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    // InputData()


    public void inputData(Scanner sc){
        if(SingerService.singers.length == 0){
            System.err.println("Chưa có ca sĩ nào, vui lòng nhập ca sĩ trước.");
            return;
        }
        System.out.println("Nhập mã bài hát : ");
        this.songId = SongService.validateSongId(sc.nextLine(),sc);
        System.out.println("Nhập tên bài hát : ");
        this.songName = SongService.validateSongName(sc.nextLine(),sc) ;
        System.out.println("Mô tả bài hát : ");
        this.descriptions = SongService.validateDescription(sc.nextLine(),sc);
        System.out.println("Nhập người sáng tác : ");
        this.songWriter = SongService.validateSongWriter(sc.nextLine(),sc);
        this.createdDate = new Date();
        System.out.println("Nhập trạng thái : ");
        this.songStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Chọn ca sĩ : ");
        for(Singer s: SingerService.singers){
            System.out.println(s);
        }
        System.out.println("Mời bạn nhập Ca sĩ : ");
        int singerId = Integer.parseInt(sc.nextLine());
        this.singer = SongService.validateSingerId(singerId,sc);

      // DisplayData()

    }
    public void displayData(){
        System.out.printf("ID : %3s | Name: %15s | Descriptons: %15s | SongWriter %10s | Singer: %15s | Created: %15s | Status %3s\n",
                this.songId,this.songName,this.descriptions,this.songWriter,this.singer.getSingerName(),this.createdDate,this.songStatus?"Active":"inActive");
    }
}
