package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("mst_hutang")
@CompositePK({"nip","urut"})
public class MdMstHutang extends Model {

}
