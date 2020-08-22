package autoria.entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Ramesh Fadatare
 *
 */
@Entity
@Table(name="users")
public class User
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique=true)
	@Email(message="{errors.invalid_email}")
	private String email;
	@Column(nullable=false)
	@Size(min=4)
	private String password;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, optional = false)
	private People people;

	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
	      name="user_role",
	      joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private List<Role> roles;


	public User() {
		roles = new ArrayList<Role>();
	}

	public User(@NotEmpty() String name, @NotEmpty @Email(message = "{errors.invalid_email}") String email, @NotEmpty @Size(min = 4) String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void setPeople(People people) {
		if(people==null){
			if(this.people!=null){
				this.people.setUser(null);
			}
		}
		else {
			people.setUser(this);
		}
		this.people=people;
	}

	public People getPeople() {
		return people;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public List<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}
}
