package eic.ifpr.pgua.relatorios.utils;



import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import eic.ifpr.pgua.relatorios.App;
import eic.ifpr.pgua.relatorios.models.Pessoa;
import eic.ifpr.pgua.relatorios.repositorios.RepositorioPessoas;

public class GeradorRelatorios {
    

    private RepositorioPessoas repositorioPessoas;

    public GeradorRelatorios(RepositorioPessoas repositorioPessoas) {
        this.repositorioPessoas = repositorioPessoas;
    }


    public void gerarRelatorioPessoas(String nomeArquivo) throws Exception{

        //cria um novo documento PDF
        Document document = new Document();

        //cria o arquivo onde será salvo o documento
        PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo));

        //abre o documento para edição
        document.open();

        //carrega uma imagem armazenada no recursos para inserir no relatório
        Path path = Paths.get(App.class.getResource("imgs/img.jpg").toURI());

        Image img = Image.getInstance(path.toAbsolutePath().toString());
        
        //ajustando o tamanho da imagem
        img.scaleToFit(new Rectangle(0, 0, 50, 50));

        //alinhando a imagem a esquerda
        img.setAlignment(Image.LEFT);
        
        //cria um elemento parágrafo, que serve para inserir texto no documento.
        Paragraph paragrafo = new Paragraph();
        
        //adiciona a imagem no parágrafo
        paragrafo.add(img);
        
        //adiciona um texto no parágrafo
        paragrafo.add("Isto é um parágrafo, que "+
        "você pode utilizar para inserir " +
        "texto no seu relatório.");
        

        //adiciona o parágrafo no documento
        document.add(paragrafo);
        
        //adiciona um espaço em branco no documento
        document.add(new Chunk());

        //cria uma tabela com 4 colunas
        PdfPTable table = new PdfPTable(4);

        //ajusta o cabeçalho da tabela, inserindo uma linha que contém o
        //título de cada coluna
        String[] cabecalho = {"Id","Nome","Nascimento","Altura"};
        for(String s:cabecalho){
            //cria uma célula 
            PdfPCell cell = new PdfPCell();
            //adiciona o texto na célula
            cell.addElement(new Paragraph(s));
            //ajusta a cor de fundo da célula
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //ajusta a largura da borda
            cell.setBorderWidth(2);
            //adiciona a célula na tabela. Importante ressaltar
            //que a inserção se dá da esquerda para a direita
            table.addCell(cell);
        }

        //preenche o restante da tabela com os dados
        for(Pessoa p:repositorioPessoas.listarPessoas()){
            table.addCell(""+p.getId()); 
            table.addCell(p.getNome());
            table.addCell(p.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            table.addCell(""+p.getAltura());           
        }

        //adiciona a tabela no documento
        document.add(table);

        //fecha o documento e salva em arquivo
        document.close();


    }
    


}
