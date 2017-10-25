package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("twafat")
@CompositePK({"NIP","KDHUBKEL"})
public class MdWafat extends Model {

}
