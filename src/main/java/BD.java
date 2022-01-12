import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Atleta> atletas = new HashMap<>();

    public static Atleta getAtleta(Integer matricula){
        return atletas.get(matricula);
    }
    public static void addAtleta(Atleta atleta){
        atletas.put(atleta.getMatricula(), atleta);
    }
}