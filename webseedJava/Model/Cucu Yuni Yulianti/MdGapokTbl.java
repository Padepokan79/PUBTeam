package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("gapok_tbl")
@CompositePK({"MASKER", "TMT_GAPOK", "KDPANGKAT", "KDKELOMPOK", "NILAI_BAWAH"})
public class MdGapokTbl extends Model{

}
