
public class Horaire {
	public java.util.ArrayList<java.util.ArrayList<Plage>> plages = null;
	
	public void Build(EmployeManager manager) {
		plages = Builder.Build(manager);
	}
}
