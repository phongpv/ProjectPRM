package com.example.luxury.projectfinal;

import java.util.ArrayList;
import java.util.List;

public class GetData {
    public static List<Image> getDataByCategory (String category) {
        List<Image> images = new ArrayList<>();
        switch (category) {
            case "Động vật":
                images = DatabaseEditor.getImageData(MainActivity.databaseCreator, 1);
                break;
            case "Hoa quả":
                images = DatabaseEditor.getImageData(MainActivity.databaseCreator, 2);
                break;
            case "Phương tiện":
                images = DatabaseEditor.getImageData(MainActivity.databaseCreator, 3);
                break;
            case "Đồ dùng hàng ngày":
                images = DatabaseEditor.getImageData(MainActivity.databaseCreator, 4);
                break;
            default:
                break;
        }
        return images;
    }

    public static List<YoutubeVideo> getDataVideoByCategory (String category) {
        List<YoutubeVideo> videos = new ArrayList<>();
        switch (category) {
            case "Động vật":
                videos = DatabaseEditor.getVideoData(MainActivity.databaseCreator, 1);
                break;
            case "Hoa quả":
                videos = DatabaseEditor.getVideoData(MainActivity.databaseCreator, 2);
                break;
            case "Phương tiện":
                videos = DatabaseEditor.getVideoData(MainActivity.databaseCreator, 3);
                break;
            case "Đồ dùng hàng ngày":
                videos = DatabaseEditor.getVideoData(MainActivity.databaseCreator, 4);
                break;
            default:
                break;
        }
        return videos;
    }
}
