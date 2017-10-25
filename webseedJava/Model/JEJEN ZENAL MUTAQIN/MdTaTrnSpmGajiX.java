package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("ta_trn_spm_gaji_x")
@CompositePK({"V_Bulan_Th","KdSkpd","kdtrans"})
public class MdTaTrnSpmGajiX extends Model{

}
