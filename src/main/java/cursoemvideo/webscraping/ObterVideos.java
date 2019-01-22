package cursoemvideo.webscraping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Classe que faz o WebScraping da página Web para obter o nome da Playlist e a lista de nomes dos vídeos presentes nela.
 * 
 * @author pedro
 *
 */
public class ObterVideos {

    /**
     * url da Playlist.
     */
    private final String url;

    /**
     * Lista de nomes dos videos.
     */
    private final List<String> nomeVideos = new ArrayList<>();

    /**
     * Representa um documento HTML.
     */
    private final Document DocumentoHTML;

    /**
     * Define a pasta Home do sistema.
     */
    private final String home = System.getProperty("user.home");

    /**
     * Construtor da classe.
     *
     * @param url
     */
    public ObterVideos(final String url) {

        this.url = url;
        this.DocumentoHTML = this.lerDocumento(url);
    }

    /**
     * Chama o método privado que extrai os nomes dos vídeos presentes na playlist, a partir de uma url.
     *
     * @return
     */
    public ObterVideos obterNomes() {

        this.obterNomes(this.url);

        return this;
    }

    /**
     * Obtém os dados da página a partir de sua url(link).
     *
     * @param link
     * @return
     */
    private Document lerDocumento(final String link) {

        Document documentoHTML = null;
        try {
            documentoHTML = Jsoup.connect(link).get();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return documentoHTML;
    }

    /**
     * Obtém o nome da Playlist
     *
     * @return
     */
    private String obterNomePlayList() {

        String elemento = null;
        final Elements elementos = this.getDocumentoHTML().getElementsByAttributeValue("class", "pl-header-title");
        for (final Element element : elementos) {
            elemento = element.text();
        }
        return elemento;
    }

    /**
     * Obtem o nome dos vídeos da Playlist e adiciona ao Array de nomes.
     *
     * @param link
     */
    private void obterNomes(final String link) {

        final Elements nomes = this.getDocumentoHTML().getElementsByAttributeValue("id", "pl-load-more-destination");

        for (final Element nome : nomes) {

            nome.childNodes().stream().forEach(n -> {

                if (n.nodeName().equals("tr")) {

                    final String nomeVideo = n.attr("data-title");

                    if (!this.nomeVideos.contains(nomeVideo)) {

                        this.nomeVideos.add(nomeVideo);
                    }
                }
            });
        }
    }

    /**
     * Imprime a lista de nomes, já enumerada
     *
     * @return
     */
    public ObterVideos imprimirLista() {

        System.out.println(this.obterNomePlayList());
        this.enumerarVideos().forEach(System.out::println);
        System.out.println();

        return this;
    }

    /**
     * Salva o conteúdo, na Pasta com o nome da Playlist, em um arquivo "nome".txt.
     *
     * @param nome
     */
    public void salvarNomes(final String nome) {

        this.salvarNomes(this.obterNomePlayList(), nome);
    }

    /**
     * Salva o conteúdo da lista em pasta e arquivo .txt com nomes definidos pelo usuário.
     *
     * @param pasta
     * @param nome
     */
    public void salvarNomes(final String pasta, final String nome) {

        final StringBuilder stringBuilder = new StringBuilder();

        final String caminhoPasta = this.home + File.separator + "Downloads" + File.separator + pasta + File.separator;

        new File(caminhoPasta).mkdirs();

        this.enumerarVideos().stream().forEach(v -> {
            stringBuilder.append(v.toString()).append("\n");
        });
        try {

            final String nomeArquivo = nome.toLowerCase() + ".txt";
            Files.write(Paths.get(caminhoPasta + nomeArquivo),
                            stringBuilder.toString().getBytes("UTF-8"));
            System.out.println("Arquivo " + nomeArquivo + " salvo em: " + caminhoPasta);
            System.out.println();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Enumera a Playlist.
     *
     * @return
     */
    private List<String> enumerarVideos() {

        final List<String> novaLista = new ArrayList<>();
        for (int i = 0; i < this.nomeVideos.size(); i++) {
            final String numero = String.format("%02d", i + 1);
            novaLista.add(numero.concat(" - ").concat(this.nomeVideos.get(i)));
        }

        return novaLista;
    }

    /**
     * Obtem o conteúdo da página
     *
     * @return
     */
    private Document getDocumentoHTML() {

        return this.DocumentoHTML;
    }
}
