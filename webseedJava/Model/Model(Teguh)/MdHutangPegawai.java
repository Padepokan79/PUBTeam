package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("hutang_pegawai")
@CompositePK({"NIP","KDHUTANG","NORUT"})
public class MdHutangPegawai extends Model{

}
