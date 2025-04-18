package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


@Entity
@NamedQueries({
	
	@NamedQuery(name = "usuario.findAll", query = "SELECT u FROM Usuario u")
	
})
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private Integer idade;
	
	@OneToMany(mappedBy = "usuario")
	private List<Telefone> telefone;
	
	public Usuario() {
		
	}
	
	public Usuario(String name, String sobrenome, String email, String login, String senha, Integer idade) {
		this.name = name;
		this.sobrenome = sobrenome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.idade = idade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, idade, login, name, senha, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(idade, other.idade)
				&& Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(senha, other.senha) && Objects.equals(sobrenome, other.sobrenome);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sobrenome=" + sobrenome + ", email=" + email + ", login="
				+ login + ", senha=" + senha + ", idade=" + idade + "]";
	}
	
	
	
	

}
