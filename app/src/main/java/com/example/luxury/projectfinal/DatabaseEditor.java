package com.example.luxury.projectfinal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseEditor {

    // Get list of category.
    public static List<Category> getCategoryData(DatabaseCreator databaseCreator) {
        List<Category> categories = new ArrayList<>();
        SQLiteDatabase db = databaseCreator.getReadableDatabase();
        String sql = "SELECT * FROM Category";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("category_name"));
            String icon = cursor.getString(cursor.getColumnIndex("category_icon"));
            Category category = new Category(name, icon);
            categories.add(category);
        }
        return categories;
    }

    // Get list of image.
    public static List<Image> getImageData(DatabaseCreator databaseCreator, int categoryID) {
        List<Image> imageList = new ArrayList<>();
        SQLiteDatabase db = databaseCreator.getReadableDatabase();
        String sql = "SELECT * FROM Image WHERE category_id = " + categoryID;
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            int cateID = cursor.getInt(cursor.getColumnIndex("category_id"));
            String name = cursor.getString(cursor.getColumnIndex("image_name"));
            String image_url = cursor.getString(cursor.getColumnIndex("image_url"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            String audio_url = cursor.getString(cursor.getColumnIndex("audio_url"));
            Image image = new Image(id, cateID, image_url, audio_url, name, description);
            imageList.add(image);
        }
        return imageList;
    }

    public static void insertData(DatabaseCreator databaseCreator) {
        SQLiteDatabase db = databaseCreator.getWritableDatabase();

        // Category
        String categ1 = "category_name";
        String categ2 = "category_icon";
        ContentValues data_categ = new ContentValues();

        data_categ.put(categ1, "Động vật");
        data_categ.put(categ2, "http://static1.bestie.vn/Mlog/Question/201506/eee06904-ecab-4db8-b2f8-624d009a38d6.jpg");
        db.insert("Category", null, data_categ);
        data_categ.put(categ1, "Hoa quả");
        data_categ.put(categ2, "https://previews.123rf.com/images/arcady31/arcady311608/arcady31160800085/62360502-yellow-apple-icon.jpg");
        db.insert("Category", null, data_categ);
        data_categ.put(categ1, "Phương tiện");
        data_categ.put(categ2, "http://ketoan24h.com.vn/wp-content/uploads/2017/03/van-tai-duong-thuy.png");
        db.insert("Category", null, data_categ);
        data_categ.put(categ1, "Đồ dùng hàng ngày");
        data_categ.put(categ2, "http://www.hangnhatbanonline.com/upload/img/category/6492icon440x440.jpeg");
        db.insert("Category", null, data_categ);

        // Image.
        String c1 = "category_id";
        String c2 = "image_url";
        String c3 = "audio_url";
        String c4 = "image_name";
        String c5 = "english_name";
        String c6 = "description";
        ContentValues data_Image = new ContentValues();

        // Animal.
        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/145939/pexels-photo-145939.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Con hổ");
        data_Image.put(c5, "Tiger");
        data_Image.put(c6, "Hổ sống trong rừng rậm. Thường ở một mình, săn mồi vào ban đêm");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/247502/pexels-photo-247502.jpeg?auto=compress&cs=tinysrgb&h=350");
        data_Image.put(c3, "");
        data_Image.put(c4, "Sư tử");
        data_Image.put(c5, "Lion");
        data_Image.put(c6, "Sư tử thường sống ở các đồng cỏ, nơi có nhiều động vật ăn cỏ làm thức ăn cho chúng. Sư tử sống theo đàn, con đực đầu đàn có quyền lực nhất");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/97533/pexels-photo-97533.jpeg?auto=compress&cs=tinysrgb&h=350");
        data_Image.put(c3, "");
        data_Image.put(c4, "Con vẹt");
        data_Image.put(c5, "Parrot");
        data_Image.put(c6, "Vẹt là một trong những loài chim cảnh được ưa thích. Trong điều kiện tự nhiên, chúng thường làm tổ trong hốc cây, ăn hạt, trái cây, chồi là chính. Vẹt là một trong số rất ít loài chim biết bắt chước tiếng người");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/461717/pexels-photo-461717.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Con ngựa");
        data_Image.put(c5, "Horse");
        data_Image.put(c6, "Ngựa sống thành đàn trong các đồng cỏ. Chúng chạy rất nhann và khỏe nên được con người thuần hóa để giúp sức trong các công việc thường ngày.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Con mèo");
        data_Image.put(c5, "Cat");
        data_Image.put(c6, "Mèo, chính xác hơn là mèo nhà để phân biệt với các loài trong họ Mèo khác, là động vật có vú nhỏ và ăn thịt, sống chung với loài người, được nuôi để săn vật gây hại hoặc làm thú nuôi. Người ta tin rằng tổ tiên trung gian gần nhất trước khi được thuần hóa của chúng là mèo rừng châu Phi (Felis silvestris lybica). Mèo nhà đã sống gần gũi với loài người ít nhất 9.500 năm,[4] và hiện nay chúng là con vật cưng phổ biến nhất trên thế giới.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/145958/pexels-photo-145958.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Con công");
        data_Image.put(c5, "Peacock");
        data_Image.put(c6, "Công hay còn gọi cuông, nộc dung, khổng tước[2][3] (danh pháp khoa học: Pavo muticus) là một loài chim thuộc họ Trĩ được Linnaeus mô tả khoa học lần đầu năm 1766. Chim công sinh sống ở rừng nhiệt đới Đông Nam Á và phía nam Trung Quốc.[4]. Nó có mối quan hệ gần gũi với Pavo cristatus ở lục địa Ấn Độ. Công đã từng phân bố rộng rãi ở Đông Nam Á từ phía đông và đông bắc Ấn Độ, Bắc Myanma và miền nam Trung Quốc, mở rộng thông qua Lào, và Thái Lan vào Việt Nam, Campuchia, bán đảo Mã Lai và các đảo Java. Loài này được tìm thấy trong một loạt các môi trường sống bao gồm cả rừng nguyên sinh và thứ cấp, cả hai vùng nhiệt đới và cận nhiệt đới, cũng như thường xanh và rụng lá. Họ cũng có thể được tìm thấy trong các khu vực có cây tre, đồng cỏ, thảo nguyên, cây bụi và cạnh đất nông nghiệp.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/45242/wolf-torque-wolf-moon-cloud-45242.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Chó sói");
        data_Image.put(c5, "Wolf");
        data_Image.put(c6, "Sói là động vật săn mồi, thường đi săn theo đàn. Chúng có tiếng hú gọi bầy rất đáng sợ");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/225869/pexels-photo-225869.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Cá heo");
        data_Image.put(c5, "Dolphin");
        data_Image.put(c6, "Cá heo là động vật có vú sống ở đại dương và sông nước có quan hệ mật thiết với cá voi. Có gần 40 loài cá heo thuộc 17 chisinh sống ở các đại dương, số ít còn lại sinh sống tại một số con sông trên thế giới (sông Dương Tử, sông Amazon, sông Ấn, sông Hằng..). Kích thước của cá heo có thể từ 1,2 m (4 ft) và40 kg (90 lb) (Cá heo Maui), cho tới 9,5 m (30 ft) và 10 tấn (9,8 tấn Anh; 11 tấn thiếu) (Cá heo đen lớn hay Cá voi sát thủ). Cá heo có trên toàn thế giới và thường cư ngụ ở các biển nông của thềm lục địa. Cá heo là loài ăn thịt, chủ yếu là ăn cá và mực. Họ cá voi đại dương Delphinidae là họ lớn nhất trong bộ cá heo và cũng là họ xuất hiện muộn nhất: khoảng 10 triệu năm trước đây, trong thế Trung Tân. Cá heo là một trong số những động vật thông minh và được biết đến nhiều trong văn hóa loài người nhờ hình thức thân thiện và thái độ tinh nghịch.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/39857/leopard-leopard-spots-animal-wild-39857.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Con báo");
        data_Image.put(c5, "Panther");
        data_Image.put(c6, "Chi Báo (danh pháp khoa học: Panthera) là một chi trong họ Mèo (Felidae), chi này được đặt tên và được mô tả lần đầu bởi nhà tự nhiên học người Đức Oken vào năm 1816.[2] Nhà phân loại học người Anh Pocock đã xem xét lại sự phân loại của chi này vào năm 1916, theo đó chi này bao gồm loài sư tử, hổ, báo đốm Mỹ, và báo hoa mai dựa trên cơ sở các đặc điểm giải phẫu sọ.[3]. Kết quả phân tích di truyền chỉ ra rằng báo tuyết cũng thuộc về chi Panthera, một sự phân loại cũng được các nhà đánh giá IUCN chấp nhận vào năm 2008");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 1);
        data_Image.put(c2, "https://images.pexels.com/photos/53957/striped-core-butterflies-butterfly-brown-53957.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Con bướm");
        data_Image.put(c5, "Butterfly");
        data_Image.put(c6, "Bướm ngày là các loài côn trùng nhỏ, biết bay, hoạt động vào ban ngày thuộc bộ Cánh vẩy (Lepidoptera), có nhiều loại, ít màu cũng có mà sặc sỡ nhiều màu sắc cũng có. Thường chúng sống gần các bụi cây nhiều hoa để hút phấn hoa, mật hoa, góp phần trong việc giúp hoa thụ phấn. Bướm ngày nhiều khi gọi tắt là bướm, mặc dù bướm có thể chỉ đến bướm đêm (ngài).");
        db.insert("Image", null, data_Image);

        //Fruit.
        data_Image.put(c1, 2);
        data_Image.put(c2, "https://images.pexels.com/photos/708777/pexels-photo-708777.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả nho");
        data_Image.put(c5, "Grape");
        data_Image.put(c6, "Nho là một loại quả mọng lấy từ các loài cây thân leo thuộc chi Nho (Vitis). Quả nho mọc thành chùm từ 6 đến 300 quả, chúng có màu đen, lam, vàng, lục, đỏ-tía hay trắng. Khi chín, quả nho có thể ăn tươi hoặc được sấy khô để làm nho khô, cũng như được dùng để sản xuất các loại rượu vang, thạch nho, nước quả, mật nho, dầu hạt nho. Trong tiếng Trung, nó được gọi là bồ đào (葡萄) và khi người ta nói đến rượu bồ đào tức là rượu sản xuất từ quả nho.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "https://images.pexels.com/photos/39803/pexels-photo-39803.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả táo");
        data_Image.put(c5, "Apple");
        data_Image.put(c6, "Táo ta hay táo chua (danh pháp hai phần: Ziziphus mauritiana) là loại cây ăn quả của vùng nhiệt đới, thuộc về họ Táo(Rhamnaceae). Tại Trung Quốc, nó được gọi là táo chua, táo Ấn Độ hay táo Điền (táo Vân Nam), táo gai Vân Nam. Cây có thể lớn rất nhanh thậm chí trong các khu vực khô và cao tới 12 mét và đạt tuổi thọ 25 năm. Nó có nguồn gốc ở châu Á (chủ yếu là Ấn Độ) mặc dù cũng có thể tìm thấy ở châu Phi. Quả là loại quả hạch, khi chín nó mềm, chứa nhiều nước, có vị ngọt. Các quả chín vào các khoảng thời gian khác nhau ngay cả khi chỉ trên một cây và có màu lục nhạt khi còn xanh và vàng nhạt khi chín. Kích thước và hình dạng quả phụ thuộc vào các giống khác nhau trong tự nhiên cũng như loại được trồng. Quả được dùng để ăn khi đã chín hoặc ngâm rượu hay sử dụng để làm đồ uống. Nó là một loại quả giàu chất dinh dưỡng và chứa nhiều vitamin C.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "https://images.pexels.com/photos/46174/strawberries-berries-fruit-freshness-46174.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả dâu tây");
        data_Image.put(c5, "Strawberry");
        data_Image.put(c6, "Dâu tây (danh pháp khoa học: Fragaria) hay còn gọi là dâu đất là một chi thực vật hạt kín và loài thực vật có hoa thuộc họ Hoa hồng (Rosaceae) cho quả được nhiều người ưa chuộng. Dâu tây xuất xứ từ châu Mỹ và được các nhà làm vườn châu Âu cho lai tạo vào thế kỷ 18 để tạo nên giống dâu tây được trồng rộng rãi hiện nay. Loài này được (Weston) Duchesne miêu tả khoa học đầu tiên năm 1788.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "https://images.pexels.com/photos/161559/background-bitter-breakfast-bright-161559.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả cam");
        data_Image.put(c5, "Orange");
        data_Image.put(c6, "Cam (danh pháp hai phần: Citrus × sinensis) là loài cây ăn quả cùng họ với bưởi. Nó có quả nhỏ hơn quả bưởi, vỏ mỏng, khi chín thường có màu da cam, có vị ngọt hoặc hơi chua. Loài cam là một cây lai được trồng từ xưa, có thể lai giống giữa loài bưởi (Citrus maxima) và quýt (Citrus reticulata). Đây là cây nhỏ, cao đến khoảng 10 m, có cành gai và lá thường xanh dài khoảng 4-10 cm. Cam bắt nguồn từ Đông Nam Á, có thể từ Ấn Độ, Việt Nam hay miền nam Trung Quốc.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "https://images.pexels.com/photos/214158/pexels-photo-214158.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả chuối");
        data_Image.put(c5, "Banana");
        data_Image.put(c6, "Chuối là tên gọi các loài cây thuộc chi Musa; trái của nó là trái cây được ăn rộng rãi nhất. Những cây này có gốc từ vùng nhiệt đới ở Đông Nam Á và Úc. Ngày nay, nó được trồng khắp vùng nhiệt đới.[1]\n" +
                "Chuối được trồng ở ít nhất 107 quốc gia.[2] Ở nhiều vùng trên thế giới và trong thương mại, \"chuối\" là từ thường được dùng để chỉ các loại quả chuối mềm và ngọt. Những giống cây trồng có quả chắc hơn được gọi chuối lá. Cũng có thể cắt chuối mỏng, sau đó đem chiên hay nướng để ăn giống như khoai tây. Chuối khô cũng được nghiền thành bột chuối.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "https://www.capitalfm.co.ke/lifestyle/files/2014/01/mango.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả xoài");
        data_Image.put(c5, "Mango");
        data_Image.put(c6, "Xoài là một loại trái cây vị ngọt thuộc chi Xoài, bao gồm rất nhiều quả cây nhiệt đới, được trồng chủ yếu như trái cây ăn được. Phần lớn các loài được tìm thấy trong tự nhiên là các loại xoài hoang dã. Tất cả đều thuộc họ thực vật có hoa Anacardiaceae. Xoài có nguồn gốc ở Nam Á và Đông Nam Á, từ đó nó đã được phân phối trên toàn thế giới để trở thành một trong những loại trái cây được trồng hầu hết ở vùng nhiệt đới. Mật độ cao nhất của chi Xoài(Magifera) ở phía tây của Malesia (Sumatra, Java và Borneo) và ở Myanmar và Ấn Độ.[1] Trong khi loài Mangifera khác (ví dụ như xoài ngựa, M. Foetida) cũng được phát triển trên cơ sở địa phương hơn, Mangifera indica, -\"xoài thường\" hoặc \"xoài Ấn Độ\"-là cây xoài thường chỉ được trồng ở nhiều vùng nhiệt đới và cận nhiệt đới. Nó có nguồn gốc ở Ấn Độ và Myanmar.[2] Nó là hoa quả quốc gia của Ấn Độ, Pakistan, Philippines, và cây quốc gia của Bangladesh.[3] Trong một số nền văn hóa, trái cây và lá của nó được sử dụng như là nghi lễ trang trí tại các đám cưới, lễ kỷ niệm, và nghi lễ tôn giáo.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "http://kenh14cdn.com/2017/1-1499938230183-0-0-958-1600-crop-1499938981782.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả măng cụt");
        data_Image.put(c5, "Mangosteen");
        data_Image.put(c6, "Măng cụt (danh pháp hai phần: Garcinia mangostana), là một loài cây thuộc họ Bứa (Clusiaceae). Nó cũng là loại cây nhiệt đới cho quả ăn được, rất quen thuộc tại Đông Nam Á. Cây cao từ 7 đến 25 m. Quả khi chín có vỏ ngoài dày, màu đỏ tím đậm. Ruột trắng ngà và chia thành nhiều múi có vị chua ngọt thanh thanh và có mùi thơm thu hút.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "http://truyenhinhnghean.vn/dataimages/201704/original/images1357879_2017_04_18_151141.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả dứa");
        data_Image.put(c5, "Pineapple");
        data_Image.put(c6, "Dứa, thơm hay khóm (có nơi gọi là khớm) hay gai (miền Trung) hoặc trái huyền nương, tên khoa học Ananas comosus, là một loại quả nhiệt đới. Dứa là cây bản địa của Paraguay và miền nam Brasil[1].\n" +
                "Quả dứa thực ra là trục của bông hoa và các lá bắc mọng nước tụ hợp lại. Còn quả thật là các \"mắt dứa\"[2][3]. Quả dứa được ăn tươi hoặc đóng hộp dưới dạng khoanh, miếng hoặc đồ hộp nước dứa, hoặc nước quả hỗn hợp.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "https://s1.marquis.vn/assets/2018/2018-03/7eb870a7a4407d96effa815ce8fa4a75.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả dưa hấu");
        data_Image.put(c5, "Watermelon");
        data_Image.put(c6, "Dưa hấu (tên khoa học: Citrullus lanatus) là một loài thực vật trong họ Bầu bí (Cucurbitaceae), một loại trái cây có vỏ cứng, chứa nhiều nước, có nguồn gốc từ miền nam châu Phi và là loại quả phổ biến nhất trong họ Bầu bí. Dưa hấu có tính hàn có thể dùng làm thức ăn giải nhiệt trong những ngày hè nóng nực.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 2);
        data_Image.put(c2, "https://image.vtcns.com/files/ctv.congnghe/2018/07/08/thanh-long-1-0847000.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Quả thanh long");
        data_Image.put(c5, "Dragon fruit");
        data_Image.put(c6, "Thanh long một loài cây được trồng chủ yếu để lấy quả và cũng là tên của một vài chi của họ xương rồng. Thanh long là loài thực vật bản địa tại México, các nước Trung Mỹ và Nam Mỹ. Hiện nay, các loài cây này cũng được trồng ở các nước trong khu vực Đông Nam Á như Việt Nam, Malaysia, Thái Lan, Philippines, Indonesia (đặc biệt là ở miền tây đảo Java); miền nam Trung Quốc, Đài Loan và một số khu vực khác.");
        db.insert("Image", null, data_Image);

        // Giao thông.
        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/326mise.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xe đạp");
        data_Image.put(c5, "Bicycle");
        data_Image.put(c6, "Xe đạp là một phương tiện giao thông có hai bánh, dùng bàn đạp để điều khiển, gồm hai bánh xe được gắn vào cùng một khung xe, bánh này sau bánh kia. Đa số xe đạp chuyển động nhờ lực đạp của người điều khiển, và giữ thăng bằng nhờ định luật bảo toàn mômen quán tính.\n" +
                "Xe đạp đã được đưa vào sử dụng vào thế kỷ 19 ở châu Âu. Cho đến năm 2003, xe đạp có số lượng hơn một tỷ trên toàn thế giới, gấp đôi so với xe ô tô.[2] Xe đạp là phương tiện chính của giao thông ở nhiều khu vực. Xe đạp cũng là một hình thức phổ biến cho giải trí, và đã được điều chỉnh để sử dụng như đồ chơi trẻ em, thiết bị trong phòng tập thể dục, các ứng dụng trong quân đội và cảnh sát, dịch vụ chuyển phát nhanh, và đua xe đạp.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/vBYULCT.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xe máy");
        data_Image.put(c5, "Motorbike");
        data_Image.put(c6, "Xe máy (còn gọi là mô-tô hay xe hai bánh, xe gắn máy, phiên âm từ tiếng Pháp: Motocyclette) là loại xe có hai bánh theo chiều trước-sau và chuyển động nhờ động cơ gắn trên nó. Xe ổn định khi chuyển động nhờ lực hồi chuyển con quay khi chạy. Thông thường, người lái xe điều khiển xe bằng tay lái nối liền với trục bánh trước. Xe hai bánh do hai người Đức là Gottlieb Daimler và Wilhelm Maybach ở Bad Cannstatt (một địa danh thuộc Stuttgart) phát minh năm 1885.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/RGNaBT8.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xích lô");
        data_Image.put(c5, "Cyclo");
        data_Image.put(c6, "Xe xích lô (từ tiếng Pháp: cyclo) là một phương tiện giao thông sử dụng sức người, có 3 bánh dùng để vận chuyển khách hoặc hàng hóa, thường có một hoặc hai ghế cho khách và một chỗ cho người lái xe. Người lái xe cũng vận hành nó như xe đạp thường, một vài loại có mô tơ để giúp người lái đỡ tốn sức, nếu có gắn động cơ thì gọi là xích lô máy. Thông thường xích lô có ba bánh. Loại xe đạp kéo thùng chở khách đằng sau trở thành xích lô thường gọi là xe lôi, phổ biến ở miền Tây Nam Bộ. Người chạy xe xích lô thông thường đạp xe đằng sau phần chở khách; nhiều loại có người đạp xe đằng trước.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/g6txNwB.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xe tăng");
        data_Image.put(c5, "Tank");
        data_Image.put(c6, "Xe tăng, thường được gọi tắt là tăng, là loại xe chiến đấu bọc thép, có bánh xích được thiết kế cho chiến đấu tiền tuyến kết hợp hỏa lực cơ động, chiến thuật tấn công và khả năng phòng thủ. Hỏa lực này thường được cung cấp bởi 1 súng chính cỡ nòng lớn trong 1 tháp pháo quay với súng máy, trong khi có áo giáp nặng và di chuyển trên mọi địa hình nhằm cung cấp sự bảo vệ cho xe tăng và tổ lái, cho phép thực hiện tất cả các nhiệm vụ chính của xe bọc thép quân đội trên chiến trường.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/cJOzsn8.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xe tải");
        data_Image.put(c5, "Truck");
        data_Image.put(c6, "Một chiếc xe tải là một loại xe có động cơ dùng để vận chuyển hàng hóa.\n" +
                "Không giống như các loại xe hơi, thường được chế tạo với một thân duy nhất, đa số xe tải, trừ xe kiểu minivan) được thiết kế xung quanh một khung cứng (chassis). Các xe tải có nhiều kích cỡ, từ kiểu nhỏ như xe hơi gọi là xe bán tải (pickup truck) cho tới những loại xe tải dùng ở các khu mỏ (không chạy trên đường quy ước) hay các loại xe móc chạy trên đường cao tốc.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/cNiaORo.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Trực thăng");
        data_Image.put(c5, "Helicopter");
        data_Image.put(c6, "Máy bay trực thăng hay máy bay lên thẳng là một loại phương tiện bay có động cơ, hoạt động bay bằng cánh quạt, có thể cất cánh, hạ cánh thẳng đứng, có thể bay đứng trong không khí và thậm chí bay lùi. Trực thăng có rất nhiều công năng cả trong đời sống thường nhật, trong kinh tế quốc dân và trong quân sự.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xe ");
        data_Image.put(c5, "Apple");
        data_Image.put(c6, "des");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/EYICRfL.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xe ô tô");
        data_Image.put(c5, "Car");
        data_Image.put(c6, "Ô tô (phương ngữ Bắc Bộ) hay xe hơi (phương ngữ Nam Bộ) là loại phương tiện giao thông chạy bằng bốn bánh có chở theo động cơ của chính nó. Tên gọi ô-tô được nhập từ tiếng Pháp (automobile), tên tiếng Pháp xuất phát từ từ auto (tiếng Hy Lạp, nghĩa là tự thân) và từ mobilis (tiếng La Tinh, nghĩa là vận động). Từ automobile ban đầu chỉ những loại xe tự di chuyển được gồm xe không ngựa và xe có động cơ. Còn từ ô tô trong tiếng Việt chỉ dùng để chỉ các loại có 4 bánh. Chữ \"Xe Hơi\" bắt nguồn từ chữ Hoa 汽车, phát âm theo Hán Việt là Khí Xa. Còn người Nhật gọi Xe hơi là 自動車 (Tự động xa) nghĩa là Xe tự động. Các kiểu khác nhau của xe hơi gồm các loại xe, xe buýt, xe tải. Tới năm 2005 có khoảng 600 triệu xe hơi trên khắp thế giới (0,074 trên đầu người).");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/Qw47c3I.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Máy bay");
        data_Image.put(c5, "Airplane");
        data_Image.put(c6, "Máy bay, còn được gọi theo âm Hán – Việt là phi cơ (飛機) hay cách gọi dân dã là tàu bay, là phương tiện bay hiện đại, cao cấp, ngày nay đóng vai trò không thể thiếu trong kinh tế và đặc biệt trong quân sự. Máy bay dân dụng là phương tiện chuyên chở chính của ngành giao thông vận tải hàng không dân dụng, và trong quân sự, máy bay chiến đấu tạo thành quân chủng không quân. Trong quân sự và kinh tế, dân dụng máy bay có vai trò ngày càng quan trọng: trong giao thông vận tải, hàng không dân dụng, lượng hành khách và hàng hóa chuyên chở bằng máy bay chiếm tỷ trọng rất lớn và ngày càng lớn vì ưu thế nhanh chóng và an toàn của loại hình giao thông vận tải này. Máy bay là phương tiện vận tải hiện đại đòi hỏi các đảm bảo kỹ thuật rất khắt khe do các tai nạn máy bay thường gây thiệt hại rất lớn về nhân mạng và tài sản. Tuy vậy, giao thông vận tải hàng không vẫn là loại hình có độ an toàn cực cao, xác suất rủi ro cực thấp nếu so sánh với các loại hình giao thông vận tải khác. Cho đến hiện nay công nghiệp chế tạo máy bay là ngành công nghiệp mũi nhọn – công nghệ cao chỉ có các cường quốc kinh tế trên thế giới mới thực hiện được và là ngành định hướng công nghệ cho các ngành công nghiệp khác. Hiện nay quốc gia chế tạo máy bay cả dân dụng và quân dụng đứng đầu thế giới là Hoa Kỳ, sau đó đến Pháp và các nước công nghiệp hàng đầu châu Âu, Nga...");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 3);
        data_Image.put(c2, "https://i.imgur.com/Z4IW7in.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Xe đạp điện");
        data_Image.put(c5, "Electric Bicycle");
        data_Image.put(c6, "Một chiếc xe đạp điện là một chiếc xe đạp với một động cơ điện được sử dụng cho động cơ đẩy. Có rất nhiều loại xe đạp điện có sẵn trên toàn thế giới,vd như là xe đạp điện chạy bằng pin, xe đạp điện chạy bằng ắc quy,... Các xe đạp điện thường có vận tốc trung bình từ 25 đến 32 km/giờ, tùy thuộc vào luật pháp của quốc gia mà họ đang bán ra. Trong một số thị trường, chẳng hạn như Đức, xe đạp điện đang trở nên phổ biến và tham gia một số thị phần của xe đạp thông thường[1], trong khi ở những nước khác, chẳng hạn như Trung Quốc, xe đạp điện đang thay thế nhiên liệu hóa thạch của mô tô và xe gắn máy nhỏ.");
        db.insert("Image", null, data_Image);

        // Đồ dùng hằng ngày.
        data_Image.put(c1, 4);
        data_Image.put(c2, "https://3.bp.blogspot.com/-ujlwjgOn6Zw/WnLBgQCQ7-I/AAAAAAAABZQ/JxouI0FC1vkBR3laz8wiXhUoxi2CVtplQCLcBGAs/s1600/cai-choi.gif");
        data_Image.put(c3, "");
        data_Image.put(c4, "Cái chổi");
        data_Image.put(c5, "Broom");
        data_Image.put(c6, "Chổi là dụng cụ để làm sạch, vệ sinh những mặt phẳng bám bụi: nền nhà, mặt sân, mặt đường.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 4);
        data_Image.put(c2, "http://30giay.vn/upload/products/bua-dau-dep-can-go-300g-century-image1.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Cái búa");
        data_Image.put(c5, "Hammer");
        data_Image.put(c6, "Búa là dụng cụ để tạo sức va chạm cho vật khác. Búa thường được xài nhiều nhất về vấn đề đóng đinh, rèn vũ khí và đập gãy vật dụng. Búa thường được thiết kế với những mục đích riêng biệt và kích thước, công năng. Búa thường cầm vừa khít với tay, đầu búa là phần nặng nhất. Búa cơ bản được thiết kế để dùng linh hoạt với tay, nhưng cũng có những máy móc hiện đại có chức năng dùng cho vật nặng hơn.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 4);
        data_Image.put(c2, "https://cdn02.static-adayroi.com/0/2017/10/17/1508232991065_2088779.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Cái xô");
        data_Image.put(c5, "Bucket");
        data_Image.put(c6, "Xô là vật dụng không thấm nước, thường có hình nón cụt hoặc hình trụ với miệng mở và đáy phẳng thường gắn với tay cầm nửa đường tròn gọi là quai.[1][2] Dung tích thông thường là 10 lit (dm³).");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 4);
        data_Image.put(c2, "https://lh3.googleusercontent.com/-gtRXGWWPNvY/Vj1iG8rB9sI/AAAAAAAADTI/BZMVccTTwX4/s550-Ic42/mo-cai-chau.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Cái chậu");
        data_Image.put(c5, "Pot");
        data_Image.put(c6, "Cái chậu thường dùng để đựng quần áo, nước tắm.");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 4);
        data_Image.put(c2, "https://png.pngtree.com/element_origin_min_pic/16/11/07/797383ff51907b89107d862cb85e139b.jpg");
        data_Image.put(c3, "");
        data_Image.put(c4, "Cái bàn");
        data_Image.put(c5, "Table");
        data_Image.put(c6, "Bàn là một loại nội thất, với cấu tạo của nó hàm chứa một mặt phẳng nằm ngang (gọi là mặt bàn) có tác dụng dùng để nâng đỡ cho những vật dụng hay vật thể mà người dùng muốn đặt lên mặt bàn đó.\n" +
                "Việc đặt các vật dụng lên mặt bàn có thể vì lý do trang trí, làm đẹp; hoặc dùng mặt bàn làm điểm tựa nhằm thực hiện một số thao tác cần thiết (viết, vẽ,...); hay đơn giản là dùng mặt bàn làm nơi chứa đồ. Vì vậy mặt bàn luôn phải được giữ trong trạng thái cân bằng; để đơn giản hóa cấu trúc thì việc chống đỡ mặt bàn thường được thực thi bởi các cột hay các giá đỡ được gọi là \"chân bàn\".");
        db.insert("Image", null, data_Image);

        data_Image.put(c1, 4);
        data_Image.put(c2, "http://doctruyencuoi.com.vn/upload/images/truyen-cuoi-cai-ghe-2015-07-20.jpg?w=600");
        data_Image.put(c3, "");
        data_Image.put(c4, "Cái ghế");
        data_Image.put(c5, "Chair");
        data_Image.put(c6, "Ghế trong tiếng Việt chỉ một dụng cụ chuyên dùng để nâng đỡ cơ thể trong tư thế ngồi. Ghế có nhiều chủng loại và nhiều công dụng quan trọng trong cuộc sống");
        db.insert("Image", null, data_Image);

        // Video.
        String col_1 = "category_id";
        String col_2 = "video_url";
        ContentValues data_Video = new ContentValues();
        data_Video.put(col_1, 1);
        data_Video.put(col_2, "http");
        db.insert("Video", null, data_Video);

        data_Video.put(col_1, 1);
        data_Video.put(col_2, "http");
        db.insert("Video", null, data_Video);
    }
}
