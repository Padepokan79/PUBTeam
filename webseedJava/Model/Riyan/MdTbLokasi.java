package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("tblokasi")
@CompositePK({"KDDATI1","KDDATI2","KDDATI3","KDDATI4"})
public class MdTbLokasi extends Model {

}
