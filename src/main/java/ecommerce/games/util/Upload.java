package ecommerce.games.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Upload {
    
    @Value("${path.img}")
    private String path_img;
    
    public void salvarFoto(MultipartFile foto){
        this.salvar(this.path_img, foto);
    }

    public void salvar(String diretorio, MultipartFile arquivo){
        Path diretorioPath = Paths.get(diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try{
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        } catch  (IOException e){
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }
    }
}
