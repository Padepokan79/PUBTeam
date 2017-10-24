package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("akunsp2d") 
@CompositePK({"KDSSBP","KDSKPD","KDTRANS"})
public class MdAkunsp2d extends Model {

}
