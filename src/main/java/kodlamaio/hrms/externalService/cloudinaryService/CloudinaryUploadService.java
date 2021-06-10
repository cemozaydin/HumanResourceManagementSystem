package kodlamaio.hrms.externalService.cloudinaryService;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.business.abstracts.CloudinaryConfigService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryUploadService {
    private Cloudinary cloudinary;
    private CloudinaryConfigService cloudinaryConfigService;

    @Autowired
    public CloudinaryUploadService(CloudinaryConfigService cloudinaryConfigService) {
        this.cloudinaryConfigService = cloudinaryConfigService;

        CloudinaryConfig cloudinaryConfig = this.cloudinaryConfigService.getById(1).getData();

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name",cloudinaryConfig.getCloudName(),
                "api_key",cloudinaryConfig.getApiKey(),
                "api_secret",cloudinaryConfig.getSecretKey()
        ));

        this.cloudinary = cloudinary;
    }

    public DataResult<Map> uploadImageFie(MultipartFile imageFile) {
        try{
        @SuppressWarnings("unchecked")
        Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
                ObjectUtils.asMap("transformation",(new Transformation().height(150).width(150).crop("scale")),
                                        "unique_filename","true",
                                        "folder","kodlamaio/profilePhotos/",
                                        "allowed_formats","jpg,jpeg,png"));

            return new SuccessDataResult<Map>(resultMap);
        }catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }

}
