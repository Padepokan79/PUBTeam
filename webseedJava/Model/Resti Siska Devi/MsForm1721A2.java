package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("form_1721_a2")
@CompositePK({"Tahun_Pajak", "Nip"})
public class MsForm1721A2 extends Model{

}
