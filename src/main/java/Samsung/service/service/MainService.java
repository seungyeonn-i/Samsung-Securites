package Samsung.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    public String createChart() throws JsonProcessingException {
        int[] dataValues = new int[]{9, 30, 50};
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dataValues);

    }
}
