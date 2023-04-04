package jardin.empresa.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jardin.empresa.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;
    private final Map<String, String> values = new HashMap<>();

    public CloudinaryServiceImpl() {
        values.put("cloud_name", "dpgoimsdy");
        values.put("api_key", "271333998824868");
        values.put("api_secret", "WaGAuKlskYWyx8nu_Pv6FXFNVHY");
        cloudinary = new Cloudinary(values);
    }
    @Override
    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = covert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    @Override
    public File covert(MultipartFile file) throws IOException {
            File convFile = new File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
    }
    @Override
    public Map delete(String id) throws IOException {
        return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }

}
