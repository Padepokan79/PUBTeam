package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.IdName;
import org.javalite.activejdbc.annotations.Table;

@Table("jabatankhusus_tbl")
@CompositePK({"TMTJABATAN","KDJABATAN"})
public class MdJabatanKhususTbl extends Model{

}
