DROP TABLE IF EXISTS site RESTRICT;

-- 사이트
CREATE TABLE `site` (
	`join_status` VARCHAR(1) NULL COLLATE 'utf8mb4_0900_ai_ci',
	`layout_type` VARCHAR(20) NULL COLLATE 'utf8mb4_0900_ai_ci'
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;

INSERT INTO `site`(`join_status`, `layout_type`) VALUES ('Y', 'right');
