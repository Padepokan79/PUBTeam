package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("formulir_ajuan")
@CompositePK({"NIP","KDKLAIM"})
public class MdFormulirAjuan extends Model{

}
