package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("ta_trn_spm_gaji")
@CompositePK({"V_Bulan_Th","C_Tipe_Data","C_Urusan_Keu","C_Bidang_Keu","C_Unit_Keu","C_Sub_Keu"})
public class MdTaTrnSpmGaji extends Model{

}
