SET @cart_id_to_select = <{row_id}>;
SELECT cart.*
    FROM cart
    WHERE cart.cart_id = @cart_id_to_select;


