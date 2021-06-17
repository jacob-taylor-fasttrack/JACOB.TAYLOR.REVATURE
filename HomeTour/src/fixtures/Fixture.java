package fixtures;

public abstract class Fixture {
	protected String name;
	
	protected String shortDescription;
	
	protected String longDescription;
	
	//Parameterized Constructor
	public Fixture(String name, String shortDescription, String longDescription) {
		super();
		this.name=name;
		this.shortDescription=shortDescription;
		this.longDescription=longDescription;
	}
	// Getters and Setters:
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}

		public String getLongDescription() {
			return longDescription;
		}

		public void setLongDescription(String longDescription) {
			this.longDescription = longDescription;
		}

		// Overridden toString method
		public String toString() {
			return "Fixture [name=" + name + ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + "]";
		}
}
