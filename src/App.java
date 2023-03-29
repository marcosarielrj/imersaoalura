import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

import javax.crypto.KeyAgreement;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Fazer uma conexão HTTP e buscar os top 250 filmes
        // https://imdb-api.com/en/API/MostPopularMovies/k_b2g36n8t

        String imdburl = "https://imdb-api.com/pt-br/API/MostPopularMovies/k_b2g36n8t";
        
        URI endereco = URI.create(imdburl);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // separar os dados que nos interessa: (titulo, poster, classificação);

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        

        // exibir e manipular os dados recebidos

        for (Map<String,String> filme : listaDeFilmes) {
            
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
        }
            
    }
}
