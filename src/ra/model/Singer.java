package ra.model;

import ra.Service.SingerService;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private int age;
    private String singerName,nationality,genre;
    private boolean gender;

    // Constructor
        // k tham số
    public Singer() {
    }
       // đủ tham số
    public Singer(int singerId, int age, String singerName, String nationality, String genre, boolean gender) {
        this.singerId = singerId;
        this.age = age;
        this.singerName = singerName;
        this.nationality = nationality;
        this.genre = genre;
        this.gender = gender;
    }

    // Getter/Setter

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public void inputData(Scanner sc){
        System.out.println("Nhập tên ca sĩ : ");
        this.singerName = SingerService.validateSingerName(sc.nextLine(),sc);
        System.out.println("Nhập tuổi ca sĩ :");
        this.age = SingerService.validateSingerAge(Integer.parseInt(sc.nextLine()),sc);
        System.out.println("Nhập quốc tịch : ");
        this.nationality = SingerService.validateSingerNationality(sc.nextLine(),sc);
        System.out.println("Nhập giới tính : ");
        this.gender = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Nhập thể loại : ");
        this.genre = SingerService.validateSingerGenre(sc.nextLine(),sc);
    }
    public void displayData(){
        System.out.printf("ID : %3s | Name: %15s | Age: %3s | Genre %15s | Sex: %5s | Nationality: %15s \n",
                this.singerId,this.singerName,this.age,this.genre,this.gender?"Male":"Female",this.nationality);
    }
    public String toString(){
        return String.format("ID : %3s | Name: %15s\n",this.singerId,this.singerName);
    }
}
