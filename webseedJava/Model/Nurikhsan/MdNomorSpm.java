package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("nomorspm")
@CompositePK({"tglgaji","kdjnstrans","kdsatker"})
public class MdNomorSpm extends Model {

}
