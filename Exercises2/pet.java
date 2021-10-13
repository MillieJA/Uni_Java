
public class pet {
	private String name;
	private String animal_type;
	private int age;
	
	public pet (String name, String animal_type, int age) {
		this.name = name;
		this.animal_type = animal_type;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return animal_type;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String animal_type) {
		this.animal_type = animal_type;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void show_details() {
		System.out.println(name + " is a " + animal_type + " and is " + age + " years old.");
	}
	
}
