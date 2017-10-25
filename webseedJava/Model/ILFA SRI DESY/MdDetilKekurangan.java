package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("detil_kekurangan")
@CompositePK({"TGLBAYAR","NIP","NORUT","KETER"})
public class MdDetilKekurangan extends Model{

}
