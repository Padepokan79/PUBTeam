package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("jabatan_tbl")
@CompositePK({"TMTJABATAN", "KDJABATAN"})
public class MdJabatanTbl extends Model{

}
