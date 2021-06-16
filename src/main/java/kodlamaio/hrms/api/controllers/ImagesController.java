package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {
    private ImageService imageService;
    private UserService userService;

    @Autowired
    public ImagesController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile multipartFile){
        User user = this.userService.getUserById(id).getData();
        Image image = new Image();
        image.setUser(user);
        return this.imageService.add(image,multipartFile);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return this.imageService.getAll();
    }



}
