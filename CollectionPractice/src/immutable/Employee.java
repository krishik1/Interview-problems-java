package immutable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Employee {
	private final Long id;
	private final String name;
	private final String role;
	private final int age;
	private final Set<String> depatments;
	
	public Employee(Long id, String name, String role, int age, Set<String> depatments) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.age = age;
		this.depatments = depatments==null?Collections.emptySet():new HashSet<>(depatments);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public int getAge() {
		return age;
	}

	public Set<String> getDepatments() {
		return Collections.unmodifiableSet(depatments);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", age=" + age + ", depatments="
				+ depatments + "]";
	}
	
	
	
	

}
