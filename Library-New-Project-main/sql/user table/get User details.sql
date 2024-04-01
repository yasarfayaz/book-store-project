SET @id_to_select = <{row_id}>;
SELECT user.*
    FROM user
    WHERE user.id = @id_to_select;