package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;

@Table("unitkerja")
@CompositePK({"satkerja","nip_atasan"})
public class MdUnitKerja extends Model{
	
}
