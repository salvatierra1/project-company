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
import java.util.Objects;

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
    public Map delete(String id) throws IOException {
        return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }
    @Override
    public File covert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
