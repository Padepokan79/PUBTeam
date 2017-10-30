package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("terima_ind")
@CompositePK({"Nip","kddati1","kddati2"})
public class MdTerimaInd extends Model {

}
