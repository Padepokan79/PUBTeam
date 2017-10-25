package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("t_mutasi_batch")
@CompositePK({"Nip","KdSkpd_l","KdSatker_l"})
public class MdTmutasiBatch extends Model{

}
