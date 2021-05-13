package com.example.lab_05_recycleview_horizontalvertical;

import java.util.ArrayList;
import java.util.List;

public class DataList {

    private static List<Device> devices = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();

    private static DataList instance;

    private  DataList(){

        devices.add(new Device(1, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp1 ));
        devices.add(new Device(2, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp2 ));
        devices.add(new Device(3, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp3 ));
        devices.add(new Device(4, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp5 ));

        books.add(new Book(5, "You can you will", R.drawable.you_can_you_will1));
        books.add(new Book(6, "Sức mạnh phi thường", R.drawable.suc_manh_phi_thuong1));
        books.add(new Book(7, "Du lịch kiếm tiền", R.drawable.vua_kiem_tien_vua_du_lich1));
        books.add(new Book(8, "Hường nội", R.drawable.huong_noi1));
        books.add(new Book(9, "Lượng giác", R.drawable.luong_giac1));
        books.add(new Book(10, "Start up", R.drawable.tim_kiem_cai_toi1));
    }

    public static List<Device> getDevices(){

        if(instance == null)
            instance = new DataList();

        return devices;
    }

    public static List<Book> getBooks(){

        if(instance == null)
            instance = new DataList();

        return books;
    }

}
