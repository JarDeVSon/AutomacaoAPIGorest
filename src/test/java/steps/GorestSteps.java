package steps;

import api.ApiHeaders;
import api.ApiRequest;
import api.ApiUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GorestSteps extends ApiRequest {

    PropertiesUtils propertiesUtils = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();

    @Dado("que possuo gorest token valido")
    public void quePossuoGorestTokenValido() {
       token = propertiesUtils.getProp("token_gorest");
        //System.out.println(propertiesUtils.getProp("token_gorest"));
    }
    @Quando("envio um request de cadastro de usuario com dados validosc")
    public void envioUmRequestDeCadastroDeUsuarioComDadosValidosc() throws IOException {
        super.uri = propertiesUtils.getProp("uri_gorest");
        super.headers = apiHeaders.getHeaders(token);
        super.body = jsonUtils.parseJSONFile();
        super.POST();
        //System.out.println(body);
    }
    @Entao("o usuario deve ser criado corretamente")
    public void oUsuarioDeveSerCriadoCorretamente() {

    }
    @Entao("o status code deve ser {int}")
    public void oStatusCodeDeveSer(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!");
    }
}
