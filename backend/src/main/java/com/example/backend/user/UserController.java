package com.example.backend.user;

import com.example.backend.user.dto.AddDto;
import com.example.backend.user.dto.GetIdDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService studentService){
        this.userService = studentService;
    }

    @GetMapping("/api/{id}")
    public GetIdDto getId(@PathVariable long id)
    {
        User user = userService.getStudents(id);
        return new GetIdDto(user);
    }

    @PostMapping("/api/paste")
    public AddDto add(@RequestBody User user){
        User dto = userService.addNewStudent(user);
        return new AddDto(dto);

    }
//    @PostMapping("/api/recents")
//    public CompletableFuture<List<GetIdDto>> recent(){
//        CompletableFuture<List<GetIdDto>> user1 = userService.getAll();
//        CompletableFuture<List<GetIdDto>> user2 = userService.getAll();
//        CompletableFuture<List<GetIdDto>> user3 = userService.getAll();
//        CompletableFuture.allOf(user1,user2,user3).join();
//        return user1;
//    }

    @PostMapping("/api/recents")
    public List<GetIdDto> recent(){
        List<GetIdDto> list = new ArrayList<>();
        for(User user: userService.getAll()){
            ModelMapper modelMapper = new ModelMapper();
            GetIdDto x = modelMapper.map(user,GetIdDto.class);
            list.add(x);
        }
        return list;
    }
}
