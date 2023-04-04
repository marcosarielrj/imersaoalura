import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        //String url = "https://api.nasa.gov/planetary/apod?api_key=hmaiRz0GBftu2y4v5TihPUyw5zWNRecVNawWHj5G&start_date=2023-03-15&end_date=2023-03-20";
        
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_b2g36n8t";
        String url = "http://localhost:8080/linguagens";
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        

        // exibir e manipular os dados recebidos
       
        List<Conteudo> conteudos = extrator.extrairConteudos(json);

        var gerador = new GeradorDeFigurinha();

        for (int i = 0; i < 4; i++ ) {

            Conteudo conteudo = conteudos.get(i);


            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            var nomeArquivo =  conteudo.titulo() + ".png";

            gerador.criar(inputStream, nomeArquivo);

            
            System.out.println(conteudo.titulo());
            System.out.println(conteudo.urlImagem());
            System.out.println();
           
        }
            
    }
}
