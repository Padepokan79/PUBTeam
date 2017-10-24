package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("Hutang")
@CompositePK({"NIP","KDHUTANG","NORUT"})
public class MdHutang extends Model {

}
