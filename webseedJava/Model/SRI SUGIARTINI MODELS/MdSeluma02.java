package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("seluma02")
@CompositePK({"NIP_PEMDA","NIP_OLD"})
public class MdSeluma02 extends Model{

}
