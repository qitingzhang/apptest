CREATE TABLE `growth_diary` (
                                `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `user_id` int NOT NULL,
                                `title` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
                                `content` text COLLATE utf8mb4_general_ci,
                                `emotion` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='成长日记表';