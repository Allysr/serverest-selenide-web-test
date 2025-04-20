import br.com.serverest.base.BaseTeste;
import br.com.serverest.paginas.PaginaLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteLogin extends BaseTeste {
    private PaginaLogin paginaLogin;

    @BeforeEach
    public void iniciarTeste(){
        paginaLogin = new PaginaLogin();
    }

    @Test
    public void deveClicarNoCadastroComSucesso(){
        paginaLogin.clicarBotaoCadastrar();
    }
}
