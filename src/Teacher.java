public class Teacher extends Person {

	private String subject;

	public Teacher(int id, String name, String DOB) {
		super(id, name, DOB, "Teacher");
	}

	@Override
	public void setType(String type) {
		type = type.toUpperCase();
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}
}
