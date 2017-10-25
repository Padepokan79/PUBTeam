package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("kolaborasi_data")
@CompositePK({"pegawai_id","nip_baru"})
public class MdKolaborasiData extends Model {

}
