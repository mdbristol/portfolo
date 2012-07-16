	function computeCost()
	{
		var burger=0;							
		var burgerSize = document.getElementById("myForm");
			for(var index=0; index < burgerSize.sizeButton.length; index++)
				{
					if(burgerSize.sizeButton[index].checked)
					{
						burger=burgerSize.sizeButton[index].value;
						switch(burger)
						{
							case("single"):
							burger = 2;
							
							break;
							case("double"):
							burger = 3;
							break;
							case("triple"):
							burger = 4;
							break;
							}
					}		
				}
		
				
				
			
			
		var toppings=0;
		var totalcost=0;
		var burgerTopping = document.getElementById("myForm2");
		
			for(  index=0; index < burgerTopping.topButton.length; index++)
				{
					if(burgerTopping.topButton[index].checked)
					{
						//alert(burgerTopping.topButton[index].value);
						toppings = (burgerTopping.topButton[index].value);
						switch(toppings)
							{
								case("cheese"):
								totalcost+=50;
								break;
								case("onions"):
								totalcost+=25;
								break;
								case("lettuce"):
								totalcost+=0;
								break;
								case("tomatoes"):
								totalcost+=30;
								break;
								case("mustard"):
								totalcost+=0;
								break;
								case("only"):
				
										totalcost+=40;
								break;
							}
								
						
						
					}
				}
				totalcost= (totalcost / 100) + burger;
				alert("Total cost of burger:  " + totalcost + "\n Burger size:" + burger + "\n Toppings:" + toppings );
	}
											
