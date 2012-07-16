public class Lab24_26c
{

public void OperationsRed(String color1, String color2, Lab24_26_2 fc1,Lab24_26_2 fc2, Lab24_26_2 fc3 )
{
	if(color1.equals("red")&&color2.equals("red")){fc1.colorR((fc1.colorT()*fc1.colorT()));}
	else if(color1.equals("red")&&color2.equals("black")){fc2.colorR((fc2.colorT()*fc1.colorT()));}//add
	else if(color1.equals("red")&&color2.equals("white")){fc3.colorR((fc3.colorT()*fc1.colorT()));}
	else if(color1.equals("white")&&color2.equals("red")){fc1.colorR((fc1.colorT()+fc1.colorT()));}
	else if(color1.equals("white")&&color2.equals("black")){fc2.colorR((fc2.colorT()+fc1.colorT()));}
	else if(color1.equals("white")&&color2.equals("white")){fc3.colorR((fc3.colorT() + fc1.colorT()));}
}

public void OperationsBlack(String color1, String color2, Lab24_26_2 fc1,Lab24_26_2 fc2, Lab24_26_2 fc3)
{
if(color1.equals("red")&&color2.equals("red")){fc1.colorR((fc1.colorT()*fc2.colorT()));}
else if(color1.equals("red")&&color2.equals("black")){fc2.colorR((fc2.colorT()*fc2.colorT()));}//add
else if(color1.equals("red")&&color2.equals("white")){fc3.colorR((fc3.colorT()*fc2.colorT()));}
else if(color1.equals("white")&&color2.equals("red")){fc1.colorR((fc1.colorT()+fc2.colorT()));}
else if(color1.equals("white")&&color2.equals("black")){fc2.colorR((fc2.colorT()+fc2.colorT()));}
else if(color1.equals("white")&&color2.equals("white")){fc3.colorR((fc3.colorT() + fc2.colorT()));}
}

public void OperationsWhite(String color1, String color2, Lab24_26_2 fc1,Lab24_26_2 fc2, Lab24_26_2 fc3)
{
if(color1.equals("red")&&color2.equals("red")){fc1.colorR((fc1.colorT()*fc3.colorT()));}
else if(color1.equals("red")&&color2.equals("black")){fc2.colorR((fc2.colorT()*fc3.colorT()));}//add
else if(color1.equals("red")&&color2.equals("white")){fc3.colorR((fc3.colorT()*fc3.colorT()));}
else if(color1.equals("white")&&color2.equals("red")){fc1.colorR((fc1.colorT()+fc3.colorT()));}
else if(color1.equals("white")&&color2.equals("black")){fc2.colorR((fc2.colorT()+fc3.colorT()));}
else if(color1.equals("white")&&color2.equals("white")){fc3.colorR((fc3.colorT() + fc3.colorT()));}
}











}
