package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("Keluarga")
@CompositePK({"NIP","KDHUBKEL"})
public class MdKeluarga extends Model {

}
