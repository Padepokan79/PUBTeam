package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table ("hist_gapok")
@CompositePK({"NIP", "TMTBERLAKU"})
public class MdHistGapok extends Model {

}
