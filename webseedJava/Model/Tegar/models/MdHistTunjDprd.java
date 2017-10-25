package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("hist_tunj_dprd")
@CompositePK({"nip","Tmt_Berlaku"})
public class MdHistTunjDprd extends Model {

}
