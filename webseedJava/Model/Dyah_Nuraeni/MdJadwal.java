package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;

@Table("jadwal")
@CompositePK({"nip","kdhutang","norut","tglcicilan")
public class MdJadwal extends Model{

}
