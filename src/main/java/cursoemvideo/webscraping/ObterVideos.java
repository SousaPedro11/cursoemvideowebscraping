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

public class ObterVideos {

    private final String url;

    private final List<String> nomeVideos = new ArrayList<>();

    private final Document DocumentoHTML;

    private final String home = System.getProperty("user.home");

    public ObterVideos(final String url) {

        this.url = url;
        this.DocumentoHTML = this.lerDocumento(url);
    }

    public ObterVideos obterNomes() {

        this.obterNomes(this.url);

        return this;
    }

    private Document lerDocumento(final String link) {

        Document documentoHTML = null;
        try {
            documentoHTML = Jsoup.connect(link).get();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return documentoHTML;
    }

    private String obterNomePlayList() {

        String elemento = null;
        final Elements elementos = this.getDocumentoHTML().getElementsByAttributeValue("class", "pl-header-title");
        for (final Element element : elementos) {
            elemento = element.text();
        }
        return elemento;
    }

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

    public ObterVideos imprimirLista() {

        System.out.println(this.obterNomePlayList());
        this.enumerarVideos().forEach(System.out::println);
        System.out.println();

        return this;
    }

    public void salvarNomes(final String nome) {

        this.salvarNomes(this.obterNomePlayList(), nome);
    }

    public void salvarNomes(final String pasta, final String nome) {

        final StringBuilder stringBuilder = new StringBuilder();

        final String caminhoPasta = this.home + pasta;

        new File(caminhoPasta).mkdirs();

        // final Path path = Paths.get(home + pasta + nome.toLowerCase() + ".txt");

        this.enumerarVideos().stream().forEach(v -> {
            stringBuilder.append(v.toString()).append("\n");
        });
        try {

            // Files.write(path, stringBuilder.toString().getBytes("UTF-8"));

            Files.write(Paths.get(this.home + pasta + nome.toLowerCase() + ".txt"),
                            stringBuilder.toString().getBytes("UTF-8"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    // private List<String> obterListaNomes() {
    //
    // return this.nomeVideos;
    // }
    //
    // private List<String> getListaNumerada() {
    //
    // return this.enumerarVideos();
    // }

    private List<String> enumerarVideos() {

        final List<String> novaLista = new ArrayList<>();
        for (int i = 0; i < this.nomeVideos.size(); i++) {
            final String numero = String.format("%02d", i + 1);
            novaLista.add(numero.concat(" - ").concat(this.nomeVideos.get(i)));
        }

        return novaLista;
    }

    private Document getDocumentoHTML() {

        return this.DocumentoHTML;
    }
}
