public abstract class Person {

	private int id;
	private String name;
	private String DOB;
	private String type;

	public Person(int id, String name, String DOB, String type) {
		this.id = id;
		this.name = name;
		this.DOB = DOB;
		this.type = type;
	}

	public abstract void setType(String type);

	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Name updated");
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
		System.out.println("DOB updated");
	}
}
