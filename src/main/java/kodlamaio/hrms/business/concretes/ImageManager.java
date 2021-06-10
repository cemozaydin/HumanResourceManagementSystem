package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.externalService.cloudinaryService.CloudinaryUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;
    private CloudinaryUploadService cloudinaryUploadService;

    public ImageManager(ImageDao imageDao, CloudinaryUploadService cloudinaryUploadService) {
        this.imageDao = imageDao;
        this.cloudinaryUploadService = cloudinaryUploadService;
    }

    @Override
    public Result add(Image image, MultipartFile imageFile) {
        @SuppressWarnings("unchecked")
        Map<String,String> uploadImage = this.cloudinaryUploadService.uploadImageFie(imageFile).getData();

        image.setImagePath(uploadImage.get("url"));
        this.imageDao.save(image);
        return new SuccessResult("Imaj dosyası sisteme eklendi.");
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
    }



}
