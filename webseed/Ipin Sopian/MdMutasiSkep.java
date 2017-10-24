package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("mutasi_skep")
@CompositePK({"nip","noagenda"})
public class MdMutasiSkep extends Model{

}
