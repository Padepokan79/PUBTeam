package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import com.Ostermiller.util.MD5;

@Table("USERS")
public class User extends Model {
	public void beforeSave(){
		set("password", encryptPassword());
	}   
	
	public void beforeCreate(){
		set("password", encryptPassword());
	}  
	
	private String encryptPassword(){		
		return MD5.getHashString(get("password").toString());
	}
}
