package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("pemda")
@CompositePK({"pemdakey","kddati1","kddati2"})
public class MdPemda extends Model {

}
