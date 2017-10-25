package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("pajak_acc")
@CompositePK({"kdcabang","kdssbp"})
public class MdPajakAcc extends Model{

}
