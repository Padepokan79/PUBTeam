package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("historis_pendidikan")
@CompositePK({"NIP","TMTAWAL","TMTAKHIR"})
public class MdHistorisPendidikan extends Model {

}
