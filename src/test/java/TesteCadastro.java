import br.com.serverest.base.BaseTeste;
import br.com.serverest.dto.CadastroDTO;
import br.com.serverest.fabrica.FabricaCadastro;
import br.com.serverest.paginas.PaginaCadastro;
import br.com.serverest.paginas.PaginaLogin;
import br.com.serverest.paginas.PaginaPrincipal;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteCadastro extends BaseTeste {
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

    @Test
    public void deveCadastrarUsuarioERedirecionarParaPaginaPrincipal() {
        paginaLogin.
                clicarBotaoCadastrar();
        paginaCadastro.
                validarTextoCadastroVisivel().
                preencherNome(usuarioValido.getNome()).
                preencherEmail(usuarioValido.getEmail()).
                preencherSenha(usuarioValido.getSenha()).
                marcarAdministrador().
                clicarBotaoCadastrar();
        paginaPrincipal.
                validarTextoBemVindo().
                clicarBotaoLogout();
    }

    @Test
    public void naoDeveCadastrarUsuarioComEmailJaUtilizado() {
        paginaLogin.
                clicarBotaoCadastrar();
        paginaCadastro.
                validarTextoCadastroVisivel().
                preencherNome(usuarioValido.getNome()).
                preencherEmail(usuarioValido.getEmail()).
                preencherSenha(usuarioValido.getSenha()).
                marcarAdministrador().
                clicarBotaoCadastrar().
                aguardarRedirecionamento();
        paginaPrincipal.
                clicarBotaoLogout();
        paginaLogin.
                clicarBotaoCadastrar();
        paginaCadastro.
                validarTextoCadastroVisivel().
                preencherNome(usuarioValido.getNome()).
                preencherEmail(usuarioValido.getEmail()).
                preencherSenha(usuarioValido.getSenha()).
                marcarAdministrador().
                clicarBotaoCadastrar().
                validarMensagemEmailJaUtilizado();
    }
}
