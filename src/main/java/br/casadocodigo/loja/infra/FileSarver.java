package br.casadocodigo.loja.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/*
   @Component
   A annotation básica que indica que uma classe vai ser gerenciada pelo container do Spring.
   A maioria das annotations são, na verdade, derivadas de @Component.
   A ideia é justamente passar mais semântica.
 */

@Component
public class FileSarver {

    @Autowired
    HttpServletRequest request;

    public String write( String baseFolder , MultipartFile file){

        //String path  = baseFolder + "/" + file.getOriginalFilename();
        try {

            String realPath = request.getServletContext().getRealPath("/"+baseFolder);
            String path  = realPath + "/" +  file.getOriginalFilename();
            file.transferTo(new File(path));

        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
        return baseFolder + "/" + file.getOriginalFilename();
    }
}
