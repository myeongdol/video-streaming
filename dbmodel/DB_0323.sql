-- DB NAME = videostream
-- root / 1234
-- video / qleldh

DROP TABLE IF EXISTS member RESTRICT;
DROP TABLE IF EXISTS board RESTRICT;
DROP TABLE IF EXISTS video RESTRICT;

-- 회원
CREATE TABLE `member` (
	`id` VARCHAR(30) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`password` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`email` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`active_status` VARCHAR(1) NULL DEFAULT 'Y' COLLATE 'utf8mb4_0900_ai_ci',
	`login_time` DATETIME NULL DEFAULT NULL,
	`permit` VARCHAR(3) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=MyISAM
;

--게시글
CREATE TABLE `board` (
	`no` INT(10,0) NOT NULL AUTO_INCREMENT,
	`video_no` INT(10,0) NULL DEFAULT '0',
	`member_id` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`title` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`contents` VARCHAR(2000) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`save_status` VARCHAR(1) NULL DEFAULT 'Y' COLLATE 'utf8mb4_0900_ai_ci',
	`save_time` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`no`) USING BTREE
)
COMMENT='게시글'
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;

--동영상
CREATE TABLE `video` (
	`no` INT(10,0) NOT NULL AUTO_INCREMENT,
	`file_path` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`file_name` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`file_url` VARCHAR(300) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`play_cnt` INT(10,0) NULL DEFAULT '0',
	PRIMARY KEY (`no`) USING BTREE
)
COMMENT='동영상 데이터'
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;

