import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AtletaProxyTest {
    @BeforeEach
    void setUp(){
        BD.addAtleta(new Atleta(1, "Maria", "Silva", "Hipertrofia", 18.5f, "Halterofilismo"));
        BD.addAtleta(new Atleta(2, "Guilherme", "Marques", "Aumento de carga", 23.3f,"Halterofilismo"));
    }
    @Test
    void deveRetornaNomeESobrenomeEEsporteDoAtleta(){
        AtletaProxy atleta = new AtletaProxy(2);
        assertEquals(Arrays.asList("Guilherme", "Marques", "Halterofilismo"), atleta.acessarDadosdoAtleta());
    }

    @Test
    void deveRetornaDadosparaIMCdoAtleta(){
        PersonalTrainer personal = new PersonalTrainer("Edmundo", true);
        AtletaProxy atleta = new AtletaProxy(1);
        assertEquals(Arrays.asList(18.5f), atleta.acessarIMC(personal));
    }
    @Test
    void deveRetornaPersonalTrainerNaoAutorizadoAcesso() {
        try {
            PersonalTrainer personal = new PersonalTrainer("Marcela", false);
            AtletaProxy atleta = new AtletaProxy(2);
            atleta.acessarIMC(personal);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Acesso incorreto", e.getMessage());
        }
    }
}
