package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.CompositePK;
import org.javalite.activejdbc.annotations.Table;

@Table("problem_cek")
@CompositePK({"nip","blthgaji"})
public class MdProblemCek extends Model {

}
