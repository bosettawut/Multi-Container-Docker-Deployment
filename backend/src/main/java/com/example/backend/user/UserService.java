package com.example.backend.user;

import com.example.backend.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository studentRepository) {
        this.userRepository = studentRepository;
    }

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "paste", key = "#id")
    public User getStudents(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }
//    @Async
//    public CompletableFuture<List<GetIdDto>> getAll(){
//        List<GetIdDto> list = new ArrayList<>();
//        List<User> y = userRepository.findTop100ByOrderByCreatedAtDesc();
//        for(User user: y){
//            ModelMapper modelMapper = new ModelMapper();
//            list.add(modelMapper.map(user,GetIdDto.class));
//        }
//        return CompletableFuture.completedFuture(list);
//    }

    @CacheEvict(cacheNames = "putStudentCache", allEntries = true)
    public List<User> getAll(){

        return userRepository.findTop100ByOrderByCreatedAtDesc();
    }

    @CachePut (cacheNames = "putStudentCache", key = "#student.id")
    public User addNewStudent(User student) {
        try {
            System.out.println(student);
            return userRepository.save(student);
        }
        catch( ResourceNotFoundException ex) {
            throw new ResourceNotFoundException("Bad Request");
        }
    }

}
