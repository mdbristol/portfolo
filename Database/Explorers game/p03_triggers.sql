---P03_triggers 
--Michael Bristol

Create Or Replace Trigger tr_count_check
Before Insert 
ON Explorer_Treasure
For EACH ROW 
Declare 
	v_max_item_count	Explorer.Max_Item_Count%type;
	item_count	integer;
	NoRoom Exception;
	
	ExMessage Varchar(200);


	
Begin
	Select count(*) into item_count from Explorer_Treasure where eid = :new.eid;
	Select Max_Item_Count INTO v_max_item_count FROM Explorer Where Explorer.eid = :new.eid;
	
	IF :old.eid = :new.eid then 
		return;
	ELSE
		IF item_count >= v_max_item_count then 
		 Raise NoRoom;
		End IF;
	End IF;
EXCEPTION
	when NoRoom then 
	ExMessage := 'This player is only allowed max of' || to_char(v_max_item_count) || 'items';
	RAISE_APPLICATION_Error (-20000, ExMessage); 
	
END;
/	

Create Or Replace Trigger tr_weight_check
Before Insert 
ON Explorer_Treasure
For EACH ROW 
Declare 
	v_max_item_weight	Explorer.Max_Item_Weight%type;
	v_max_bag_weight	Explorer.Max_Bag_Weight%type; --bAG weight 
	current_weight number; --bagweight
	v_treasure_weight   Treasure.Weight%type;
	itemweight Exception;
 	bagweight	Exception;  --bagweight
	ExMessage Varchar(200);


	
Begin
	
	Select Max_Item_Weight INTO v_max_item_weight FROM Explorer Where Explorer.eid = :new.eid;
	Select Weight INTO v_treasure_weight  FROM Treasure Where Treasure.tid = :new.tid;
	Select Max_Bag_Weight INTO v_max_bag_weight FROM Explorer Where Explorer.eid = :new.eid; --bagweight
	Select Sum(Weight) Into current_weight From Treasure inner join Explorer_Treasure On Explorer_Treasure.tid = Treasure.tid Inner Join Explorer On Explorer.eid = Explorer_Treasure.eid where Explorer.eid = :new.eid; --bagweight inner join  -- 
	IF (:old.eid = :new.eid AND :old.tid = :new.tid) then
		return;
	ELSE
		IF v_treasure_weight >  v_max_item_weight  then  
		 Raise itemweight;
		ElsIf current_weight + v_treasure_weight > v_max_bag_weight then --bagweight --add the current weight with the treasure weight 
		  Raise bagweight; --bagweight
		End IF;
	End IF;
EXCEPTION
	when itemweight then 
	ExMessage := 'This treasure exceeds the max item weight of ' || ' ' ||   to_char(v_max_item_weight)|| ', '  || 'treasure weight is'|| ' ' || to_char(v_treasure_weight);
	RAISE_APPLICATION_Error (-20000, ExMessage); 
	when bagweight then 
	ExMessage := 'No more treasure can be added max bag weight of ' || ' ' ||   to_char(v_max_bag_weight)|| ', ' || 'current_weight' || ' ' || to_char(current_weight);
	RAISE_APPLICATION_Error (-20000, ExMessage); 
	
	
END;
/	



