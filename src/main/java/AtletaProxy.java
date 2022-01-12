import java.util.List;

public class AtletaProxy implements IAtleta {
    private Atleta atleta;

    private Integer matricula;

    public AtletaProxy(Integer matricula) {
        this.matricula = matricula;
    }
    @Override
    public List<String> acessarDadosdoAtleta(){
        if(this.atleta == null){
            this.atleta = new Atleta(this.matricula);
        }
        return this.atleta.acessarDadosdoAtleta();
    }
    @Override
    public List<Float>acessarIMC(PersonalTrainer personal){
        if (!personal.isAdministrador()) {
            throw new IllegalArgumentException("Acesso incorreto");
        }
        if(this.atleta == null){
            this.atleta = new Atleta(this.matricula);
        }
        return this.atleta.acessarIMC(personal);
    }
}