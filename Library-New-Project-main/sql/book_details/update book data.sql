UPDATE `ebook`.`book_details`
SET
`book_id` = <{book_id: }>,
`book_name` = <{book_name: }>,
`author` = <{author: }>,
`price` = <{price: }>,
`book_category` = <{book_category: }>,
`status` = <{status: }>,
`published_year` = <{published_year: }>,
`qty_instock` = <{qty_instock: }>,
`photo` = <{photo: }>
WHERE `book_id` = <{expr}>;
