
CREATE TABLE `members` (
  `user_name` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `joined_on` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);
CREATE TABLE `authors` (
  `author` varchar(100) NOT NULL,
  PRIMARY KEY (`author`)
);
CREATE TABLE `books` (
  `isbn` VARCHAR(20) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `author` (`author`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`author`) REFERENCES `authors` (`author`)
);

CREATE TABLE `copies` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(20) DEFAULT NULL,
  `isinlibrary` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `isbn` (`isbn`),
  CONSTRAINT `copies_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `books` (`isbn`)
);

CREATE TABLE borrowed_books (
transaction_id int PRIMARY KEY AUTO_INCREMENT,
user_id int,
isbn VARCHAR(20),
due_date DATETIME,
date_taken DATETIME,
book_id int,
FOREIGN KEY (isbn) REFERENCES books(isbn),
FOREIGN KEY (user_id) REFERENCES members(user_id),
FOREIGN KEY (book_id) REFERENCES copies(book_id)
);






