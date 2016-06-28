package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.dao.core.CategoriaDAO;
import br.udesc.restaurantes.modelo.dao.core.JPAFactory;
import br.udesc.restaurantes.modelo.dao.core.RestauranteDAO;
import br.udesc.restaurantes.modelo.entidade.Categoria;
import br.udesc.restaurantes.modelo.entidade.Restaurante;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class BeanCadastroRestaurante {
    private Restaurante restaurante;
    private List<Categoria> categorias;
    private RestauranteDAO dao;
    private UploadedFile file;
    private CategoriaDAO cdao;

    public BeanCadastroRestaurante() {
    restaurante = new Restaurante();
    dao = JPAFactory.getRestauranteDAO();
    cdao = JPAFactory.getCategoriaDAO();
    categorias = cdao.listar();
    }
    
    public String salvar(){
        dao.salvar(restaurante);
        return "index";
    }
    
    public String validaNome() {
        if (dao.validaNome(restaurante.getNomeEstabelecimento()) == null){
            return salvar();
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Restaurante já existe"));
            return null;
        }
    }
    
    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public RestauranteDAO getDao() {
        return dao;
    }

    public void setDao(RestauranteDAO dao) {
        this.dao = dao;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public void criaArquivo(byte[] bytes, String arquivo) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(arquivo);
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public void upload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        byte[] foto = event.getFile().getContents();
        String nomeArquivo = event.getFile().getFileName();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
        String arquivo = scontext.getRealPath("resources/img/" + nomeArquivo);
        criaArquivo(foto, arquivo);
        restaurante.addFotos(arquivo);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    private UIComponent select;

    public UIComponent getSelect() {
        return this.select;
    }

    public void setSelect(UIComponent select) {
        this.select = select;
    }

}
