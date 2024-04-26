
public class Material {
    private String title;
    private String type;
    private double replacementValue;
    private String location;
    private boolean suitableForChildren;

    public Material(String title, String type, double replacementValue, String location, boolean suitableForChildren) {
        this.title = title;
        this.type = type;
        this.replacementValue = replacementValue;
        this.location = location;
        this.suitableForChildren = suitableForChildren;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public double getReplacementValue() {
		return replacementValue;
	}

	public void setReplacementValue(double replacementValue) {
		this.replacementValue = replacementValue;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isSuitableForChildren() {
		return suitableForChildren;
	}

	public void setSuitableForChildren(boolean suitableForChildren) {
		this.suitableForChildren = suitableForChildren;
	}
}
