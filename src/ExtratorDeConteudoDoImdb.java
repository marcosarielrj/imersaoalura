import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb {

    public List<Conteudo> extraiConteudos (String json){

        // separar os dados que nos interessa: (titulo, poster, classificação);

        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtibutos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteúdos

        for (Map<String, String> atributos : listaDeAtibutos) {
            
            
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String titulo =  atributos.get("title");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
    
}
