package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;


@Data
@Entity
@Table(name = "cloudinary_config")
@NoArgsConstructor
@AllArgsConstructor
public class CloudinaryConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id = 1;

    @Column(name = "cloud_name")
    private String cloudName;

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "api_secret")
    private String secretKey;
}
