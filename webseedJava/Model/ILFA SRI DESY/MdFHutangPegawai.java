package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("fhutang_pegawai")
@CompositePK({"nip","tglgaji","KdJnsTrans"})
public class MdFHutangPegawai extends Model{

}
