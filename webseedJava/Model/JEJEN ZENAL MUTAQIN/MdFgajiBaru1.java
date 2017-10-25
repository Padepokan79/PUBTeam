package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("fgaji_baru_1")
@CompositePK({"TGLGAJI","KDJNSTRANS","NIP"})
public class MdFgajiBaru1 extends Model{

}
