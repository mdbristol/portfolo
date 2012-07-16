//change font script


function setColor(where, newColor)
	{
	if(where == "background")
		document.getElementById("main").style.backgroundColor = newColor;
	if (where == "text")
		document.getElementById("main").style.color = newColor;
	 if (where=="border")
	 document.getElementById("main").style.borderColor = newColor;
		
	}
	
function setText(Weight)
	{

			  document.getElementById("main").style.fontWeight = Weight;
	}
	function setSize(size)
	{
	document.getElementById("main").style.fontSize = size;

	}
	function setVib()
	{
		dom = document.getElementById("main").style;
		
		if(dom.visibility =="visible")
			dom.visibility = "hidden";
		else
			dom.visibility = "visible";
		}
