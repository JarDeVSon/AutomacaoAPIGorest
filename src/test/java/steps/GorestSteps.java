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
       token = propertiesUtils.getProp("token");
        //System.out.println(propertiesUtils.getProp("token_gorest"));
    }

    @Quando("envio um request de cadastro de posts com dados validos")
    public void envioUmRequestDeCadastroDePostsComDadosValidos() throws IOException {
        super.uri = propertiesUtils.getProp("uri_jsonplaceholder");
        super.headers = apiHeaders.getHeaders(token);
        super.body = jsonUtils.parseJSONFile();
        super.POST();
        //System.out.println(body);
    }
    @Entao("o post deve ser criado corretamente")
    public void oPostDeveSerCriadoCorretamente() {

        assertEquals(body.get("title"), response.jsonPath().getString("title"));
        assertEquals(body.get("body"), response.jsonPath().getString("body"));

    }
    @Entao("o status code deve ser {int}")
    public void oStatusCodeDeveSer(Integer statusEsperado) {
        assertEquals(statusEsperado, response.statusCode(), "Status code diferente do esperado!");
    }
}
