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
import javax.faces.context.FacesContext;
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

    public void upload(FileUploadEvent event) {
        file = event.getFile();

        if (file != null) {
            File file1 = new File("recources/img/usuario", file.getFileName()); 
            try {
                FileOutputStream fos = new FileOutputStream(file1);
                fos.write(event.getFile().getContents());
                fos.close();
                fos.flush();

                FacesContext instance = FacesContext.getCurrentInstance();
                instance.addMessage("mensagens", new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        file.getFileName() + " anexado com sucesso", null));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    }
}
