package kodlamaio.hrms.core.utilities.generator;

import org.hibernate.id.UUIDGenerator;

import java.util.UUID;

public class Genarator {
    public static String generateString() {
        String uuid=UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
