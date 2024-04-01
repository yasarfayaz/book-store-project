SELECT `book_order`.`id`,
    `book_order`.`order_id`,
    `book_order`.`user_name`,
    `book_order`.`email`,
    `book_order`.`address`,
    `book_order`.`phone`,
    `book_order`.`book_name`,
    `book_order`.`author`,
    `book_order`.`price`,
    `book_order`.`payment`
FROM `ebook`.`book_order`
where  `book_order`.`id`= 'id';
