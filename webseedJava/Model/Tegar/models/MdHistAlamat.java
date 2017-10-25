package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("HIST_ALAMAT")
@CompositePK({"tmt_alm", "kdhubkel", "nip"})
public class MdHistAlamat extends Model {

}
