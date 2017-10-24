package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("hist_jiwa")
@CompositePK({"nip","tmtberlaku"})
public class MdHistJiwa extends Model{

}
