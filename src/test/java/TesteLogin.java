import br.com.serverest.base.BaseTeste;
import br.com.serverest.dto.CadastroDTO;
import br.com.serverest.fabrica.FabricaCadastro;
import br.com.serverest.paginas.PaginaCadastro;
import br.com.serverest.paginas.PaginaLogin;
import br.com.serverest.paginas.PaginaPrincipal;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteLogin extends BaseTeste {
    private PaginaLogin paginaLogin;
    private PaginaCadastro paginaCadastro;
    private PaginaPrincipal paginaPrincipal;
    private CadastroDTO usuarioValido;


    @BeforeEach
    public void iniciarTeste(){
        paginaLogin = new PaginaLogin();
        paginaCadastro = new PaginaCadastro();
        paginaPrincipal = new PaginaPrincipal();
        usuarioValido = FabricaCadastro.criarUsuarioValido();

    }

    @AfterEach
    public void finalizarTeste(){
        paginaPrincipal.clicarBotaoLogout();
    }

    @Test
    public void deveFazerLoginComSucesso() {
        paginaLogin.
                clicarBotaoCadastrar();
        paginaCadastro.
                validarTextoCadastroVisivel().
                preencherNome(usuarioValido.getNome()).
                preencherEmail(usuarioValido.getEmail()).
                preencherSenha(usuarioValido.getSenha()).
                clicarBotaoCadastrar().
                aguardarRedirecionamento();
        paginaPrincipal.
                validarTextoServerest().
                clicarBotaoLogout();
        paginaLogin.
                validarPaginaLogin().
                preencherEmail(usuarioValido.getEmail()).
                preencherSenha(usuarioValido.getSenha()).
                clicarBotaoLogin().
                validarPaginaLogin();
        System.out.println(usuarioValido.getEmail());

    }
}