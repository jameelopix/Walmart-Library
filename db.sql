DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS rating;

START TRANSACTION;

CREATE TABLE `book` (
`id` bigint(20) NOT NULL,
`description` varchar(255) DEFAULT NULL,
`title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `book`
ADD PRIMARY KEY (`id`);

ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

INSERT INTO `book`(`id`, `description`, `title`) VALUES 
(1, 'Head First Java', 'Must have book for Java'),
(2, 'Design Pattern', 'Archirtect Bible'),
(3, 'Data Structures', 'Basics of Programming');

CREATE TABLE `rating` (
`id` bigint(20) NOT NULL,
`bookid` bigint(20) DEFAULT NULL,
`rating` double DEFAULT NULL,
`rating_count` int(11) DEFAULT NULL,
`rating_point` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `rating`
ADD PRIMARY KEY (`id`);

ALTER TABLE `rating`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;  

INSERT INTO `rating`(`id`, `bookid`, `rating`, `rating_count`, `rating_point`) VALUES 
(1,1,4.5,5,24),
(2,2,4.0,5,20),
(3,3,3.5,5,19);


COMMIT;