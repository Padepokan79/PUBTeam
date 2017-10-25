package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;
@Table("skpdimport")
@CompositePK({"KDSSBP","KDSKPD"})
public class MdSkpdImport extends Model {

}
