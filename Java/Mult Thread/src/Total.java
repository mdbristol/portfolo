
public class Total {
	

	
	
		private static int total = 0; // count starts at zero

		public synchronized void setTotal(int amount)
		{ 
			total = total+ amount;
		}
		
		public synchronized int getTotal()
		{
			return total;
		}

	}


