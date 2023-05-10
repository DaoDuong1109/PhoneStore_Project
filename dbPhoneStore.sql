-- create database phone_store;
-- use phone_store;
 

CREATE TABLE `category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(100) DEFAULT NULL,
  `image` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO `category` VALUES (1,'iPhone','Apple.jpg'),(2,'SAMSUNG','Samsung.jpg'),(3,'OPPO','Oppo.jpg'),(4,'NOKIA','Nokia.jpg'),(6,'XIAOMI','Xiaomi.jpg'),(7,'REALME','Realme.jpg'),(8,'huawei','Realme.jpg'),(18,'REAL','Realme.jpg');

CREATE TABLE `color` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `color` VALUES (1,'Đen'),(2,'Đỏ'),(3,'Trắng'),(4,'Vàng'),(5,'Xanh');


CREATE TABLE `comment` (
  `ID` int(11) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `detail` varchar(266) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `product_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `galery` (
  `ID` int(11) NOT NULL,
  `image` varchar(266) NOT NULL,
  `product_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `order` (
  `ID` int(11) NOT NULL,
  `address` varchar(266) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(266) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `status` bit(5) DEFAULT NULL,
  `user_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `order_detail` (
  `product_ID` int(11) NOT NULL,
  `order_ID` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `amount` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `screen` varchar(150) NOT NULL,
  `operating_system` varchar(150) NOT NULL,
  `front_camera` varchar(150) NOT NULL,
  `rear_camera` varchar(150) NOT NULL,
  `CPU` varchar(150) NOT NULL,
  `RAM` varchar(150) NOT NULL,
  `inside_memory` varchar(150) NOT NULL,
  `memory_card` varchar(150) NOT NULL,
  `battery` varchar(150) NOT NULL,
  `trending` bit(5) DEFAULT NULL,
  `status` bit(5) NOT NULL DEFAULT b'1',
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `product` VALUES (1,'SamSung Galaxy J4+','samsung-galaxy-j4-plus-pink-400x400.jpg','IPS LCD, 6.0\', HD+','Android 8.1 (Oreo)','5 MP','13 MP','Qualcomm Snapdragon 425 4 nhân 64-bit','2 GB','16 GB','MicroSD, hỗ trợ tối đa 256 GB','3300 mAh',_binary '\0',_binary '\0',2),(2,'Samsung Galaxy S23 5G 128GB','samsung-galaxy-s23-den-1-1.jpg','6.1\" Dynamic AMOLED 2X','Android','12 MP','Chính 50 MP & Phụ 12 MP, 10 MP','Snapdragon 8 Gen 2 8 nhân','8 GB','128 GB','Không','3900 mAh25 W',_binary '\0',_binary '\0',2),(3,'Samsung Galaxy Z Fold 3 5G','600_Galaxy_Z_Fold_3.png','Chính 7.6 inch, Phụ 6.2 inch','Android','4MP, 10MP','12MP, 12MP, 12MP','Snapdragon 888 5G (5 nm)','12GB','256GB','Không','4.400 mAh',_binary '',_binary '\0',2),(4,'Samsung Galaxy S23 Ultra 5G 256GB','600_samsung_galaxy_s23_ultra_tim_6.jpg','6.8\" Dynamic AMOLED 2','Android','12 MP','Chính 200 MP & Phụ 12 MP, 10 MP, 10 MP','Snapdragon 8 Gen 2 8 nhân','8 GB','256 GB','Không','5000 mAh45 W',_binary '',_binary '\0',2),(5,'Samsung Galaxy Note 10 Plus 5G (12GB|256GB)','600_galaxy_note_10_plus_den_6.png','Dynamic AMOLED 6,8 inch 1440 x 3040 pixels','Android','10 MP','Chính 12 MP & Phụ 12 MP, 16 MP, TOF 3D','Exynos 9825 (7 nm)','12 GB','256GB','Không','4300 mAh',_binary '\0',_binary '\0',2),(6,'Samsung Galaxy S20 Plus','600_Samsung_S20_Plus_den.jpg','Dynamic AMOLED 2X6.7\"Quad HD+ (2K+)','Android 10','10 MP','Chính 12 MP & Phụ 64 MP, 12 MP, TOF 3D','Exynos 990','8 GB','128 GB','Không','4500 mAh',_binary '\0',_binary '\0',2),(7,'iPhone 14 Pro Max 256GB','600_iPhone_14_pro_trang_18.png','OLED6.7\"Super Retina XDR','iOS 16','12 MP','Chính 48 MP & Phụ 12 MP, 12 MP','Apple A16 Bionic','6 GB','256 GB','Không','4323 mAh',_binary '',_binary '\0',1),(8,'iPhone 12 Pro 512GB','600_iphone_12_pro_max_trang_4.png','OLED6.7\"Super Retina XDR','iOS 15','12 MP','3 camera 12 MP','Apple A14 Bionic','6 GB','512 GB','Không','3687 mAh',_binary '',_binary '\0',1),(9,'iPhone Xs Max 256GB','iphone-x-256gb-silver-400x400.jpg','OLED, 6.5\", Super Retina','iOS 14','7 MP','2 camera 12 MP','Apple A12 Bionic','4 GB','256 GB','Không','3174 mAh',_binary '\0',_binary '\0',1),(10,'iPhone 11 128GB','600_iphone_11_trang_xtsmart.jpg','IPS LCD, 6.1\", Liquid Retina','iOS 15','12 MP','2 camera 12 MP','Apple A13 Bionic','4 GB','128 GB','Không','3110 mAh',_binary '\0',_binary '\0',1),(11,' iPhone XR 128GB','600_iphone_xr_den.png','IPS LCD, 6.1\", Liquid Retina','iOS 15','7 MP','12 MP','Apple A12 Bionic','3 GB','128 GB','Không','2942 mAh',_binary '\0',_binary '\0',1),(12,'iPhone 8 Plus 64GB','600_iphone_8_plus_silver_xtsmart.jpg','LED-backlit IPS LCD, 5.5\", Retina HD','iOS 13','7 MP','2 camera 12 MP','Apple A11 Bionic','3 GB','64 GB','Không','2691 mAh',_binary '\0',_binary '\0',1),(15,'XIAOMI 11T PRO 5G (12GBl256GB)','600_Xiaomi_Redmi_11T_Pro_XTsmart.png','AMOLED, 6.67\", Full HD+','Android','16 MP','Chính 108 MP & Phụ 8 MP, 5 MP','Snapdragon 888','12 GB','256 GB','Không','5000 mAh',_binary '\0',_binary '\0',6),(16,'Xiaomi poco F3 (8GB|256GB)','600_Xiaomi_Poco_F3.png','AMOLED6.67\"Full HD+','Android','20 MP','Chính 48 MP & Phụ 8 MP, 5 MP','Snapdragon 870','6 GB','128 GB','Không','4520 mAh',_binary '\0',_binary '\0',6),(17,'Xiaomi poco X4 pro 5G (8GBl256GB)','600_Artboard_2_3.png','AMOLED, 6.67\", Full HD+','Android','16 MP','Chính 108 MP & Phụ 8 MP, 2 MP','Snapdragon 695 5G 8 nhân','8GB','256GB','Không','5000 mAh',_binary '',_binary '\0',6),(18,'XIAOMI REDMI NOTE 11S','XIAOMI_REDMI_NOTE_11S.png','AMOLED Full HD+ (1080 x 2400 Pixels)','Android','16 MP','Chính 108 MP & Phụ 8 MP, 2 MP, 2 MP','MediaTek Helio G96 8 nhân','8 GB','128GB','Không','5000 mAh',_binary '',_binary '\0',6),(19,'XIAOMI REDMI 10C 4GB/128GB','600_redmi-10c.png','IPS LCD 6.71\" HD+','Android','5 MP','Chính 50 MP & Phụ 2 MP','Snapdragon 680 8 nhân','4 GB','128 GB','Không','5000 mAh',_binary '\0',_binary '\0',6),(20,'Xiaomi Redmi 9C (3GB|64GB)','600_Xiaomi_redmi_9c.png','IPS LCD, 6.53\", HD+','Android','5 MP','Chính 13 MP & Phụ 2 MP, 2 MP','MediaTek Helio G35','2 GB','32 GB','MicroSD, hỗ trợ tối đa 512 GB','5000 mAh',_binary '\0',_binary '\0',6),(21,'Realme Q5 Pro','realme-q5-pro-600x600.jpg','AMOLED6.62\"Full HD+','Android','16 MP','Chính 64 MP & Phụ 8 MP, 2 MP','Snapdragon 870 5G','8 GB','256 GB','Không','5000 mAh',_binary '',_binary '\0',7),(22,'Realme C11 2021 (2G/32G)','600_Realme_C11_2021.png','IPS LCD, 6.5\", HD+','Android','5 MP','8 MP','Spreadtrum SC9863A','2 GB','32 GB','MicroSD, hỗ trợ tối đa 256 GB','5000 mAh',_binary '\0',_binary '\0',7),(23,'OPPO Find X5 Pro 5G ','oppo-find-x5-pro-den-thumb-600x600.jpg','AMOLED6.7\"Quad HD+ (2K+)','Android','32 MP','Chính 50 MP & Phụ 50 MP, 13 MP','Snapdragon 8 Gen 1','12 GB','256 GB','Không','5000 mAh',_binary '',_binary '\0',3),(24,'OPPO Reno8 T 5G 256GB','oppo-reno8t-den1-thumb-600x600.jpg','AMOLED, 6.7\", Full HD+','Android','32 MP','Chính 108 MP & Phụ 2 MP, 2 MP','Snapdragon 695 5G','8 GB','256 GB','MicroSD, hỗ trợ tối đa 1 TB','4800 mAh',_binary '',_binary '\0',3),(25,'OPPO A57 64GB ','oppo-a57-den-thumb-600x600.jpg','IPS LCD, 6.56\", HD+','Android','8 MP','Chính 13 MP & Phụ 2 MP','MediaTek Helio G35','4 GB','64 GB','MicroSD, hỗ trợ tối đa 1 TB','5000 mAh',_binary '\0',_binary '\0',3),(26,'OPPO A16 ','oppo-a16-silver-8-600x600.jpg','IPS LCD, 6.52\", HD+','Android','8 MP','Chính 13 MP & Phụ 2 MP, 2 MP','MediaTek Helio G35','3 GB','32 GB','MicroSD, hỗ trợ tối đa 256 GB','5000 mAh',_binary '\0',_binary '\0',3),(27,'OPPO Reno6 5G','oppo-reno-6.jpg','AMOLED, 6.43\", Full HD+','Android','32 MP','Chính 64 MP & Phụ 8 MP, 2 MP','MediaTek Dimensity 900 5G','8 GB','128 GB','Không','4300 mAh',_binary '\0',_binary '\0',3),(28,'Nokia C21 Plus 64GB ','Nokia-C21-Plus-Gray-600x600.jpg','TFT LCD, 6.5\", HD+','Android','5 MP','Chính 13 MP & Phụ 2 MP','Spreadtrum SC9863A','3 GB','64 GB','MicroSD, hỗ trợ tối đa 256 GB','5050 mAh',_binary '',_binary '\0',4),(29,'Nokia C31 (3GB/32GB)','Nokia-C31-600x600.jpg','TFT LCD, 6.7\", HD+','Android','5 MP','Chính 13 MP & Phụ 2 MP, 2 MP','Unisoc SC9863A1','3 GB','32 GB','MicroSD, hỗ trợ tối đa 256 GB','5050 mAh',_binary '\0',_binary '\0',4),(30,'Nokia 8210 4G','Nokia 8210-600x600.jpg','2.8\"','Series 30+','Không','0.3 MP','Unisoc T107','48 MB','128 MB','MicroSD, hỗ trợ tối đa 32 GB','1450 mAh',_binary '\0',_binary '\0',4),(31,'Nokia 110 4G','Nokia_110_4G.jpg','TFT LCD, 1.8\", 65.536 màu','Nokia S30+','Không','0.08 MP','Unisoc T107','48 MB','128 MB','MicroSD, hỗ trợ tối đa 32 GB','1020 mAh',_binary '\0',_binary '\0',4),(32,'sp1',NULL,'1','1','1','1','1','1','1','1','1',_binary '',_binary '',8),(33,'sp2',NULL,'1','1','1','2','2','2','2','2','2',_binary '',_binary '',8);

CREATE TABLE `product_color` (
  `color_ID` int(11) NOT NULL,
  `product_ID` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `product_color` VALUES (1,2,22990000,10),(3,2,22990000,15);


CREATE TABLE `role` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `slide` (
  `ID` int(11) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(150) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `slide` VALUES (1,'slide1','banner1.png',_binary ''),(2,'slide2','banner2.png',_binary ''),(3,'slide3','banner3.png',_binary ''),(4,'slide4','banner4.png',_binary ''),(5,'slide5','banner5.png',_binary ''),(6,'slide6','banner6.png',_binary ''),(7,'slide7','banner7.png',_binary ''),(8,'slide8','banner8.png',_binary ''),(9,'slide9','banner9.png',_binary '');

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `fullname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(266) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(266) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) NOT NULL,
  `role_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


