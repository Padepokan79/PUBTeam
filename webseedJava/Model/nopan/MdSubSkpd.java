package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("subskpd")
@CompositePK({"kdskpd","subskpd"})
public class MdSubSkpd extends Model{

}
