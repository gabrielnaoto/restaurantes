package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.dao.core.JPAFactory;
import br.udesc.restaurantes.modelo.dao.core.UsuarioDAO;
import br.udesc.restaurantes.modelo.entidade.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;

import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class BeanCadastroUsuario {

    private Usuario usuario;
    private UsuarioDAO dao;
    private UploadedFile file;

    public BeanCadastroUsuario() {
        usuario = new Usuario();
        dao = JPAFactory.getUsuarioDAO();
    }

    public String salvar() {
        dao.salvar(usuario);
        return "index";
    }

    public String apelido() {
        if (dao.apelido(usuario.getApelido()) == null) {
            return salvar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Apelido já existe"));
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void criaArquivo(byte[] bytes, String arquivo) {
        File f = new File(arquivo);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(f);
            fos.write(bytes);
            fos.flush();
            fos.close();
            System.out.println(f.getAbsolutePath() + "-tagggparapesquisar");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesful", arquivo + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (FileNotFoundException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "file not found");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (IOException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "io exception");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void upload(FileUploadEvent event) {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

            String realPath = context.getRealPath("../../");

            File file = new File(realPath + "\\web\\resources\\img\\usuarios\\");
            file.mkdirs();
            String caminhoServer = context.getRealPath("");
            byte[] arquivo = event.getFile().getContents();
            String nomesss = Integer.toString((int)Math.ceil(Math.random() * 1000)) + Integer.toString((int)Math.ceil(Math.random() * 1000)) + Integer.toString((int)Math.ceil(Math.random() * 1000)) + Integer.toString((int)Math.ceil(Math.random() * 1000));
            String[] type = event.getFile().getContentType().split("/");
            String caminho = realPath + "\\web\\resources\\img\\usuarios\\" + nomesss + "." + type[1];

            FileOutputStream fos = new FileOutputStream(caminho);
            fos.write(arquivo);
            fos.close();
            usuario.setFoto("\\web\\resources\\img\\usuarios\\" + nomesss + "." + type[1]);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Foto inserida!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro ao cadastrar.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
