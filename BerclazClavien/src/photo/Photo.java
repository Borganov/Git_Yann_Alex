package photo;

public class Photo {
	
	private int name;
	private String path;
	
	public Photo(int name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
