import java.util.ArrayList;

public class Builder {
	public static java.util.ArrayList<java.util.ArrayList<Plage>> Build(EmployeManager manager) {
		ArrayList<Employe> employes = manager.employes;
		
		//Initialize 
		ArrayList<ArrayList<Plage>> plages = new ArrayList<ArrayList<Plage>>();
		for (int i = 0; i < 7; i++) {
			ArrayList<Plage> day = new ArrayList<Plage>();
			for (int j=0; j < 48; j++) {
				day.add(new Plage(i, j));
			}
			plages.add(day);
		}
		
		//Sort by highest employe hour asked
		ArrayList<Employe> temp = new ArrayList<Employe>();
		
		for (int i = 0; i < employes.size(); i++) {
			int maxHour = 0;
			Employe employe = null;
			for (int j = 0; j < employes.size(); j++) {
				if (employes.get(j).askedHour > maxHour) {
					maxHour = employes.get(j).askedHour;
					employe = employes.get(j);
				}
			}
			temp.add(employe);
			employes.remove(employe);
		}
		
		employes = temp;
		
		
		ArrayList<EmployeWithHourLeft> employesWithHourLeft = new ArrayList<EmployeWithHourLeft>();
		
		//First pass of employe (with most asked hour)
		for (int i=0; i < employes.size(); i++) {
			double hourLeft = employes.get(i).askedHour;
			
			for (int day=0; day < 7; day++) {
				for (int index=0; index < 48; index++) {
					if (hourLeft > 0
						&& Opened(day, index)
						&& !ContainedInList(plages.get(day).get(index), employes.get(i).unavailability)
						&& !EmployeCountDone(index, plages.get(day).get(index).employes.size())
						&& !plages.get(day).get(index).employes.contains(employes.get(i))) 
					{
						hourLeft -= 0.5;
						plages.get(day).get(index).employes.add(employes.get(i));
					}
				}
			}
			
			if (hourLeft > 0){
				employesWithHourLeft.add(new EmployeWithHourLeft(employes.get(i), hourLeft));
			}
		}
		
		//For employe with hour left
		//First pass of employe (with most asked hour)
				for (int i=0; i < employesWithHourLeft.size(); i++) {
					double hourLeft = employesWithHourLeft.get(i).hourLeft;
					
					for (int day=0; day < 7; day++) {
						for (int index=0; index < 48; index++) {
							if (hourLeft > 0
								&& Opened(day, index)
								&& !ContainedInList(plages.get(day).get(index), employesWithHourLeft.get(i).employe.unavailability)
								&& !plages.get(day).get(index).employes.contains(employes.get(i))) 
							{
								hourLeft -= 0.5;
								plages.get(day).get(index).employes.add(employesWithHourLeft.get(i).employe);
							}
						}
					}
				}
		
		
		return plages;
	}
	
	private static boolean ContainedInList(Plage plage, ArrayList<Plage> cant) {
		for (int i=0; i < cant.size(); i++) {
			if (cant.get(i).day == plage.day && cant.get(i).index == plage.index) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean Opened(int day, int index) {
		switch (day) {
			case 0: return index >= 16 && index <= 34;
			case 1: return index >= 16 && index <= 34; 
			case 2: return index >= 16 && index <= 34; 
			case 3: return index >= 16 && index <= 42; 
			case 4: return index >= 16 && index <= 42; 
			case 5: return index >= 16 && index <= 42; 
			case 6: return index >= 22 && index <= 34; 
		}
		return false;
	}
	
	private static boolean EmployeCountDone(int hour, int employeCount) {
		return (hour < 23 && employeCount >= 2)||
			   (hour > 33 && employeCount >= 3)||
			   (employeCount >= 4);
	}
}